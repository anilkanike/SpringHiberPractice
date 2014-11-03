package com.springapp.model;

import org.hibernate.annotations.Index;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by lewis on 13/10/2014.
 */
@NamedQueries(
        {
                @NamedQuery(
                        name = PartyHierarchyEO.NQ_listPartyHierarchy,
                        query = "from PartyHierarchyEO p\n" +
                                "where (p.orgId = :organizationId)\n" +
                                "  and enabledFlag = 'Y'\n" +
                                "  and startDateActive <= :currentDate\n" +
                                "  and (endDateActive IS NULL OR endDateActive > :currentDate)\n" +
                                "order by p.hierarchyId ASC"
                )
        }
)
@Entity
@Table(name="PARTY_HIERARCHY")
@org.hibernate.annotations.Table(appliesTo = "PARTY_HIERARCHY", indexes = {
        @Index(name="hier_org_id", columnNames = {"org_Id"}),
        @Index(name="hier_division_id", columnNames = {"division_code"}),
        @Index(name="hier_agency_id", columnNames = {"agency_code"})
})
public class PartyHierarchyEO {

    public static final String NQ_listPartyHierarchy = "listPartyHierarchy";

    private Integer hierarchyId;
    private Integer orgId;

    private String clusterCode;
    private String clusterName;

    private String level2Code;
    private String level2Name;

    private String agencyCode;
    private String agencyName;

    private String divisionCode;
    private String divisionName;

    private String enabledFlag;
    private DateTime startDateActive;
    private DateTime endDateActive;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="G1")
    @SequenceGenerator(name="G1", sequenceName="PARTY_HIERARCHY_SEQ")
    @Column(name = "HIERARCHY_ID", nullable=false, insertable = true, updatable = false, length = 10, precision = 0)
    public Integer getHierarchyId() {
        return hierarchyId;
    }

    public void setHierarchyId(Integer hierarchyId) {
        this.hierarchyId = hierarchyId;
    }

    @Basic
    @Column(name = "ORG_ID", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    @Column(name="CLUSTER_CODE", insertable = true, updatable = true, nullable = true, length = 20)
    public String getClusterCode() {
        return clusterCode;
    }

    public void setClusterCode(String clusterCode) {
        this.clusterCode = clusterCode;
    }

    @Column(name="CLUSTER_NAME", insertable = true, updatable = true, nullable = true, length = 255)
    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    @Column(name="LEVEL2_CODE", insertable = true, updatable = true, nullable = true, length = 20)
    public String getLevel2Code() {
        return level2Code;
    }

    public void setLevel2Code(String level2Code) {
        this.level2Code = level2Code;
    }

    @Column(name="LEVEL2_NAME", insertable = true, updatable = true, nullable = true, length = 255)
    public String getLevel2Name() {
        return level2Name;
    }

    public void setLevel2Name(String level2Name) {
        this.level2Name = level2Name;
    }

    @Column(name="AGENCY_CODE", insertable = true, updatable = true, nullable = true, length = 20)
    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

    @Column(name="AGENCY_NAME", insertable = true, updatable = true, nullable = true, length = 255)
    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    @Column(name="DIVISION_CODE", insertable = true, updatable = true, nullable = true, length = 20)
    public String getDivisionCode() {
        return divisionCode;
    }

    public void setDivisionCode(String divisionCode) {
        this.divisionCode = divisionCode;
    }

    @Column(name="DIVISION_NAME", insertable = true, updatable = true, nullable = true, length = 255)
    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
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

}
