package org.amaap.credit.card.manager;

import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class StorageManager {
    private static List<Map<Integer, Map<String, Double>>> currentMonthDataList = new ArrayList<>();
    private static List<Map<Integer, Map<String, Double>>> previousMonthDataList = new ArrayList<>();

    public static List<Map<Integer, Map<String, Double>>> currentMonthDataList() {
        return currentMonthDataList;
    }

    public static List<Map<Integer, Map<String, Double>>> previousMonthDataList() {
        return previousMonthDataList;
    }

    public void previousMonthAnalysis() {
        // Get the current actual month
        Month currentMonth = Month.of(Calendar.getInstance().get(Calendar.MONTH) + 1);

        // Iterate through the current month data and move transactions to the previous month list
        List<Map<Integer, Map<String, Double>>> transactionsToMove = new ArrayList<>();
        for (Map<Integer, Map<String, Double>> transaction : currentMonthDataList) {
            for (Map.Entry<Integer, Map<String, Double>> entry : transaction.entrySet()) {
                Map<String, Double> categoryAmountMap = entry.getValue();
                // Check if the month of the transaction is the previous month
                if (categoryAmountMap.containsKey("month")) {
                    Month transactionMonth = Month.valueOf(categoryAmountMap.get("month").toString().toUpperCase());
                    if (transactionMonth.equals(currentMonth.minus(1))) {
                        transactionsToMove.add(transaction);
                        break;
                    }
                }
            }
        }

        // Move transactions from current month list to previous month list
        for (Map<Integer, Map<String, Double>> transaction : transactionsToMove) {
            currentMonthDataList.remove(transaction);
            previousMonthDataList.add(transaction);
        }
    }
}
