package com.aligorithm.ecommerce.customer;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

@Document
@Validated
public class Address {

    private String street;
    private String houseNumber;
    private String zipCode;

    public Address(String street, String houseNumber, String zipCode) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
    }

    public Address() {
    }

    public static AddressBuilder builder() {
        return new AddressBuilder();
    }

    public String getStreet() {
        return this.street;
    }

    public String getHouseNumber() {
        return this.houseNumber;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public static class AddressBuilder {
        private String street;
        private String houseNumber;
        private String zipCode;

        AddressBuilder() {
        }

        public AddressBuilder street(String street) {
            this.street = street;
            return this;
        }

        public AddressBuilder houseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
            return this;
        }

        public AddressBuilder zipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Address build() {
            return new Address(this.street, this.houseNumber, this.zipCode);
        }

        public String toString() {
            return "Address.AddressBuilder(street=" + this.street + ", houseNumber=" + this.houseNumber + ", zipCode=" + this.zipCode + ")";
        }
    }
}
