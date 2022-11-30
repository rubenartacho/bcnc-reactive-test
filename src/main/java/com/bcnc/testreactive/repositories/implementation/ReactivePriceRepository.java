package com.bcnc.testreactive.repositories.implementation;

import com.bcnc.testreactive.repositories.dao.entities.PriceDAO;
import java.time.OffsetDateTime;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ReactivePriceRepository extends R2dbcRepository<PriceDAO, Long> {

    @Query("SELECT p.* FROM PriceDAO p WHERE p.startDate <= ?1 AND p.endDate >= ?1 AND p.productId = ?2 AND p.brandId = ?3")
    Flux<PriceDAO> findPricesForDate(OffsetDateTime applicationDate, long productId, long brandId);




}
