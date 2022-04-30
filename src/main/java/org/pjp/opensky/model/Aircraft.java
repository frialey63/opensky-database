package org.pjp.opensky.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author frialey63
 *
 */
@Entity
public class Aircraft {

    @Id
    @Column(updatable = false, nullable = false)
    private String icao24;
    @Column
    private String registration;
    @Column
    private String manufacturerIcao;
    @Column
    private String manufacturerName;
    @Column
    private String model;
    @Column
    private String typecode;
    @Column
    private String serialNumber;
    @Column
    private String lineNumber;
    @Column
    private String icaoAircraftType;
    @Column
    private String operator;
    @Column
    private String operatorCallsign;
    @Column
    private String operatorIcao;
    @Column
    private String operatorIata;
    @Column
    private String owner;
    @Column
    private String testReg;
    @Column
    private LocalDate registered;
    @Column
    private LocalDate regUntil;
    @Column
    private String status;
    @Column
    private LocalDate built;
    @Column
    private LocalDate firstFlightDate;
    @Column
    private String seatConfiguration;
    @Column
    private String engines;
    @Column
    private Boolean modes;
    @Column
    private Boolean adsb;
    @Column
    private Boolean acars;
    @Column
    private String notes;
    @Column
    private String categoryDescription;

    public Aircraft() {
        super();
    }

    public Aircraft(String icao24, String manufacturerName, String categoryDescription) {
        super();
        this.icao24 = icao24;
        this.manufacturerName = manufacturerName;
        this.categoryDescription = categoryDescription;
    }

    public Aircraft(String icao24, String registration, String manufacturerIcao, String manufacturerName, String model,
            String typecode, String serialNumber, String lineNumber, String icaoAircraftType, String operator,
            String operatorCallsign, String operatorIcao, String operatorIata, String owner, String testReg,
            LocalDate registered, LocalDate regUntil, String status, LocalDate built, LocalDate firstFlightDate,
            String seatConfiguration, String engines, Boolean modes, Boolean adsb, Boolean acars, String notes,
            String categoryDescription) {
        super();
        this.icao24 = icao24;
        this.registration = registration;
        this.manufacturerIcao = manufacturerIcao;
        this.manufacturerName = manufacturerName;
        this.model = model;
        this.typecode = typecode;
        this.serialNumber = serialNumber;
        this.lineNumber = lineNumber;
        this.icaoAircraftType = icaoAircraftType;
        this.operator = operator;
        this.operatorCallsign = operatorCallsign;
        this.operatorIcao = operatorIcao;
        this.operatorIata = operatorIata;
        this.owner = owner;
        this.testReg = testReg;
        this.registered = registered;
        this.regUntil = regUntil;
        this.status = status;
        this.built = built;
        this.firstFlightDate = firstFlightDate;
        this.seatConfiguration = seatConfiguration;
        this.engines = engines;
        this.modes = modes;
        this.adsb = adsb;
        this.acars = acars;
        this.notes = notes;
        this.categoryDescription = categoryDescription;
    }

    public String getIcao24() {
        return icao24;
    }

    public void setIcao24(String icao24) {
        this.icao24 = icao24;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getManufacturerIcao() {
        return manufacturerIcao;
    }

    public void setManufacturerIcao(String manufacturerIcao) {
        this.manufacturerIcao = manufacturerIcao;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getIcaoAircraftType() {
        return icaoAircraftType;
    }

    public void setIcaoAircraftType(String icaoAircraftType) {
        this.icaoAircraftType = icaoAircraftType;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperatorCallsign() {
        return operatorCallsign;
    }

    public void setOperatorCallsign(String operatorCallsign) {
        this.operatorCallsign = operatorCallsign;
    }

    public String getOperatorIcao() {
        return operatorIcao;
    }

    public void setOperatorIcao(String operatorIcao) {
        this.operatorIcao = operatorIcao;
    }

    public String getOperatorIata() {
        return operatorIata;
    }

    public void setOperatorIata(String operatorIata) {
        this.operatorIata = operatorIata;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTestReg() {
        return testReg;
    }

    public void setTestReg(String testReg) {
        this.testReg = testReg;
    }

    public LocalDate getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDate registered) {
        this.registered = registered;
    }

    public LocalDate getRegUntil() {
        return regUntil;
    }

    public void setRegUntil(LocalDate regUntil) {
        this.regUntil = regUntil;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getBuilt() {
        return built;
    }

    public void setBuilt(LocalDate built) {
        this.built = built;
    }

    public LocalDate getFirstFlightDate() {
        return firstFlightDate;
    }

    public void setFirstFlightDate(LocalDate firstFlightDate) {
        this.firstFlightDate = firstFlightDate;
    }

    public String getSeatConfiguration() {
        return seatConfiguration;
    }

    public void setSeatConfiguration(String seatConfiguration) {
        this.seatConfiguration = seatConfiguration;
    }

    public String getEngines() {
        return engines;
    }

    public void setEngines(String engines) {
        this.engines = engines;
    }

    public Boolean getModes() {
        return modes;
    }

    public void setModes(Boolean modes) {
        this.modes = modes;
    }

    public Boolean getAdsb() {
        return adsb;
    }

    public void setAdsb(Boolean adsb) {
        this.adsb = adsb;
    }

    public Boolean getAcars() {
        return acars;
    }

    public void setAcars(Boolean acars) {
        this.acars = acars;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Aircraft [icao24=");
        builder.append(icao24);
        builder.append(", registration=");
        builder.append(registration);
        builder.append(", manufacturerIcao=");
        builder.append(manufacturerIcao);
        builder.append(", manufacturerName=");
        builder.append(manufacturerName);
        builder.append(", model=");
        builder.append(model);
        builder.append(", typecode=");
        builder.append(typecode);
        builder.append(", serialNumber=");
        builder.append(serialNumber);
        builder.append(", lineNumber=");
        builder.append(lineNumber);
        builder.append(", icaoAircraftType=");
        builder.append(icaoAircraftType);
        builder.append(", operator=");
        builder.append(operator);
        builder.append(", operatorCallsign=");
        builder.append(operatorCallsign);
        builder.append(", operatorIcao=");
        builder.append(operatorIcao);
        builder.append(", operatorIata=");
        builder.append(operatorIata);
        builder.append(", owner=");
        builder.append(owner);
        builder.append(", testReg=");
        builder.append(testReg);
        builder.append(", registered=");
        builder.append(registered);
        builder.append(", regUntil=");
        builder.append(regUntil);
        builder.append(", status=");
        builder.append(status);
        builder.append(", built=");
        builder.append(built);
        builder.append(", firstFlightDate=");
        builder.append(firstFlightDate);
        builder.append(", seatConfiguration=");
        builder.append(seatConfiguration);
        builder.append(", engines=");
        builder.append(engines);
        builder.append(", modes=");
        builder.append(modes);
        builder.append(", adsb=");
        builder.append(adsb);
        builder.append(", acars=");
        builder.append(acars);
        builder.append(", notes=");
        builder.append(notes);
        builder.append(", categoryDescription=");
        builder.append(categoryDescription);
        builder.append("]");
        return builder.toString();
    }

}
