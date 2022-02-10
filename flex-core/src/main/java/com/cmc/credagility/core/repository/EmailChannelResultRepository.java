package com.cmc.credagility.core.repository;

import com.cmc.credagility.core.domain.channel.EmailChannelResult;
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
public interface EmailChannelResultRepository extends JpaRepository<EmailChannelResult, Long> {
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
      "select e from EmailChannelResult e where e.status = 'INIT' and e.source = 'CID' and e.account.portfolio.portfolioId = :portfolioId and e.createDate < :date"
  )
  List<EmailChannelResult> getUnprocessedEmailChannelResultEarlierThan(@Param("portfolioId") Long portfolioId,
    @Param("date") Date date);


  @Query("SELECT l from EmailChannelResult l where l.channelAction.category =?1 and l.account.accountNum =?2 order by l.strategyDate desc,l.emailResultId desc")
  List<EmailChannelResult> getEmailChannelResult( String category, Long accountNum);

  @Query("SELECT l from EmailChannelResult l where l.account.accountNum =?1 order by l.strategyDate desc,l.emailResultId desc")
  List<EmailChannelResult> getEmailChannelResult(Long accountNum);

  @Query("SELECT l from EmailChannelResult l where l.channelAction.category =?1 and l.account.accountNum =?2 and l.exportDate >=?3 and l.exportDate<?4 order by l.strategyDate desc,l.emailResultId desc")
  List<EmailChannelResult> getEmailChannelResult( String category, Long accountNum,Date startExportDate, Date endExportDate);

  @Query("SELECT l from EmailChannelResult l where l.account.accountNum =?1 and l.exportDate >=?2 and l.exportDate<?3 order by l.strategyDate desc,l.emailResultId desc")
  List<EmailChannelResult> getEmailChannelResult(Long accountNum,Date startExportDate, Date endExportDate);


}
