package com.cmc.credagility.core.domain.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "CustomerPortalLoginConfiguration")
public class CustomerPortalLoginConfiguration extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 405899795673656461L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /**
   * If the result(which executed the SQL) to find out more than one responsible,.
   *
   * <p>If <code>allowNoneUnique</code> is 'True', then:</p>
   *
   * <p>1. Return the Primary Responsible</p>
   *
   * <p>2. Return the Random Responsible if no primary responsible in results.</p>
   */
  @Column(
    name             = "allowNoneUnique",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean allowNoneUnique = Boolean.FALSE;

  private String description;

  /**
   * The OR condition groups Each group in (...), in a group the condition is OR. In a group multiple tokens split by
   * comma.
   *
   * <p>This field can defined multiple groups such as: (OAN,responsibleNumber)(zipCode,dob)</p>
   *
   * <p>each group allow more than one fields such as:</p>
   *
   * <p>(originalAccountNumber, responsibleNumber) --> means originalAccountNumber or responsibleNumber.</p>
   *
   * <p>In front-end one of them need be required. If both of the 2 fields are all empty, the validation could not
   * passed.</p>
   */
  private String groups;

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id private Long id;

  /**
   * The login SQL (using JPA query, not the native SQL) The parameters which in SQL using ?1, ?2, ?3 .... ?n
   * placeholder text.
   */
  @Column(
    name     = "loginSQL",
    nullable = false,
    length   = 2048
  )
  private String loginSQL;

  @Transient private LinkedHashSet<CustomerPortalLoginToken> loginTokens = null;

  /**
   * The <code>packageName</code> name (i.e: Package_1, Package_1, Option3 ...)
   *
   * <p>The Customer Portal startup env variable {code}securityTokenPackage{code}</p>
   *
   * <p>Would configured this field value if the Customer Portal want to using this DB configuration as the login
   * tokens.</p>
   */
  @Column(
    unique   = true,
    nullable = false
  )
  private String packageName;

  /**
   * Which tokens using (refer the CustomerPortalLoginToken table).
   *
   * <p>If there more than one token, the split them by comma.</p>
   *
   * <p>such as:</p>
   *
   * <p>1,2,3</p>
   *
   * <p>1,2</p>
   *
   * <p>5</p>
   */
  @Column(nullable = false)
  private String tokens;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    CustomerPortalLoginConfiguration that = (CustomerPortalLoginConfiguration) o;

    return packageName.equals(that.packageName)
      && loginSQL.equals(that.loginSQL)
      && tokens.equals(that.tokens)
      && allowNoneUnique.equals(that.allowNoneUnique);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowNoneUnique() {
    if (null == allowNoneUnique) {
      return Boolean.FALSE;
    }

    return allowNoneUnique;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the groups.
   *
   * <p>The CustomerPortalLoginConfiguration.group just like (1,2)(3,4)</p>
   *
   * <p>This method just get per group as a list item</p>
   *
   * <p>Such AS:</p>
   *
   * <p>(1,2)(3,4)(5,6,7) ===> list: [(1,2), (3,4), (5,6,7)]</p>
   *
   * @return  the group list
   */
  public List<String> getGroupList() {
    List<String> groupNames = new ArrayList<>();

    Map<Long, String> tokenMap = getTokenMap();

    List<String> groupList = new ArrayList<String>();

    if ((groups != null) && StringUtils.hasText(groups)) {
      Pattern p = Pattern.compile("\\((.*?)\\)");
      Matcher m = p.matcher(groups);

      while (m.find()) {
        groupList.add(m.group(1));
      }
    }

    if (!groupList.isEmpty()) {
      for (String group : groupList) {
        if (StringUtils.hasText(group)) {
          groupNames.add(StringUtils.collectionToCommaDelimitedString(
              Arrays.stream(group.split(",")).map(gid -> tokenMap.get(new Long(gid))).collect(Collectors.toList())));
        }
      }
    }

    return groupNames;
  } // end method getGroupList

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getGroups() {
    return groups;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getLoginSQL() {
    return loginSQL;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public LinkedHashSet<CustomerPortalLoginToken> getLoginTokens() {
    return loginTokens;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPackageName() {
    return packageName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public List<Long> getTokenIds() {
    List<Long> tokenList = new LinkedList<>();

    if ((tokens != null) && StringUtils.hasText(tokens)) {
      String[] tokenArray = tokens.split(",");

      for (String token : tokenArray) {
        tokenList.add(new Long(token.trim()));
      }
    }

    return tokenList;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Map<Long, String> getTokenMap() {
    if ((loginTokens != null) && !loginTokens.isEmpty()) {
      return loginTokens.stream().collect(Collectors.toMap(CustomerPortalLoginToken::getId,
            CustomerPortalLoginToken::getToken));
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTokens() {
    return tokens;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    return Objects.hash(super.hashCode(), packageName, loginSQL, tokens, allowNoneUnique);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowNoneUnique  DOCUMENT ME!
   */
  public void setAllowNoneUnique(Boolean allowNoneUnique) {
    this.allowNoneUnique = allowNoneUnique;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  description  DOCUMENT ME!
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  groups  DOCUMENT ME!
   */
  public void setGroups(String groups) {
    this.groups = groups;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  loginSQL  DOCUMENT ME!
   */
  public void setLoginSQL(String loginSQL) {
    this.loginSQL = loginSQL;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  loginTokens     DOCUMENT ME!
   * @param  orderedTokenId  DOCUMENT ME!
   * @param  language        DOCUMENT ME!
   */
  public void setLoginTokens(List<CustomerPortalLoginToken> loginTokens, List<Long> orderedTokenId,
    final String language) {
    loginTokens.sort(Comparator.comparing(v -> orderedTokenId.indexOf(v.getId())));

    this.loginTokens = new LinkedHashSet<CustomerPortalLoginToken>();
    this.loginTokens.addAll(loginTokens);

    for (CustomerPortalLoginToken loginToken : loginTokens) {
      Set<CustomerPortalLoginTokenLabel> labels = loginToken.getLabels().stream().filter(l ->
            l.getLanguage().equalsIgnoreCase(language)).collect(Collectors.toSet());
      loginToken.setLabels(labels);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  packageName  DOCUMENT ME!
   */
  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  tokens  DOCUMENT ME!
   */
  public void setTokens(String tokens) {
    this.tokens = tokens;
  }

} // end class CustomerPortalLoginConfiguration
