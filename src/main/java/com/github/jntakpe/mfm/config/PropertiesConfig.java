package com.github.jntakpe.mfm.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Classe de gestion des properties de l'application
 *
 * @author jntakpe
 */
@Configuration
public class PropertiesConfig {

    @Component
    @ConfigurationProperties(prefix = "rest")
    public static class RestProperties {

        private int timeout;

        public int getTimeout() {
            return timeout;
        }

        public void setTimeout(int timeout) {
            this.timeout = timeout * 1000;
        }
    }

}
