package com.github.jntakpe.mfm.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Bean représentant les paramètres d'un projet monitoré
 *
 * @author jntakpe
 */
@Document
public class Settings extends IdMongoEntity {

    @NotNull
    private String name;

    @NotNull
    private Boolean active;

    @NotNull
    private Boolean cluster;

    @URL
    private String url;

    private Set<String> members;

    @NotNull
    private Integer interval;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getCluster() {
        return cluster;
    }

    public void setCluster(Boolean cluster) {
        this.cluster = cluster;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<String> getMembers() {
        return members;
    }

    public void setMembers(Set<String> members) {
        this.members = members;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Settings settings = (Settings) o;

        return !(name != null ? !name.equals(settings.name) : settings.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("active", active)
                .append("cluster", cluster)
                .append("url", url)
                .append("members", members)
                .append("interval", interval)
                .toString();
    }
}
