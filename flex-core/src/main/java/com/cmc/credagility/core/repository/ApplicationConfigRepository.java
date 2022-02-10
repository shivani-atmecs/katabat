package com.cmc.credagility.core.repository;


import com.cmc.credagility.core.domain.config.ApplicationConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 15:41
 */
@Repository
public interface ApplicationConfigRepository extends JpaRepository<ApplicationConfig, String> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * findFirstByFeatureName.
   *
   * @param   featureName  String
   *
   * @return  ApplicationConfigRepository
   */
  ApplicationConfig findFirstByFeatureName(String featureName);
  
}
