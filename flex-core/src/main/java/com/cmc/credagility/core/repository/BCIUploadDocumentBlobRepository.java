package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozstrategy.credagility.core.domain.document.bci.BCIUploadDocumentBlob;


/**
 * Created by yongliu on 11/21/15.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  11/21/2015 20:12
 */
public interface BCIUploadDocumentBlobRepository extends JpaRepository<BCIUploadDocumentBlob, Long> { }
