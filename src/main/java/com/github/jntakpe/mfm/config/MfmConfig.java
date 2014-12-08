package com.github.jntakpe.mfm.config;

import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.IOException;

/**
 * Classe de configuration principale de l'application
 *
 * @author jntakpe
 */
@Configuration
@EnableMetrics
@EnableAutoConfiguration
@ComponentScan("com.github.jntakpe.mfm")
@EnableMongoRepositories("com.github.jntakpe.mfm.repository")
public class MfmConfig extends SpringBootServletInitializer {

    private static final Logger LOG = LoggerFactory.getLogger(MfmConfig.class);

    /**
     * Démarre l'application en mode 'embedded'
     *
     * @param args arguments passés par le goal maven
     */
    public static void main(String[] args) throws IOException {
        LOG.debug("Démarrage de l'application en mode 'embedded'");
        new SpringApplication(MfmConfig.class).run(args);
    }

    /**
     * Démarrage sur un serveur classique (Tomcat, Jetty, JBoss, etc ...)
     *
     * @param application builder de la configuration Spring Boot
     * @return la configuration prête à être lancée
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        LOG.debug("Démarrage de l'application en mode 'classique'");
        String profile = SystemUtils.IS_OS_LINUX ? Constants.PROD_PROFILE : Constants.DEV_PROFILE;
        LOG.debug("Profil '{}' sélectionné", profile);
        application.profiles(profile);
        return application.sources(MfmConfig.class);
    }
}
