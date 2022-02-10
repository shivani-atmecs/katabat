package com.cmc.credagility.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmc.credagility.core.domain.document.DocumentTypeStatusType;


/**
 * Created by Yang Wang on 1/16/15.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  01/16/2015 17:04 PM
 */
public interface DocumentTypeStatusTypeRepository extends JpaRepository<DocumentTypeStatusType, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * findDocumentTypeStatusTypeByTypeId.
   *
   * @param   typeId  Long
   *
   * @return  List
   */
  @Query("select distinct t from DocumentTypeStatusType t where t.documentType.id = ?1")
  List<DocumentTypeStatusType> findDocumentTypeStatusTypeByTypeId(Long typeId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findDocumentTypeStatusTypeByTypeIdAndPosition.
   *
   * @param   typeId        Long
   * @param   flowPosition  String
   *
   * @return  List
   */
  @Query("select distinct t from DocumentTypeStatusType t where t.documentType.id = ?1 and t.flowPosition= ?2 ")
  List<DocumentTypeStatusType> findDocumentTypeStatusTypeByTypeIdAndPosition(Long typeId, String flowPosition);
} // end interface DocumentTypeStatusTypeRepository
