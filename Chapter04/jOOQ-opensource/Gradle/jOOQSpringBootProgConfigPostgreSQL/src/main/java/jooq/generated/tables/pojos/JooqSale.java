/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables.pojos;


import java.io.Serializable;

import javax.annotation.processing.Generated;
import javax.validation.constraints.NotNull;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4",
        "schema version:1.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqSale implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long    saleId;
    private Integer fiscalYear;
    private Double  sale;
    private Long    employeeNumber;
    private Boolean hot;

    public JooqSale() {}

    public JooqSale(JooqSale value) {
        this.saleId = value.saleId;
        this.fiscalYear = value.fiscalYear;
        this.sale = value.sale;
        this.employeeNumber = value.employeeNumber;
        this.hot = value.hot;
    }

    public JooqSale(
        Long    saleId,
        Integer fiscalYear,
        Double  sale,
        Long    employeeNumber,
        Boolean hot
    ) {
        this.saleId = saleId;
        this.fiscalYear = fiscalYear;
        this.sale = sale;
        this.employeeNumber = employeeNumber;
        this.hot = hot;
    }

    /**
     * Getter for <code>public.sale.sale_id</code>.
     */
    public Long getSaleId() {
        return this.saleId;
    }

    /**
     * Setter for <code>public.sale.sale_id</code>.
     */
    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    /**
     * Getter for <code>public.sale.fiscal_year</code>.
     */
    @NotNull
    public Integer getFiscalYear() {
        return this.fiscalYear;
    }

    /**
     * Setter for <code>public.sale.fiscal_year</code>.
     */
    public void setFiscalYear(Integer fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    /**
     * Getter for <code>public.sale.sale</code>.
     */
    @NotNull
    public Double getSale() {
        return this.sale;
    }

    /**
     * Setter for <code>public.sale.sale</code>.
     */
    public void setSale(Double sale) {
        this.sale = sale;
    }

    /**
     * Getter for <code>public.sale.employee_number</code>.
     */
    public Long getEmployeeNumber() {
        return this.employeeNumber;
    }

    /**
     * Setter for <code>public.sale.employee_number</code>.
     */
    public void setEmployeeNumber(Long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    /**
     * Getter for <code>public.sale.hot</code>.
     */
    public Boolean getHot() {
        return this.hot;
    }

    /**
     * Setter for <code>public.sale.hot</code>.
     */
    public void setHot(Boolean hot) {
        this.hot = hot;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JooqSale (");

        sb.append(saleId);
        sb.append(", ").append(fiscalYear);
        sb.append(", ").append(sale);
        sb.append(", ").append(employeeNumber);
        sb.append(", ").append(hot);

        sb.append(")");
        return sb.toString();
    }
}