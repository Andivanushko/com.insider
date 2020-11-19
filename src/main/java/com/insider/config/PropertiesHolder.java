package com.insider.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHolder {

    private static final Logger LOG = LoggerFactory.getLogger(PropertiesHolder.class);
    private static PropertiesHolder instance;
    private final Properties properties;

    private PropertiesHolder() {
        properties = new Properties();
        load();
    }

    public static PropertiesHolder getInstance() {
        if (instance == null) {
            instance = new PropertiesHolder();
        }
        return instance;
    }

    public String getProperty(final String key) {
        final String property = properties.getProperty(key);
        if (property != null) {
            return property;
        }
        LOG.error("Can't find property" + key);
        throw new RuntimeException("Can't find property" + key);
    }

    private void load() {
        try (InputStream in = PropertiesHolder.class.getClassLoader().getResourceAsStream(Constants.PROPERTY_FILE)) {
            properties.load(in);
        } catch (final IOException e) {
            LOG.error("Failed to load build properties file.", e);
            throw new RuntimeException("Failed to load build properties file.");
        }
    }
}