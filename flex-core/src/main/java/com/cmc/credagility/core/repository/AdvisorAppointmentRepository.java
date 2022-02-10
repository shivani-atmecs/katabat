package com.cmc.credagility.core.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmc.credagility.core.domain.client.AdvisorAppointment;
import com.cmc.credagility.core.domain.type.AppointmentStatus;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 15:19
 */
public interface AdvisorAppointmentRepository extends JpaRepository<AdvisorAppointment, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * countAppointmentByResponsibleId.
   *
   * @param   responsibleId  Long
   *
   * @return  long
   */
  Long countByResponsibleResponsibleId(Long responsibleId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * countScheduledAppointmentByResponsible.
   *
   * @param   responsibleId    Long
   * @param   appointmentDate  Date
   *
   * @return  Long
   */
  @Query(
    "select count(distinct a) from AdvisorAppointment a where a.responsible.responsibleId = ?1 and a.status = 'SCHEDULED' and a.appointmentDateTime > ?2 order by a.createDate asc"
  )
  Long countScheduledAppointmentByResponsible(Long responsibleId, Date appointmentDate);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listAdvisorAppointment.
   *
   * @param   responsibleId  Long
   * @param   page           Pageable
   *
   * @return  Page
   */
  Page<AdvisorAppointment> findByResponsibleResponsibleIdOrderByCreateDateDesc(Long responsibleId, Pageable page);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listScheduledAppointmentByResponsible.
   *
   * @param   responsibleId    Long
   * @param   appointmentDate  Date
   * @param   page             Pageable
   *
   * @return  Page
   */
  @Query(
    "select a from AdvisorAppointment a where a.responsible.responsibleId = ?1 and a.status = 'SCHEDULED' and a.appointmentDateTime > ?2 order by a.createDate asc"
  )
  Page<AdvisorAppointment> listScheduledAppointmentByResponsible(Long responsibleId, Date appointmentDate,
    Pageable page);
} // end interface AdvisorAppointmentRepository
