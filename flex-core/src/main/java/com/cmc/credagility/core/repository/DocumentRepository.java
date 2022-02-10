package com.cmc.credagility.core.repository;

import com.cmc.credagility.core.domain.document.DocumentTypeStatusType;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.document.Document;

import java.util.List;


/**
 * Created by yongliu on 1/15/15.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  01/15/2015 14:36
 */
@Repository public interface DocumentRepository extends JpaRepository<Document, Long> {

  
  @Query("select t from DocumentTypeStatusType t where t.documentType.id = ?1")
  List<DocumentTypeStatusType> findDocumentTypeStatusTypeByTypeId(Long docTypeId);

  @Query("select t from DocumentTypeStatusType t where t.documentType.id = ?1 and t.flowPosition = ?2")
  List<DocumentTypeStatusType> findDocumentTypeStatusTypeByTypeId(Long docTypeId, String flowPosition);
}
