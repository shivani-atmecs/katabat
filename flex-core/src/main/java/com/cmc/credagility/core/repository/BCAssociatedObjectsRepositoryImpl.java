package com.cmc.credagility.core.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;

import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Restrictions;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.businesscontext.BCAssociatedField;
import com.cmc.encryption.CmcPBEStringEncryptor;
import com.cmc.credagility.util.DateUtil;

import com.ozstrategy.credagility.core.repository.OzHibernateDaoSupport;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 15:51
 */
@Repository("bcAssociatedObjectsRepository")
public class BCAssociatedObjectsRepositoryImpl extends OzHibernateDaoSupport implements BCAssociatedObjectsRepository {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Autowired protected ConfigurablePasswordEncryptor hashEncryptor;
  @Autowired private CmcPBEStringEncryptor cmcStringEncryptor;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  BCAssociatedObjectsRepository#countCaseId(String)
   */
  @Override public Long countCaseId(String caseId) {
    return (Long) em.createQuery("SELECT COUNT(c.id) FROM DynamicCase c WHERE c.caseNumber=:caseId").setParameter(
        "caseId",
        caseId).getSingleResult();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BCAssociatedObjectsRepository#findObject(Class, java.util.List)
   */
  @Override public <T> T findObject(Class<T> clazz, List<BCAssociatedField> fields) {
    Junction             junction = Restrictions.conjunction();
    Criteria             result   = getSession().createCriteria(
        clazz);
    Map<String, Boolean> aliasMap = new HashMap<String, Boolean>();

    for (BCAssociatedField field : fields) {
      if (field.getSubModelName() != null) {
        junction.add(Restrictions.eq(getSubModelFieldName(field.getSubModelName().toLowerCase(), field.getFieldName()),
            field.getValue()));

        // create alias
        if (aliasMap.get(field.getSubModelName().toLowerCase()) == null) {
          String associationPath      = null;
          String contactAssociatePath = null;
          String contactType          = null;

          if ("AccountIndex".equalsIgnoreCase(field.getSubModelName())) {
            associationPath = "accountIndex";
          } else if ("ResponsibleIndex".equalsIgnoreCase(field.getSubModelName())) {
            associationPath = "responsibleIndex";
          } else if ("HomePhone".equalsIgnoreCase(field.getSubModelName())) {
            contactAssociatePath = "phones";
            contactType          = "phoneType";
          } else if ("HomeAddress".equalsIgnoreCase(field.getSubModelName())) {
            contactAssociatePath = "addresses";
            contactType          = "addressType";
          } else if ("HomeEmail".equalsIgnoreCase(field.getSubModelName())) {
            contactAssociatePath = "emails";
            contactType          = "emailType";
          }

          if (associationPath != null) {
            result.createAlias(associationPath, field.getSubModelName().toLowerCase());
            aliasMap.put(field.getSubModelName().toLowerCase(), Boolean.TRUE);
          } else if (contactAssociatePath != null) {
            String aliasName = field.getSubModelName().toLowerCase();
            result.createAlias(contactAssociatePath, aliasName).createAlias(
              aliasName + "." + contactType, contactType).add(Restrictions.eq(contactType + ".name",
                field.getSubModelName()));

            aliasMap.put(aliasName, Boolean.TRUE);
          }
        } // end if
      } else {
        Object fieldValue = field.getValue();

        if (field.getFieldName().contains("originalAccountNumber")) {
          // this field has encrypted
          return (T) getAccountByOriginalNum(fieldValue.toString());
        } else if (field.getDataType().equalsIgnoreCase("Date")) {
          Date dataValue = (Date) fieldValue;
          fieldValue = DateUtil.formatDateTime(dataValue);
        }

        junction.add(Restrictions.eq(field.getFieldName(), fieldValue));
      } // end if-else
    }   // end for

    result.add(junction);

    List<T> list = result.list();

    if (list.size() > 0) {
      return list.get(0);
    }

    return null;
  } // end method findObject

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BCAssociatedObjectsRepository#getAccountByOriginalNum(String)
   */
  @Override public Account getAccountByOriginalNum(String originalAccountNum) {
    org.hibernate.Query query = getSession().createQuery(
        "SELECT distinct acctIndex.account FROM AccountIndex acctIndex WHERE acctIndex.originalAccountNumberHash =:orgAccountNumHash")
      .setMaxResults(1);

    if (StringUtils.hasText(originalAccountNum)) {
      String orgAccountNumHash = null;

      if ((cmcStringEncryptor != null)
            && ((StringUtils.hasText(cmcStringEncryptor.getAlgorithm())
                && StringUtils.hasText(cmcStringEncryptor.getPassword()))
              || cmcStringEncryptor.useIndexQuery())) {
        orgAccountNumHash = hashEncryptor.encryptPassword(originalAccountNum);
      }

      query.setParameter("orgAccountNumHash", orgAccountNumHash);
    }

    List result = query.list();

    if ((result != null) && (result.size() > 0)) {
      return (Account) query.list().get(0);
    }

    return null;
  } // end method getAccountByOriginalNum

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BCAssociatedObjectsRepository#getMaxCaseId()
   */
  @Override public String getMaxCaseId() {
    String caseId = (String) em.createQuery(
        "SELECT MAX(bci.uniqueId) FROM BusinessContextInstance bci WHERE bci.source='W'").getSingleResult();

    return caseId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BCAssociatedObjectsRepository#getMaxUserLogon()
   */
  @Override public String getMaxUserLogon() {
    String userLogon = (String) em.createQuery("SELECT MAX(resp.userLogon) FROM Responsible resp ").getSingleResult();

    return userLogon;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private String getSubModelFieldName(String subModelName, String fieldName) {
    if ("HomeAddress".equalsIgnoreCase(subModelName)) {
      if ("address1".equalsIgnoreCase(fieldName)
            || "address2".equalsIgnoreCase(fieldName)
            || "address3".equalsIgnoreCase(fieldName)
            || "city".equalsIgnoreCase(fieldName)
            || "country".equalsIgnoreCase(fieldName)
            || "postalCode".equalsIgnoreCase(fieldName)
            || "province".equalsIgnoreCase(fieldName)) {
        return subModelName + ".address." + fieldName;
      }
    }

    return subModelName + "." + fieldName;
  }

} // end class BCAssociatedObjectsRepositoryImpl
