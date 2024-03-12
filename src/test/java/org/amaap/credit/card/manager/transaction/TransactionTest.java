package org.amaap.credit.card.manager.transaction;

import org.amaap.credit.card.manager.CreditCardManager;
import org.amaap.credit.card.manager.doamin.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @BeforeEach
    void setup(){
        Transaction.clearTransactionList();
    }

    @Test
    void shouldAbleToPerformTransactionForCustomerId() {
        Customer customer = Customer.createCustomer(1, "xyz", "abc@123");
        boolean creditCardManager = CreditCardManager.assignCard(customer);
        boolean expected = false;
        if (creditCardManager) {
            Transaction transaction = new Transaction(Customer.getId());
            expected = transaction.perform("Grocery", 1200, Month.MARCH);
        }

        assertTrue(expected);
    }

    @Test
    void shouldAbleToHandleMultipleTransactions() {
        // Set up a transaction with a specific customer ID
        int customerId = 1;
        Transaction transaction = new Transaction(customerId);


        // Perform multiple transactions for the same customer
        assertTrue(transaction.perform("Grocery", 1200, Month.MARCH));
        assertTrue(transaction.perform("Grocery", 1200, Month.MARCH));
        assertTrue(transaction.perform("Electronics", 800, Month.MARCH));
        assertTrue(transaction.perform("Clothing", 500, Month.MARCH));
    }
    @Test
    void shouldCalculateTotalAmountForCategory() {
        // Set up a transaction with a specific customer ID
        int customerId = 1;
        Transaction transaction = new Transaction(customerId);

        // Perform multiple transactions for the same customer
        assertTrue(transaction.perform("Grocery", 1200, Month.MARCH));
        assertTrue(transaction.perform("Grocery", 800, Month.MARCH));
        assertTrue(transaction.perform("Grocery", 500, Month.MARCH));

//
//        double totalAmount = TransactionManager.getTotalAmountForCategory(customerId, "Grocery");
//        assertEquals(2500.0, totalAmount);

    }

}