package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigMacTestSuite {

    @Test
    public void testBuilder() {
        // Given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .bun("sesame")
                .burgers(2)
                .sauce("standard")
                .addIngredient("lettuce")
                .addIngredient("onion")
                .build();

        // When
        String bun = bigMac.getBun();
        int burgers = bigMac.getBurgers();
        String sauce = bigMac.getSauce();
        int ingredientsCount = bigMac.getIngredients().size();

        // Then
        assertEquals("sesame", bun);
        assertEquals(2, burgers);
        assertEquals("standard", sauce);
        assertEquals(2, ingredientsCount);
    }
}