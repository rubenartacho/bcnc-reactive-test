package com.bcnc.testreactive.ports.inbound;

import com.bcnc.testreactive.controllers.dto.entities.PriceDTO;
import reactor.core.publisher.Mono;

public interface PriceServiceAdapter {
    Mono<PriceDTO> getActualPriceForDate(String applicationDate, long productId, long brandId);

}
