package org.pjp.opensky;

import java.io.FileReader;
import java.io.Reader;
import java.time.LocalDate;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.pjp.opensky.config.Config;
import org.pjp.opensky.model.Aircraft;
import org.pjp.opensky.repository.AircraftRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.google.common.base.Strings;

/**
 * @author frialey63
 *
 */
@ComponentScan(basePackages = { "org.pjp.opensky" })
@SpringBootApplication
public class OpenSkyApplication implements ApplicationRunner {

    private static Boolean parseBoolean(String str) {
        if (str == null) {
            return null;
        }

        return Boolean.parseBoolean(str);
    }

    private static LocalDate parseLocalDate(String str) {
        if (Strings.isNullOrEmpty(str)) {
            return null;
        }

        return LocalDate.parse(str);
    }

    private static final String NO_CATEGORY = "No ADS-B Emitter Category Information";

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenSkyApplication.class);

    @Autowired
    private AircraftRepository repository;

    @Autowired
    private Config config;

    /**
     * @param args The args
     */
    public static void main(String[] args) {
        SpringApplication.run(OpenSkyApplication.class);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        if (config.isLoadDatabase()) {
            Reader in = new FileReader(config.getCsvFilePath());

            @SuppressWarnings("deprecation")
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);

            int count = 0;

            for (CSVRecord record : records) {
                String icao24 = record.get("icao24");
                String registration = record.get("registration");
                String manufacturerIcao = record.get("manufacturericao");
                String manufacturerName = record.get("manufacturername");
                String model = record.get("model");
                String typeCode = record.get("typecode");
                String serialNumber = record.get("serialnumber");
                String lineNumber = record.get("linenumber");
                String icaoAircraftType = record.get("icaoaircrafttype");
                String operator = record.get("operator");
                String operatorCallsign = record.get("operatorcallsign");
                String operatorIcao = record.get("operatoricao");
                String operatorIata = record.get("operatoriata");
                String owner = record.get("owner");
                String testReg = record.get("testreg");
                LocalDate registered = parseLocalDate(record.get("registered"));
                LocalDate regUntil = parseLocalDate(record.get("reguntil"));
                String status = record.get("status");
                LocalDate built = parseLocalDate(record.get("built"));
                LocalDate firstFlightDate = parseLocalDate(record.get("firstflightdate"));
                String seatConfiguration = record.get("seatconfiguration");
                String engines = record.get("engines");
                Boolean modes = parseBoolean(record.get("modes"));
                Boolean adsb = parseBoolean(record.get("adsb"));
                Boolean acars = parseBoolean(record.get("acars"));
                String notes = record.get("notes");
                String categoryDescription = record.get("categoryDescription");

                if (!Strings.isNullOrEmpty(categoryDescription) && !NO_CATEGORY.equals(categoryDescription)) {
                    Aircraft aircraft = new Aircraft(icao24, registration, manufacturerIcao, manufacturerName, model, typeCode, serialNumber, lineNumber, icaoAircraftType, operator, operatorCallsign, operatorIcao, operatorIata, owner, testReg, registered, regUntil, status, built, firstFlightDate, seatConfiguration, engines, modes, adsb, acars, notes, categoryDescription);

                    repository.save(aircraft);

                    count++;
                }

                if (count == 1000) {
                    break;
                }
            }

            LOGGER.info("finished loading {} aircraft from CSV into database", count);
        }

        if (LOGGER.isDebugEnabled()) {
            for (Aircraft ac : repository.findAll()) {
                LOGGER.debug(ac.toString());
            }
        }
    }

}
