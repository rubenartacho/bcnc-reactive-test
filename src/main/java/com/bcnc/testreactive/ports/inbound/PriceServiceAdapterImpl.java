package com.bcnc.testreactive.ports.inbound;

import com.bcnc.testreactive.controllers.dto.entities.PriceDTO;
import com.bcnc.testreactive.controllers.dto.mappers.PriceDTOMapper;
import com.bcnc.testreactive.domain.services.PriceService;
import java.time.OffsetDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * This class acts as an Adapter for accessing Price's business logic. It handles conversion between DTO's and domain entities and decouples
 * business logic from it's clients
 */
@Component
public class PriceServiceAdapterImpl implements PriceServiceAdapter{
    @Autowired
    PriceService priceService;

    @Autowired
    PriceDTOMapper priceDTOMapper;

    @Override
    public Mono<PriceDTO> getActualPriceForDate(String applicationDate, long productId, long brandId) {
        return priceService.getActualPriceForDate(OffsetDateTime.parse(applicationDate), productId, brandId)
                .map(priceDTOMapper::getFromDOM);
    }
}
