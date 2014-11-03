package com.springapp.model;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

/**
 * Created by lewis on 26/08/2014.
 */
@NamedQueries(
                @NamedQuery(
                        name = PeopleEO.NQ_getPersonByIdentifier,
                        query = "from PeopleEO p " +
                                "where (p.organizationId = :organizationId and p.identifiedBy = :identifiedBy)"
                )
)
@NamedNativeQueries({
        @NamedNativeQuery(name= PeopleEO.NQ_identityViewInOrg + "-HSQL", query=(
                PeopleEO.identityViewQuery_SelectHsql +
                        PeopleEO.identityViewQuery_From +
                        "where (PE.organization_id = :pOrganizationId)\n" +
                        PeopleEO.identityViewQuery_GroupBy
        )
        ),
        @NamedNativeQuery(name=PeopleEO.NQ_identityViewByPersonId + "-HSQL", query=(
                PeopleEO.identityViewQuery_SelectHsql +
                        PeopleEO.identityViewQuery_From +
                        "where (PE.person_Id = :personId)\n" +
                        PeopleEO.identityViewQuery_GroupBy
        )
        ),
        @NamedNativeQuery(name=PeopleEO.NQ_identityViewInParty + "-HSQL", query=(
                PeopleEO.identityViewQuery_SelectHsql +
                        PeopleEO.identityViewQuery_From +
                        "where (PA.party_id = :pPartyId)\n" +
                        PeopleEO.identityViewQuery_GroupBy
        )
        ),
        @NamedNativeQuery(name=PeopleEO.NQ_identityViewAll + "-HSQL", query=(
                PeopleEO.identityViewQuery_SelectHsql +
                        PeopleEO.identityViewQuery_From +
                        "where (1=1)\n" +
                        PeopleEO.identityViewQuery_GroupBy
        )
        ),
        @NamedNativeQuery(name= PeopleEO.NQ_identityViewInOrg + "-ORA", query=(
                PeopleEO.identityViewQuery_SelectOra +
                        PeopleEO.identityViewQuery_From +
                        "where (PE.organization_id = :pOrganizationId)\n" +
                        PeopleEO.identityViewQuery_GroupBy
        )
        ),
        @NamedNativeQuery(name=PeopleEO.NQ_identityViewByPersonId + "-ORA", query=(
                PeopleEO.identityViewQuery_SelectOra +
                        PeopleEO.identityViewQuery_From +
                        "where (PE.person_Id = :personId)\n" +
                        PeopleEO.identityViewQuery_GroupBy
        )
        ),
        @NamedNativeQuery(name=PeopleEO.NQ_identityViewInParty + "-ORA", query=(
                PeopleEO.identityViewQuery_SelectOra +
                        PeopleEO.identityViewQuery_From +
                        "where (PA.party_id = :pPartyId)\n" +
                        PeopleEO.identityViewQuery_GroupBy
        )
        ),
        @NamedNativeQuery(name=PeopleEO.NQ_identityViewAll + "-ORA", query=(
                PeopleEO.identityViewQuery_SelectOra +
                        PeopleEO.identityViewQuery_From +
                        "where (1=1)\n" +
                        PeopleEO.identityViewQuery_GroupBy
        )
        )
})
@Entity
@Table(name = "PEOPLE", schema = "", catalog = "")
public class PeopleEO implements PeopleEI {
    public static final String NQ_getPersonByIdentifier = "getPersonByIdentifier";
    public static final String NQ_getIdentitiesByIds = "getIdentitiesByIds";

    public static final String NQ_identityViewAll = "identityViewAll";
    public static final String NQ_identityViewInOrg = "identityViewInOrg";
    public static final String NQ_identityViewInParty = "identityViewInParty";
    public static final String NQ_identityViewByPersonId = "identityViewByPersonId";

    public static final String identityViewQuery_SelectHsql = "select\n" +
            "  PE.person_Id as personId, PE.identified_By as identifiedBy, PE.active_Flag as activeFlag, PE.successor_Person_Id as successorPersonId, PE.organization_Id as organizationId,\n" +
            "  PH.first_Name as firstName, PH.initials as initials, PH.last_Name as lastName, PH.known_As_Name as knownAsName, PH.date_Of_Birth as dateOfBirth, PH.gender as gender,\n" +
            "  PH.personal_Email as personalEmail, PH.mobile_Phone as mobilePhone, PH.effective_Start_Date as effectiveStartDate, PH.effective_End_Date as effectiveEndDate, \n" +
            "  GROUP_CONCAT(DISTINCT DISPLAY_NAME ORDER BY DISPLAY_NAME ASC SEPARATOR ', ') as partyNames \n";
    public static final String identityViewQuery_SelectOra = "select\n" +
            "  PE.person_Id as personId, PE.identified_By as identifiedBy, PE.active_Flag as activeFlag, PE.successor_Person_Id as successorPersonId, PE.organization_Id as organizationId,\n" +
            "  PH.first_Name as firstName, PH.initials as initials, PH.last_Name as lastName, PH.known_As_Name as knownAsName, PH.date_Of_Birth as dateOfBirth, PH.gender as gender,\n" +
            "  PH.personal_Email as personalEmail, PH.mobile_Phone as mobilePhone, PH.effective_Start_Date as effectiveStartDate, PH.effective_End_Date as effectiveEndDate, \n" +
            "  LISTAGG(PA.DISPLAY_NAME, ', ') WITHIN GROUP (ORDER BY PA.DISPLAY_NAME ASC) as partyNames \n";
    public static final String identityViewQuery_From =
            "from People PE\n" +
            "inner join Person_History PH ON (ph.person_id = pe.person_id\n" +
            "  AND PH.effective_end_date IS NULL)\n" +
            "inner join Employments EMP ON (Pe.person_Id = EMP.person_Id\n" +
            "  AND (EMP.enabled_flag != 'N' \n" +
            "  AND EMP.START_DATE < :currentDate \n" +
            "  AND (EMP.END_DATE IS NULL OR EMP.END_DATE > :currentDate))\n" +
            ")\n" +
            "inner join Parties PA ON (pa.party_id = emp.party_id)\n"+
            "left outer join PARTY_HIERARCHY HI ON (HI.division_code = PA.party_code \n"+
            "  AND HI.enabled_flag != 'N' \n"+
            "  AND (HI.HIERARCHY_ID IS NULL OR HI.START_DATE_ACTIVE <= :currentDate) \n"+
            "  AND (HI.END_DATE_ACTIVE IS NULL OR HI.END_DATE_ACTIVE > :currentDate)\n"+
            ")\n";
    public static final String identityViewQuery_GroupBy =
            "group by PE.person_Id, PE.identified_By, PE.active_Flag, PE.successor_Person_Id, PE.organization_Id,\n" +
            "  PH.first_Name, PH.initials, PH.last_Name, PH.known_As_Name, PH.date_Of_Birth, PH.gender,\n" +
            "  PH.personal_Email, PH.mobile_Phone, PH.effective_Start_Date, PH.effective_End_Date";

