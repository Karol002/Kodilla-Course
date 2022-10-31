package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {

    @Test
    void testBigmacBuilder() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .setBurgersQuantity(1)
                .setSauce(Sauce.BARBECUE)
                .setBread(Bread.SESAME_ROLL)
                .addIngredients(Ingredient.BACON)
                .addIngredients(Ingredient.PEPPERS)
                .build();
        System.out.println(bigmac.toString());

        //When && Then
        assertEquals(1, bigmac.getBurgers());
        assertEquals("barbecue", bigmac.getSauce());
        assertEquals("roll with sesame", bigmac.getBread());
        assertEquals(2, bigmac.getIngredients().size());
    }
}
