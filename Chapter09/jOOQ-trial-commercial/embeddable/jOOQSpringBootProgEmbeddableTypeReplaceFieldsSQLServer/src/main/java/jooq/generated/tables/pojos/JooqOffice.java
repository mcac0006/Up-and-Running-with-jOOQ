/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables.pojos;


import java.io.Serializable;

import javax.annotation.processing.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jooq.generated.embeddables.pojos.Location;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4",
        "schema version:1.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqOffice implements Serializable {

    private static final long serialVersionUID = 1L;

    private String officeCode;
    private String city;
    private String phone;
    private String addressLineFirst;
    private String addressLineSecond;
    private String state;
    private String country;
    private String postalCode;
    private String territory;

    public JooqOffice() {}

    public JooqOffice(JooqOffice value) {
        this.officeCode = value.officeCode;
        this.city = value.city;
        this.phone = value.phone;
        this.addressLineFirst = value.addressLineFirst;
        this.addressLineSecond = value.addressLineSecond;
        this.state = value.state;
        this.country = value.country;
        this.postalCode = value.postalCode;
        this.territory = value.territory;
    }

    public JooqOffice(
        String officeCode,
        String city,
        String phone,
        String addressLineFirst,
        String addressLineSecond,
        String state,
        String country,
        String postalCode,
        String territory
    ) {
        this.officeCode = officeCode;
        this.city = city;
        this.phone = phone;
        this.addressLineFirst = addressLineFirst;
        this.addressLineSecond = addressLineSecond;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.territory = territory;
    }

    /**
     * Getter for <code>classicmodels.dbo.office.office_code</code>.
     */
    @NotNull
    @Size(max = 10)
    public String getOfficeCode() {
        return this.officeCode;
    }

    /**
     * Setter for <code>classicmodels.dbo.office.office_code</code>.
     */
    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    /**
     * Getter for <code>classicmodels.dbo.office.city</code>.
     */
    @Size(max = 50)
    public String getCity() {
        return this.city;
    }

    /**
     * Setter for <code>classicmodels.dbo.office.city</code>.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter for <code>classicmodels.dbo.office.phone</code>.
     */
    @NotNull
    @Size(max = 50)
    public String getPhone() {
        return this.phone;
    }

    /**
     * Setter for <code>classicmodels.dbo.office.phone</code>.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Getter for <code>classicmodels.dbo.office.address_line_first</code>.
     */
    @NotNull
    @Size(max = 50)
    public String getAddressLineFirst() {
        return this.addressLineFirst;
    }

    /**
     * Setter for <code>classicmodels.dbo.office.address_line_first</code>.
     */
    public void setAddressLineFirst(String addressLineFirst) {
        this.addressLineFirst = addressLineFirst;
    }

    /**
     * Getter for <code>classicmodels.dbo.office.address_line_second</code>.
     */
    @Size(max = 50)
    public String getAddressLineSecond() {
        return this.addressLineSecond;
    }

    /**
     * Setter for <code>classicmodels.dbo.office.address_line_second</code>.
     */
    public void setAddressLineSecond(String addressLineSecond) {
        this.addressLineSecond = addressLineSecond;
    }

    /**
     * Getter for <code>classicmodels.dbo.office.state</code>.
     */
    @Size(max = 50)
    public String getState() {
        return this.state;
    }

    /**
     * Setter for <code>classicmodels.dbo.office.state</code>.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Getter for <code>classicmodels.dbo.office.country</code>.
     */
    @Size(max = 50)
    public String getCountry() {
        return this.country;
    }

    /**
     * Setter for <code>classicmodels.dbo.office.country</code>.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Getter for <code>classicmodels.dbo.office.postal_code</code>.
     */
    @NotNull
    @Size(max = 15)
    public String getPostalCode() {
        return this.postalCode;
    }

    /**
     * Setter for <code>classicmodels.dbo.office.postal_code</code>.
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Getter for <code>classicmodels.dbo.office.territory</code>.
     */
    @NotNull
    @Size(max = 10)
    public String getTerritory() {
        return this.territory;
    }

    /**
     * Setter for <code>classicmodels.dbo.office.territory</code>.
     */
    public void setTerritory(String territory) {
        this.territory = territory;
    }

    /**
     * Setter for <code>classicmodels.dbo.LOCATION</code>.
     */
    public void setLocation(Location value) {
        setCity(value.getCity());
        setAddressLineFirst(value.getAddressLineFirst());
        setState(value.getState());
        setCountry(value.getCountry());
    }

    /**
     * Getter for <code>classicmodels.dbo.LOCATION</code>.
     */
    public Location getLocation() {
        return new Location(
              getCity()
            , getAddressLineFirst()
            , getState()
            , getCountry()
        );
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JooqOffice (");

        sb.append(officeCode);
        sb.append(", ").append(city);
        sb.append(", ").append(phone);
        sb.append(", ").append(addressLineFirst);
        sb.append(", ").append(addressLineSecond);
        sb.append(", ").append(state);
        sb.append(", ").append(country);
        sb.append(", ").append(postalCode);
        sb.append(", ").append(territory);

        sb.append(")");
        return sb.toString();
    }
}