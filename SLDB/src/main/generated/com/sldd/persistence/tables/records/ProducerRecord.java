/*
 * This file is generated by jOOQ.
 */
package com.sldd.persistence.tables.records;


import com.sldd.persistence.tables.Producer;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * The table <code>public.producer</code>.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ProducerRecord extends UpdatableRecordImpl<ProducerRecord> implements Record2<Long, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.producer.id</code>.
     */
    public ProducerRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.producer.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.producer.type</code>.
     */
    public ProducerRecord setType(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.producer.type</code>.
     */
    public String getType() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Long, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Long, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Producer.PRODUCER.ID;
    }

    @Override
    public Field<String> field2() {
        return Producer.PRODUCER.TYPE;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getType();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getType();
    }

    @Override
    public ProducerRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public ProducerRecord value2(String value) {
        setType(value);
        return this;
    }

    @Override
    public ProducerRecord values(Long value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ProducerRecord
     */
    public ProducerRecord() {
        super(Producer.PRODUCER);
    }

    /**
     * Create a detached, initialised ProducerRecord
     */
    public ProducerRecord(Long id, String type) {
        super(Producer.PRODUCER);

        setId(id);
        setType(type);
    }

    /**
     * Create a detached, initialised ProducerRecord
     */
    public ProducerRecord(com.sldd.persistence.tables.pojos.Producer value) {
        super(Producer.PRODUCER);

        if (value != null) {
            setId(value.getId());
            setType(value.getType());
        }
    }
}
