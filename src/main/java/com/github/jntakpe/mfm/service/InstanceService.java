package com.github.jntakpe.mfm.service;

import com.github.jntakpe.mfm.model.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Services associés à l'entité {@link com.github.jntakpe.mfm.model.Instance}
 *
 * @author jntakpe
 */
@Service
public class InstanceService {

    private static final Logger LOG = LoggerFactory.getLogger(InstanceService.class);

    private RestTemplate restTemplate;

    @Autowired
    public InstanceService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Récupère les informations d'une instance à l'aide de l'url de monitoring
     *
     * @param url url de monitoring du projet
     * @return renvoie une {@link org.springframework.http.ResponseEntity} contenant les infos du projet
     */
    public ResponseEntity<Info> findInfo(URI url) {
        LOG.debug("Checking connection to {}", url);
        return restTemplate.getForEntity(url, Info.class);
    }
}
