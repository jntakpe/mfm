package com.github.jntakpe.mfm.service;

import com.github.jntakpe.mfm.config.MfmConfig;
import com.github.jntakpe.mfm.model.Settings;
import com.github.jntakpe.mfm.repository.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = MfmConfig.class)
public class SettingsServiceTest extends AbstractTestNGSpringContextTests {

    public static final String EC = "ec";

    public static final String EERS = "eers";

    @Autowired
    private SettingsRepository settingsRepository;

    @Autowired
    private SettingsService settingsService;

    @BeforeClass
    public void setUp() {
        settingsRepository.deleteAll();
        assertThat(settingsRepository.findAll()).isEmpty();
        Settings eersSettings = new Settings();
        eersSettings.setName(EERS);
        eersSettings.setActive(Boolean.TRUE);
        eersSettings.setCluster(Boolean.TRUE);
        eersSettings.setUrl("http://www.someurl.com");
        settingsRepository.save(eersSettings);
        assertThat(settingsRepository.count()).isNotZero();
    }

    @Test
    public void testSave() {
        long initSize = settingsRepository.count();
        Settings ecSettings = new Settings();
        ecSettings.setName(EC);
        ecSettings.setActive(Boolean.TRUE);
        ecSettings.setCluster(Boolean.FALSE);
        ecSettings.setUrl("http://www.ecurl.com");
        Settings savedSettings = settingsService.save(ecSettings);
        assertThat(savedSettings).isNotNull();
        assertThat(settingsRepository.count()).isNotZero().isEqualTo(initSize + 1);
    }

    @Test
    public void testFindByName() {
        Optional<Settings> settingsOptional = settingsService.findByName(EERS);
        assertThat(settingsOptional.isPresent()).isTrue();
        assertThat(settingsOptional.map(Settings::getName).get()).isEqualTo(EERS);
        assertThat(settingsService.findByName("testProj").isPresent()).isFalse();
    }
}