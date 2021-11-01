/*
 * This file is generated by jOOQ.
 */
package com.sldd.persistence.tables.pojos;


import java.io.Serializable;


/**
 * The table <code>public.company</code>.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long    id;
    private final String  name;
    private final String  address;
    private final String  phone;
    private final Integer discount;
    private final String  info;
    private final Long    producerId;

    public Company(Company value) {
        this.id = value.id;
        this.name = value.name;
        this.address = value.address;
        this.phone = value.phone;
        this.discount = value.discount;
        this.info = value.info;
        this.producerId = value.producerId;
    }

    public Company(
        Long    id,
        String  name,
        String  address,
        String  phone,
        Integer discount,
        String  info,
        Long    producerId
    ) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.discount = discount;
        this.info = info;
        this.producerId = producerId;
    }

    /**
     * Getter for <code>public.company.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Getter for <code>public.company.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for <code>public.company.address</code>.
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Getter for <code>public.company.phone</code>.
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Getter for <code>public.company.discount</code>.
     */
    public Integer getDiscount() {
        return this.discount;
    }

    /**
     * Getter for <code>public.company.info</code>.
     */
    public String getInfo() {
        return this.info;
    }

    /**
     * Getter for <code>public.company.producer_id</code>.
     */
    public Long getProducerId() {
        return this.producerId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Company other = (Company) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        }
        else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        }
        else if (!name.equals(other.name))
            return false;
        if (address == null) {
            if (other.address != null)
                return false;
        }
        else if (!address.equals(other.address))
            return false;
        if (phone == null) {
            if (other.phone != null)
                return false;
        }
        else if (!phone.equals(other.phone))
            return false;
        if (discount == null) {
            if (other.discount != null)
                return false;
        }
        else if (!discount.equals(other.discount))
            return false;
        if (info == null) {
            if (other.info != null)
                return false;
        }
        else if (!info.equals(other.info))
            return false;
        if (producerId == null) {
            if (other.producerId != null)
                return false;
        }
        else if (!producerId.equals(other.producerId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.address == null) ? 0 : this.address.hashCode());
        result = prime * result + ((this.phone == null) ? 0 : this.phone.hashCode());
        result = prime * result + ((this.discount == null) ? 0 : this.discount.hashCode());
        result = prime * result + ((this.info == null) ? 0 : this.info.hashCode());
        result = prime * result + ((this.producerId == null) ? 0 : this.producerId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Company (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(address);
        sb.append(", ").append(phone);
        sb.append(", ").append(discount);
        sb.append(", ").append(info);
        sb.append(", ").append(producerId);

        sb.append(")");
        return sb.toString();
    }
}
