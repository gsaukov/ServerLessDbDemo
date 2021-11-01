/*
 * This file is generated by jOOQ.
 */
package com.sldd.persistence.tables.daos;


import com.sldd.persistence.tables.Orders;
import com.sldd.persistence.tables.records.OrdersRecord;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * The table <code>public.orders</code>.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OrdersDao extends DAOImpl<OrdersRecord, com.sldd.persistence.tables.pojos.Orders, Long> {

    /**
     * Create a new OrdersDao without any configuration
     */
    public OrdersDao() {
        super(Orders.ORDERS, com.sldd.persistence.tables.pojos.Orders.class);
    }

    /**
     * Create a new OrdersDao with an attached configuration
     */
    public OrdersDao(Configuration configuration) {
        super(Orders.ORDERS, com.sldd.persistence.tables.pojos.Orders.class, configuration);
    }

    @Override
    public Long getId(com.sldd.persistence.tables.pojos.Orders object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.sldd.persistence.tables.pojos.Orders> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Orders.ORDERS.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.sldd.persistence.tables.pojos.Orders> fetchById(Long... values) {
        return fetch(Orders.ORDERS.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.sldd.persistence.tables.pojos.Orders fetchOneById(Long value) {
        return fetchOne(Orders.ORDERS.ID, value);
    }

    /**
     * Fetch records that have <code>transaction_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.sldd.persistence.tables.pojos.Orders> fetchRangeOfTransactionId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Orders.ORDERS.TRANSACTION_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>transaction_id IN (values)</code>
     */
    public List<com.sldd.persistence.tables.pojos.Orders> fetchByTransactionId(Long... values) {
        return fetch(Orders.ORDERS.TRANSACTION_ID, values);
    }

    /**
     * Fetch records that have <code>total_cost BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.sldd.persistence.tables.pojos.Orders> fetchRangeOfTotalCost(BigDecimal lowerInclusive, BigDecimal upperInclusive) {
        return fetchRange(Orders.ORDERS.TOTAL_COST, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>total_cost IN (values)</code>
     */
    public List<com.sldd.persistence.tables.pojos.Orders> fetchByTotalCost(BigDecimal... values) {
        return fetch(Orders.ORDERS.TOTAL_COST, values);
    }

    /**
     * Fetch records that have <code>end_date BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.sldd.persistence.tables.pojos.Orders> fetchRangeOfEndDate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(Orders.ORDERS.END_DATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>end_date IN (values)</code>
     */
    public List<com.sldd.persistence.tables.pojos.Orders> fetchByEndDate(LocalDateTime... values) {
        return fetch(Orders.ORDERS.END_DATE, values);
    }

    /**
     * Fetch records that have <code>start_date BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.sldd.persistence.tables.pojos.Orders> fetchRangeOfStartDate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(Orders.ORDERS.START_DATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>start_date IN (values)</code>
     */
    public List<com.sldd.persistence.tables.pojos.Orders> fetchByStartDate(LocalDateTime... values) {
        return fetch(Orders.ORDERS.START_DATE, values);
    }

    /**
     * Fetch records that have <code>status BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.sldd.persistence.tables.pojos.Orders> fetchRangeOfStatus(String lowerInclusive, String upperInclusive) {
        return fetchRange(Orders.ORDERS.STATUS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>status IN (values)</code>
     */
    public List<com.sldd.persistence.tables.pojos.Orders> fetchByStatus(String... values) {
        return fetch(Orders.ORDERS.STATUS, values);
    }

    /**
     * Fetch records that have <code>user_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.sldd.persistence.tables.pojos.Orders> fetchRangeOfUserId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Orders.ORDERS.USER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>user_id IN (values)</code>
     */
    public List<com.sldd.persistence.tables.pojos.Orders> fetchByUserId(Long... values) {
        return fetch(Orders.ORDERS.USER_ID, values);
    }
}