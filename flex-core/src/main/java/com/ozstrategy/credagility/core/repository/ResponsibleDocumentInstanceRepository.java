package com.ozstrategy.credagility.core.repository;

import com.ozstrategy.credagility.core.domain.document.responsible.ResponsibleDocumentInstance;
import com.ozstrategy.credagility.core.domain.document.responsible.ResponsibleUploadDocumentBlob;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * Created by yongliu on 2/10/15.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  02/10/2015 14:31
 */

@Repository public interface ResponsibleDocumentInstanceRepository
  extends JpaRepository<ResponsibleDocumentInstance, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for doc blob by instance id.
   *
   * @param   docInstanceId  Long
   *
   * @return  ResponsibleUploadDocumentBlob
   */
  @Query("select distinct b from ResponsibleUploadDocumentBlob b where b.documentInstance.id=?1")
  ResponsibleUploadDocumentBlob getDocBlobByInstanceId(Long docInstanceId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * readWorkflowDocumentHistory.
   *
   * @param   documentId     Long
   * @param   responsibleId  Long
   * @param   page           Pageable
   *
   * @return  Page
   */
  @Query(
    "select i from ResponsibleDocumentInstance i where i.document.id=?1 and i.owner.responsibleId=?2 ORDER BY i.createDate ASC, i.lastUpdateDate DESC"
  )
  Page<ResponsibleDocumentInstance> readWorkflowDocumentHistory(Long documentId, Long responsibleId, Pageable page);
} // end interface ResponsibleDocumentInstanceRepository
