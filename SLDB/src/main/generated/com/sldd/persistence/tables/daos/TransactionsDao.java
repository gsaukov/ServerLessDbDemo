/*
 * This file is generated by jOOQ.
 */
package com.sldd.persistence.tables.daos;


import com.sldd.persistence.tables.Transactions;
import com.sldd.persistence.tables.records.TransactionsRecord;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * The table <code>public.transactions</code>.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TransactionsDao extends DAOImpl<TransactionsRecord, com.sldd.persistence.tables.pojos.Transactions, Long> {

    /**
     * Create a new TransactionsDao without any configuration
     */
    public TransactionsDao() {
        super(Transactions.TRANSACTIONS, com.sldd.persistence.tables.pojos.Transactions.class);
    }

    /**
     * Create a new TransactionsDao with an attached configuration
     */
    public TransactionsDao(Configuration configuration) {
        super(Transactions.TRANSACTIONS, com.sldd.persistence.tables.pojos.Transactions.class, configuration);
    }

    @Override
    public Long getId(com.sldd.persistence.tables.pojos.Transactions object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.sldd.persistence.tables.pojos.Transactions> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Transactions.TRANSACTIONS.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.sldd.persistence.tables.pojos.Transactions> fetchById(Long... values) {
        return fetch(Transactions.TRANSACTIONS.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.sldd.persistence.tables.pojos.Transactions fetchOneById(Long value) {
        return fetchOne(Transactions.TRANSACTIONS.ID, value);
    }

    /**
     * Fetch records that have <code>external_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.sldd.persistence.tables.pojos.Transactions> fetchRangeOfExternalId(UUID lowerInclusive, UUID upperInclusive) {
        return fetchRange(Transactions.TRANSACTIONS.EXTERNAL_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>external_id IN (values)</code>
     */
    public List<com.sldd.persistence.tables.pojos.Transactions> fetchByExternalId(UUID... values) {
        return fetch(Transactions.TRANSACTIONS.EXTERNAL_ID, values);
    }

    /**
     * Fetch a unique record that has <code>external_id = value</code>
     */
    public com.sldd.persistence.tables.pojos.Transactions fetchOneByExternalId(UUID value) {
        return fetchOne(Transactions.TRANSACTIONS.EXTERNAL_ID, value);
    }

    /**
     * Fetch records that have <code>transaction_type BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.sldd.persistence.tables.pojos.Transactions> fetchRangeOfTransactionType(String lowerInclusive, String upperInclusive) {
        return fetchRange(Transactions.TRANSACTIONS.TRANSACTION_TYPE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>transaction_type IN (values)</code>
     */
    public List<com.sldd.persistence.tables.pojos.Transactions> fetchByTransactionType(String... values) {
        return fetch(Transactions.TRANSACTIONS.TRANSACTION_TYPE, values);
    }

    /**
     * Fetch records that have <code>amount BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.sldd.persistence.tables.pojos.Transactions> fetchRangeOfAmount(BigDecimal lowerInclusive, BigDecimal upperInclusive) {
        return fetchRange(Transactions.TRANSACTIONS.AMOUNT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>amount IN (values)</code>
     */
    public List<com.sldd.persistence.tables.pojos.Transactions> fetchByAmount(BigDecimal... values) {
        return fetch(Transactions.TRANSACTIONS.AMOUNT, values);
    }

    /**
     * Fetch records that have <code>date_time BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.sldd.persistence.tables.pojos.Transactions> fetchRangeOfDateTime(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(Transactions.TRANSACTIONS.DATE_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>date_time IN (values)</code>
     */
    public List<com.sldd.persistence.tables.pojos.Transactions> fetchByDateTime(LocalDateTime... values) {
        return fetch(Transactions.TRANSACTIONS.DATE_TIME, values);
    }

    /**
     * Fetch records that have <code>from_account_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.sldd.persistence.tables.pojos.Transactions> fetchRangeOfFromAccountId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Transactions.TRANSACTIONS.FROM_ACCOUNT_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>from_account_id IN (values)</code>
     */
    public List<com.sldd.persistence.tables.pojos.Transactions> fetchByFromAccountId(Long... values) {
        return fetch(Transactions.TRANSACTIONS.FROM_ACCOUNT_ID, values);
    }

    /**
     * Fetch records that have <code>to_account_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.sldd.persistence.tables.pojos.Transactions> fetchRangeOfToAccountId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Transactions.TRANSACTIONS.TO_ACCOUNT_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>to_account_id IN (values)</code>
     */
    public List<com.sldd.persistence.tables.pojos.Transactions> fetchByToAccountId(Long... values) {
        return fetch(Transactions.TRANSACTIONS.TO_ACCOUNT_ID, values);
    }
}