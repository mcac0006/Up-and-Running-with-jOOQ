package com.classicmodels.repository;

import com.classicmodels.pojo.SimpleSale;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import static jooq.generated.Sequences.BANK_TRANSACTION_TRANSACTION_ID_SEQ;
import static jooq.generated.Sequences.SALE_SEQ;
import static jooq.generated.tables.Employee.EMPLOYEE;
import static jooq.generated.tables.Sale.SALE;
import jooq.generated.tables.records.BankTransactionRecord;
import jooq.generated.tables.records.SaleRecord;
import org.jooq.BatchBindStep;
import org.jooq.DSLContext;
import org.jooq.conf.Settings;
import org.jooq.conf.StatementType;
import static org.jooq.impl.DSL.val;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ClassicModelsRepository {

    private final DSLContext ctx;

    public ClassicModelsRepository(DSLContext ctx) {
        this.ctx = ctx;
    }

    public void batchInsertStatements() {

        // batch inserts in a table having auto-generated primary key (several queries)
        int[] result1 = ctx.batch(
                ctx.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                        .values(2005, 1370L, 1282.64),
                ctx.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                        .values(2004, 1370L, 3938.24),
                ctx.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                        .values(2004, 1370L, 4676.14),
                ctx.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                        .values(2003, 1166L, 2223.0),
                ctx.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                        .values(2004, 1166L, 4531.35),
                ctx.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                        .values(2004, 1166L, 6751.33)
        ).execute();

        System.out.println("EXAMPLE 1.1: " + Arrays.toString(result1));

        // batch inserts in a table having auto-generated primary key (several queries)
        int[] result2 = ctx.batch(
                ctx.insertInto(SALE, SALE.SALE_ID, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(SALE_SEQ.nextval(), val(2005), val(1370L), val(1282.64)),
                ctx.insertInto(SALE, SALE.SALE_ID, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(SALE_SEQ.nextval(), val(2004), val(1370L), val(3938.24)),
                ctx.insertInto(SALE, SALE.SALE_ID, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(SALE_SEQ.nextval(), val(2004), val(1370L), val(4676.14)),
                ctx.insertInto(SALE, SALE.SALE_ID, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(SALE_SEQ.nextval(), val(2003), val(1166L), val(2223.0)),
                ctx.insertInto(SALE, SALE.SALE_ID, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(SALE_SEQ.nextval(), val(2004), val(1166L), val(4531.35)),
                ctx.insertInto(SALE, SALE.SALE_ID, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(SALE_SEQ.nextval(), val(2004), val(1166L), val(6751.33))
        ).execute();

        System.out.println("EXAMPLE 1.2: " + Arrays.toString(result2));

        var ids = ctx.fetch(SALE_SEQ.nextvals(6)); // fetch 6 ids               
        int[] result3 = ctx.batch(
                ctx.insertInto(SALE, SALE.SALE_ID, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(ids.get(0).value1(), 2005, 1370L, 1282.64),
                ctx.insertInto(SALE, SALE.SALE_ID, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(ids.get(1).value1(), 2004, 1370L, 3938.24),
                ctx.insertInto(SALE, SALE.SALE_ID, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(ids.get(2).value1(), 2004, 1370L, 4676.14),
                ctx.insertInto(SALE, SALE.SALE_ID, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(ids.get(3).value1(), 2003, 1166L, 2223.0),
                ctx.insertInto(SALE, SALE.SALE_ID, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(ids.get(4).value1(), 2004, 1166L, 4531.35),
                ctx.insertInto(SALE, SALE.SALE_ID, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_).values(ids.get(5).value1(), 2004, 1166L, 6751.33)
        ).execute();

        System.out.println("EXAMPLE 1.3: " + Arrays.toString(result3));

        // batch inserts (single query) PreparedStatement
        int[] result41 = ctx.batch(
                ctx.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                        .values((Integer) null, null, null))
                .bind(2005, 1370L, 1282.64)
                .bind(2004, 1370L, 3938.24)
                .bind(2004, 1370L, 4676.14)
                .bind(2003, 1166L, 2223.0)
                .bind(2004, 1166L, 4531.35)
                .bind(2004, 1166L, 6751.33)
                .execute();

        System.out.println("EXAMPLE 1.4.1: " + Arrays.toString(result41));

        // batch inserts (single query) Statement - this is like EXAMPLE 1.1
        int[] result42 = ctx.configuration().derive(
                new Settings().withStatementType(StatementType.STATIC_STATEMENT))
                .dsl().batch(
                        ctx.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                                .values((Integer) null, null, null))
                .bind(2005, 1370L, 1282.64)
                .bind(2004, 1370L, 3938.24)
                .bind(2004, 1370L, 4676.14)
                .bind(2003, 1166L, 2223.0)
                .bind(2004, 1166L, 4531.35)
                .bind(2004, 1166L, 6751.33)
                .execute();

        System.out.println("EXAMPLE 1.4.2: " + Arrays.toString(result42));

        // batch inserts in a table having manually assigned primary key
        int[] result5 = ctx.batch(
                ctx.insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                        EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                        .values(10L, "Toga", "Alison", "x3332", "talison@classicmodelcars.com", "1", 110000, "VP Sales")
                        .onDuplicateKeyIgnore(),
                ctx.insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                        EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                        .values(11L, "Marius", "Pologa", "x5332", "mpologa@classicmodelcars.com", "3", 50000, "Sales Rep")
                        .onDuplicateKeyIgnore(),
                ctx.insertInto(EMPLOYEE, EMPLOYEE.EMPLOYEE_NUMBER, EMPLOYEE.LAST_NAME, EMPLOYEE.FIRST_NAME, EMPLOYEE.EXTENSION,
                        EMPLOYEE.EMAIL, EMPLOYEE.OFFICE_CODE, EMPLOYEE.SALARY, EMPLOYEE.JOB_TITLE)
                        .values(12L, "Ana", "Arica", "x5111", "aarica@classicmodelcars.com", "3", 50000, "Sales Rep")
                        .onDuplicateKeyIgnore()
        ).execute();

        System.out.println("EXAMPLE 1.5: " + Arrays.toString(result5));
    }

    public void batchInsertRecords1() {

        // get 10 ids
        var idsr = ctx.fetch(SALE_SEQ.nextvals(10));

        // Records batch inserts (single query, bind values)
        SaleRecord sr11 = new SaleRecord(idsr.get(0).value1(), 2005, 1223.23, 1370L, null, null, null, null);
        SaleRecord sr12 = new SaleRecord(idsr.get(1).value1(), 2004, 543.33, 1166L, null, null, null, null);
        SaleRecord sr13 = new SaleRecord(idsr.get(2).value1(), 2005, 9022.21, 1370L, null, null, null, null);
        SaleRecord sr14 = new SaleRecord(idsr.get(3).value1(), 2003, 4333.22, 1504L, null, null, null, null);
        SaleRecord sr15 = new SaleRecord(idsr.get(4).value1(), 2003, 8002.22, 1504L, null, null, null, null);

        List<SaleRecord> sales1 = List.of(sr15, sr12, sr13, sr14, sr11);

        // There is a single batch since the generated SQL with bind variables is the same for sr11-sr15.
        // The order of records is preserved.
        int[] result1 = ctx.batchInsert(sales1)
                // or, .batchInsert(sr15, sr12, sr13, sr14, sr11)
                .execute();

        System.out.println("EXAMPLE 2.1: " + Arrays.toString(result1));

        // Records batch inserts (multiple query, inlined values)
        // Order of records is always preserved entirely
        SaleRecord sr21 = new SaleRecord(idsr.get(5).value1(), 2005, 1223.23, 1370L, null, null, null, null);
        SaleRecord sr22 = new SaleRecord(idsr.get(6).value1(), 2004, 543.33, 1166L, null, null, null, null);
        SaleRecord sr23 = new SaleRecord(idsr.get(7).value1(), 2005, 9022.21, 1370L, null, null, null, null);
        SaleRecord sr24 = new SaleRecord(idsr.get(8).value1(), 2003, 4333.22, 1504L, null, null, null, null);
        SaleRecord sr25 = new SaleRecord(idsr.get(9).value1(), 2003, 8002.22, 1504L, null, null, null, null);

        List<SaleRecord> sales2 = List.of(sr25, sr22, sr23, sr24, sr21);

        int[] result2 = ctx.configuration().derive(
                new Settings().withStatementType(StatementType.STATIC_STATEMENT))
                .dsl().batchInsert(sales2)
                // or, .batchInsert(sr25, sr22, sr23, sr24, sr21)
                .execute();

        System.out.println("EXAMPLE 2.2: " + Arrays.toString(result2));
    }

    public void batchInsertRecords2() {

        // get 5 ids
        var idsr = ctx.fetch(SALE_SEQ.nextvals(5));
        var idbt = ctx.fetch(BANK_TRANSACTION_TRANSACTION_ID_SEQ.nextvals(2));

        SaleRecord sr1 = new SaleRecord(idsr.get(0).value1(), 2005, 1223.23, 1370L, null, null, null, null);
        SaleRecord sr2 = new SaleRecord(idsr.get(1).value1(), 2004, 543.33, 1166L, null, null, null, null);
        SaleRecord sr3 = new SaleRecord(idsr.get(2).value1(), 2005, 9022.21, null, null, null, null, null);
        BankTransactionRecord bt1 = new BankTransactionRecord(
                idbt.get(0).value1(), "", "", BigDecimal.ZERO, LocalDateTime.now(), 114L, "NP603840", "");
        SaleRecord sr4 = new SaleRecord(idsr.get(3).value1(), 2003, 4333.22, 1504L, null, null, null, null);
        SaleRecord sr5 = new SaleRecord(idsr.get(4).value1(), 2003, 8002.22, 1504L, null, null, null, "UP");
        BankTransactionRecord bt2 = new BankTransactionRecord(
                idbt.get(1).value1(), "", "", BigDecimal.ZERO, LocalDateTime.now(), 114L, "NP603840", "");

        // There are two batches, one for SaleRecord and one for BankTransactionRecord.
        // The order of records is not preserved (check the log).
        int[] result = ctx.batchInsert(bt1, sr1, sr2, sr3, sr4, sr5, bt2)
                .execute();

        System.out.println("EXAMPLE 3: " + Arrays.toString(result));
    }

    public void batchInsertRecords3() {

        SaleRecord sr1 = new SaleRecord();
        sr1.setFiscalYear(2005);
        sr1.setSale(1223.23);
        sr1.setEmployeeNumber(1370L);
        sr1.setTrend("UP");

        SaleRecord sr2 = new SaleRecord();
        sr2.setFiscalYear(2005);
        sr2.setSale(9022.21);

        SaleRecord sr3 = new SaleRecord();
        sr3.setFiscalYear(2003);
        sr3.setSale(8002.22);
        sr3.setEmployeeNumber(1504L);

        // There are three batches, one for each SaleRecord because the generated SQL with bind variables is not the same.
        // The order of records is preserved.
        int[] result = ctx.batchInsert(sr3, sr2, sr1)
                .execute();

        System.out.println("EXAMPLE 4: " + Arrays.toString(result));
    }

    // batch collection of Objects
    public void batchInsertCollectionOfObjects() {

        List<SimpleSale> sales = List.of(
                new SimpleSale(2005, 1370L, 1282.64),
                new SimpleSale(2004, 1370L, 3938.24),
                new SimpleSale(2004, 1370L, 4676.14)
        );

        BatchBindStep batch = ctx.batch(
                ctx.insertInto(SALE, SALE.FISCAL_YEAR, SALE.EMPLOYEE_NUMBER, SALE.SALE_)
                        .values((Integer) null, null, null)
        );

        sales.forEach(s -> batch.bind(s.getFiscalYear(), s.getEmployeeNumber(), s.getSale()));
        batch.execute();
    }

    public void forceNumberOfBatches() {

        // by default the generated INSERT has 3 placeholders
        // insert into `classicmodels`.`sale` (`fiscal_year`, `sale`, `trend`) values (?, ?, ?)
        SaleRecord sr1 = new SaleRecord();
        sr1.setSaleId(pk());
        sr1.setFiscalYear(2003);
        sr1.setTrend("UP");
        sr1.setSale(34493.22);

        // by default the generated INSERT has 4 placeholders
        // insert into `classicmodels`.`sale` (`fiscal_year`, `sale`, `employee_number`, `hot`) values (?, ?, ?, ?)
        SaleRecord sr2 = new SaleRecord();
        sr2.setSaleId(pk());
        sr2.setEmployeeNumber(1370L);
        sr2.setSale(4522.34);
        sr2.setFiscalYear(2005);
        sr2.setHot(true);

        // in this context, there will be 2 batches, but we can force a single batch if
        // we force a insert having the same string, and for this we can
        // enforce all INSERT statements to be the same by 
        // seting all changed flags of each individual record to true
        sr1.changed(true);
        sr2.changed(true);

        // a single batch is executed having this INSERT
        // insert into `classicmodels`.`sale` (`sale_id`, `fiscal_year`, `sale`, `employee_number`, `hot`, `rate`, `vat`, `trend`) values (?, ?, ?, ?, ?, ?, ?, ?)
        ctx.batchInsert(sr1, sr2).execute();
    }

    private long pk() {

        return (long) (Math.random() * 99999999);
    }
}
