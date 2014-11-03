package com.springapp.model;

import javax.persistence.*;

/**
 * Created by lewis on 26/08/2014.
 */

@NamedQueries(
        {
                @NamedQuery(
                        name = EdqHashesEO.NQ_getPeopleByHashcodes,
                        query = "select distinct e.personId \n" +
                                "from EdqHashesEO e\n" +
                                "where e.person.activeFlag = 'Y'\n" +
                                "  and e.hashCategory = :hashCategory\n" +
                                "  and e.person.organizationId = :organizationId\n" +
                                "  and e.hash in :hashes"
                ),
                @NamedQuery(
                        name = EdqHashesEO.NQ_getPeopleByHashcode,
                        query = "select distinct e.personId \n" +
                                "from EdqHashesEO e\n" +
                                "where e.person.activeFlag = 'Y'\n" +
                                "  and e.hashCategory = :hashCategory\n" +
                                "  and e.person.organizationId = :organizationId\n" +
                                "  and e.hash = :hash\n" +
                                "  and e.person.identifiedBy not in :excludeIdentifiers"
                ),
                @NamedQuery(
                        name = EdqHashesEO.NQ_deleteClusterKeys,
                        query = "delete EdqHashesEO where personId = :personId"
                )
        }
)
@Entity
@Table(name = "EDQ_HASHES", schema = "", catalog = "")
public class EdqHashesEO {

    public static final String NQ_getPeopleByHashcode = "getPeopleByHashCode";
    public static final String NQ_getPeopleByHashcodes = "getPeopleByHashCodes";
    public static final String NQ_deleteClusterKeys = "deleteClusterKeys";

    private long hashId;
    private String hash;
    private String hashCategory;
    private long personId;
    private PeopleEO person;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="G1")
    @SequenceGenerator(name="G1", sequenceName="EDQ_HASHES_SEQ")
    @Column(name = "HASH_ID", nullable = false, insertable = true, updatable = true, length=19, precision = 0)
    public long getHashId() {
        return hashId;
    }

    public void setHashId(long hashId) {
        this.hashId = hashId;
    }

    @Basic
    @Column(name = "HASH", nullable = false, insertable = true, updatable = true, length = 240)
    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Basic
    @Column(name = "HASH_CATEGORY", nullable = false, insertable = true, updatable = true, length = 10)
    public String getHashCategory() {
        return hashCategory;
    }

    public void setHashCategory(String hashCategory) {
        this.hashCategory = hashCategory;
    }

    @Basic
    @Column(name = "PERSON_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = PeopleEO.class)
    @JoinColumn(name = "PERSON_ID", nullable = false, insertable = false, updatable = false)
    public PeopleEO getPerson() {
        return person;
    }

    public void setPerson(PeopleEO person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EdqHashesEO that = (EdqHashesEO) o;

        if (personId != that.personId) return false;
        if (hash != null ? !hash.equals(that.hash) : that.hash != null) return false;
        if (hashCategory != null ? !hashCategory.equals(that.hashCategory) : that.hashCategory != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hash != null ? hash.hashCode() : 0;
        result = 31 * result + (hashCategory != null ? hashCategory.hashCode() : 0);
        result = 31 * result + (int)(personId ^ (personId >>> 32));
        return result;
    }
}
