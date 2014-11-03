package com.springapp.model;

/**
 * Created by lewis on 9/09/2014.
 */
public interface PeopleEI {

    long getPersonId();
    Long getSuccessorPersonId();
    int getOrganizationId();
    String getIdentifiedBy();
    String getActiveFlag();
}
