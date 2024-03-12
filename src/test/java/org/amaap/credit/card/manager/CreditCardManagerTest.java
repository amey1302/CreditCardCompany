package org.amaap.credit.card.manager;

import org.amaap.credit.card.manager.doamin.Customer;
import org.junit.jupiter.api.Test;

import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreditCardManagerTest {

    @Test
    void shouldAbleToCreateCustomer() {
        CreditCardManager creditCardManger = new CreditCardManager();
        Customer expected = Customer.createCustomer(1, "John Doe", "abc@gmail.com");
        Customer actual = creditCardManger.createCustomer(1, "John Doe", "abc@gmail.com");

        assertEquals(expected, actual);

    }

    @Test
    void shouldAbleToAssignCreditCardToUser() {
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