    private long personId;
    private Long successorPersonId;
    private int organizationId;
    private String identifiedBy;
    private String activeFlag;
    private List<PersonHistoryEO> latestPersonHistory;

    @Id
    @Override
    @GeneratedValue(strategy = GenerationType.AUTO, generator="G1")
    @SequenceGenerator(name="G1", sequenceName="PEOPLE_SEQ")
    @Column(name = "PERSON_ID", nullable = false, insertable = true, updatable = true, length=19, precision = 0)
    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }


    @Basic
    @Override
    @Column(name = "SUCCESSOR_PERSON_ID", nullable = true, insertable = true, updatable = true, length=19, precision = 0)
    public Long getSuccessorPersonId() {
        return successorPersonId;
    }

    public void setSuccessorPersonId(Long successorPersonId) {
        this.successorPersonId = successorPersonId;
    }

    @Basic
    @Override
    @Column(name = "ORGANIZATION_ID", nullable = false, insertable = true, updatable = true, length=10, precision = 0)
    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    @Basic
    @Override
    @Column(name = "IDENTIFIED_BY", nullable = false, insertable = true, updatable = true, length = 32)
    public String getIdentifiedBy() {
        return identifiedBy;
    }

    public void setIdentifiedBy(String identifiedBy) {
        this.identifiedBy = identifiedBy;
    }

    @Basic
    @Override
    @Column(name = "ACTIVE_FLAG", nullable = false, insertable = true, updatable = true, length = 1)
    public String getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag;
    }

    /*
    @JoinColumn(name = "HISTORY_ID", referencedColumnName = "PERSON_ID", insertable = false, updatable = false, nullable = true, unique = false)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = PersonHistoryEO.class)
    @Where(clause = "PersonHistoryEO.effectiveEndDate IS NULL")
    public PersonHistoryEO getLatestPersonHistory() {
        return latestPersonHistory;
    }

    public void setLatestPersonHistory(PersonHistoryEO latestPersonHistory) {
        this.latestPersonHistory = latestPersonHistory;
    }
    */
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "PERSON_ID", insertable = false, updatable = false, nullable = true)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = PersonHistoryEO.class)
    @Where(clause = "EFFECTIVE_END_DATE IS NULL")
    public List<PersonHistoryEO> getLatestPersonHistory() {
        return latestPersonHistory;
    }

    public void setLatestPersonHistory(List<PersonHistoryEO> latestPersonHistory) {
        this.latestPersonHistory = latestPersonHistory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PeopleEO)) return false;

        PeopleEO peopleEO = (PeopleEO) o;

        if (activeFlag != null ? !activeFlag.equals(peopleEO.activeFlag) : peopleEO.activeFlag != null) return false;
        if (organizationId != peopleEO.organizationId) return false;
        if (personId != peopleEO.personId) return false;
        if (activeFlag != null ? !activeFlag.equals(peopleEO.activeFlag) : peopleEO.activeFlag != null) return false;
        if (identifiedBy != null ? !identifiedBy.equals(peopleEO.identifiedBy) : peopleEO.identifiedBy != null)
            return false;
        if (latestPersonHistory != null ? !latestPersonHistory.equals(peopleEO.latestPersonHistory) : peopleEO.latestPersonHistory != null)
            return false;
        if (successorPersonId != null ? !successorPersonId.equals(peopleEO.successorPersonId) : peopleEO.successorPersonId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (personId ^ (personId >>> 32));
        result = 31 * result + (successorPersonId != null ? successorPersonId.hashCode() : 0);
        result = 31 * result + organizationId;
        result = 31 * result + (identifiedBy != null ? identifiedBy.hashCode() : 0);
        result = 31 * result + (activeFlag != null ? activeFlag.hashCode() : 0);
        result = 31 * result + (latestPersonHistory != null ? latestPersonHistory.hashCode() : 0);
        return result;
    }
}
