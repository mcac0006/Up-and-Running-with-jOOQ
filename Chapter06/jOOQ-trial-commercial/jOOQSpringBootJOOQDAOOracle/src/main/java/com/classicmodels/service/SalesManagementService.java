package com.classicmodels.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.classicmodels.repository.SaleRepositoryImpl;
import java.math.BigInteger;
import jooq.generated.tables.pojos.Sale;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SalesManagementService {

    private final SaleRepositoryImpl saleRepository;

    public SalesManagementService(SaleRepositoryImpl saleRepository) {
        this.saleRepository = saleRepository;
    }

    /* call jOOQ user-defined DAOs */
    public List<Sale> fetchSaleAscGtLimit(int limit) {

        return saleRepository.findSaleAscGtLimit(limit);
    }

    /* call jOOQ generated DAOs */
    @Transactional(readOnly = true)
    public List<Sale> fetchSaleByFiscalYear(int year) {

        return saleRepository.fetchByFiscalYear(BigInteger.valueOf(year));
    }
}