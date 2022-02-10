package com.cmc.credagility.core.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.businesscontext.BusinessContext;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 16:42
 */
@Entity
@Table(name = "RoleContext")
public class RoleContext extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  @JoinColumn(
    name       = "businessContextId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private BusinessContext businessContext;

  @JoinColumn(
    name       = "roleId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Role role;

  @Column(length = 255)
  private String staticContext;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new RoleContext object.
   */
  public RoleContext() { }

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

    RoleContext that = (RoleContext) o;

    if (!StringUtils.hasText(staticContext)) {
      if ((businessContext != null) ? (!businessContext.equals(that.businessContext))
                                    : (that.businessContext != null)) {
        return false;
      }
    } else {
      if ((staticContext != null) ? (!staticContext.equals(that.staticContext)) : (that.staticContext != null)) {
        return false;
      }
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((role != null) ? (!role.equals(that.role)) : (that.role != null)) {
      return false;
    }


    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context.
   *
   * @return  BusinessContext
   */
  public BusinessContext getBusinessContext() {
    return businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for context name.
   *
   * @return  String
   */
  public String getContextName() {
    if (StringUtils.hasText(staticContext)) {
      return staticContext;
    } else if (null != businessContext) {
      return businessContext.getContext();
    }

    return "";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for role.
   *
   * @return  Role
   */
  public Role getRole() {
    return role;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for static context.
   *
   * @return  String
   */
  public String getStaticContext() {
    return staticContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);

    if (!StringUtils.hasText(staticContext)) {
      result = (31 * result) + ((businessContext != null) ? businessContext.hashCode() : 0);
    } else {
      result = (31 * result) + ((staticContext != null) ? staticContext.hashCode() : 0);
    }

    result = (31 * result) + ((role != null) ? role.hashCode() : 0);


    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business context.
   *
   * @param  businessContext  BusinessContext
   */
  public void setBusinessContext(BusinessContext businessContext) {
    this.businessContext = businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for role.
   *
   * @param  role  Role
   */
  public void setRole(Role role) {
    this.role = role;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for static context.
   *
   * @param  staticContext  String
   */
  public void setStaticContext(String staticContext) {
    this.staticContext = staticContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.CreatorEntity#toString()
   */
  @Override public String toString() {
    return "RoleContext{"
      + "id=" + id
      + ", businessContext=" + businessContext
      + ", role=" + role
      + ", staticContext='" + staticContext + '\''
      + '}';
  }
} // end class RoleContext
