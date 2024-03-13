package org.amaap.credit.card.manager.domain.exception;

public class InvalidCustomerNameException extends CustomerValidationException {
    public InvalidCustomerNameException(String message) {
        super(message);
    }
}

