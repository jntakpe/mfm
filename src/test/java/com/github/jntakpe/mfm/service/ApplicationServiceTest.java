package com.github.jntakpe.mfm.service;

import com.github.jntakpe.mfm.config.MfmConfig;
import com.github.jntakpe.mfm.model.Application;
import com.github.jntakpe.mfm.model.Instance;
import com.github.jntakpe.mfm.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = MfmConfig.class)
public class ApplicationServiceTest extends AbstractTestNGSpringContextTests {

    public static final String EC = "ec";

    public static final String EERS = "eers";

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ApplicationService applicationService;

    @BeforeClass
    public void setUp() {
        applicationRepository.deleteAll();
        assertThat(applicationRepository.findAll()).isEmpty();
        Application eers = new Application();
        eers.setName(EERS);
        eers.setActive(Boolean.TRUE);
        applicationRepository.save(eers);
        assertThat(applicationRepository.count()).isNotZero();
    }

    @Test
    public void testSave() {
        long initSize = applicationRepository.count();
        Application ec = new Application();
        ec.setName(EC);
        ec.setActive(Boolean.TRUE);
        ec.getInstances().add(new Instance("ECInstance"));
        Application savedEc = applicationService.save(ec);
        assertThat(savedEc).isNotNull();
        assertThat(applicationRepository.count()).isNotZero().isEqualTo(initSize + 1);
        assertThat(savedEc.getInstances()).isNotEmpty();
    }

    @Test
    public void testFindByName() {
        Optional<Application> settingsOptional = applicationService.findByName(EERS);
        assertThat(settingsOptional.isPresent()).isTrue();
        assertThat(settingsOptional.map(Application::getName).get()).isEqualTo(EERS);
        assertThat(applicationService.findByName("testProj").isPresent()).isFalse();
    }
}