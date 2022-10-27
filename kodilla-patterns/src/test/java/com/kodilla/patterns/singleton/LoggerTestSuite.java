package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void openSettingsFile() {
        logger = Logger.INSTANCE;
        logger.log("This is log");
    }

    @Test
    void getLastLogeTest() {
        //Given
        //When
        String logData = logger.getLastLog();
        System.out.println("Last log: " + logData);
        //Then
        assertEquals("This is log", logData);
    }
}
