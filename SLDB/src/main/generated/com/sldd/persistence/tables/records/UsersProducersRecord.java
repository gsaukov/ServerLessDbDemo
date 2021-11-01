/*
 * This file is generated by jOOQ.
 */
package com.sldd.persistence.tables.records;


import com.sldd.persistence.tables.UsersProducers;

import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.TableRecordImpl;


/**
 * The table <code>public.users_producers</code>.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsersProducersRecord extends TableRecordImpl<UsersProducersRecord> implements Record3<Long, Long, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.users_producers.user_id</code>.
     */
    public UsersProducersRecord setUserId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.users_producers.user_id</code>.
     */
    public Long getUserId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.users_producers.producer_id</code>.
     */
    public UsersProducersRecord setProducerId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.users_producers.producer_id</code>.
     */
    public Long getProducerId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.users_producers.role_id</code>.
     */
    public UsersProducersRecord setRoleId(Long value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.users_producers.role_id</code>.
     */
    public Long getRoleId() {
        return (Long) get(2);
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, Long, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Long, Long, Long> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return UsersProducers.USERS_PRODUCERS.USER_ID;
    }

    @Override
    public Field<Long> field2() {
        return UsersProducers.USERS_PRODUCERS.PRODUCER_ID;
    }

    @Override
    public Field<Long> field3() {
        return UsersProducers.USERS_PRODUCERS.ROLE_ID;
    }

    @Override
    public Long component1() {
        return getUserId();
    }

    @Override
    public Long component2() {
        return getProducerId();
    }

    @Override
    public Long component3() {
        return getRoleId();
    }

    @Override
    public Long value1() {
        return getUserId();
    }

    @Override
    public Long value2() {
        return getProducerId();
    }

    @Override
    public Long value3() {
        return getRoleId();
    }

    @Override
    public UsersProducersRecord value1(Long value) {
        setUserId(value);
        return this;
    }

    @Override
    public UsersProducersRecord value2(Long value) {
        setProducerId(value);
        return this;
    }

    @Override
    public UsersProducersRecord value3(Long value) {
        setRoleId(value);
        return this;
    }

    @Override
    public UsersProducersRecord values(Long value1, Long value2, Long value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UsersProducersRecord
     */
    public UsersProducersRecord() {
        super(UsersProducers.USERS_PRODUCERS);
    }

    /**
     * Create a detached, initialised UsersProducersRecord
     */
    public UsersProducersRecord(Long userId, Long producerId, Long roleId) {
        super(UsersProducers.USERS_PRODUCERS);

        setUserId(userId);
        setProducerId(producerId);
        setRoleId(roleId);
    }

    /**
     * Create a detached, initialised UsersProducersRecord
     */
    public UsersProducersRecord(com.sldd.persistence.tables.pojos.UsersProducers value) {
        super(UsersProducers.USERS_PRODUCERS);

        if (value != null) {
            setUserId(value.getUserId());
            setProducerId(value.getProducerId());
            setRoleId(value.getRoleId());
        }
    }
}
