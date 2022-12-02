package com.bcnc.testreactive.domain.services;

import com.bcnc.testreactive.domain.entities.Price;
import java.time.OffsetDateTime;
import reactor.core.publisher.Mono;

/**
 * This is the Price Service  interface. Business logic can be accessed through this.
 */
public interface PriceService {

    /**
     *
     * @param applicationDate When does the Price need to be resolved.
     * @param productId The Id for the product
     * @param brandId The product brand
     * @return The actual price for the product at the supplied DateTime
     */
    Mono<Price> getActualPriceForDate(OffsetDateTime applicationDate, long productId, long brandId);

}
