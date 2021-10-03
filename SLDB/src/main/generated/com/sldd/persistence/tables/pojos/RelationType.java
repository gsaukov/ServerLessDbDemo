/*
 * This file is generated by jOOQ.
 */
package com.sldd.persistence.tables.pojos;


import java.io.Serializable;


/**
 * The table <code>public.relation_type</code>.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RelationType implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long id;
    private final Long companyDescriptionId;
    private final Long factoryDescriptionId;

    public RelationType(RelationType value) {
        this.id = value.id;
        this.companyDescriptionId = value.companyDescriptionId;
        this.factoryDescriptionId = value.factoryDescriptionId;
    }

    public RelationType(
        Long id,
        Long companyDescriptionId,
        Long factoryDescriptionId
    ) {
        this.id = id;
        this.companyDescriptionId = companyDescriptionId;
        this.factoryDescriptionId = factoryDescriptionId;
    }

    /**
     * Getter for <code>public.relation_type.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Getter for <code>public.relation_type.company_description_id</code>.
     */
    public Long getCompanyDescriptionId() {
        return this.companyDescriptionId;
    }

    /**
     * Getter for <code>public.relation_type.factory_description_id</code>.
     */
    public Long getFactoryDescriptionId() {
        return this.factoryDescriptionId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final RelationType other = (RelationType) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        }
        else if (!id.equals(other.id))
            return false;
        if (companyDescriptionId == null) {
            if (other.companyDescriptionId != null)
                return false;
        }
        else if (!companyDescriptionId.equals(other.companyDescriptionId))
            return false;
        if (factoryDescriptionId == null) {
            if (other.factoryDescriptionId != null)
                return false;
        }
        else if (!factoryDescriptionId.equals(other.factoryDescriptionId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.companyDescriptionId == null) ? 0 : this.companyDescriptionId.hashCode());
        result = prime * result + ((this.factoryDescriptionId == null) ? 0 : this.factoryDescriptionId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("RelationType (");

        sb.append(id);
        sb.append(", ").append(companyDescriptionId);
        sb.append(", ").append(factoryDescriptionId);

        sb.append(")");
        return sb.toString();
    }
}