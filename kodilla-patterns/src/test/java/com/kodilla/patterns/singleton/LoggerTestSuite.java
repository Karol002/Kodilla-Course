package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void createLogInstance() {
        logger = Logger.INSTANCE;
    }

    @Test
    void getAnotherLastLogTest() {
        //Given
        //When
        logger.log("This is log");
        String logData = logger.getLastLog();
        logger.log("This is another log");
        String anotherLogData = logger.getLastLog();

        //Then
        assertEquals("This is log", logData);
        assertEquals("This is another log", anotherLogData);
    }

}
