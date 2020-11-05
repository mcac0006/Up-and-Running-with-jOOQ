package com.classicmodels.repository;

import java.time.LocalDate;
import java.util.List;
import jooq.generated.tables.pojos.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly=true)
public interface OrderRepository extends ClassicModelsRepository<Order, Long> {
    
    public List<Order> findOrderDescByDate();
    public List<Order> findOrderBetweenDate(LocalDate sd, LocalDate ed);
}