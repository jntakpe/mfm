package com.github.jntakpe.mfm.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * Bean représentant les paramètres d'un projet monitoré
 *
 * @author jntakpe
 */
@Document
public class Application extends IdMongoEntity {

    @NotNull
    private String name;

    @NotNull
    private Boolean active;

    @NotNull
    private Integer interval;

    private Instant nextCheck;

    private Set<Instance> instances = new HashSet<>();

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

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Instant getNextCheck() {
        return nextCheck;
    }

    public void setNextCheck(Instant nextCheck) {
        this.nextCheck = nextCheck;
    }

    public Set<Instance> getInstances() {
        return instances;
    }

    public void setInstances(Set<Instance> instances) {
        this.instances = instances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Application application = (Application) o;

        if (name != null ? !name.equals(application.name) : application.name != null) return false;

        return true;
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
                .append("interval", interval)
                .append("nextCheck", nextCheck)
                .toString();
    }
}
