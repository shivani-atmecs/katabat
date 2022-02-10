package com.ozstrategy.credagility.core.repository;


import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.account.AccountEligibleProgram;
import com.ozstrategy.credagility.core.domain.ProgramAction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountEligibleProgramRepository extends JpaRepository<AccountEligibleProgram, Long> {
  List<AccountEligibleProgram> findByAccountAndProgramAction(Account account, ProgramAction programAction);
}
