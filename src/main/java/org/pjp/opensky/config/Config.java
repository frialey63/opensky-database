package org.pjp.opensky.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author frialey63
 *
 */
@Component
public final class Config {

    @Value("${loadDatabase}")
    private Boolean loadDatabase;

    @Value("${csvFilePath}")
    private String csvFilePath;

    public Boolean isLoadDatabase() {
        return loadDatabase;
    }

    public String getCsvFilePath() {
        return csvFilePath;
    }

    private Config() {
        // prevent instantiation
    }
}