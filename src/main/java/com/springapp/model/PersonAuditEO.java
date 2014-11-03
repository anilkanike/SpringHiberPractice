package com.springapp.model;

import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by lewis on 26/08/2014.
 */
@Entity
@NamedNativeQueries(
        @NamedNativeQuery(name = PersonAuditEO.NQ_getPersonAuditByPersonId,
            query = "select pa.audit_Id as auditId, pa.person_Id as personId, pa.change_Type as changeType, " +
                    "   pa.change_Data_1 as changeData1, pa.change_Data_2 as changeData2, pa.change_Data_3 as changeData3, " +
                    "   pa.change_Data_4 as changeData4, " +
                    "   pa.creation_Date as creationDate, pa.created_By as createdBy, " +
                    "   pec.identified_by as createdByIdentifier, phc.first_name||' '||phc.last_name as createdByName\n" +
                    "from Person_Audit pa\n" +
                    "inner join Person_History phc ON (phc.person_id = pa.created_By AND phc.effective_end_date IS NULL AND phc.effective_start_date <= :currentDate)\n" +
                    "left outer join People pec ON (pec.person_id = pa.created_by)\n" +
                    "where pa.person_id = :personId " +
                    "  AND pa.changeType NOT LIKE 'V_%'"
        )
)
@Table(name = "PERSON_AUDIT", schema = "", catalog = "")
public class PersonAuditEO {
    public final static String NQ_getPersonAuditByPersonId = "getPersonAuditByPersonId";

    private long auditId;
    private long personId;
    private String changeType;
    private String changeData1;
    private String changeData2;
    private String changeData3;
    private String changeData4;
    private DateTime creationDate;
    private long createdBy;
    private PeopleEO createdByPerson;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="G1")
    @SequenceGenerator(name="G1", sequenceName="PERSON_AUDIT_SEQ")
    @Column(name = "AUDIT_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public long getAuditId() {
        return auditId;
    }

    public void setAuditId(long auditId) {
        this.auditId = auditId;
    }

    @Basic
    @Column(name = "PERSON_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "CHANGE_TYPE", nullable = false, insertable = true, updatable = true, length = 30)
    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    @Basic
    @Column(name = "CHANGE_DATA_1", nullable = true, insertable = true, updatable = true, length = 240)
    public String getChangeData1() {
        return changeData1;
    }

    public void setChangeData1(String changeData1) {
        this.changeData1 = changeData1;
    }

    @Basic
    @Column(name = "CHANGE_DATA_2", nullable = true, insertable = true, updatable = true, length = 240)
    public String getChangeData2() {
        return changeData2;
    }

    public void setChangeData2(String changeData2) {
        this.changeData2 = changeData2;
    }

    @Basic
    @Column(name = "CHANGE_DATA_3", nullable = true, insertable = true, updatable = true, length = 240)
    public String getChangeData3() {
        return changeData3;
    }

    public void setChangeData3(String changeData3) {
        this.changeData3 = changeData3;
    }

    @Basic
    @Column(name = "CHANGE_DATA_4", nullable = true, insertable = true, updatable = true, length = 240)
    public String getChangeData4() {
        return changeData4;
    }

    public void setChangeData4(String changeData4) {
        this.changeData4 = changeData4;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="CREATED_BY", referencedColumnName = "PERSON_ID", nullable = false, insertable = false, updatable = false)
    public PeopleEO getCreatedByPerson() {
        return createdByPerson;
    }

    public void setCreatedByPerson(PeopleEO createdByPerson) {
        this.createdByPerson = createdByPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonAuditEO that = (PersonAuditEO) o;

        if (auditId != that.auditId) return false;
        if (createdBy != that.createdBy) return false;
        if (personId != that.personId) return false;
        if (changeData1 != null ? !changeData1.equals(that.changeData1) : that.changeData1 != null) return false;
        if (changeData2 != null ? !changeData2.equals(that.changeData2) : that.changeData2 != null) return false;
        if (changeData3 != null ? !changeData3.equals(that.changeData3) : that.changeData3 != null) return false;
        if (changeData4 != null ? !changeData4.equals(that.changeData4) : that.changeData4 != null) return false;
        if (changeType != null ? !changeType.equals(that.changeType) : that.changeType != null) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (auditId ^ (auditId >>> 32));
        result = 31 * result + (int) (personId ^ (personId >>> 32));
        result = 31 * result + (changeType != null ? changeType.hashCode() : 0);
        result = 31 * result + (changeData1 != null ? changeData1.hashCode() : 0);
        result = 31 * result + (changeData2 != null ? changeData2.hashCode() : 0);
        result = 31 * result + (changeData3 != null ? changeData3.hashCode() : 0);
        result = 31 * result + (changeData4 != null ? changeData4.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (int) (createdBy ^ (createdBy >>> 32));
        return result;
    }
}
