package com.cmc.credagility.core.repository;

import com.cmc.credagility.core.domain.channel.SmsChannelResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/23/2014 14:30
 */
public interface SmsChannelResultRepository extends JpaRepository<SmsChannelResult, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * TODO: DOCUMENT ME!
   *
   * @param   portfolioId  Long
   * @param   date         Date
   *
   * @return  List
   */
  @Query(
    value =
      "select e from SmsChannelResult e where e.status = 'INIT' and e.source = 'CID' and e.account.portfolio.portfolioId = :portfolioId and e.createDate < :date"
  )
  List<SmsChannelResult> getUnprocessedSmsChannelResultEarlierThan(@Param("portfolioId") Long portfolioId,
    @Param("date") Date date);

  @Query("SELECT l from SmsChannelResult l where l.channelAction.category =?1 and l.account.accountNum =?2 order by l.strategyDate desc, l.smsResultId desc")
  List<SmsChannelResult> getSmsChannelResult(String category, Long accountNum);

  @Query("SELECT l from SmsChannelResult l where l.account.accountNum =?1 order by l.strategyDate desc, l.smsResultId desc")
  List<SmsChannelResult> getSmsChannelResult(Long accountNum);

  @Query("SELECT l from SmsChannelResult l where l.channelAction.category =?1 and l.account.accountNum =?2 and l.exportDate >=?3 and l.exportDate<?4 order by l.strategyDate desc, l.smsResultId desc")
  List<SmsChannelResult> getSmsChannelResult(String category, Long accountNum,Date startExportDate, Date endExportDate);

  @Query("SELECT l from SmsChannelResult l where l.account.accountNum =?1 and l.exportDate >=?2 and l.exportDate<?3 order by l.strategyDate desc, l.smsResultId desc")
  List<SmsChannelResult> getSmsChannelResult(Long accountNum,Date startExportDate, Date endExportDate);

}
