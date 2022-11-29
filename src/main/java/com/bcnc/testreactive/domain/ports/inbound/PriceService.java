package com.bcnc.testreactive.domain.ports.inbound;

import com.bcnc.testreactive.domain.entities.Price;
import java.util.Date;
import reactor.core.publisher.Mono;

/**
 * This is the Price Service inbound port. Business logic can be accessed through this interface.
 */
public interface PriceService {
    public Mono<Price> getActualPriceForDate(Date applicationDate, long productId, long brandId);

}
