package com.github.jntakpe.mfm.service;

import com.github.jntakpe.mfm.model.Settings;
import com.github.jntakpe.mfm.repository.SettingsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Services associés aux document {@link com.github.jntakpe.mfm.model.Settings}
 *
 * @author jntakpe
 */
@Service
public class SettingsService {

    private static final Logger LOG = LoggerFactory.getLogger(SettingsService.class);

    private SettingsRepository settingsRepository;

    @Autowired
    public SettingsService(SettingsRepository settingsRepository) {
        this.settingsRepository = settingsRepository;
    }

    /**
     * Création et modification du paramétrage d'un projet
     *
     * @param settings paramétrage
     * @return le paramétrage mis à jour
     */
    public Settings save(Settings settings) {
        Assert.notNull(settings, "Unable to update null settings");
        LOG.info("Updating settings for project : {}", settings.getName());
        Settings updated = settingsRepository.save(settings);
        LOG.debug("Settings updated with values : {}", updated);
        return updated;
    }
}
