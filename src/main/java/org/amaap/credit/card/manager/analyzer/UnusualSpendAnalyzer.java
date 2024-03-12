package org.amaap.credit.card.manager.analyzer;

import java.util.List;
import java.util.Map;

public class UnusualSpendAnalyzer {

    public boolean isUnusualSpend(List<Map<Integer, Map<String, Double>>> currentMonthDataList, List<Map<Integer, Map<String, Double>>> previousMonthDataList) {
        return calculateUnusualSpend(currentMonthDataList, previousMonthDataList);
    }

    private boolean calculateUnusualSpend(List<Map<Integer, Map<String, Double>>> currentMonthDataList, List<Map<Integer, Map<String, Double>>> previousMonthDataList) {
        for (Map<Integer, Map<String, Double>> currentMonthTransaction : currentMonthDataList) {
            int customerId = currentMonthTransaction.keySet().iterator().next();
            Map<String, Double> currentMonthCategoryAmountMap = currentMonthTransaction.get(customerId);

            if (previousMonthDataList.stream().anyMatch(prevMonthTransaction -> {
                if (prevMonthTransaction.containsKey(customerId)) {
                    Map<String, Double> previousMonthCategoryAmountMap = prevMonthTransaction.get(customerId);
                    return previousMonthCategoryAmountMap.keySet().containsAll(currentMonthCategoryAmountMap.keySet());
                }
                return false;
            })) {
                Map<String, Double> previousMonthCategoryAmountMap = previousMonthDataList.stream()
                        .filter(prevMonthTransaction -> prevMonthTransaction.containsKey(customerId))
                        .findFirst()
                        .map(prevMonthTransaction -> prevMonthTransaction.get(customerId))
                        .orElseThrow();

                for (String category : currentMonthCategoryAmountMap.keySet()) {
                    double currentMonthAmount = currentMonthCategoryAmountMap.get(category);
                    double previousMonthAmount = previousMonthCategoryAmountMap.getOrDefault(category, 0.0);

                    double percentageIncrease = ((currentMonthAmount - previousMonthAmount) / previousMonthAmount) * 100;

                    if (percentageIncrease >= 50) {
                        System.out.println("Unusual spend detected for category: " + category +
                                " by customer ID: " + customerId +
                                " in the current month compared to the previous month.");
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
