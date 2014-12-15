package com.github.jntakpe.mfm.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * L'enregistrement des événements de mise à jour des métriques
 *
 * @author jntakpe
 */
@Service
public class ScheduleService {

    @Scheduled(fixedRate = 1000L)
    public void clock() {

    }
}
