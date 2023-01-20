package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(20), calculatedCost);
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        //When
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals("Pizza with cheese", description);
    }

    @Test
    public void testChickenPizzaOrderGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ChickenPizzaOrderDecorator(pizzaOrder);

        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(25), calculatedCost);
    }

    @Test
    public void testChickenPizzaOrderGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ChickenPizzaOrderDecorator(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals("Pizza with cheese, chicken", description);
    }

    @Test
    public void testSalamiPizzaOrderGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new SalamiPizzaOrderDecorator(pizzaOrder);

        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(27), calculatedCost);
    }

    @Test
    public void testSalamiPizzaOrderGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new SalamiPizzaOrderDecorator(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals("Pizza with cheese, salami", description);
    }

    @Test
    public void testPizzaOrderSpiceGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new PizzaOrderSpiceDecorator(pizzaOrder);

        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(22), calculatedCost);
    }

    @Test
    public void testPizzaOrderSpiceGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new PizzaOrderSpiceDecorator(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals("Pizza with cheese, additional spice", description);
    }

    @Test
    public void testSalamiChickenPizzaOrderSpiceGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new SalamiPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new ChickenPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new PizzaOrderSpiceDecorator(pizzaOrder);

        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(34), calculatedCost);
    }

    @Test
    public void testSalamiChickenPizzaOrderSpiceGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new SalamiPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new ChickenPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new PizzaOrderSpiceDecorator(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals("Pizza with cheese, salami, chicken, additional spice", description);
    }
}
