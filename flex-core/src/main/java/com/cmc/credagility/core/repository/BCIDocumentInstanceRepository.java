package com.cmc.credagility.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmc.credagility.core.domain.businesscontext.BusinessContextInstance;

import com.ozstrategy.credagility.core.domain.document.bci.BCIDocumentInstance;
import com.ozstrategy.credagility.core.domain.document.bci.BCIUploadDocumentBlob;


/**
 * Created by tangwei on 11/21/15.
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  11/21/2015 02:00
 */
public interface BCIDocumentInstanceRepository extends JpaRepository<BCIDocumentInstance, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context instances by case.
   *
   * @param   bci  BusinessContextInstance
   *
   * @return  List
   */
  @Query("select ins from BCIDocumentInstance ins where ins.bci=?1")
  List<BCIDocumentInstance> getBCIDocumentInstances(BusinessContextInstance bci);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for BCIUpload document blobs by doc instance.
   *
   * @param   documentInstance  BCIDocumentInstance
   *
   * @return  List
   */
  @Query("select b from BCIUploadDocumentBlob b where b.documentInstance=?1")
  List<BCIUploadDocumentBlob> getBCIUploadDocumentBlobsByDocInstance(BCIDocumentInstance documentInstance);


} // end interface BCIDocumentInstanceRepository
