package com.bcnc.testreactive.ports.outbound;

import com.bcnc.testreactive.domain.entities.Price;
import java.time.OffsetDateTime;
import reactor.core.publisher.Flux;

/**
 * This is the outbound port. This interface acts as an adapter for accessing the data backend.
 */
public interface PriceRepositoryAdapter {

    Flux<Price> getPricesForDate(OffsetDateTime applicationDate, long productId,long brandId);

}
