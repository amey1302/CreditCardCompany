package org.amaap.credit.card.manager.doamin;

import java.util.Objects;

public class Customer {
    private static int id;
    private String name;
    private String email;


    public static Customer createCustomer(int id, String name, String email) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid or duplicate ID");
        }
        return new Customer(id, name, email);
    }

    private Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public static int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(name, customer.name) && Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }
}