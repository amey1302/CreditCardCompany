package org.amaap.credit.card.manager.domain;

import org.amaap.credit.card.manager.domain.exception.InvalidCustomerIdException;
import org.amaap.credit.card.manager.domain.exception.InvalidCustomerNameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomerTest {

    @Test
    void shouldAbleToCreateCustomer() throws InvalidCustomerIdException, InvalidCustomerNameException {
        Customer.createCustomer(1, "Amey Kulkarni", "amey@gmail.com");
        assertEquals(1, Customer.getId());
        assertEquals("Amey Kulkarni", Customer.getName());
        assertEquals("amey@gmail.com", Customer.getEmail());

    }

    @Test
    void shouldAbleToThrowExceptionWhenCustomerIdIsInvalid() {
        assertThrows(InvalidCustomerIdException.class, () -> {
            Customer.createCustomer(-1, "baburao Apte", "baburao@babu.com");

        });
        assertThrows(InvalidCustomerIdException.class, () -> {
            Customer.createCustomer(0, "baburao Apte", "baburao@babu.com");

        });
    }

    @Test
    void shouldAbleToThrowExceptionWhenCustomerNameIsInvalid() {
        assertThrows(InvalidCustomerNameException.class, () -> {
            Customer.createCustomer(1, "", "baburao@babu.com");

        });
       Throwable throwable = assertThrows(InvalidCustomerNameException.class, () -> {
            Customer.createCustomer(1, null, "baburao@babu.com");

        });
       assertEquals("Invalid Name Exception",throwable.getMessage());



    }

}