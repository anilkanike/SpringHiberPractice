package com.springapp.model;

import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by lewis on 26/08/2014.
 */
@NamedNativeQueries({
        @NamedNativeQuery(name = EmploymentsEO.NQ_getEmploymentsByPersonId,
                query = "select pe.employment_Id as employmentId, pe.organization_Id as organizationId, " +
                        "  pe.person_Id as personId, pe.party_Id as partyId, pe.employee_Id as employeeId, " +
                        "  pe.employment_type as employmentType, pe.job_Title as jobTitle, pe.job_Band as jobBand, pe.work_Email as workEmail, " +
                        "  pe.direct_Phone as directPhone, pe.enabled_Flag as enabledFlag, pe.start_Date as startDate, " +
                        "  pe.end_Date as endDate, " +
                        "  pt.party_code as partyCode, pt.display_Name as partyDisplayName, pt.external_code as partyExternalCode\n" +
                        "from Employments pe\n" +
                        "inner join parties pt ON (pe.party_id = pt.party_id)\n" +
                        "where pe.person_id = :personId and enabled_flag = 'Y'"),

        @NamedNativeQuery(name = EmploymentsEO.NQ_getEmploymentById,
                query = "select pe.employment_Id as employmentId, pe.organization_Id as organizationId," +
                        "  pe.person_Id as personId, pe.party_Id as partyId, pe.employee_Id as employeeId," +
                        "  pe.employment_type as employmentType, pe.job_Title as jobTitle, pe.job_Band as jobBand, pe.work_Email as workEmail," +
                        "  pe.direct_Phone as directPhone, pe.enabled_Flag as enabledFlag, pe.start_Date as startDate," +
                        "  pe.end_Date as endDate " +
                        "from Employments pe\n" +
                        "where pe.person_id = :personId and pe.employment_Id = :employmentId and " +
                        "pe.organization_Id = :organizationId and pe.party_id = :partyId  and enabled_flag = 'Y'")
}


)
@Entity
@Table(name = "EMPLOYMENTS", schema = "", catalog = "")
public class EmploymentsEO {

    public static final String NQ_getEmploymentsByPersonId = "getEmploymentsByPersonId";
    public static final String NQ_getEmploymentsChangedBetween = "getEmploymentsChangedBetween";
    public static final String NQ_getEmploymentById = "NQ_getEmploymentById";

    private long employmentId;
    private int organizationId;
    private long personId;
    private int partyId;
    private String employeeId;
    private String employmentType;
    private String jobTitle;
    private String jobBand;
    private String workEmail;
    private String directPhone;
    private String enabledFlag;
    private DateTime startDate;
    private DateTime endDate;

    private PartiesEO party;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="G1")
    @SequenceGenerator(name="G1", sequenceName="EMPLOYMENTS_SEQ")
    @Column(name = "EMPLOYMENT_ID", nullable = false, insertable = true, updatable = true, length=10, precision = 0)
    public long getEmploymentId() {
        return employmentId;
    }

    public void setEmploymentId(long employmentId) {
        this.employmentId = employmentId;
    }

    @Basic
    @Column(name = "ORGANIZATION_ID", nullable = false, insertable = true, updatable = true, length=10, precision = 0)
    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    @Basic
    @Column(name = "PERSON_ID", nullable = false, insertable = true, updatable = true, length=19, precision = 0)
    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "PARTY_ID", nullable = false, insertable = true, updatable = true, length=10, precision = 0)
    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    @Basic
    @Column(name = "EMPLOYEE_ID", nullable = true, insertable = true, updatable = true, length=10, precision = 32)
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "EMPLOYMENT_TYPE", nullable = true, insertable = true, updatable = true, precision = 32)
    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String type) {
        this.employmentType = type;
    }

    @Basic
    @Column(name = "JOB_TITLE", nullable = true, insertable = true, updatable = true, precision = 100)
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Basic
    @Column(name = "JOB_BAND", nullable = true, insertable = true, updatable = true, precision = 10)
    public String getJobBand() {
        return jobBand;
    }

    public void setJobBand(String jobBand) {
        this.jobBand = jobBand;
    }

    @Basic
    @Column(name = "WORK_EMAIL", nullable = true, insertable = true, updatable = true, precision = 250)
    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    @Basic
    @Column(name = "DIRECT_PHONE", nullable = true, insertable = true, updatable = true, length = 15)
    public String getDirectPhone() {
        return directPhone;
    }

    public void setDirectPhone(String directPhone) {
        this.directPhone = directPhone;
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
    @Column(name = "START_DATE", nullable = false, insertable = true, updatable = true)
    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "END_DATE", nullable = true, insertable = true, updatable = true)
    public DateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="PARTY_ID", referencedColumnName = "PARTY_ID", nullable = false, insertable = false, updatable = false)
    public PartiesEO getParty() {
        return party;
    }

    public void setParty(PartiesEO party) {
        this.party = party;
    }

    /* NOT NULL:
    enabledFlag
    startDate
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmploymentsEO that = (EmploymentsEO) o;

        if (employmentId != that.employmentId) return false;
        if (organizationId != that.organizationId) return false;
        if (partyId != that.partyId) return false;
        if (personId != that.personId) return false;
        if (directPhone != null ? !directPhone.equals(that.directPhone) : that.directPhone != null) return false;
        if (employeeId != null ? !employeeId.equals(that.employeeId) : that.employeeId != null) return false;
        if (!enabledFlag.equals(that.enabledFlag)) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (jobBand != null ? !jobBand.equals(that.jobBand) : that.jobBand != null) return false;
        if (jobTitle != null ? !jobTitle.equals(that.jobTitle) : that.jobTitle != null) return false;
        if (party != null ? !party.equals(that.party) : that.party != null) return false;
        if (!startDate.equals(that.startDate)) return false;
        if (employmentType != null ? !employmentType.equals(that.employmentType) : that.employmentType != null) return false;
        if (workEmail != null ? !workEmail.equals(that.workEmail) : that.workEmail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (employmentId ^ (employmentId >>> 32));
        result = 31 * result + organizationId;
        result = 31 * result + (int) (personId ^ (personId >>> 32));
        result = 31 * result + partyId;
        result = 31 * result + (employeeId != null ? employeeId.hashCode() : 0);
        result = 31 * result + (employmentType != null ? employmentType.hashCode() : 0);
        result = 31 * result + (jobTitle != null ? jobTitle.hashCode() : 0);
        result = 31 * result + (jobBand != null ? jobBand.hashCode() : 0);
        result = 31 * result + (workEmail != null ? workEmail.hashCode() : 0);
        result = 31 * result + (directPhone != null ? directPhone.hashCode() : 0);
        result = 31 * result + enabledFlag.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (party != null ? party.hashCode() : 0);
        return result;
    }
}
