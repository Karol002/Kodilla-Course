package com.kodilla.patterns2.facade.aop;

import com.kodilla.patterns2.facade.api.OrderDto;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderWatcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" + "&& args(orderDto, userId) && target(object)")
    public void logEvent(OrderDto orderDto, Long userId, Object object) {
        LOGGER.info("\nClass: " + object.getClass().getName() + ", \n"
                + "Order: " + orderDto.toString() + ", \n"
                + "User ID: " + userId);
    }
}
