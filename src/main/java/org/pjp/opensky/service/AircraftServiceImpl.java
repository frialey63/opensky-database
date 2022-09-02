package org.pjp.opensky.service;

import java.util.Optional;

import org.pjp.opensky.model.Aircraft;
import org.pjp.opensky.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AircraftServiceImpl implements AircraftService {

	@Autowired
    private AircraftRepository aircraftRepository;

    public AircraftServiceImpl() {
        super();
    }

    @Override
	public Optional<Aircraft> getAircraftByIcao24(String icao24) {
        return aircraftRepository.findById(icao24);
    }

    @Override
	public Optional<String> getCategoryByIcao24(String icao24) {
        Optional<String> result;

        Optional<Aircraft> optAircraft = aircraftRepository.findById(icao24);

        if (optAircraft.isPresent()) {
            String category = optAircraft.get().getCategoryDescription().toLowerCase();
            String tempResult;

            if (category.contains("small") || category.contains("light") || category.contains("glider")) {
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
