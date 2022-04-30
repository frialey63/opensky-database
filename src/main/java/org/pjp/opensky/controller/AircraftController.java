package org.pjp.opensky.controller;

import java.util.Optional;

import org.pjp.opensky.model.Aircraft;
import org.pjp.opensky.repository.AircraftRepository;
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

    private static final String CAT_MEDIUM = "medium";
    private static final String CAT_LARGE = "large";
    private static final String CAT_SMALL = "small";

    private final AircraftRepository aircraftRepository;

    @Autowired
    public AircraftController(AircraftRepository aircraftRepository) {
        super();
        this.aircraftRepository = aircraftRepository;
    }

    @RequestMapping(value = "/{icao24}", method = RequestMethod.GET)
    Optional<Aircraft> getAircraftByIcao24(@PathVariable("icao24") String icao24) {
        return aircraftRepository.findById(icao24);
    }

    @RequestMapping(value = "/{icao24}/category", method = RequestMethod.GET)
    Optional<String> getCategoryByIcao24(@PathVariable("icao24") String icao24) {
        Optional<String> result;

        Optional<Aircraft> optAircraft = aircraftRepository.findById(icao24);

        if (optAircraft.isPresent()) {
            String category = optAircraft.get().getCategoryDescription().toLowerCase();
            String tempResult;

            if (category.contains("small") || category.contains("light")) {
                tempResult = CAT_SMALL;
            } else if (category.contains("large") || category.contains("heavy")) {
                tempResult = CAT_LARGE;
            } else {
                tempResult = CAT_MEDIUM;
            }

            result = Optional.of(tempResult);

        } else {
            result = Optional.empty();
        }

        return result;
    }

}
