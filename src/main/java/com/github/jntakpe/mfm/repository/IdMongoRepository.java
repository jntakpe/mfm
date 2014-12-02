package com.github.jntakpe.mfm.repository;

import com.github.jntakpe.mfm.model.IdMongoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Publication des méthodes de gestion des documents fils de {@link com.github.jntakpe.mfm.model.IdMongoEntity}
 *
 * @author jntakpe
 */
@NoRepositoryBean
public interface IdMongoRepository<T extends IdMongoEntity> extends MongoRepository<T, String> {

}
