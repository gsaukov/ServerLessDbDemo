/*
 * This file is generated by jOOQ.
 */
package com.sldd.persistence;


import com.sldd.persistence.tables.AuthInfoEntity;
import com.sldd.persistence.tables.CompanyDescription;
import com.sldd.persistence.tables.FactoryDescription;
import com.sldd.persistence.tables.Orders;
import com.sldd.persistence.tables.OrdersProductDetails;
import com.sldd.persistence.tables.Product;
import com.sldd.persistence.tables.ProductDetails;
import com.sldd.persistence.tables.RelationType;
import com.sldd.persistence.tables.Role;
import com.sldd.persistence.tables.UserDescription;
import com.sldd.persistence.tables.Users;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * The schema <code>public</code>.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.auth_info_entity</code>.
     */
    public final AuthInfoEntity AUTH_INFO_ENTITY = AuthInfoEntity.AUTH_INFO_ENTITY;

    /**
     * The table <code>public.company_description</code>.
     */
    public final CompanyDescription COMPANY_DESCRIPTION = CompanyDescription.COMPANY_DESCRIPTION;

    /**
     * The table <code>public.factory_description</code>.
     */
    public final FactoryDescription FACTORY_DESCRIPTION = FactoryDescription.FACTORY_DESCRIPTION;

    /**
     * The table <code>public.orders</code>.
     */
    public final Orders ORDERS = Orders.ORDERS;

    /**
     * The table <code>public.orders_product_details</code>.
     */
    public final OrdersProductDetails ORDERS_PRODUCT_DETAILS = OrdersProductDetails.ORDERS_PRODUCT_DETAILS;

    /**
     * The table <code>public.product</code>.
     */
    public final Product PRODUCT = Product.PRODUCT;

    /**
     * The table <code>public.product_details</code>.
     */
    public final ProductDetails PRODUCT_DETAILS = ProductDetails.PRODUCT_DETAILS;

    /**
     * The table <code>public.relation_type</code>.
     */
    public final RelationType RELATION_TYPE = RelationType.RELATION_TYPE;

    /**
     * The table <code>public.role</code>.
     */
    public final Role ROLE = Role.ROLE;

    /**
     * The table <code>public.user_description</code>.
     */
    public final UserDescription USER_DESCRIPTION = UserDescription.USER_DESCRIPTION;

    /**
     * The table <code>public.users</code>.
     */
    public final Users USERS = Users.USERS;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            AuthInfoEntity.AUTH_INFO_ENTITY,
            CompanyDescription.COMPANY_DESCRIPTION,
            FactoryDescription.FACTORY_DESCRIPTION,
            Orders.ORDERS,
            OrdersProductDetails.ORDERS_PRODUCT_DETAILS,
            Product.PRODUCT,
            ProductDetails.PRODUCT_DETAILS,
            RelationType.RELATION_TYPE,
            Role.ROLE,
            UserDescription.USER_DESCRIPTION,
            Users.USERS
        );
    }
}
