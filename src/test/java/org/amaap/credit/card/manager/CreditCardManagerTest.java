package org.amaap.credit.card.manager;

import org.amaap.credit.card.manager.domain.Customer;
import org.amaap.credit.card.manager.domain.exception.CustomerValidationException;
import org.amaap.credit.card.manager.domain.exception.InvalidCustomerIdException;
import org.amaap.credit.card.manager.domain.exception.InvalidCustomerNameException;
import org.junit.jupiter.api.Test;

import javax.naming.InvalidNameException;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreditCardManagerTest {

    @Test
    void shouldAbleToCreateCustomer() throws CustomerValidationException {
        CreditCardManager creditCardManger = new CreditCardManager();
        Customer expected = Customer.createCustomer(1, "John Doe", "abc@gmail.com");
        Customer actual = creditCardManger.createCustomer(1, "John Doe", "abc@gmail.com");

        assertEquals(expected, actual);

    }

    @Test
    void shouldAbleToAssignCreditCardToUser() throws CustomerValidationException {
        CreditCardManager creditCardManager = new CreditCardManager();
        Customer customer = Customer.createCustomer(1, "John Doe", "abc@gmail.com");
        boolean isAssigned = creditCardManager.assignCard(customer);
        assertTrue(isAssigned);


    }

    @Test
    void shouldAbleToMakeTransactions() {
        CreditCardManager creditCardManager = new CreditCardManager();

        assertTrue(creditCardManager.MakeTransactions("groceries", 1000.0, Month.MARCH));


    }


}
