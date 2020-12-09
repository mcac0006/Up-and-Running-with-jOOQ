package com.classicmodels.repository;

import static jooq.generated.tables.Customerdetail.CUSTOMERDETAIL;
import static jooq.generated.tables.Employee.EMPLOYEE;
import static jooq.generated.tables.Office.OFFICE;
import static jooq.generated.tables.Sale.SALE;
import org.jooq.DSLContext;
import static org.jooq.impl.DSL.select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class ClassicModelsRepository {

    private final DSLContext ctx;

    public ClassicModelsRepository(DSLContext ctx) {
        this.ctx = ctx;
    }

    // EXAMPLE 1 - typical INNER JOIN
    public void fetchEmployeeNameOfficeCityInnerJoin() {

        System.out.println("EXAMPLE 1 (INNER JOIN)\n"
                + ctx.select(EMPLOYEE.FIRST_NAME, EMPLOYEE.LAST_NAME, OFFICE.CITY)
                        .from(EMPLOYEE)
                        .innerJoin(OFFICE)
                        .on(EMPLOYEE.OFFICE_CODE.eq(OFFICE.OFFICE_CODE))
                        .fetch()
        );
    }

    // EXAMPLE 2 - typical LEFT OUTER JOIN
    public void fetchEmployeeNameSaleLeftOuterJoin() {

        System.out.println("EXAMPLE 2 (LEFT OUTER JOIN)\n"
                + ctx.select(EMPLOYEE.FIRST_NAME, EMPLOYEE.LAST_NAME, SALE.SALE_)
                        .from(EMPLOYEE)
                        .leftOuterJoin(SALE)
                        .on(EMPLOYEE.EMPLOYEE_NUMBER.eq(SALE.EMPLOYEE_NUMBER))
                        .fetch()
        );
    }

    // EXAMPLE 3 - typical LEFT OUTER JOIN (EXCLUSIVE)
    public void fetchEmployeeNameSaleLeftOuterJoinExclusive() {

        System.out.println("EXAMPLE 3 (LEFT OUTER JOIN (EXCLUSIVE))\n"
                + ctx.select(EMPLOYEE.FIRST_NAME, EMPLOYEE.LAST_NAME, SALE.SALE_)
                        .from(EMPLOYEE)
                        .leftOuterJoin(SALE)
                        .on(EMPLOYEE.EMPLOYEE_NUMBER.eq(SALE.EMPLOYEE_NUMBER))
                        .where(SALE.EMPLOYEE_NUMBER.isNull())
                        .fetch()
        );
    }

    // EXAMPLE 4 - typical RIGHT OUTER JOIN
    public void fetchEmployeeNameSaleRightOuterJoin() {

        System.out.println("EXAMPLE 4 (RIGHT OUTER JOIN)\n"
                + ctx.select(EMPLOYEE.FIRST_NAME, EMPLOYEE.LAST_NAME, SALE.SALE_)
                        .from(EMPLOYEE)
                        .rightOuterJoin(SALE)
                        .on(EMPLOYEE.EMPLOYEE_NUMBER.eq(SALE.EMPLOYEE_NUMBER))
                        .fetch()
        );
    }

    // EXAMPLE 5 - typical RIGHT OUTER JOIN (EXCLUSIVE)
    public void fetchEmployeeNameSaleRightOuterJoinExclusive() {

        System.out.println("EXAMPLE 5 (RIGHT OUTER JOIN (EXCLUSIVE))\n"
                + ctx.select(EMPLOYEE.FIRST_NAME, EMPLOYEE.LAST_NAME, SALE.SALE_)
                        .from(EMPLOYEE)
                        .rightOuterJoin(SALE)
                        .on(EMPLOYEE.EMPLOYEE_NUMBER.eq(SALE.EMPLOYEE_NUMBER))
                        .where(EMPLOYEE.EMPLOYEE_NUMBER.isNull())
                        .fetch()
        );
    }

    // EXAMPLE 6 - FULL OUTER JOIN
    public void fetchOfficeCustomerdetailFullOuterJoin() {

        System.out.println("EXAMPLE 6 (FULL OUTER JOIN)\n"
                + ctx.select(OFFICE.CITY, OFFICE.COUNTRY, OFFICE.OFFICE_CODE,
                        CUSTOMERDETAIL.CITY, CUSTOMERDETAIL.COUNTRY, CUSTOMERDETAIL.CUSTOMER_NUMBER)
                        .from(OFFICE)
                        .fullOuterJoin(CUSTOMERDETAIL)
                        .on(OFFICE.CITY.eq(CUSTOMERDETAIL.CITY))
                        .fetch()
        );
    }
    
    // EXAMPLE 7 - FULL OUTER JOIN
    public void fetchOfficeCustomerdetailFullOuterJoinExclusive() {

        System.out.println("EXAMPLE 7 (FULL OUTER JOIN (EXCLUSIVE))\n"
                + ctx.select(OFFICE.CITY, OFFICE.COUNTRY, OFFICE.OFFICE_CODE,
                        CUSTOMERDETAIL.CITY, CUSTOMERDETAIL.COUNTRY, CUSTOMERDETAIL.CUSTOMER_NUMBER)
                        .from(OFFICE)
                        .fullOuterJoin(CUSTOMERDETAIL)
                        .on(OFFICE.CITY.eq(CUSTOMERDETAIL.CITY))
                        .where(OFFICE.CITY.isNull().or(CUSTOMERDETAIL.CITY.isNull()))
                        .fetch()
        );
    }
    
    // EXAMPLE 8 - emulate FULL OUTER JOIN via UNION    
    public void fetchOfficeCustomerdetailFullOuterJoinViaUnion() {

        System.out.println("EXAMPLE 8 (FULL OUTER JOIN via UNION)\n"
                + ctx.select(OFFICE.CITY, OFFICE.COUNTRY, OFFICE.OFFICE_CODE,
                        CUSTOMERDETAIL.CITY, CUSTOMERDETAIL.COUNTRY, CUSTOMERDETAIL.CUSTOMER_NUMBER)
                        .from(OFFICE)
                        .leftOuterJoin(CUSTOMERDETAIL)
                        .on(OFFICE.CITY.eq(CUSTOMERDETAIL.CITY))                        
                        .union(select(OFFICE.CITY, OFFICE.COUNTRY, OFFICE.OFFICE_CODE,
                                CUSTOMERDETAIL.CITY, CUSTOMERDETAIL.COUNTRY, CUSTOMERDETAIL.CUSTOMER_NUMBER)
                                .from(OFFICE)
                                .rightOuterJoin(CUSTOMERDETAIL)
                                .on(OFFICE.CITY.eq(CUSTOMERDETAIL.CITY))
                                .where(OFFICE.CITY.isNull()))
                        .fetch()
        );
    }

    // EXAMPLE 9 - emulate FULL OUTER JOIN (EXCLUSIVE) via UNION
    public void fetchOfficeCustomerdetailFullOuterJoinExclusiveViaUnion() {

        System.out.println("EXAMPLE 9 (FULL OUTER JOIN (EXCLUSIVE) via UNION)\n"
                + ctx.select(OFFICE.CITY, OFFICE.COUNTRY, OFFICE.OFFICE_CODE,
                        CUSTOMERDETAIL.CITY, CUSTOMERDETAIL.COUNTRY, CUSTOMERDETAIL.CUSTOMER_NUMBER)
                        .from(OFFICE)
                        .leftOuterJoin(CUSTOMERDETAIL)
                        .on(OFFICE.CITY.eq(CUSTOMERDETAIL.CITY))
                        .where(CUSTOMERDETAIL.CITY.isNull())
                        .union(select(OFFICE.CITY, OFFICE.COUNTRY, OFFICE.OFFICE_CODE,
                                CUSTOMERDETAIL.CITY, CUSTOMERDETAIL.COUNTRY, CUSTOMERDETAIL.CUSTOMER_NUMBER)
                                .from(OFFICE)
                                .rightOuterJoin(CUSTOMERDETAIL)
                                .on(OFFICE.CITY.eq(CUSTOMERDETAIL.CITY))
                                .where(OFFICE.CITY.isNull()))
                        .fetch()
        );
    }
}