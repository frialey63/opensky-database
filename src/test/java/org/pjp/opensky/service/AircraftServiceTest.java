package org.pjp.opensky.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.pjp.opensky.model.Aircraft;
import org.pjp.opensky.repository.AircraftRepository;

@RunWith(MockitoJUnitRunner.class)
public class AircraftServiceTest {

    @InjectMocks
    private AircraftServiceImpl aircraftService;

    @Mock
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
