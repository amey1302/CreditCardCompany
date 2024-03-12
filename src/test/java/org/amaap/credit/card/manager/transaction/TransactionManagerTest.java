package org.amaap.credit.card.manager.transaction;

import org.amaap.credit.card.manager.StorageManager;
import org.amaap.credit.card.manager.analyzer.UnusualSpendAnalyzer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TransactionManagerTest {
    @Test
    void shouldAbleToCheckUnusualSpending() {
        StorageManager storageManager = new StorageManager();
        UnusualSpendAnalyzer unusualSpendAnalyzer = new UnusualSpendAnalyzer();
//        int customerId = 1;
//        Transaction transaction = new Transaction(customerId);
//       transaction.perform("Grocery", 1200, Month.MARCH);
//        transaction.perform("Grocery", 1200, Month.MARCH);
//         transaction.perform("Electronics", 800, Month.MARCH)
//        assertTrue(transaction.perform("Clothing", 500, Month.MARCH))

        boolean actual = unusualSpendAnalyzer.isUnusualSpend(storageManager.currentMonthDataList(), storageManager.previousMonthDataList());

        assertTrue(actual);
    }

}