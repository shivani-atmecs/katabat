package com.cmc.credagility.core.repository;

import com.cmc.credagility.core.domain.channel.DialerChannelResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmc.credagility.core.domain.channel.DialerChannelResult;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 15:06
 */
@Repository
public interface DialerChannelResultRepository extends JpaRepository<DialerChannelResult, Long> {

  @Query("SELECT l from DialerChannelResult l where l.channelAction.category =?1 and l.account.accountNum =?2 order by l.strategyDate desc, l.dialerResultId desc")
  List<DialerChannelResult> getDialerChannelResult(String category, Long accountNum);

  @Query("SELECT l from DialerChannelResult l where l.account.accountNum =?1 order by l.strategyDate desc, l.dialerResultId desc")
  List<DialerChannelResult> getDialerChannelResult(Long accountNum);

  @Query("SELECT l from DialerChannelResult l where l.channelAction.category =?1 and l.account.accountNum =?2 and l.exportDate >=?3 and l.exportDate<?4 order by l.strategyDate desc, l.dialerResultId desc")
  List<DialerChannelResult> getDialerChannelResult(String category, Long accountNum,Date startExportDate, Date endExportDate);

  @Query("SELECT l from DialerChannelResult l where l.account.accountNum =?1 and l.exportDate >=?2 and l.exportDate<?3 order by l.strategyDate desc, l.dialerResultId desc")
  List<DialerChannelResult> getDialerChannelResult(Long accountNum,Date startExportDate,Date endExportDate);

  @Query("select dcr from DialerChannelResult dcr where dcr.responsible.responsibleId=?1 and dcr.status = 'EXPORTED' and dcr.exportDate>=?2 order by dcr.exportDate desc")
  List<DialerChannelResult> getTodayDialerChannelResult(Long responsibleId, Date today);
}
