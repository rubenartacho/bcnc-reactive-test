package com.bcnc.testreactive.ports.inbound;

import com.bcnc.testreactive.controllers.dto.entities.PriceDTO;
import reactor.core.publisher.Mono;
/**
 * This is the inbound port. This interface acts as an adapter for accessing the business logic.
 */
public interface PriceServiceAdapter {
    Mono<PriceDTO> getActualPriceForDate(String applicationDate, long productId, long brandId);

}
