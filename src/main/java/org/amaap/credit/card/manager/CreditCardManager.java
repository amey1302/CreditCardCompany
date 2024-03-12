package org.amaap.credit.card.manager;

import org.amaap.credit.card.manager.doamin.CreditCard;
import org.amaap.credit.card.manager.doamin.Customer;
import org.amaap.credit.card.manager.transaction.Transaction;
import org.amaap.credit.card.manager.transaction.TransactionManager;

import java.time.Month;

public class CreditCardManager {
    private static CreditCard creditCard; // Assuming CreditCard is another class where card method is defined

    public CreditCardManager() {
        this.creditCard = new CreditCard(); // Assuming CreditCard has a default constructor
    }

    public Customer createCustomer(int customerId, String customerName, String customerEmail) {
        // Create a customer using the provided data
        Customer customer = Customer.createCustomer(customerId, customerName, customerEmail);
        return customer;
    }

    public static boolean assignCard(Customer customer) {
        // Extract data from the customer object and pass it to the card method
        int id = customer.getId();
        String name = customer.getName();
        String email = customer.getEmail();
        return creditCard.card(id, name, email); // Assuming card method takes these parameters
    }

    public boolean MakeTransactions( String grocery, double amount, Month month) {
        return TransactionManager.perform(grocery,amount,month);
    }
}