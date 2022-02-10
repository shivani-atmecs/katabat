package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.document.DocumentFile;


/**
 * Created by yongliu on 1/15/15.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  01/15/2015 14:37
 */
@Repository public interface DocumentFileRepository extends JpaRepository<DocumentFile, Long> { }
