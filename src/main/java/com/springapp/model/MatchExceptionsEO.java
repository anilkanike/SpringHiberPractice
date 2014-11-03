package com.springapp.model;

import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by lewis on 26/08/2014.
 */
@Entity
@Table(name = "MATCH_EXCEPTIONS", schema = "", catalog = "")
public class MatchExceptionsEO {
    private long exceptionId;
    private long lhsPersonId;
    private long rhsPersonId;
    private DateTime creationDate;
    private long createdBy;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="G1")
    @SequenceGenerator(name="G1", sequenceName="MATCH_EXCEPTIONS_SEQ")
    @Column(name = "EXCEPTION_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public long getExceptionId() {
        return exceptionId;
    }

    public void setExceptionId(long exceptionId) {
        this.exceptionId = exceptionId;
    }

    @Basic
    @Column(name = "LHS_PERSON_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public long getLhsPersonId() {
        return lhsPersonId;
    }

    public void setLhsPersonId(long lhsPersonId) {
        this.lhsPersonId = lhsPersonId;
    }

    @Basic
    @Column(name = "RHS_PERSON_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public long getRhsPersonId() {
        return rhsPersonId;
    }

    public void setRhsPersonId(long rhsPersonId) {
        this.rhsPersonId = rhsPersonId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MatchExceptionsEO that = (MatchExceptionsEO) o;

        if (createdBy != that.createdBy) return false;
        if (exceptionId != that.exceptionId) return false;
        if (lhsPersonId != that.lhsPersonId) return false;
        if (rhsPersonId != that.rhsPersonId) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int)(exceptionId ^ (exceptionId >>> 32));
        result = 31 * result + (int)(lhsPersonId ^ (lhsPersonId >>> 32));
        result = 31 * result + (int)(rhsPersonId ^ (rhsPersonId >>> 32));
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (int)(rhsPersonId ^ (rhsPersonId >>> 32));
        return result;
    }
}
