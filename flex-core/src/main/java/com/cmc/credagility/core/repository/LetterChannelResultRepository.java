package com.cmc.credagility.core.repository;

import com.cmc.credagility.core.domain.channel.LetterChannelResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 15:52
 */
public interface LetterChannelResultRepository extends JpaRepository<LetterChannelResult, Long> {


  @Query("SELECT l from LetterChannelResult l where l.channelAction.category =?1 and l.account.accountNum =?2 order by l.strategyDate desc, l.letterResultId desc")
  List<LetterChannelResult> getLetterChannelResult(String category, Long accountNum);

  @Query("SELECT l from LetterChannelResult l where l.account.accountNum =?1 order by l.strategyDate desc, l.letterResultId desc")
  List<LetterChannelResult> getLetterChannelResult(Long accountNum);

  @Query("SELECT l from LetterChannelResult l where l.channelAction.category =?1 and l.account.accountNum =?2 and l.exportDate >=?3 and l.exportDate<?4 order by l.strategyDate desc, l.letterResultId desc")
  List<LetterChannelResult> getLetterChannelResult(String category, Long accountNum,Date startExportDate,Date endExportDate);

  @Query("SELECT l from LetterChannelResult l where l.account.accountNum =?1 and l.exportDate >=?2 and l.exportDate<?3 order by l.strategyDate desc, l.letterResultId desc")
  List<LetterChannelResult> getLetterChannelResult(Long accountNum,Date startExportDate,Date endExportDate);

}
