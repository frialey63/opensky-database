package org.pjp.opensky.controller;

import java.util.Optional;

import org.pjp.opensky.model.Aircraft;
import org.pjp.opensky.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author frialey63
 *
 */
@RestController
@RequestMapping("opensky/aircraft")
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;

    public AircraftController() {
        super();
    }

    @RequestMapping(value = "/{icao24}", method = RequestMethod.GET)
    Optional<Aircraft> getAircraftByIcao24(@PathVariable("icao24") String icao24) {
        return aircraftService.getAircraftByIcao24(icao24);
    }

    @RequestMapping(value = "/{icao24}/category", method = RequestMethod.GET)
    Optional<String> getCategoryByIcao24(@PathVariable("icao24") String icao24) {
        return aircraftService.getCategoryByIcao24(icao24);
    }


}
