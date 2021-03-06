/*
 * This file is generated by jOOQ.
 */
package com.sldd.persistence.tables.daos;


import com.sldd.persistence.tables.AuthInfoEntity;
import com.sldd.persistence.tables.records.AuthInfoEntityRecord;

import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * The table <code>public.auth_info_entity</code>.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AuthInfoEntityDao extends DAOImpl<AuthInfoEntityRecord, com.sldd.persistence.tables.pojos.AuthInfoEntity, Long> {

    /**
     * Create a new AuthInfoEntityDao without any configuration
     */
    public AuthInfoEntityDao() {
        super(AuthInfoEntity.AUTH_INFO_ENTITY, com.sldd.persistence.tables.pojos.AuthInfoEntity.class);
    }

    /**
     * Create a new AuthInfoEntityDao with an attached configuration
     */
    public AuthInfoEntityDao(Configuration configuration) {
        super(AuthInfoEntity.AUTH_INFO_ENTITY, com.sldd.persistence.tables.pojos.AuthInfoEntity.class, configuration);
    }

    @Override
    public Long getId(com.sldd.persistence.tables.pojos.AuthInfoEntity object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.sldd.persistence.tables.pojos.AuthInfoEntity> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(AuthInfoEntity.AUTH_INFO_ENTITY.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.sldd.persistence.tables.pojos.AuthInfoEntity> fetchById(Long... values) {
        return fetch(AuthInfoEntity.AUTH_INFO_ENTITY.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.sldd.persistence.tables.pojos.AuthInfoEntity fetchOneById(Long value) {
        return fetchOne(AuthInfoEntity.AUTH_INFO_ENTITY.ID, value);
    }

    /**
     * Fetch records that have <code>login BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.sldd.persistence.tables.pojos.AuthInfoEntity> fetchRangeOfLogin(String lowerInclusive, String upperInclusive) {
        return fetchRange(AuthInfoEntity.AUTH_INFO_ENTITY.LOGIN, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>login IN (values)</code>
     */
    public List<com.sldd.persistence.tables.pojos.AuthInfoEntity> fetchByLogin(String... values) {
        return fetch(AuthInfoEntity.AUTH_INFO_ENTITY.LOGIN, values);
    }

    /**
     * Fetch records that have <code>password BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.sldd.persistence.tables.pojos.AuthInfoEntity> fetchRangeOfPassword(String lowerInclusive, String upperInclusive) {
        return fetchRange(AuthInfoEntity.AUTH_INFO_ENTITY.PASSWORD, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>password IN (values)</code>
     */
    public List<com.sldd.persistence.tables.pojos.AuthInfoEntity> fetchByPassword(String... values) {
        return fetch(AuthInfoEntity.AUTH_INFO_ENTITY.PASSWORD, values);
    }

    /**
     * Fetch records that have <code>user_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.sldd.persistence.tables.pojos.AuthInfoEntity> fetchRangeOfUserId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(AuthInfoEntity.AUTH_INFO_ENTITY.USER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>user_id IN (values)</code>
     */
    public List<com.sldd.persistence.tables.pojos.AuthInfoEntity> fetchByUserId(Long... values) {
        return fetch(AuthInfoEntity.AUTH_INFO_ENTITY.USER_ID, values);
    }
}
