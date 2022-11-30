package com.bcnc.testreactive.domain.services;

import com.bcnc.testreactive.domain.entities.Price;
import java.time.OffsetDateTime;
import reactor.core.publisher.Mono;

/**
 * This is the Price Service inbound port. Business logic can be accessed through this interface.
 */
public interface PriceService {
    Mono<Price> getActualPriceForDate(OffsetDateTime applicationDate, long productId, long brandId);

}
