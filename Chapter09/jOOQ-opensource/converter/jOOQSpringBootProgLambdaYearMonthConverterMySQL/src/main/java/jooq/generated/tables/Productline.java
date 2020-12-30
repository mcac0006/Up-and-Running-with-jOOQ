/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import jooq.generated.Classicmodels;
import jooq.generated.Indexes;
import jooq.generated.Keys;
import jooq.generated.tables.records.ProductlineRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.4",
        "schema version:1.1"
    },
    date = "2020-12-29T07:38:31.604Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Productline extends TableImpl<ProductlineRecord> {

    private static final long serialVersionUID = 76301983;

    /**
     * The reference instance of <code>classicmodels.productline</code>
     */
    public static final Productline PRODUCTLINE = new Productline();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ProductlineRecord> getRecordType() {
        return ProductlineRecord.class;
    }

    /**
     * The column <code>classicmodels.productline.product_line</code>.
     */
    public final TableField<ProductlineRecord, String> PRODUCT_LINE = createField(DSL.name("product_line"), org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>classicmodels.productline.code</code>.
     */
    public final TableField<ProductlineRecord, Long> CODE = createField(DSL.name("code"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>classicmodels.productline.text_description</code>.
     */
    public final TableField<ProductlineRecord, String> TEXT_DESCRIPTION = createField(DSL.name("text_description"), org.jooq.impl.SQLDataType.VARCHAR(4000), this, "");

    /**
     * The column <code>classicmodels.productline.html_description</code>.
     */
    public final TableField<ProductlineRecord, String> HTML_DESCRIPTION = createField(DSL.name("html_description"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>classicmodels.productline.image</code>.
     */
    public final TableField<ProductlineRecord, byte[]> IMAGE = createField(DSL.name("image"), org.jooq.impl.SQLDataType.BLOB, this, "");

    /**
     * The column <code>classicmodels.productline.created_on</code>.
     */
    public final TableField<ProductlineRecord, LocalDate> CREATED_ON = createField(DSL.name("created_on"), org.jooq.impl.SQLDataType.LOCALDATE.defaultValue(org.jooq.impl.DSL.inline("curdate()", org.jooq.impl.SQLDataType.LOCALDATE)), this, "");

    /**
     * Create a <code>classicmodels.productline</code> table reference
     */
    public Productline() {
        this(DSL.name("productline"), null);
    }

    /**
     * Create an aliased <code>classicmodels.productline</code> table reference
     */
    public Productline(String alias) {
        this(DSL.name(alias), PRODUCTLINE);
    }

    /**
     * Create an aliased <code>classicmodels.productline</code> table reference
     */
    public Productline(Name alias) {
        this(alias, PRODUCTLINE);
    }

    private Productline(Name alias, Table<ProductlineRecord> aliased) {
        this(alias, aliased, null);
    }

    private Productline(Name alias, Table<ProductlineRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Productline(Table<O> child, ForeignKey<O, ProductlineRecord> key) {
        super(child, key, PRODUCTLINE);
    }

    @Override
    public Schema getSchema() {
        return Classicmodels.CLASSICMODELS;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.PRODUCTLINE_UNIQUE_PRODUCT_LINE);
    }

    @Override
    public UniqueKey<ProductlineRecord> getPrimaryKey() {
        return Keys.KEY_PRODUCTLINE_PRIMARY;
    }

    @Override
    public List<UniqueKey<ProductlineRecord>> getKeys() {
        return Arrays.<UniqueKey<ProductlineRecord>>asList(Keys.KEY_PRODUCTLINE_PRIMARY, Keys.KEY_PRODUCTLINE_UNIQUE_PRODUCT_LINE);
    }

    @Override
    public Productline as(String alias) {
        return new Productline(DSL.name(alias), this);
    }

    @Override
    public Productline as(Name alias) {
        return new Productline(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Productline rename(String name) {
        return new Productline(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Productline rename(Name name) {
        return new Productline(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<String, Long, String, String, byte[], LocalDate> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}