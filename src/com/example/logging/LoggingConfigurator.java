package com.example.logging;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LoggingConfigurator {
    private static boolean initialized;

    public static synchronized void initialize() {
        if (!initialized) {
            BasicConfigurator.configure();
            Logger.getLogger("org").setLevel(Level.ERROR);
            Logger.getLogger("httpclient").setLevel(Level.WARN);
            initialized = true;
        }
    }
}
