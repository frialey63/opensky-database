package org.pjp.opensky.service;

import java.util.Optional;

import org.pjp.opensky.model.Aircraft;

public interface AircraftService {

	String CAT_MEDIUM = "MEDIUM";
	String CAT_LARGE = "LARGE";
	String CAT_SMALL = "SMALL";

	Optional<Aircraft> getAircraftByIcao24(String icao24);

	Optional<String> getCategoryByIcao24(String icao24);

}