package com.github.jntakpe.mfm.web;

import com.github.jntakpe.mfm.model.Application;
import com.github.jntakpe.mfm.model.Info;
import com.github.jntakpe.mfm.service.ApplicationService;
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

    private ApplicationService applicationService;

    @Autowired
    public SettingsResource(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public ResponseEntity<Info> check(@RequestParam URI url) throws InterruptedException {
        return applicationService.check(url);
    }

    @RequestMapping(value = "/{appName}", method = RequestMethod.GET)
    public ResponseEntity<Application> application(@PathVariable String appName) {
        Optional<Application> application = applicationService.findByName(appName);
        if (application.isPresent()) {
            return new ResponseEntity<>(application.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
