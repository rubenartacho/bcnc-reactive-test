package com.bcnc.testreactive.ports.inbound;

import com.bcnc.testreactive.controllers.dto.entities.PriceDTO;
import java.time.OffsetDateTime;
import reactor.core.publisher.Mono;

public interface PriceServiceAdapter {
    Mono<PriceDTO> getActualPriceForDate(OffsetDateTime applicationDate, long productId, long brandId);

}
