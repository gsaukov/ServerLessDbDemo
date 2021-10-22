/*
 * This file is generated by jOOQ.
 */
package com.sldd.persistence.tables.pojos;


import java.io.Serializable;


/**
 * The table <code>public.users</code>.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long   id;
    private final String email;
    private final String phone;
    private final String fullName;
    private final Long   accountId;

    public Users(Users value) {
        this.id = value.id;
        this.email = value.email;
        this.phone = value.phone;
        this.fullName = value.fullName;
        this.accountId = value.accountId;
    }

    public Users(
        Long   id,
        String email,
        String phone,
        String fullName,
        Long   accountId
    ) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.fullName = fullName;
        this.accountId = accountId;
    }

    /**
     * Getter for <code>public.users.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Getter for <code>public.users.email</code>.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Getter for <code>public.users.phone</code>.
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Getter for <code>public.users.full_name</code>.
     */
    public String getFullName() {
        return this.fullName;
    }

    /**
     * Getter for <code>public.users.account_id</code>.
     */
    public Long getAccountId() {
        return this.accountId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Users other = (Users) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        }
        else if (!id.equals(other.id))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        }
        else if (!email.equals(other.email))
            return false;
        if (phone == null) {
            if (other.phone != null)
                return false;
        }
        else if (!phone.equals(other.phone))
            return false;
        if (fullName == null) {
            if (other.fullName != null)
                return false;
        }
        else if (!fullName.equals(other.fullName))
            return false;
        if (accountId == null) {
            if (other.accountId != null)
                return false;
        }
        else if (!accountId.equals(other.accountId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
        result = prime * result + ((this.phone == null) ? 0 : this.phone.hashCode());
        result = prime * result + ((this.fullName == null) ? 0 : this.fullName.hashCode());
        result = prime * result + ((this.accountId == null) ? 0 : this.accountId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Users (");

        sb.append(id);
        sb.append(", ").append(email);
        sb.append(", ").append(phone);
        sb.append(", ").append(fullName);
        sb.append(", ").append(accountId);

        sb.append(")");
        return sb.toString();
    }
}
