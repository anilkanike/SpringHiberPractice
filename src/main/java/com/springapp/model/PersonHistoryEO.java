package com.springapp.model;

import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by lewis on 26/08/2014.
 */
@NamedQueries(
        {
                @NamedQuery(
                        name = PersonHistoryEO.NQ_getPersonHistoryById,
                        query = "from PersonHistoryEO ph " +
                                "where ph.personId = :personId"
                ),
                @NamedQuery(
                        name = PersonHistoryEO.NQ_getPersonHistoryByIdentifier,
                        query = "from PersonHistoryEO ph, PeopleEO p " +
                                "where (ph.personId = p.personId) " +
                                "  and (p.organizationId = :organizationId and p.identifiedBy = :identifiedBy)"
                ),
                @NamedQuery(
                        // This query assumes that only one record can exist for an identity with no effectiveEndDate.
                        name = PersonHistoryEO.NQ_getCurrentPersonHistoryByIdentifier,
                        query = "from PersonHistoryEO ph, PeopleEO p " +
                                "where (ph.personId = p.personId) " +
                                "  and (ph.effectiveEndDate IS NULL) " +
                                "  and (p.organizationId = :organizationId and p.identifiedBy = :identifiedBy)"
                ),
                @NamedQuery(
                        // This query assumes that only one record can exist for an identity with no effectiveEndDate.
                        name = PersonHistoryEO.NQ_getCurrentPersonHistoryByPersonId,
                        query = "from PersonHistoryEO ph " +
                                "where (ph.personId = :personId) " +
                                "  and (ph.effectiveEndDate IS NULL)"
                ),

        }
)
@Entity
@Table(name = "PERSON_HISTORY", schema = "", catalog = "")
public class PersonHistoryEO {
    public static final String NQ_getPersonHistoryById = "getPersonHistoryById";
    public static final String NQ_getPersonHistoryByIdentifier = "getPersonHistoryByIdentifier";
    public static final String NQ_getCurrentPersonHistoryByIdentifier = "getCurrentPersonHistoryByIdentifier";
    public static final String NQ_getCurrentPersonHistoryByPersonId = "getCurrentPersonHistoryByPersonId";

