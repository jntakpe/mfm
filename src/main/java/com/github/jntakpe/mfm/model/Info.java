package com.github.jntakpe.mfm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Bean représentant les informations d'une application
 *
 * @author jntakpe
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {

    private String name;

    private String version;

    private String description;

    private String artifact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArtifact() {
        return artifact;
    }

    public void setArtifact(String artifact) {
        this.artifact = artifact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Info info = (Info) o;

        if (artifact != null ? !artifact.equals(info.artifact) : info.artifact != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return artifact != null ? artifact.hashCode() : 0;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("version", version)
                .append("description", description)
                .append("artifact", artifact)
                .toString();
    }
}
