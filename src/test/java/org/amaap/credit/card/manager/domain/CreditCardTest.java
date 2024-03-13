package org.amaap.credit.card.manager.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreditCardTest {

    @BeforeEach
    void setUp() {

        CreditCard.clearDataList();
    }

    @Test
    void shouldThrowExceptionIfIdIsSame() {

        CreditCard.card(1, "John", "john@example.com");
        assertThrows(IllegalArgumentException.class, () -> CreditCard.card(1, "Alice", "alice@example.com"));
    }

    @Test
    void shouldAbleToAddAndCheckMultipleUSer() {
        assertTrue(CreditCard.card(1, "John", "john@example.com"));

        assertTrue(CreditCard.card(2, "John", "john@example.com"));

        assertTrue(CreditCard.card(3, "John", "john@example.com"));

        assertTrue(CreditCard.card(4, "John", "john@example.com"));

    }


}