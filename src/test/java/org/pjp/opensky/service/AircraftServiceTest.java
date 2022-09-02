package org.pjp.opensky.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.pjp.opensky.model.Aircraft;
import org.pjp.opensky.repository.AircraftRepository;
import org.pjp.opensky.service.AircraftServiceTest.AircraftServiceImplTestContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import(AircraftServiceImplTestContextConfiguration.class)
public class AircraftServiceTest {

    @TestConfiguration
    static class AircraftServiceImplTestContextConfiguration {

        @Bean
        public AircraftService aircraftService() {
            return new AircraftServiceImpl();
        }
    }

    @Autowired
    private AircraftService aircraftService;

    @MockBean
    private AircraftRepository aircraftRepository;

    @Test
    public void testGetAircraftByIcao24() {
        // GIVEN

        String icao24 = "00741d";
        Aircraft aircraft = new Aircraft(icao24, "manufacturerName", "categoryDescription");

        // WHEN

        Mockito.when(aircraftRepository.findById(icao24)).thenReturn(Optional.of(aircraft));

        // THEN

        Optional<Aircraft> optAircraft = aircraftService.getAircraftByIcao24(icao24);

        assertTrue(optAircraft.isPresent());
        assertEquals(icao24, optAircraft.get().getIcao24());
    }

    @Test
    public void testGetCategoryByIcao24Small() {
        // GIVEN

        String icao24 = "00741d";
        Aircraft aircraft = new Aircraft(icao24, "manufacturerName", "smallCategoryDescription");

        // WHEN

        Mockito.when(aircraftRepository.findById(icao24)).thenReturn(Optional.of(aircraft));

        // THEN

        Optional<String> optCategory = aircraftService.getCategoryByIcao24(icao24);

        assertTrue(optCategory.isPresent());
        assertEquals(AircraftService.CAT_SMALL, optCategory.get());
    }

    @Test
    public void testGetCategoryByIcao24Large() {
        // GIVEN

        String icao24 = "00741d";
        Aircraft aircraft = new Aircraft(icao24, "manufacturerName", "largeCategoryDescription");

        // WHEN

        Mockito.when(aircraftRepository.findById(icao24)).thenReturn(Optional.of(aircraft));

        // THEN

        Optional<String> optCategory = aircraftService.getCategoryByIcao24(icao24);

        assertTrue(optCategory.isPresent());
        assertEquals(AircraftService.CAT_LARGE, optCategory.get());
    }

    @Test
    public void testGetCategoryByIcao24Medium() {
        // GIVEN

        String icao24 = "00741d";
        Aircraft aircraft = new Aircraft(icao24, "manufacturerName", "categoryDescription");

        // WHEN

        Mockito.when(aircraftRepository.findById(icao24)).thenReturn(Optional.of(aircraft));

        // THEN

        Optional<String> optCategory = aircraftService.getCategoryByIcao24(icao24);

        assertTrue(optCategory.isPresent());
        assertEquals(AircraftService.CAT_MEDIUM, optCategory.get());
    }

}
