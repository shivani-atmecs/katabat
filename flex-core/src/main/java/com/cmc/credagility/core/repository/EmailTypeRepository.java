package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmc.credagility.core.domain.channel.EmailType;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 15:26
 */
public interface EmailTypeRepository extends JpaRepository<EmailType, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for email type by name.
   *
   * @param   name  String
   *
   * @return  EmailType
   */
  @Query("from EmailType et where et.name=?1")
  EmailType getEmailTypeByName(String name);
}
