/*
 * This file is generated by jOOQ.
 */
package jooq.generated.enums;


import javax.annotation.processing.Generated;

import jooq.generated.Public;

import org.jooq.Catalog;
import org.jooq.EnumType;
import org.jooq.Schema;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.4",
        "schema version:1.1"
    },
    date = "2020-12-28T06:34:31.202Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public enum VatType implements EnumType {

    NONE("NONE"),

    MIN("MIN"),

    MAX("MAX");

    private final String literal;

    private VatType(String literal) {
        this.literal = literal;
    }

    @Override
    public Catalog getCatalog() {
        return getSchema() == null ? null : getSchema().getCatalog();
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public String getName() {
        return "vat_type";
    }

    @Override
    public String getLiteral() {
        return literal;
    }
}