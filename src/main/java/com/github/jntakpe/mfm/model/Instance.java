package com.github.jntakpe.mfm.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;

/**
 * Bean représentant l'instance d'une application
 *
 * @author jntakpe
 */
public class Instance {

    @NotNull
    private String url;

    public Instance() {
    }

    public Instance(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Instance instance = (Instance) o;

        if (url != null ? !url.equals(instance.url) : instance.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return url != null ? url.hashCode() : 0;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("url", url)
                .toString();
    }
}
