package com.cmc.credagility.core.repository;

import org.springframework.data.repository.CrudRepository;

import com.cmc.credagility.core.domain.user.User;
import org.springframework.stereotype.Repository;


/**
 * Created by rojer on 14-10-2.
 *
 * @author   Yang Wang
 * @version  $Revision$, $Date$
 */
@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * findByUsername.
   *
   * @param   username  String
   *
   * @return  User
   */
  User findByUsername(String username);
}
