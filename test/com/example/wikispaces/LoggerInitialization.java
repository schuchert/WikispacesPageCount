package com.example.wikispaces;

import org.junit.BeforeClass;

import com.example.logging.LoggingConfigurator;

public class LoggerInitialization {
  @BeforeClass
  public static void initDefaultLogging() {
    LoggingConfigurator.initialize();
  }
}
