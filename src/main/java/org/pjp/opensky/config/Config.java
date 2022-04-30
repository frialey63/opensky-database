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

    @Value("${excludeEmptyCategory}")
    private Boolean excludeEmptyCategory;

    public Boolean getLoadDatabase() {
        return loadDatabase;
    }

    public String getCsvFilePath() {
        return csvFilePath;
    }

    public Boolean getExcludeEmptyCategory() {
        return excludeEmptyCategory;
    }

    private Config() {
        // prevent instantiation
    }
}