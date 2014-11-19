package com.github.jntakpe.mfm.model;

import java.util.Date;

/**
 * Classe représentant un ensemble de données d'un projet à un instant
 *
 * @author jntakpe
 */
public abstract class ProjectTimedEntity extends MongoEntity {

    private Project project;

    private Date timestamp;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectTimedEntity that = (ProjectTimedEntity) o;

        if (project != null ? !project.equals(that.project) : that.project != null) return false;
        if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = project != null ? project.hashCode() : 0;
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        return result;
    }
}
