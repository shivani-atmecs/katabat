package com.cmc.credagility.core.domain.livechat;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 12:03
 */
@Entity
@Table(name = "LiveChatSessionTranscript")
public class LiveChatSessionTranscript extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 7015775085868614044L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "chatBy",
    length = 80
  )
  protected String chatBy;


  /** TODO: DOCUMENT ME! */
  @Column(name = "chatLocalTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date chatLocalTime;


  /** TODO: DOCUMENT ME! */
  @Lob protected String chatText;


  /** TODO: DOCUMENT ME! */
  @Column(name = "chatTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date chatTime;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "liveChatSessionId",
    nullable = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected LiveChatSession liveChatSession;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long liveChatSessionTranscriptId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof LiveChatSessionTranscript)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    LiveChatSessionTranscript that = (LiveChatSessionTranscript) o;

    if ((chatBy != null) ? (!chatBy.equals(that.chatBy)) : (that.chatBy != null)) {
      return false;
    }

    if ((chatText != null) ? (!chatText.equals(that.chatText)) : (that.chatText != null)) {
      return false;
    }

    if ((chatTime != null) ? (!chatTime.equals(that.chatTime)) : (that.chatTime != null)) {
      return false;
    }

    if ((liveChatSession != null) ? (!liveChatSession.equals(that.liveChatSession)) : (that.liveChatSession != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for chat by.
   *
   * @return  String
   */
  public String getChatBy() {
    return chatBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for chat local time.
   *
   * @return  Date
   */
  public Date getChatLocalTime() {
    return chatLocalTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for chat text.
   *
   * @return  String
   */
  public String getChatText() {
    return chatText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for chat time.
   *
   * @return  Date
   */
  public Date getChatTime() {
    return chatTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for live chat session.
   *
   * @return  LiveChatSession
   */
  public LiveChatSession getLiveChatSession() {
    return liveChatSession;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for live chat session transcript id.
   *
   * @return  Long
   */
  public Long getLiveChatSessionTranscriptId() {
    return liveChatSessionTranscriptId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((chatBy != null) ? chatBy.hashCode() : 0);
    result = (31 * result) + ((chatText != null) ? chatText.hashCode() : 0);
    result = (31 * result) + ((chatTime != null) ? chatTime.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for chat by.
   *
   * @param  chatBy  String
   */
  public void setChatBy(String chatBy) {
    this.chatBy = chatBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for chat local time.
   *
   * @param  chatLocalTime  Date
   */
  public void setChatLocalTime(Date chatLocalTime) {
    this.chatLocalTime = chatLocalTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for chat text.
   *
   * @param  chatText  String
   */
  public void setChatText(String chatText) {
    this.chatText = chatText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for chat time.
   *
   * @param  chatTime  Date
   */
  public void setChatTime(Date chatTime) {
    this.chatTime = chatTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for live chat session.
   *
   * @param  liveChatSession  LiveChatSession
   */
  public void setLiveChatSession(LiveChatSession liveChatSession) {
    this.liveChatSession = liveChatSession;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for live chat session transcript id.
   *
   * @param  liveChatSessionTranscriptId  Long
   */
  public void setLiveChatSessionTranscriptId(Long liveChatSessionTranscriptId) {
    this.liveChatSessionTranscriptId = liveChatSessionTranscriptId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    return "LiveChatSessionTranscript{"
      + "chatBy='" + chatBy + '\''
      + ", chatText='" + chatText + '\''
      + ", chatTime=" + chatTime
      + ", LiveChatSessionTranscriptId=" + liveChatSessionTranscriptId
      + '}';
  }
} // end class LiveChatSessionTranscript
