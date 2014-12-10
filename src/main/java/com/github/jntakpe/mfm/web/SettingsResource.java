package com.github.jntakpe.mfm.web;

import com.github.jntakpe.mfm.service.ApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Ressource gérant les paramètres des différents projets
 *
 * @author jntakpe
 */
@RestController
@RequestMapping("/settings")
public class SettingsResource {

    private static final Logger LOG = LoggerFactory.getLogger(SettingsResource.class);

    private ApplicationService applicationService;

    @Autowired
    public SettingsResource(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @RequestMapping(value = "/{appName}/check", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> checkUrl(@PathVariable String appName, @RequestParam String url) throws InterruptedException {
        LOG.debug("Checking URL {} for application {}", url, appName);
        Thread.sleep(2000);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
