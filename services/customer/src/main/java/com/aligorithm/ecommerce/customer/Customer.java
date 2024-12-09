package com.aligorithm.ecommerce.customer;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {

    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private Address address;

    public Customer(String id, String firstname, String lastname, String email, Address address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
    }

    public Customer() {
    }

    public static CustomerBuilder builder() {
        return new CustomerBuilder();
    }

    public String getId() {
        return this.id;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getEmail() {
        return this.email;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static class CustomerBuilder {
        private String id;
        private String firstname;
        private String lastname;
        private String email;
        private Address address;

        CustomerBuilder() {
        }

        public CustomerBuilder id(String id) {
            this.id = id;
            return this;
        }

        public CustomerBuilder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public CustomerBuilder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public CustomerBuilder email(String email) {
            this.email = email;
            return this;
        }

        public CustomerBuilder address(Address address) {
            this.address = address;
            return this;
        }

        public Customer build() {
            return new Customer(this.id, this.firstname, this.lastname, this.email, this.address);
        }

        public String toString() {
            return "Customer.CustomerBuilder(id=" + this.id + ", firstname=" + this.firstname + ", lastname=" + this.lastname + ", email=" + this.email + ", address=" + this.address + ")";
        }
    }
}
