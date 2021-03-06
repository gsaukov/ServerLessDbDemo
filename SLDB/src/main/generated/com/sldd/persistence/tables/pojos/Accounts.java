/*
 * This file is generated by jOOQ.
 */
package com.sldd.persistence.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;


/**
 * The table <code>public.accounts</code>.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Accounts implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long       id;
    private final Long       accountNumber;
    private final BigDecimal amount;
    private final LocalDate  openingDate;
    private final LocalDate  validityPeriod;

    public Accounts(Accounts value) {
        this.id = value.id;
        this.accountNumber = value.accountNumber;
        this.amount = value.amount;
        this.openingDate = value.openingDate;
        this.validityPeriod = value.validityPeriod;
    }

    public Accounts(
        Long       id,
        Long       accountNumber,
        BigDecimal amount,
        LocalDate  openingDate,
        LocalDate  validityPeriod
    ) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.openingDate = openingDate;
        this.validityPeriod = validityPeriod;
    }

    /**
     * Getter for <code>public.accounts.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Getter for <code>public.accounts.account_number</code>.
     */
    public Long getAccountNumber() {
        return this.accountNumber;
    }

    /**
     * Getter for <code>public.accounts.amount</code>.
     */
    public BigDecimal getAmount() {
        return this.amount;
    }

    /**
     * Getter for <code>public.accounts.opening_date</code>.
     */
    public LocalDate getOpeningDate() {
        return this.openingDate;
    }

    /**
     * Getter for <code>public.accounts.validity_period</code>.
     */
    public LocalDate getValidityPeriod() {
        return this.validityPeriod;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Accounts other = (Accounts) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        }
        else if (!id.equals(other.id))
            return false;
        if (accountNumber == null) {
            if (other.accountNumber != null)
                return false;
        }
        else if (!accountNumber.equals(other.accountNumber))
            return false;
        if (amount == null) {
            if (other.amount != null)
                return false;
        }
        else if (!amount.equals(other.amount))
            return false;
        if (openingDate == null) {
            if (other.openingDate != null)
                return false;
        }
        else if (!openingDate.equals(other.openingDate))
            return false;
        if (validityPeriod == null) {
            if (other.validityPeriod != null)
                return false;
        }
        else if (!validityPeriod.equals(other.validityPeriod))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.accountNumber == null) ? 0 : this.accountNumber.hashCode());
        result = prime * result + ((this.amount == null) ? 0 : this.amount.hashCode());
        result = prime * result + ((this.openingDate == null) ? 0 : this.openingDate.hashCode());
        result = prime * result + ((this.validityPeriod == null) ? 0 : this.validityPeriod.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Accounts (");

        sb.append(id);
        sb.append(", ").append(accountNumber);
        sb.append(", ").append(amount);
        sb.append(", ").append(openingDate);
        sb.append(", ").append(validityPeriod);

        sb.append(")");
        return sb.toString();
    }
}
