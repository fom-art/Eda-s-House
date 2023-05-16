package com.example.edashouse;
public class LoggingHandler {
    static public void logInfo(String info) {
        System.Logger logger = System.getLogger("INFO LOGGER");
        logger.log(System.Logger.Level.INFO, info);
    }
}
