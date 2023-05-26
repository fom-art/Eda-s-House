package com.example.edashouse;

/**
 * Utility class for logging information.
 */
public class LoggingHandler {

    /**
     * Logs the given information as an INFO level message.
     *
     * @param info the information to be logged
     */
    public static void logInfo(String info) {
        System.Logger logger = System.getLogger("INFO LOGGER");
        logger.log(System.Logger.Level.INFO, info);
    }
}
