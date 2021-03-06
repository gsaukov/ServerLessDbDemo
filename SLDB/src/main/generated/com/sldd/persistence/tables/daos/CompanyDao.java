/*
 * This file is generated by jOOQ.
 */
package com.sldd.persistence.tables.daos;


import com.sldd.persistence.tables.Company;
import com.sldd.persistence.tables.records.CompanyRecord;

import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * The table <code>public.company</code>.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CompanyDao extends DAOImpl<CompanyRecord, com.sldd.persistence.tables.pojos.Company, Long> {

    /**
     * Create a new CompanyDao without any configuration
     */
    public CompanyDao() {
        super(Company.COMPANY, com.sldd.persistence.tables.pojos.Company.class);
    }

    /**
     * Create a new CompanyDao with an attached configuration
     */
    public CompanyDao(Configuration configuration) {
        super(Company.COMPANY, com.sldd.persistence.tables.pojos.Company.class, configuration);
    }

    @Override
    public Long getId(com.sldd.persistence.tables.pojos.Company object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.sldd.persistence.tables.pojos.Company> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Company.COMPANY.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.sldd.persistence.tables.pojos.Company> fetchById(Long... values) {
        return fetch(Company.COMPANY.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.sldd.persistence.tables.pojos.Company fetchOneById(Long value) {
        return fetchOne(Company.COMPANY.ID, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.sldd.persistence.tables.pojos.Company> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Company.COMPANY.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<com.sldd.persistence.tables.pojos.Company> fetchByName(String... values) {
        return fetch(Company.COMPANY.NAME, values);
    }

    /**
     * Fetch records that have <code>address BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.sldd.persistence.tables.pojos.Company> fetchRangeOfAddress(String lowerInclusive, String upperInclusive) {
        return fetchRange(Company.COMPANY.ADDRESS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>address IN (values)</code>
     */
    public List<com.sldd.persistence.tables.pojos.Company> fetchByAddress(String... values) {
        return fetch(Company.COMPANY.ADDRESS, values);
    }

    /**
     * Fetch records that have <code>phone BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.sldd.persistence.tables.pojos.Company> fetchRangeOfPhone(String lowerInclusive, String upperInclusive) {
        return fetchRange(Company.COMPANY.PHONE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>phone IN (values)</code>
     */
    public List<com.sldd.persistence.tables.pojos.Company> fetchByPhone(String... values) {
        return fetch(Company.COMPANY.PHONE, values);
    }

    /**
     * Fetch records that have <code>discount BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.sldd.persistence.tables.pojos.Company> fetchRangeOfDiscount(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Company.COMPANY.DISCOUNT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>discount IN (values)</code>
     */
    public List<com.sldd.persistence.tables.pojos.Company> fetchByDiscount(Integer... values) {
        return fetch(Company.COMPANY.DISCOUNT, values);
    }

    /**
     * Fetch records that have <code>info BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.sldd.persistence.tables.pojos.Company> fetchRangeOfInfo(String lowerInclusive, String upperInclusive) {
        return fetchRange(Company.COMPANY.INFO, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>info IN (values)</code>
     */
    public List<com.sldd.persistence.tables.pojos.Company> fetchByInfo(String... values) {
        return fetch(Company.COMPANY.INFO, values);
    }

    /**
     * Fetch records that have <code>producer_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.sldd.persistence.tables.pojos.Company> fetchRangeOfProducerId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Company.COMPANY.PRODUCER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>producer_id IN (values)</code>
     */
    public List<com.sldd.persistence.tables.pojos.Company> fetchByProducerId(Long... values) {
        return fetch(Company.COMPANY.PRODUCER_ID, values);
    }
}
