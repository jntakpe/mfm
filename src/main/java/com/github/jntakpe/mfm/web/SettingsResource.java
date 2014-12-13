package com.github.jntakpe.mfm.web;

import com.github.jntakpe.mfm.model.Application;
import com.github.jntakpe.mfm.model.Info;
import com.github.jntakpe.mfm.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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

    @RequestMapping(method = RequestMethod.GET)
    public List<Application> applications() {
        return applicationService.findAll();
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public ResponseEntity<Info> check(@RequestParam URI url) throws InterruptedException {
        return applicationService.check(url);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Application save(@RequestBody Application application) {
        return applicationService.save(application);
    }
}
