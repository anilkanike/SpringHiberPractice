package com.springapp.model;

import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by lewis on 26/08/2014.
 */
@Entity
@Table(name = "APPLICATIONS", schema = "", catalog = "")
public class ApplicationsEO {
    private int applicationId;
    private String displayName;
    private Integer orgId;
    private Integer partyId;
    private String globalFlag;
    private String enabledFlag;
    private String helpText;
    private int displayPriority;
    private String iconSrc;
    private String iconSrcRelative;
    private String cssClass;
    private String cssStyle;
    private DateTime creationDate;
    private long createdBy;
    private DateTime lastUpdateDate;
    private Long lastUpdatedBy;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="G1")
    @SequenceGenerator(name="G1", sequenceName="APPLICATIONS_SEQ")
    @Column(name = "APPLICATION_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
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
    @Column(name = "ORG_ID", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    @Basic
    @Column(name = "PARTY_ID", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getPartyId() {
        return partyId;
    }

    public void setPartyId(Integer partyId) {
        this.partyId = partyId;
    }

    @Basic
    @Column(name = "GLOBAL_FLAG", nullable = false, insertable = true, updatable = true, length = 1)
    public String getGlobalFlag() {
        return globalFlag;
    }

    public void setGlobalFlag(String globalFlag) {
        this.globalFlag = globalFlag;
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
    @Column(name = "HELP_TEXT", nullable = true, insertable = true, updatable = true, length = 240)
    public String getHelpText() {
        return helpText;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
    }

    @Basic
    @Column(name = "DISPLAY_PRIORITY", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getDisplayPriority() {
        return displayPriority;
    }

    public void setDisplayPriority(int displayPriority) {
        this.displayPriority = displayPriority;
    }

    @Basic
    @Column(name = "ICON_SRC", nullable = true, insertable = true, updatable = true, length = 1000)
    public String getIconSrc() {
        return iconSrc;
    }

    public void setIconSrc(String iconSrc) {
        this.iconSrc = iconSrc;
    }

    @Basic
    @Column(name = "ICON_SRC_RELATIVE", nullable = false, insertable = true, updatable = true, length = 1)
    public String getIconSrcRelative() {
        return iconSrcRelative;
    }

    public void setIconSrcRelative(String iconSrcRelative) {
        this.iconSrcRelative = iconSrcRelative;
    }

    @Basic
    @Column(name = "CSS_CLASS", nullable = true, insertable = true, updatable = true, length = 1000)
    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    @Basic
    @Column(name = "CSS_STYLE", nullable = true, insertable = true, updatable = true, length = 1000)
    public String getCssStyle() {
        return cssStyle;
    }

    public void setCssStyle(String cssStyle) {
        this.cssStyle = cssStyle;
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

        ApplicationsEO that = (ApplicationsEO) o;

        if (applicationId != that.applicationId) return false;
        if (createdBy != that.createdBy) return false;
        if (displayPriority != that.displayPriority) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (cssClass != null ? !cssClass.equals(that.cssClass) : that.cssClass != null) return false;
        if (cssStyle != null ? !cssStyle.equals(that.cssStyle) : that.cssStyle != null) return false;
        if (displayName != null ? !displayName.equals(that.displayName) : that.displayName != null) return false;
        if (enabledFlag != null ? !enabledFlag.equals(that.enabledFlag) : that.enabledFlag != null) return false;
        if (globalFlag != null ? !globalFlag.equals(that.globalFlag) : that.globalFlag != null) return false;
        if (helpText != null ? !helpText.equals(that.helpText) : that.helpText != null) return false;
        if (iconSrc != null ? !iconSrc.equals(that.iconSrc) : that.iconSrc != null) return false;
        if (iconSrcRelative != null ? !iconSrcRelative.equals(that.iconSrcRelative) : that.iconSrcRelative != null)
            return false;
        if (lastUpdateDate != null ? !lastUpdateDate.equals(that.lastUpdateDate) : that.lastUpdateDate != null)
            return false;
        if (lastUpdatedBy != null ? !lastUpdatedBy.equals(that.lastUpdatedBy) : that.lastUpdatedBy != null)
            return false;
        if (orgId != null ? !orgId.equals(that.orgId) : that.orgId != null) return false;
        if (partyId != null ? !partyId.equals(that.partyId) : that.partyId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = applicationId;
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        result = 31 * result + (orgId != null ? orgId.hashCode() : 0);
        result = 31 * result + (partyId != null ? partyId.hashCode() : 0);
        result = 31 * result + (globalFlag != null ? globalFlag.hashCode() : 0);
        result = 31 * result + (enabledFlag != null ? enabledFlag.hashCode() : 0);
        result = 31 * result + (helpText != null ? helpText.hashCode() : 0);
        result = 31 * result + displayPriority;
        result = 31 * result + (iconSrc != null ? iconSrc.hashCode() : 0);
        result = 31 * result + (iconSrcRelative != null ? iconSrcRelative.hashCode() : 0);
        result = 31 * result + (cssClass != null ? cssClass.hashCode() : 0);
        result = 31 * result + (cssStyle != null ? cssStyle.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (int)(createdBy ^ (createdBy >>> 32));
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        return result;
    }
}
