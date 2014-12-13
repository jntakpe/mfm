package com.github.jntakpe.mfm.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * Classe représentant une entité abstraite MongoDB.
 *
 * @author jntakpe
 */
public abstract class IdMongoEntity implements Serializable {

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
