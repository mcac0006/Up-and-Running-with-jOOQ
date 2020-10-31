/*
 * This file is generated by jOOQ.
 */
package jooq.generated.master.dbo.tables.daos;


import java.util.List;

import javax.annotation.processing.Generated;

import jooq.generated.master.dbo.tables.Managers;
import jooq.generated.master.dbo.tables.pojos.JooqManagers;
import jooq.generated.master.dbo.tables.records.ManagersRecord;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.5",
        "schema version:1.1"
    },
    date = "2020-10-31T06:19:36.439Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class ManagersRepository extends DAOImpl<ManagersRecord, JooqManagers, Integer> {

    /**
     * Create a new ManagersRepository without any configuration
     */
    public ManagersRepository() {
        super(Managers.MANAGERS, JooqManagers.class);
    }

    /**
     * Create a new ManagersRepository with an attached configuration
     */
    @Autowired
    public ManagersRepository(Configuration configuration) {
        super(Managers.MANAGERS, JooqManagers.class, configuration);
    }

    @Override
    public Integer getId(JooqManagers object) {
        return object.getManagerid();
    }

    /**
     * Fetch records that have <code>managerId BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JooqManagers> fetchRangeOfManagerid(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Managers.MANAGERS.MANAGERID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>managerId IN (values)</code>
     */
    public List<JooqManagers> fetchByManagerid(Integer... values) {
        return fetch(Managers.MANAGERS.MANAGERID, values);
    }

    /**
     * Fetch a unique record that has <code>managerId = value</code>
     */
    public JooqManagers fetchOneByManagerid(Integer value) {
        return fetchOne(Managers.MANAGERS.MANAGERID, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JooqManagers> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Managers.MANAGERS.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<JooqManagers> fetchByName(String... values) {
        return fetch(Managers.MANAGERS.NAME, values);
    }
}