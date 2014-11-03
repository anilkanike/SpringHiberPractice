package com.springapp.model;

import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by lewis on 26/08/2014.
 */
@Entity
@Table(name = "ORGANIZATIONS", schema = "", catalog = "")
public class OrganizationsEO {
    private int organizationId;
    private String externalCode;
    private String displayName;
    private String identifierType;
    private DateTime creationDate;
    private long createdBy;
    private DateTime lastUpdateDate;
    private Long lastUpdatedBy;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="G1")
    @SequenceGenerator(name="G1", sequenceName="ORGANIZATIONS_SEQ")
    @Column(name = "ORGANIZATION_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    @Basic
    @Column(name = "EXTERNAL_CODE", nullable = true, insertable = true, updatable = true, length = 100)
    public String getExternalCode() {
        return externalCode;
    }

    public void setExternalCode(String externalCode) {
        this.externalCode = externalCode;
    }

    @Basic
    @Column(name = "DISPLAY_NAME", nullable = false, insertable = true, updatable = true, length = 100)
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Basic
    @Column(name = "IDENTIFIER_TYPE", nullable = false, insertable = true, updatable = true, length = 100)
    public String getIdentifierType() {
        return identifierType;
    }

    public void setIdentifierType(String identifierType) {
        this.identifierType = identifierType;
    }

    @Basic
    @Column(name = "CREATION_DATE", nullable = false, insertable = true, updatable = true)
    public DateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(DateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Basic
    @Column(name = "CREATED_BY", nullable = false, insertable = true, updatable = true, precision = 0)
    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "LAST_UPDATE_DATE", nullable = true, insertable = true, updatable = true)
    public DateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(DateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Basic
    @Column(name = "LAST_UPDATED_BY", nullable = true, insertable = true, updatable = true, precision = 0)
    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationsEO that = (OrganizationsEO) o;

        if (createdBy != that.createdBy) return false;
        if (organizationId != that.organizationId) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (displayName != null ? !displayName.equals(that.displayName) : that.displayName != null) return false;
        if (externalCode != null ? !externalCode.equals(that.externalCode) : that.externalCode != null) return false;
        if (lastUpdateDate != null ? !lastUpdateDate.equals(that.lastUpdateDate) : that.lastUpdateDate != null)
            return false;
        if (lastUpdatedBy != null ? !lastUpdatedBy.equals(that.lastUpdatedBy) : that.lastUpdatedBy != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = organizationId;
        result = 31 * result + (externalCode != null ? externalCode.hashCode() : 0);
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (int)(createdBy ^ (createdBy >>> 32));
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        return result;
    }
}
