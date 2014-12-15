package com.github.jntakpe.mfm.config;

import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Classe de configuration principale de l'application
 *
 * @author jntakpe
 */
@Configuration
@EnableMetrics
@EnableScheduling
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan("com.github.jntakpe.mfm")
@EnableMongoRepositories("com.github.jntakpe.mfm.repository")
public class MfmConfig extends SpringBootServletInitializer {

    private static final Logger LOG = LoggerFactory.getLogger(MfmConfig.class);

    @Autowired
    private PropertiesConfig.RestProperties restProperties;

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

    /**
     * Template permettant d'accéder aux ressources REST
     *
     * @return le template configuré
     */
    @Bean
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(restProperties.getTimeout());
        factory.setReadTimeout(restProperties.getTimeout());
        return new RestTemplate(factory);
    }
}
