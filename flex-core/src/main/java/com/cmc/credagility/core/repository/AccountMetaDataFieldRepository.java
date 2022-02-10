package com.cmc.credagility.core.repository;

import com.cmc.credagility.core.domain.account.AccountMetaDataField;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMetaDataFieldRepository extends JpaRepository<AccountMetaDataField, Long> {

  @Query("select amdf from AccountMetaDataField amdf where amdf.name = ?1")
  List<AccountMetaDataField> getAccountMetaDataField(String name);

}

