package com.springapp.model;


import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by lewis on 7/08/2014.
 */
@NamedQueries({
        @NamedQuery(name = LookupCodesEO.NQ_getLookupByType,
                query = ""
                        + "  from LookupCodesEO"
                        + " where lookup_type = :lookupType and enabledFlag = 'Y' "
                        + "   and startDateActive <= :nowDate and ("
                        + "           endDateActive is null or endDateActive > :nowDate"
                        + "       )"
                        + "   and orgId = :organizationId"
                        + " order by displayOrder"
        )
})
@Entity
@Table(name = "LOOKUP_CODES", schema = "", catalog = "")
public class LookupCodesEO {

    public static final String NQ_getLookupByType = "getLookupByType";

    private int lookupCodeId;
    private String lookupType;
    private String lookupCode;
    private Integer orgId;
    private Integer partyId;
    private int displayOrder;
    private String meaning;
    private String meaningExternal;
    private String description;
    private String descriptionExternal;
    private String enabledFlag;
    private DateTime startDateActive;
    private DateTime endDateActive;
    private DateTime creationDate;
    private long createdBy;
    private DateTime lastUpdateDate;
    private Long lastUpdatedBy;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="G1")
    @SequenceGenerator(name="G1", sequenceName="LOOKUP_CODES_SEQ")
    @Column(name = "LOOKUP_CODE_ID", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getLookupCodeId() {
        return lookupCodeId;
    }

    public void setLookupCodeId(int lookupCodeId) {
        this.lookupCodeId = lookupCodeId;
    }

    @Basic
    @Column(name = "LOOKUP_TYPE", nullable = false, insertable = true, updatable = true, length = 30)
    public String getLookupType() {
        return lookupType;
    }

    public void setLookupType(String lookupType) {
        this.lookupType = lookupType;
    }

    @Basic
    @Column(name = "LOOKUP_CODE", nullable = false, insertable = true, updatable = true, length = 30)
    public String getLookupCode() {
        return lookupCode;
    }

    public void setLookupCode(String lookupCode) {
        this.lookupCode = lookupCode;
    }

    @Basic
    @Column(name = "ORG_ID", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    @Basic
    @Column(name = "PARTY_ID", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getPartyId() {
        return partyId;
    }

    public void setPartyId(Integer partyId) {
        this.partyId = partyId;
    }

    @Basic
    @Column(name = "DISPLAY_ORDER", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    @Basic
    @Column(name = "MEANING", nullable = false, insertable = true, updatable = true, length = 100)
    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @Basic
    @Column(name = "MEANING_EXTERNAL", nullable = true, insertable = true, updatable = true, length = 100)
    public String getMeaningExternal() {
        return meaningExternal;
    }

    public void setMeaningExternal(String meaningExternal) {
        this.meaningExternal = meaningExternal;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = true, insertable = true, updatable = true, length = 240)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "DESCRIPTION_EXTERNAL", nullable = true, insertable = true, updatable = true, length = 240)
    public String getDescriptionExternal() {
        return descriptionExternal;
    }

    public void setDescriptionExternal(String descriptionExternal) {
        this.descriptionExternal = descriptionExternal;
    }

    @Basic
    @Column(name = "ENABLED_FLAG", nullable = false, insertable = true, updatable = true, length = 1)
    public String getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(String enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    @Basic
    @Column(name = "START_DATE_ACTIVE", nullable = false, insertable = true, updatable = true)
    public DateTime getStartDateActive() {
        return startDateActive;
    }

    public void setStartDateActive(DateTime startDateActive) {
        this.startDateActive = startDateActive;
    }

    @Basic
    @Column(name = "END_DATE_ACTIVE", nullable = true, insertable = true, updatable = true)
    public DateTime getEndDateActive() {
        return endDateActive;
    }

    public void setEndDateActive(DateTime endDateActive) {
        this.endDateActive = endDateActive;
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

        LookupCodesEO that = (LookupCodesEO) o;

        if (createdBy != that.createdBy) return false;
        if (displayOrder != that.displayOrder) return false;
        if (lookupCodeId != that.lookupCodeId) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (descriptionExternal != null ? !descriptionExternal.equals(that.descriptionExternal) : that.descriptionExternal != null)
            return false;
        if (enabledFlag != null ? !enabledFlag.equals(that.enabledFlag) : that.enabledFlag != null) return false;
        if (endDateActive != null ? !endDateActive.equals(that.endDateActive) : that.endDateActive != null)
            return false;
        if (lastUpdateDate != null ? !lastUpdateDate.equals(that.lastUpdateDate) : that.lastUpdateDate != null)
            return false;
        if (lastUpdatedBy != null ? !lastUpdatedBy.equals(that.lastUpdatedBy) : that.lastUpdatedBy != null)
            return false;
        if (lookupCode != null ? !lookupCode.equals(that.lookupCode) : that.lookupCode != null) return false;
        if (lookupType != null ? !lookupType.equals(that.lookupType) : that.lookupType != null) return false;
        if (meaning != null ? !meaning.equals(that.meaning) : that.meaning != null) return false;
        if (meaningExternal != null ? !meaningExternal.equals(that.meaningExternal) : that.meaningExternal != null)
            return false;
        if (orgId != null ? !orgId.equals(that.orgId) : that.orgId != null) return false;
        if (partyId != null ? !partyId.equals(that.partyId) : that.partyId != null) return false;
        if (startDateActive != null ? !startDateActive.equals(that.startDateActive) : that.startDateActive != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lookupCodeId;
        result = 31 * result + (lookupType != null ? lookupType.hashCode() : 0);
        result = 31 * result + (lookupCode != null ? lookupCode.hashCode() : 0);
        result = 31 * result + (orgId != null ? orgId.hashCode() : 0);
        result = 31 * result + (partyId != null ? partyId.hashCode() : 0);
        result = 31 * result + displayOrder;
        result = 31 * result + (meaning != null ? meaning.hashCode() : 0);
        result = 31 * result + (meaningExternal != null ? meaningExternal.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (descriptionExternal != null ? descriptionExternal.hashCode() : 0);
        result = 31 * result + (enabledFlag != null ? enabledFlag.hashCode() : 0);
        result = 31 * result + (startDateActive != null ? startDateActive.hashCode() : 0);
        result = 31 * result + (endDateActive != null ? endDateActive.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (int)(createdBy ^ (createdBy >>> 32));
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        return result;
    }
}
