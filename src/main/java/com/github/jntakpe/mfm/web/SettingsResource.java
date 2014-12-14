package com.github.jntakpe.mfm.web;

import com.github.jntakpe.mfm.model.Application;
import com.github.jntakpe.mfm.model.Info;
import com.github.jntakpe.mfm.service.ApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

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

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<Application> get(@PathVariable String name) {
        Optional<Application> app = applicationService.findByName(name);
        if (app.isPresent()) {
            LOG.info("Returning settings for application name {}", name);
            return new ResponseEntity<>(app.get(), HttpStatus.OK);
        }
        LOG.warn("No settings found for application name {}", name);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.POST)
    public Application save(@PathVariable String name, @RequestBody Application application) {
        return applicationService.save(application);
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public ResponseEntity<Info> check(@RequestParam URI url) throws InterruptedException {
        return applicationService.check(url);
    }
}
