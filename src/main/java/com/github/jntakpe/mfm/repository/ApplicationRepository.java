package com.github.jntakpe.mfm.repository;

import com.github.jntakpe.mfm.model.Application;

/**
 * Publication des méthodes de gestion du document {@link com.github.jntakpe.mfm.model.Application}
 *
 * @author jntakpe
 */
public interface ApplicationRepository extends IdMongoRepository<Application> {

    /**
     * Renvoie les paramètres en fonction d'un nom de projet
     *
     * @param name nom du projet
     * @return le paramétrage du projet sinon {@code null}
     */
    Application findByName(String name);
}
