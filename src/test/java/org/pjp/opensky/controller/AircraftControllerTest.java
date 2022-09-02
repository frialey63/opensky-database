package org.pjp.opensky.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.pjp.opensky.model.Aircraft;
import org.pjp.opensky.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * 1. Ignore the @RestController and test using Mockito in the same way that the service layer has been tested
 * 2. Build the test case using MockHttpServletRequest, see https://howtodoinjava.com/spring-boot2/testing/rest-controller-unit-test-example/
 * 3. Use the MockMvc as in the sample code below, from https://www.baeldung.com/spring-boot-testing
 *
 * @author Paul
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(AircraftController.class)
public class AircraftControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    @Qualifier("aircraftService")
    private AircraftService service;

    @Test
    public void testGetAircraftByIcao24() throws Exception {
        // GIVEN

        String icao24 = "00741d";
        Aircraft aircraft = new Aircraft(icao24, "manufacturerName", "categoryDescription");

        // WHEN

        Mockito.when(service.getAircraftByIcao24(icao24)).thenReturn(Optional.of(aircraft));

        // THEN

        mvc.perform(get("/opensky/aircraft/" + icao24).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.icao24", is(icao24)))
                .andExpect(jsonPath("$.manufacturerName", is(aircraft.getManufacturerName())))
                .andExpect(jsonPath("$.categoryDescription", is(aircraft.getCategoryDescription())));
    }

    @Test
    public void testGetCategoryByIcao24() throws Exception {
        // GIVEN

        String icao24 = "00741d";
        String category = AircraftService.CAT_SMALL;

        // WHEN

        Mockito.when(service.getCategoryByIcao24(icao24)).thenReturn(Optional.of(category));

        // THEN

        mvc.perform(get("/opensky/aircraft/" + icao24 + "/category").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(category)));
    }

}
