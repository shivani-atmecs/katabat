package com.cmc.credagility.core.repository;

import com.cmc.credagility.core.domain.variable.UtilityHiddenVariable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilityHiddenVariableRepository extends JpaRepository<UtilityHiddenVariable, Long> {

  @Query("select v from UtilityHiddenVariable v where v.context=?1 and v.name=?2")
  List<UtilityHiddenVariable> findUtilityVariableByName(String context, String name);

}
