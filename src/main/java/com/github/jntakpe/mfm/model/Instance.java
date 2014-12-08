package com.github.jntakpe.mfm.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

/**
 * Bean représentant l'instance d'une application
 *
 * @author jntakpe
 */
@Document
public class Instance extends IdMongoEntity {

    @NotNull
    private String ip;

    public Instance(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Instance instance = (Instance) o;

        if (ip != null ? !ip.equals(instance.ip) : instance.ip != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ip != null ? ip.hashCode() : 0;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("ip", ip)
                .toString();
    }
}
