package org.amaap.credit.card.manager.transaction;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionManager {
    private static int customerId;
    private static List<Map<Integer, List<Object>>> transactionDataList = new ArrayList<>();

    public TransactionManager(int customerId) {
        this.customerId = customerId;
    }

    public static int getCustomerId() {
        return customerId;
    }

    public static boolean perform(String category, double amount, Month month) {
        // Set transaction details
        setDetails(category, amount, month);

        // Check if the transaction has been added successfully
        for (Map<Integer, List<Object>> map : transactionDataList) {
            int storedCustomerId = map.keySet().iterator().next();
            if (storedCustomerId == getCustomerId()) {
                List<Object> transactionDetails = map.get(storedCustomerId);
                if (transactionDetails != null &&
                        transactionDetails.size() == 3 &&
                        transactionDetails.get(0).equals(category) &&
                        transactionDetails.get(1).equals(amount) &&
                        transactionDetails.get(2).equals(month)) {
                    // Transaction with the same details already exists, return true
                    System.out.println("Transaction found in the list");
                    return true;
                }
            }
        }

        // Transaction not found
        System.out.println("Transaction not found in the list");
        return false;
    }

    private static void setDetails(String category, double amount, Month month) {
        // Check if the transaction with the same customer ID, category, and month already exists
        for (Map<Integer, List<Object>> map : transactionDataList) {
            int storedCustomerId = map.keySet().iterator().next();
            if (storedCustomerId == customerId) {
                List<Object> transactionDetails = map.get(storedCustomerId);
                if (transactionDetails != null &&
                        transactionDetails.size() == 3 &&
                        transactionDetails.get(0).equals(category) &&
                        transactionDetails.get(1).equals(amount) &&
                        transactionDetails.get(2).equals(month)) {
                    // Transaction with the same details already exists, skip adding it again
                    System.out.println("Transaction already exists");
                    return;
                }
            }
        }

        // If the transaction doesn't exist, proceed with adding the data
        List<Object> transactionList = new ArrayList<>();
        transactionList.add(category);
        transactionList.add(amount);
        transactionList.add(month);

        Map<Integer, List<Object>> transactionMap = new HashMap<>();
        transactionMap.put(customerId, transactionList);

        System.out.println("Transaction performed..");
        System.out.println(transactionDataList);
        transactionDataList.add(transactionMap);
    }

    public static List<Map<Integer, List<Object>>> getTransactionDataList() {
        return transactionDataList;
    }

    public static void clearDataList() {
        transactionDataList.clear();
    }
}
