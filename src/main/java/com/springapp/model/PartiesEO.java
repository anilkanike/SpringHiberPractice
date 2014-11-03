package com.springapp.model;

import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by lewis on 26/08/2014.
 */

@NamedQueries(
    {
        @NamedQuery(
                name = PartiesEO.NQ_getPartyById,
                query = "from PartiesEO p\n" +
                        "where (p.partyId = :partyId)"
        ),
        @NamedQuery(
                name = PartiesEO.NQ_getPartyByCode,
                query = "from PartiesEO p\n" +
                        "where (p.organizationId = :organizationId and p.partyCode = :partyCode)"
        ),
        @NamedQuery(
                name = PartiesEO.NQ_findByOrganizationId,
                query = "from PartiesEO p\n" +
                        "where p.organizationId = :organizationId\n" +
                        "order by p.displayName ASC"
        )
    }
)
@Entity
@Table(name = "PARTIES", schema = "", catalog = "")
public class PartiesEO {

    public static final String NQ_getPartyById = "getPartyById";
    public static final String NQ_getPartyByCode = "getPartyByCode";
    public static final String NQ_findByOrganizationId = "findByOrganizationId";


    private int partyId;
    private int organizationId;
    private String partyCode;
    private String externalCode;
    private String displayName;
    private DateTime creationDate;
    private long createdBy;
    private DateTime lastUpdateDate;
    private Long lastUpdatedBy;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="G1")
    @SequenceGenerator(name="G1", sequenceName="PARTIES_SEQ")
    @Column(name = "PARTY_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    @Basic
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
    @Column(name = "PARTY_CODE", nullable = true, insertable = true, updatable = true, length = 30)
    public String getPartyCode() {
        return partyCode;
    }

    public void setPartyCode(String partyCode) {
        this.partyCode = partyCode;
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

    // NOT NULL: partyCode, creationDate, partyId

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PartiesEO)) return false;

        PartiesEO partiesEO = (PartiesEO) o;

        if (createdBy != partiesEO.createdBy) return false;
        if (organizationId != partiesEO.organizationId) return false;
        if (partyId != partiesEO.partyId) return false;
        if (!creationDate.equals(partiesEO.creationDate)) return false;
        if (displayName != null ? !displayName.equals(partiesEO.displayName) : partiesEO.displayName != null)
            return false;
        if (externalCode != null ? !externalCode.equals(partiesEO.externalCode) : partiesEO.externalCode != null)
            return false;
        if (lastUpdateDate != null ? !lastUpdateDate.equals(partiesEO.lastUpdateDate) : partiesEO.lastUpdateDate != null)
            return false;
        if (lastUpdatedBy != null ? !lastUpdatedBy.equals(partiesEO.lastUpdatedBy) : partiesEO.lastUpdatedBy != null)
            return false;
        if (!partyCode.equals(partiesEO.partyCode)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = partyId;
        result = 31 * result + organizationId;
        result = 31 * result + partyCode.hashCode();
        result = 31 * result + (externalCode != null ? externalCode.hashCode() : 0);
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        result = 31 * result + creationDate.hashCode();
        result = 31 * result + (int) (createdBy ^ (createdBy >>> 32));
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        return result;
    }
}
