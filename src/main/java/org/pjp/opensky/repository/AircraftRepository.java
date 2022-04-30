package org.pjp.opensky.repository;

import org.pjp.opensky.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author frialey63
 *
 */
public interface AircraftRepository extends JpaRepository<Aircraft, String> {

}