    private long historyId;
    private long personId;
    private String firstName;
    private String initials;
    private String lastName;
    private String knownAsName;
    private DateTime dateOfBirth;
    private String gender;
    private String personalEmail;
    private String mobilePhone;
    private DateTime effectiveStartDate;
    private DateTime effectiveEndDate;
    private PeopleEO person;
    private DateTime lastUpdateDate;
    private Long lastUpdatedBy;
    private PeopleEO lastUpdatedByPerson;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="G1")
    @SequenceGenerator(name="G1", sequenceName="PERSON_HISTORY_SEQ")
    @Column(name = "HISTORY_ID", nullable = true, insertable = true, updatable = true, length=19, precision = 0)
    public long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(long historyId) {
        this.historyId = historyId;
    }

    @Basic
    @Column(name = "PERSON_ID", nullable = true, insertable = true, updatable = true, length=19, precision = 0)
    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "FIRST_NAME", nullable = false, insertable = true, updatable = true, length = 100)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "INITIALS", nullable = true, insertable = true, updatable = true, length = 5)
    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    @Basic
    @Column(name = "LAST_NAME", nullable = false, insertable = true, updatable = true, length = 100)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "KNOWN_AS_NAME", nullable = true, insertable = true, updatable = true, length = 100)
    public String getKnownAsName() {
        return knownAsName;
    }

    public void setKnownAsName(String knownAsName) {
        this.knownAsName = knownAsName;
    }

    @Basic
    @Column(name = "DATE_OF_BIRTH", nullable = false, insertable = true, updatable = true)
    public DateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "GENDER", nullable = true, insertable = true, updatable = true, length = 1)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "PERSONAL_EMAIL", nullable = true, insertable = true, updatable = true, length = 240)
    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    @Basic
    @Column(name = "MOBILE_PHONE", nullable = true, insertable = true, updatable = true, length = 15)
    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Basic
    @Column(name = "EFFECTIVE_START_DATE", nullable = false, insertable = true, updatable = true)
    public DateTime getEffectiveStartDate() {
        return effectiveStartDate;
    }

    public void setEffectiveStartDate(DateTime effectiveStartDate) {
        this.effectiveStartDate = effectiveStartDate;
    }

    @Basic
    @Column(name = "EFFECTIVE_END_DATE", nullable = true, insertable = true, updatable = true)
    public DateTime getEffectiveEndDate() {
        return effectiveEndDate;
    }

    public void setEffectiveEndDate(DateTime effectiveEndDate) {
        this.effectiveEndDate = effectiveEndDate;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = PeopleEO.class)
    @JoinColumn(name = "PERSON_ID", nullable = false, insertable = false, updatable = false)
    public PeopleEO getPerson() {
        return person;
    }

    public void setPerson(PeopleEO person) {
        this.person = person;
    }

    @Basic
    @Column(name = "LAST_UPDATE_DATE", nullable = true, insertable = true, updatable = true)
    public DateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(DateTime creationDate) {
        this.lastUpdateDate = creationDate;
    }

    @Basic
    @Column(name = "LAST_UPDATED_BY", nullable = true, insertable = true, updatable = true, precision = 0)
    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long createdBy) {
        this.lastUpdatedBy = createdBy;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="LAST_UPDATED_BY", referencedColumnName = "PERSON_ID", nullable = false, insertable = false, updatable = false)
    public PeopleEO getLastUpdatedByPerson() {
        return lastUpdatedByPerson;
    }

    public void setLastUpdatedByPerson(PeopleEO createdByPerson) {
        this.lastUpdatedByPerson = createdByPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonHistoryEO that = (PersonHistoryEO) o;

        if (historyId != that.historyId) return false;
        if (personId != that.personId) return false;
        if (!dateOfBirth.equals(that.dateOfBirth)) return false;
        if (effectiveEndDate != null ? !effectiveEndDate.equals(that.effectiveEndDate) : that.effectiveEndDate != null)
            return false;
        if (!effectiveStartDate.equals(that.effectiveStartDate)) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (initials != null ? !initials.equals(that.initials) : that.initials != null) return false;
        if (knownAsName != null ? !knownAsName.equals(that.knownAsName) : that.knownAsName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (lastUpdateDate != null ? !lastUpdateDate.equals(that.lastUpdateDate) : that.lastUpdateDate != null)
            return false;
        if (lastUpdatedBy != null ? !lastUpdatedBy.equals(that.lastUpdatedBy) : that.lastUpdatedBy != null)
            return false;
        if (lastUpdatedByPerson != null ? !lastUpdatedByPerson.equals(that.lastUpdatedByPerson) : that.lastUpdatedByPerson != null)
            return false;
        if (mobilePhone != null ? !mobilePhone.equals(that.mobilePhone) : that.mobilePhone != null) return false;
        if (person != null ? !person.equals(that.person) : that.person != null) return false;
        if (personalEmail != null ? !personalEmail.equals(that.personalEmail) : that.personalEmail != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (historyId ^ (historyId >>> 32));
        result = 31 * result + (int) (personId ^ (personId >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (initials != null ? initials.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (knownAsName != null ? knownAsName.hashCode() : 0);
        result = 31 * result + dateOfBirth.hashCode();
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (personalEmail != null ? personalEmail.hashCode() : 0);
        result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
        result = 31 * result + effectiveStartDate.hashCode();
        result = 31 * result + (effectiveEndDate != null ? effectiveEndDate.hashCode() : 0);
        result = 31 * result + (person != null ? person.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        result = 31 * result + (lastUpdatedByPerson != null ? lastUpdatedByPerson.hashCode() : 0);
        return result;
    }
}
