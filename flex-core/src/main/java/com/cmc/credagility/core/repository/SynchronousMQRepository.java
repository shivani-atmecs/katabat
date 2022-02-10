package com.cmc.credagility.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.message.MessagePacket;
import com.cmc.credagility.core.domain.webactivity.SynchronousMQCallStatus;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 17:31
 */
@Repository public interface SynchronousMQRepository extends JpaRepository<SynchronousMQCallStatus, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for last request.
   *
   * @param   status         String
   * @param   msgType        String
   * @param   acctNum        Long
   *
   * @return  SynchronousMQCallStatus
   */
  @Query(
    "select s from SynchronousMQCallStatus s where s.status=?1 and s.messageType=?2 and s.messageStaging.account.accountNum=?3 order by s.createDate desc"
  )
  List<SynchronousMQCallStatus> getLastRequest(String status, String msgType, Long acctNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message packet by packet name and portfolio id.
   *
   * @param   packetNames  String[]
   * @param   portfolioId  Long
   *
   * @return  Map
   */
  @Query("select m from MessagePacket m where m.packetName in(?1) and m.portfolio.portfolioId=?2")
  List<MessagePacket> getMessagePacketByPacketNameAndPortfolioId(List<String> packetNames, Long portfolioId);

  @Query("select sc from SynchronousMQCallStatus sc where sc.messageType=?2 and sc.transViewKey=?1 order by sc.createDate desc")
  List<SynchronousMQCallStatus> getFinalStatus(String transViewKey, String msgType);
} // end interface SynchronousMQRepository
