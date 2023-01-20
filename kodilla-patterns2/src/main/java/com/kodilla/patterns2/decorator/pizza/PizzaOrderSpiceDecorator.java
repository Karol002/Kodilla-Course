package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PizzaOrderSpiceDecorator extends AbstractPizzaOrderDecorator{
    public PizzaOrderSpiceDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        // hardcoded stub cost = 2
        return super.getCost().add(new BigDecimal(2));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", additional spice";
    }
}
