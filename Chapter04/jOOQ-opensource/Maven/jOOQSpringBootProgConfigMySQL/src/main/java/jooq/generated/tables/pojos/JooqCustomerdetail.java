/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables.pojos;


import java.io.Serializable;

import javax.annotation.processing.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.4",
        "schema version:1.1"
    },
    date = "2020-10-19T13:27:12.864Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqCustomerdetail implements Serializable {

    private static final long serialVersionUID = 367077884;

    private Long   customerNumber;
    private String addressLineFirst;
    private String addressLineSecond;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    public JooqCustomerdetail() {}

    public JooqCustomerdetail(JooqCustomerdetail value) {
        this.customerNumber = value.customerNumber;
        this.addressLineFirst = value.addressLineFirst;
        this.addressLineSecond = value.addressLineSecond;
        this.city = value.city;
        this.state = value.state;
        this.postalCode = value.postalCode;
        this.country = value.country;
    }

    public JooqCustomerdetail(
        Long   customerNumber,
        String addressLineFirst,
        String addressLineSecond,
        String city,
        String state,
        String postalCode,
        String country
    ) {
        this.customerNumber = customerNumber;
        this.addressLineFirst = addressLineFirst;
        this.addressLineSecond = addressLineSecond;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }

    @NotNull
    public Long getCustomerNumber() {
        return this.customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    @NotNull
    @Size(max = 50)
    public String getAddressLineFirst() {
        return this.addressLineFirst;
    }

    public void setAddressLineFirst(String addressLineFirst) {
        this.addressLineFirst = addressLineFirst;
    }

    @Size(max = 50)
    public String getAddressLineSecond() {
        return this.addressLineSecond;
    }

    public void setAddressLineSecond(String addressLineSecond) {
        this.addressLineSecond = addressLineSecond;
    }

    @NotNull
    @Size(max = 50)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Size(max = 50)
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Size(max = 15)
    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @NotNull
    @Size(max = 50)
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JooqCustomerdetail (");

        sb.append(customerNumber);
        sb.append(", ").append(addressLineFirst);
        sb.append(", ").append(addressLineSecond);
        sb.append(", ").append(city);
        sb.append(", ").append(state);
        sb.append(", ").append(postalCode);
        sb.append(", ").append(country);

        sb.append(")");
        return sb.toString();
    }
}