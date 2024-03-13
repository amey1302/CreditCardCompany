package org.amaap.credit.card.manager.domain;

import org.amaap.credit.card.manager.domain.exception.InvalidCustomerIdException;
import org.amaap.credit.card.manager.domain.exception.InvalidCustomerNameException;

import java.util.Objects;

public class Customer {
    private static int id;
    private static String name;
    private static String email;


    public static Customer createCustomer(int id, String name, String email) throws InvalidCustomerIdException, InvalidCustomerNameException {
        if(id <= 0 )
            throw new InvalidCustomerIdException();
        if( name == null || name.isEmpty() )
            throw new InvalidCustomerNameException("Invalid Name Exception");
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

    public static String getName() {
        return name;
    }

    public static String getEmail() {
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