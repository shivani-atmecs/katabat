package com.cmc.credagility.core.domain.businesscontext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.bc.BusinessStaticPage;
import com.cmc.credagility.core.domain.event.Event;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 11:42
 */
@Entity public class BusinessContext extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 497253897023889394L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean active;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 255
  )
  protected String context;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    mappedBy = "businessContext",
    cascade  = { CascadeType.PERSIST, CascadeType.MERGE }
  )
  protected Set<Event> events = new HashSet<Event>();

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @MapKey(name = "fieldName")
  @OneToMany(
    mappedBy = "businessContext",
    fetch    = FetchType.LAZY
  )
  protected Map<String, BCMetaDataField> metaDataFieldMap = new HashMap<String, BCMetaDataField>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    mappedBy = "businessContext",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  protected Set<BCMetaDataField> metaDataFields = new HashSet<BCMetaDataField>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = { CascadeType.MERGE, CascadeType.PERSIST },
    fetch    = FetchType.LAZY,
    mappedBy = "businessContext"
  )
  @OrderBy("pageName ASC")
  protected Set<BusinessStaticPage> staticPages = new HashSet<BusinessStaticPage>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
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

    BusinessContext that = (BusinessContext) o;

    if ((active != null) ? (!active.equals(that.active)) : (that.active != null)) {
      return false;
    }

    if ((context != null) ? (!context.equals(that.context)) : (that.context != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for active.
   *
   * @return  Boolean
   */
  public Boolean getActive() {
    return active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for context.
   *
   * @return  String
   */
  public String getContext() {
    return context;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for events.
   *
   * @return  Set
   */
  public Set<Event> getEvents() {
    return events;
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
   * getter method for meta data field map.
   *
   * @return  Map
   */
  public Map<String, BCMetaDataField> getMetaDataFieldMap() {
    return metaDataFieldMap;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data fields.
   *
   * @return  Set
   */
  public Set<BCMetaDataField> getMetaDataFields() {
    return metaDataFields;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for static pages.
   *
   * @return  Set
   */
  public Set<BusinessStaticPage> getStaticPages() {
    return staticPages;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((active != null) ? active.hashCode() : 0);
    result = (31 * result) + ((context != null) ? context.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for active.
   *
   * @param  active  Boolean
   */
  public void setActive(Boolean active) {
    this.active = active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for context.
   *
   * @param  context  String
   */
  public void setContext(String context) {
    this.context = context;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for events.
   *
   * @param  events  Set
   */
  public void setEvents(Set<Event> events) {
    this.events = events;
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
   * setter method for meta data field map.
   *
   * @param  metaDataFieldMap  Map
   */
  public void setMetaDataFieldMap(Map<String, BCMetaDataField> metaDataFieldMap) {
    this.metaDataFieldMap = metaDataFieldMap;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data fields.
   *
   * @param  metaDataFields  Set
   */
  public void setMetaDataFields(Set<BCMetaDataField> metaDataFields) {
    this.metaDataFields = metaDataFields;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for static pages.
   *
   * @param  staticPages  Set
   */
  public void setStaticPages(Set<BusinessStaticPage> staticPages) {
    this.staticPages = staticPages;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.CreatorEntity#toString()
   */
  @Override public String toString() {
    return "BusinessContext{"
      + "id=" + id
      + ", context=" + context
      + ", active=" + active
      + '}';
  }
} // end class BusinessContext
