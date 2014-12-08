package com.github.jntakpe.mfm.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * Classe représentant une entité abstraite MongoDB.
 *
 * @author jntakpe
 */
public abstract class IdMongoEntity implements Serializable {

    @Id
    private ObjectId id;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
