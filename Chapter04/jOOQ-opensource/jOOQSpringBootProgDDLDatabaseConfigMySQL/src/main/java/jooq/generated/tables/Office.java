/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables;


import java.util.Arrays;
import java.util.List;

import jooq.generated.DefaultSchema;
import jooq.generated.Keys;
import jooq.generated.tables.records.OfficeRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row9;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Office extends TableImpl<OfficeRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>office</code>
     */
    public static final Office OFFICE = new Office();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OfficeRecord> getRecordType() {
        return OfficeRecord.class;
    }

    /**
     * The column <code>office.office_code</code>.
     */
    public final TableField<OfficeRecord, String> OFFICE_CODE = createField(DSL.name("office_code"), SQLDataType.VARCHAR(10).nullable(false), this, "");

    /**
     * The column <code>office.city</code>.
     */
    public final TableField<OfficeRecord, String> CITY = createField(DSL.name("city"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>office.phone</code>.
     */
    public final TableField<OfficeRecord, String> PHONE = createField(DSL.name("phone"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>office.address_line_first</code>.
     */
    public final TableField<OfficeRecord, String> ADDRESS_LINE_FIRST = createField(DSL.name("address_line_first"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>office.address_line_second</code>.
     */
    public final TableField<OfficeRecord, String> ADDRESS_LINE_SECOND = createField(DSL.name("address_line_second"), SQLDataType.VARCHAR(50).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>office.state</code>.
     */
    public final TableField<OfficeRecord, String> STATE = createField(DSL.name("state"), SQLDataType.VARCHAR(50).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>office.country</code>.
     */
    public final TableField<OfficeRecord, String> COUNTRY = createField(DSL.name("country"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>office.postal_code</code>.
     */
    public final TableField<OfficeRecord, String> POSTAL_CODE = createField(DSL.name("postal_code"), SQLDataType.VARCHAR(15).nullable(false), this, "");

    /**
     * The column <code>office.territory</code>.
     */
    public final TableField<OfficeRecord, String> TERRITORY = createField(DSL.name("territory"), SQLDataType.VARCHAR(10).nullable(false), this, "");

    private Office(Name alias, Table<OfficeRecord> aliased) {
        this(alias, aliased, null);
    }

    private Office(Name alias, Table<OfficeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>office</code> table reference
     */
    public Office(String alias) {
        this(DSL.name(alias), OFFICE);
    }

    /**
     * Create an aliased <code>office</code> table reference
     */
    public Office(Name alias) {
        this(alias, OFFICE);
    }

    /**
     * Create a <code>office</code> table reference
     */
    public Office() {
        this(DSL.name("office"), null);
    }

    public <O extends Record> Office(Table<O> child, ForeignKey<O, OfficeRecord> key) {
        super(child, key, OFFICE);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<OfficeRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_C;
    }

    @Override
    public List<UniqueKey<OfficeRecord>> getKeys() {
        return Arrays.<UniqueKey<OfficeRecord>>asList(Keys.CONSTRAINT_C);
    }

    @Override
    public Office as(String alias) {
        return new Office(DSL.name(alias), this);
    }

    @Override
    public Office as(Name alias) {
        return new Office(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Office rename(String name) {
        return new Office(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Office rename(Name name) {
        return new Office(name, null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<String, String, String, String, String, String, String, String, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }
}