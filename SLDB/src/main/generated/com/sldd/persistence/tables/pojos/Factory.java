/*
 * This file is generated by jOOQ.
 */
package com.sldd.persistence.tables.pojos;


import java.io.Serializable;


/**
 * The table <code>public.factory</code>.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Factory implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long   id;
    private final String name;
    private final String address;
    private final String phone;
    private final String position;
    private final String industry;
    private final Long   producerId;

    public Factory(Factory value) {
        this.id = value.id;
        this.name = value.name;
        this.address = value.address;
        this.phone = value.phone;
        this.position = value.position;
        this.industry = value.industry;
        this.producerId = value.producerId;
    }

    public Factory(
        Long   id,
        String name,
        String address,
        String phone,
        String position,
        String industry,
        Long   producerId
    ) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.position = position;
        this.industry = industry;
        this.producerId = producerId;
    }

    /**
     * Getter for <code>public.factory.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Getter for <code>public.factory.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for <code>public.factory.address</code>.
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Getter for <code>public.factory.phone</code>.
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Getter for <code>public.factory.position</code>.
     */
    public String getPosition() {
        return this.position;
    }

    /**
     * Getter for <code>public.factory.industry</code>.
     */
    public String getIndustry() {
        return this.industry;
    }

    /**
     * Getter for <code>public.factory.producer_id</code>.
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
        final Factory other = (Factory) obj;
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
        if (position == null) {
            if (other.position != null)
                return false;
        }
        else if (!position.equals(other.position))
            return false;
        if (industry == null) {
            if (other.industry != null)
                return false;
        }
        else if (!industry.equals(other.industry))
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
        result = prime * result + ((this.position == null) ? 0 : this.position.hashCode());
        result = prime * result + ((this.industry == null) ? 0 : this.industry.hashCode());
        result = prime * result + ((this.producerId == null) ? 0 : this.producerId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Factory (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(address);
        sb.append(", ").append(phone);
        sb.append(", ").append(position);
        sb.append(", ").append(industry);
        sb.append(", ").append(producerId);

        sb.append(")");
        return sb.toString();
    }
}
