package com.github.jntakpe.mfm.repository;

import com.github.jntakpe.mfm.model.Instance;

/**
 * Publication des méthodes de gestion d'une {@link com.github.jntakpe.mfm.model.Instance} d'une application
 *
 * @author jntakpe
 */
public interface InstanceRepository extends IdMongoRepository<Instance> {

    /**
     * Renvoie l'instance correspondante à une adresse IP
     *
     * @param ip addresse IP
     * @return une instance correspondant à l'IP sinon {@code null}
     */
    Instance findByIp(String ip);

}
