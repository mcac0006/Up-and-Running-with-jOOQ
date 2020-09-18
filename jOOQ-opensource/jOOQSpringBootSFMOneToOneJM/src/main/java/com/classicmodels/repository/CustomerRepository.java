package com.classicmodels.repository;

import com.classicmodels.pojo.CustomerDTO;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
import static jooq.generated.tables.Customer.CUSTOMER;
import static jooq.generated.tables.Customerdetail.CUSTOMERDETAIL;
import org.jooq.DSLContext;
import org.simpleflatmapper.jdbc.JdbcMapper;
import org.simpleflatmapper.jdbc.JdbcMapperFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

    private final JdbcMapper<CustomerDTO> customerMapper;
    private final DSLContext create;

    public CustomerRepository(DSLContext create) {
        this.create = create;
        this.customerMapper = JdbcMapperFactory
                .newInstance()
                .newMapper(CustomerDTO.class);
    }

    public List<CustomerDTO> findCustomerByCreditLimit(float creditLimit) {

        try ( ResultSet rs
                = create.select(CUSTOMER.CUSTOMER_NAME, 
                                CUSTOMER.PHONE, 
                                CUSTOMER.CREDIT_LIMIT,
                                CUSTOMERDETAIL.ADDRESS_LINE_FIRST.as("details_addressLineFirst"), 
                                CUSTOMERDETAIL.STATE.as("details_state"), 
                                CUSTOMERDETAIL.CITY.as("details_city"))
                        .from(CUSTOMER)
                        .innerJoin(CUSTOMERDETAIL).using(CUSTOMER.CUSTOMER_NUMBER)
                        .where(CUSTOMER.CREDIT_LIMIT.le(BigDecimal.valueOf(creditLimit)))
                        .orderBy(CUSTOMER.CUSTOMER_NUMBER)
                        .fetchResultSet()) {

                    Stream<CustomerDTO> stream = customerMapper.stream(rs);

                    return stream.collect(toList());

                } catch (SQLException ex) {
                    // handle exception (for example, wrap it into a unchecked exception)
                }

                return Collections.emptyList();
    }
}