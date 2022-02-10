package com.cmc.credagility.core.domain.livechat;

import java.io.Serializable;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.type.ChatInitiatedType;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 11:23
 */
@Entity
@Table(name = "LiveChatSession")
public class LiveChatSession extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1456547385447048683L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "agentId",
    length = 20
  )
  protected String agentId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "agentName",
    length = 80
  )
  protected String agentName;


  /** TODO: DOCUMENT ME! */
  @Column(name = "chatEndTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date chatEndTime;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "chatInitiatedType",
    length = 50
  )
  @Enumerated(EnumType.STRING)
  protected ChatInitiatedType chatInitiatedType;


  /** TODO: DOCUMENT ME! */
  @Column(name = "chatLocalEndTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date chatLocalEndTime;


  /** TODO: DOCUMENT ME! */
  @Column(name = "chatLocalStartTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date chatLocalStartTime;


  /** TODO: DOCUMENT ME! */
  @Column(name = "chatStartTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date chatStartTime;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "cmcChatLocation",
    length = 150
  )
  protected String cmcChatLocation;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long liveChatSessionId;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    mappedBy = "liveChatSession",
    fetch    = FetchType.LAZY,
    cascade  = CascadeType.ALL
  )
  protected Set<LiveChatSessionTranscript> liveChatSessionTranscripts = new LinkedHashSet<LiveChatSessionTranscript>();


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "responsibleId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "sessionId",
    nullable = false,
    length   = 40
  )
  protected String sessionId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "visitorAgent",
    length = 80
  )
  protected String visitorAgent;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "visitorChatReferer",
    length = 800
  )
  protected String visitorChatReferer;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "visitorGeoCity",
    length = 150
  )
  protected String visitorGeoCity;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "visitorGeoConType",
    length = 150
  )
  protected String visitorGeoConType;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "visitorGeoCountry",
    length = 150
  )
  protected String visitorGeoCountry;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "visitorGeoIP",
    length = 20
  )
  protected String visitorGeoIP;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "visitorGeoISP",
    length = 150
  )
  protected String visitorGeoISP;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "visitorGeoLat",
    length = 20
  )
  protected String visitorGeoLat;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "visitorGeoLong",
    length = 20
  )
  protected String visitorGeoLong;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "visitorGeoOrg",
    length = 150
  )
  protected String visitorGeoOrg;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "visitorGeoPost",
    length = 150
  )
  protected String visitorGeoPost;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "visitorGeoReg",
    length = 150
  )
  protected String visitorGeoReg;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "visitorGeoTimeZone",
    length = 150
  )
  protected String visitorGeoTimeZone;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "visitorHost",
    length = 150
  )
  protected String visitorHost;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "visitorId",
    length = 20
  )
  protected String visitorId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "visitorIp",
    length = 20
  )
  protected String visitorIp;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addLiveChatSessionTranscript.
   *
   * @param   transcript  LiveChatSessionTranscript
   *
   * @return  boolean
   */
  public boolean addLiveChatSessionTranscript(LiveChatSessionTranscript transcript) {
    boolean b = getLiveChatSessionTranscripts().add(transcript);

    if (b) {
      transcript.setLiveChatSession(this);
    }

    return b;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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

    LiveChatSession that = (LiveChatSession) o;

    if (!liveChatSessionId.equals(that.liveChatSessionId)) {
      return false;
    }

    if ((agentId != null) ? (!agentId.equals(that.agentId)) : (that.agentId != null)) {
      return false;
    }

    if ((agentName != null) ? (!agentName.equals(that.agentName)) : (that.agentName != null)) {
      return false;
    }

    if ((chatEndTime != null) ? (!chatEndTime.equals(that.chatEndTime)) : (that.chatEndTime != null)) {
      return false;
    }

    if ((chatStartTime != null) ? (!chatStartTime.equals(that.chatStartTime)) : (that.chatStartTime != null)) {
      return false;
    }

    if ((liveChatSessionTranscripts != null) ? (!liveChatSessionTranscripts.equals(that.liveChatSessionTranscripts))
                                             : (that.liveChatSessionTranscripts != null)) {
      return false;
    }

    if (!sessionId.equals(that.sessionId)) {
      return false;
    }

    if ((visitorAgent != null) ? (!visitorAgent.equals(that.visitorAgent)) : (that.visitorAgent != null)) {
      return false;
    }

    if ((visitorChatReferer != null) ? (!visitorChatReferer.equals(that.visitorChatReferer))
                                     : (that.visitorChatReferer != null)) {
      return false;
    }

    if ((visitorGeoCity != null) ? (!visitorGeoCity.equals(that.visitorGeoCity)) : (that.visitorGeoCity != null)) {
      return false;
    }

    if ((visitorGeoConType != null) ? (!visitorGeoConType.equals(that.visitorGeoConType))
                                    : (that.visitorGeoConType != null)) {
      return false;
    }

    if ((visitorGeoCountry != null) ? (!visitorGeoCountry.equals(that.visitorGeoCountry))
                                    : (that.visitorGeoCountry != null)) {
      return false;
    }

    if ((visitorGeoIP != null) ? (!visitorGeoIP.equals(that.visitorGeoIP)) : (that.visitorGeoIP != null)) {
      return false;
    }

    if ((visitorGeoISP != null) ? (!visitorGeoISP.equals(that.visitorGeoISP)) : (that.visitorGeoISP != null)) {
      return false;
    }

    if ((visitorGeoLat != null) ? (!visitorGeoLat.equals(that.visitorGeoLat)) : (that.visitorGeoLat != null)) {
      return false;
    }

    if ((visitorGeoLong != null) ? (!visitorGeoLong.equals(that.visitorGeoLong)) : (that.visitorGeoLong != null)) {
      return false;
    }

    if ((visitorGeoOrg != null) ? (!visitorGeoOrg.equals(that.visitorGeoOrg)) : (that.visitorGeoOrg != null)) {
      return false;
    }

    if ((visitorGeoPost != null) ? (!visitorGeoPost.equals(that.visitorGeoPost)) : (that.visitorGeoPost != null)) {
      return false;
    }

    if ((visitorGeoReg != null) ? (!visitorGeoReg.equals(that.visitorGeoReg)) : (that.visitorGeoReg != null)) {
      return false;
    }

    if ((visitorGeoTimeZone != null) ? (!visitorGeoTimeZone.equals(that.visitorGeoTimeZone))
                                     : (that.visitorGeoTimeZone != null)) {
      return false;
    }

    if ((visitorHost != null) ? (!visitorHost.equals(that.visitorHost)) : (that.visitorHost != null)) {
      return false;
    }

    if (!visitorId.equals(that.visitorId)) {
      return false;
    }

    if ((visitorIp != null) ? (!visitorIp.equals(that.visitorIp)) : (that.visitorIp != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent id.
   *
   * @return  String
   */
  public String getAgentId() {
    return agentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent name.
   *
   * @return  String
   */
  public String getAgentName() {
    return agentName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for chat end time.
   *
   * @return  Date
   */
  public Date getChatEndTime() {
    return chatEndTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for chat initiated type.
   *
   * @return  ChatInitiatedType
   */
  public ChatInitiatedType getChatInitiatedType() {
    return chatInitiatedType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for chat local end time.
   *
   * @return  Date
   */
  public Date getChatLocalEndTime() {
    return chatLocalEndTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for chat local start time.
   *
   * @return  Date
   */
  public Date getChatLocalStartTime() {
    return chatLocalStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for chat start time.
   *
   * @return  Date
   */
  public Date getChatStartTime() {
    return chatStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cmc chat location.
   *
   * @return  String
   */
  public String getCmcChatLocation() {
    return cmcChatLocation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for live chat session id.
   *
   * @return  Long
   */
  public Long getLiveChatSessionId() {
    return liveChatSessionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for live chat session transcripts.
   *
   * @return  Set
   */
  public Set<LiveChatSessionTranscript> getLiveChatSessionTranscripts() {
    return liveChatSessionTranscripts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for session id.
   *
   * @return  String
   */
  public String getSessionId() {
    return sessionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for visitor agent.
   *
   * @return  String
   */
  public String getVisitorAgent() {
    return visitorAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for visitor chat referer.
   *
   * @return  String
   */
  public String getVisitorChatReferer() {
    return visitorChatReferer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for visitor geo city.
   *
   * @return  String
   */
  public String getVisitorGeoCity() {
    return visitorGeoCity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for visitor geo con type.
   *
   * @return  String
   */
  public String getVisitorGeoConType() {
    return visitorGeoConType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for visitor geo country.
   *
   * @return  String
   */
  public String getVisitorGeoCountry() {
    return visitorGeoCountry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for visitor geo IP.
   *
   * @return  String
   */
  public String getVisitorGeoIP() {
    return visitorGeoIP;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for visitor geo ISP.
   *
   * @return  String
   */
  public String getVisitorGeoISP() {
    return visitorGeoISP;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for visitor geo lat.
   *
   * @return  String
   */
  public String getVisitorGeoLat() {
    return visitorGeoLat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for visitor geo long.
   *
   * @return  String
   */
  public String getVisitorGeoLong() {
    return visitorGeoLong;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for visitor geo org.
   *
   * @return  String
   */
  public String getVisitorGeoOrg() {
    return visitorGeoOrg;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for visitor geo post.
   *
   * @return  String
   */
  public String getVisitorGeoPost() {
    return visitorGeoPost;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for visitor geo reg.
   *
   * @return  String
   */
  public String getVisitorGeoReg() {
    return visitorGeoReg;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for visitor geo time zone.
   *
   * @return  String
   */
  public String getVisitorGeoTimeZone() {
    return visitorGeoTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for visitor host.
   *
   * @return  String
   */
  public String getVisitorHost() {
    return visitorHost;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for visitor id.
   *
   * @return  String
   */
  public String getVisitorId() {
    return visitorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for visitor ip.
   *
   * @return  String
   */
  public String getVisitorIp() {
    return visitorIp;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((agentId != null) ? agentId.hashCode() : 0);
    result = (31 * result) + ((agentName != null) ? agentName.hashCode() : 0);
    result = (31 * result) + ((chatEndTime != null) ? chatEndTime.hashCode() : 0);
    result = (31 * result) + ((chatStartTime != null) ? chatStartTime.hashCode() : 0);
    result = (31 * result) + sessionId.hashCode();
    result = (31 * result) + ((visitorAgent != null) ? visitorAgent.hashCode() : 0);
    result = (31 * result) + ((visitorChatReferer != null) ? visitorChatReferer.hashCode() : 0);
    result = (31 * result) + ((visitorGeoCity != null) ? visitorGeoCity.hashCode() : 0);
    result = (31 * result) + ((visitorGeoConType != null) ? visitorGeoConType.hashCode() : 0);
    result = (31 * result) + ((visitorGeoCountry != null) ? visitorGeoCountry.hashCode() : 0);
    result = (31 * result) + ((visitorGeoIP != null) ? visitorGeoIP.hashCode() : 0);
    result = (31 * result) + ((visitorGeoISP != null) ? visitorGeoISP.hashCode() : 0);
    result = (31 * result) + ((visitorGeoLat != null) ? visitorGeoLat.hashCode() : 0);
    result = (31 * result) + ((visitorGeoLong != null) ? visitorGeoLong.hashCode() : 0);
    result = (31 * result) + ((visitorGeoOrg != null) ? visitorGeoOrg.hashCode() : 0);
    result = (31 * result) + ((visitorGeoPost != null) ? visitorGeoPost.hashCode() : 0);
    result = (31 * result) + ((visitorGeoReg != null) ? visitorGeoReg.hashCode() : 0);
    result = (31 * result) + ((visitorGeoTimeZone != null) ? visitorGeoTimeZone.hashCode() : 0);
    result = (31 * result) + ((visitorHost != null) ? visitorHost.hashCode() : 0);
    result = (31 * result) + visitorId.hashCode();
    result = (31 * result) + ((visitorIp != null) ? visitorIp.hashCode() : 0);

    return result;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent id.
   *
   * @param  agentId  String
   */
  public void setAgentId(String agentId) {
    this.agentId = agentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent name.
   *
   * @param  agentName  String
   */
  public void setAgentName(String agentName) {
    this.agentName = agentName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for chat end time.
   *
   * @param  chatEndTime  Date
   */
  public void setChatEndTime(Date chatEndTime) {
    this.chatEndTime = chatEndTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for chat initiated type.
   *
   * @param  chatInitiatedType  ChatInitiatedType
   */
  public void setChatInitiatedType(ChatInitiatedType chatInitiatedType) {
    this.chatInitiatedType = chatInitiatedType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for chat local end time.
   *
   * @param  chatLocalEndTime  Date
   */
  public void setChatLocalEndTime(Date chatLocalEndTime) {
    this.chatLocalEndTime = chatLocalEndTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for chat local start time.
   *
   * @param  chatLocalStartTime  Date
   */
  public void setChatLocalStartTime(Date chatLocalStartTime) {
    this.chatLocalStartTime = chatLocalStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for chat start time.
   *
   * @param  chatStartTime  Date
   */
  public void setChatStartTime(Date chatStartTime) {
    this.chatStartTime = chatStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cmc chat location.
   *
   * @param  cmcChatLocation  String
   */
  public void setCmcChatLocation(String cmcChatLocation) {
    this.cmcChatLocation = cmcChatLocation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for live chat session id.
   *
   * @param  liveChatSessionId  Long
   */
  public void setLiveChatSessionId(Long liveChatSessionId) {
    liveChatSessionId = liveChatSessionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for live chat session transcripts.
   *
   * @param  liveChatSessionTranscripts  Set
   */
  public void setLiveChatSessionTranscripts(Set<LiveChatSessionTranscript> liveChatSessionTranscripts) {
    this.liveChatSessionTranscripts = liveChatSessionTranscripts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for session id.
   *
   * @param  sessionId  String
   */
  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for visitor agent.
   *
   * @param  visitorAgent  String
   */
  public void setVisitorAgent(String visitorAgent) {
    this.visitorAgent = visitorAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for visitor chat referer.
   *
   * @param  visitorChatReferer  String
   */
  public void setVisitorChatReferer(String visitorChatReferer) {
    this.visitorChatReferer = visitorChatReferer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for visitor geo city.
   *
   * @param  visitorGeoCity  String
   */
  public void setVisitorGeoCity(String visitorGeoCity) {
    this.visitorGeoCity = visitorGeoCity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for visitor geo con type.
   *
   * @param  visitorGeoConType  String
   */
  public void setVisitorGeoConType(String visitorGeoConType) {
    this.visitorGeoConType = visitorGeoConType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for visitor geo country.
   *
   * @param  visitorGeoCountry  String
   */
  public void setVisitorGeoCountry(String visitorGeoCountry) {
    this.visitorGeoCountry = visitorGeoCountry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for visitor geo IP.
   *
   * @param  visitorGeoIP  String
   */
  public void setVisitorGeoIP(String visitorGeoIP) {
    this.visitorGeoIP = visitorGeoIP;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for visitor geo ISP.
   *
   * @param  visitorGeoISP  String
   */
  public void setVisitorGeoISP(String visitorGeoISP) {
    this.visitorGeoISP = visitorGeoISP;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for visitor geo lat.
   *
   * @param  visitorGeoLat  String
   */
  public void setVisitorGeoLat(String visitorGeoLat) {
    this.visitorGeoLat = visitorGeoLat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for visitor geo long.
   *
   * @param  visitorGeoLong  String
   */
  public void setVisitorGeoLong(String visitorGeoLong) {
    this.visitorGeoLong = visitorGeoLong;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for visitor geo org.
   *
   * @param  visitorGeoOrg  String
   */
  public void setVisitorGeoOrg(String visitorGeoOrg) {
    this.visitorGeoOrg = visitorGeoOrg;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for visitor geo post.
   *
   * @param  visitorGeoPost  String
   */
  public void setVisitorGeoPost(String visitorGeoPost) {
    this.visitorGeoPost = visitorGeoPost;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for visitor geo reg.
   *
   * @param  visitorGeoReg  String
   */
  public void setVisitorGeoReg(String visitorGeoReg) {
    this.visitorGeoReg = visitorGeoReg;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for visitor geo time zone.
   *
   * @param  visitorGeoTimeZone  String
   */
  public void setVisitorGeoTimeZone(String visitorGeoTimeZone) {
    this.visitorGeoTimeZone = visitorGeoTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for visitor host.
   *
   * @param  visitorHost  String
   */
  public void setVisitorHost(String visitorHost) {
    this.visitorHost = visitorHost;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for visitor id.
   *
   * @param  visitorId  String
   */
  public void setVisitorId(String visitorId) {
    this.visitorId = visitorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for visitor ip.
   *
   * @param  visitorIp  String
   */
  public void setVisitorIp(String visitorIp) {
    this.visitorIp = visitorIp;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    return "LiveChatSession{"
      + "agentId='" + agentId + '\''
      + ", agentName='" + agentName + '\''
      + ", chatEndTime=" + chatEndTime
      + ", chatStartTime=" + chatStartTime
      + ", LiveChatSessionId=" + liveChatSessionId
      + ", liveChatSessionTranscripts=" + liveChatSessionTranscripts
      + ", sessionId='" + sessionId + '\''
      + ", visitorAgent='" + visitorAgent + '\''
      + ", visitorChatReferer='" + visitorChatReferer + '\''
      + ", visitorGeoCity='" + visitorGeoCity + '\''
      + ", visitorGeoConType='" + visitorGeoConType + '\''
      + ", visitorGeoCountry='" + visitorGeoCountry + '\''
      + ", visitorGeoIP='" + visitorGeoIP + '\''
      + ", visitorGeoISP='" + visitorGeoISP + '\''
      + ", visitorGeoLat='" + visitorGeoLat + '\''
      + ", visitorGeoLong='" + visitorGeoLong + '\''
      + ", visitorGeoOrg='" + visitorGeoOrg + '\''
      + ", visitorGeoPost='" + visitorGeoPost + '\''
      + ", visitorGeoReg='" + visitorGeoReg + '\''
      + ", visitorGeoTimeZone='" + visitorGeoTimeZone + '\''
      + ", visitorHost='" + visitorHost + '\''
      + ", visitorId='" + visitorId + '\''
      + ", visitorIp='" + visitorIp + '\''
      + '}';
  } // end method toString
} // end class LiveChatSession
