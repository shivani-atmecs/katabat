package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmc.credagility.core.domain.address.StateParameter;
import org.springframework.stereotype.Repository;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 17:27
 */
@Repository
public interface StateParameterRepository extends JpaRepository<StateParameter, String> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for state parameter.
   *
   * @param   state  String
   *
   * @return  StateParameter
   */
  @Query("select s from StateParameter s where s.state=?1")
  StateParameter getStateParameter(final String state);
}
