package com.github.jntakpe.mfm.service;

import com.github.jntakpe.mfm.config.MfmConfig;
import com.github.jntakpe.mfm.model.Settings;
import com.github.jntakpe.mfm.repository.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = MfmConfig.class)
public class SettingsServiceTest extends AbstractTestNGSpringContextTests {

    public static final String EC = "ec";

    @Autowired
    private SettingsRepository settingsRepository;

    @Autowired
    private SettingsService settingsService;

    @BeforeClass
    public void setUp() {
        settingsRepository.deleteAll();
        assertThat(settingsRepository.findAll()).isEmpty();
    }

    @Test
    public void testSave() throws Exception {
        long initSize = settingsRepository.count();
        Settings ecSettings = new Settings();
        ecSettings.setName(EC);
        ecSettings.setActive(Boolean.TRUE);
        ecSettings.setCluster(Boolean.FALSE);
        ecSettings.setUrl("http://www.ecurl.com");
        settingsService.save(ecSettings);
        assertThat(settingsRepository.count()).isNotZero().isEqualTo(initSize + 1);
    }
}