package com.github.jntakpe.mfm.repository;

import com.github.jntakpe.mfm.model.Settings;

/**
 * Publication des méthodes de gestion du document {@link com.github.jntakpe.mfm.model.Settings}
 *
 * @author jntakpe
 */
public interface SettingsRepository extends IdMongoRepository<Settings> {

    /**
     * Renvoie les paramètres en fonction d'un nom de projet
     *
     * @param name nom du projet
     * @return paramétrage du projet
     */
    Settings findByName(String name);
}
