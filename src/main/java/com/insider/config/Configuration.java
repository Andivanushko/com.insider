package com.insider.config;

import org.apache.commons.lang3.StringUtils;

public class Configuration {

    private static final String BROWSER_TYPE_PROPERTY_NAME = "browser.type";
    private static final String TEST_ENVIRONMENT_PROPERTY_NAME = "test.environment";
    private static final String BROWSER_WIDTH = "browser.width";
    private static final String BROWSER_HEIGHT = "browser.height";

    private static String getFileProperty(final String key) {
        return PropertiesHolder.getInstance().getProperty(key);
    }

    public static String getBrowserType() {
        final String browser = System.getProperty(BROWSER_TYPE_PROPERTY_NAME);
        return StringUtils.isNotEmpty(browser) ? browser : getFileProperty(BROWSER_TYPE_PROPERTY_NAME);
    }

    public static int getBrowserWidth() {
        return Integer.parseInt(getFileProperty(BROWSER_WIDTH));
    }

    public static int getBrowserHeight() {
        return Integer.parseInt(getFileProperty(BROWSER_HEIGHT));
    }

    public static String getBaseUrl() {
        return getFileProperty(TEST_ENVIRONMENT_PROPERTY_NAME);
    }
}