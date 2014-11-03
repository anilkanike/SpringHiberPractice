package com.springapp.model;

import javax.persistence.*;

/**
 * Created by lewis on 26/08/2014.
 */
@Entity
@Table(name = "LOOKUP_TYPES", schema = "", catalog = "")
public class LookupTypesEO {
    private String lookupType;
    private String displayName;
    private String enabledFlag;

    @Id
    @Column(name = "LOOKUP_TYPE", nullable = false, insertable = true, updatable = true, length = 30)
    public String getLookupType() {
        return lookupType;
    }

    public void setLookupType(String lookupType) {
        this.lookupType = lookupType;
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
    @Column(name = "ENABLED_FLAG", nullable = false, insertable = true, updatable = true, length = 1)
    public String getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(String enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LookupTypesEO that = (LookupTypesEO) o;

        if (displayName != null ? !displayName.equals(that.displayName) : that.displayName != null) return false;
        if (enabledFlag != null ? !enabledFlag.equals(that.enabledFlag) : that.enabledFlag != null) return false;
        if (lookupType != null ? !lookupType.equals(that.lookupType) : that.lookupType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lookupType != null ? lookupType.hashCode() : 0;
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        result = 31 * result + (enabledFlag != null ? enabledFlag.hashCode() : 0);
        return result;
    }
}
