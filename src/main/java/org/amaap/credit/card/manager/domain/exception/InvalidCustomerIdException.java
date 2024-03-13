package org.amaap.credit.card.manager.domain.exception;

public class InvalidCustomerIdException extends CustomerValidationException{


    public InvalidCustomerIdException(String message) {
        super(message);
    }
}
