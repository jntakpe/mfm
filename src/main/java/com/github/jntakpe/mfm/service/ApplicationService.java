package com.github.jntakpe.mfm.service;

import com.github.jntakpe.mfm.model.Application;
import com.github.jntakpe.mfm.repository.ApplicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

/**
 * Services associés aux document {@link com.github.jntakpe.mfm.model.Application}
 *
 * @author jntakpe
 */
@Service
public class ApplicationService {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationService.class);

    private ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    /**
     * Création et modification du paramétrage d'un projet
     *
     * @param application paramétrage
     * @return le paramétrage mis à jour
     */
    public Application save(Application application) {
        Assert.notNull(application, "Unable to update null application");
        LOG.info("Updating settings for project : {}", application.getName());
        Application updated = applicationRepository.save(application);
        LOG.debug("Settings of {} updated with values : {}", application.getName(), updated);
        return updated;
    }

    /**
     * Récupère le paramétrage d'un projet en fonction du nom du projet
     *
     * @param name nom du projet
     * @return paramétrage du projet
     */
    public Optional<Application> findByName(String name) {
        LOG.debug("Retrieving settings for project : {}", name);
        return Optional.ofNullable(applicationRepository.findByName(name));
    }
}
