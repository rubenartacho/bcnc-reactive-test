package com.bcnc.testreactive.controllers;

import com.bcnc.testreactive.controllers.dto.entities.PriceDTO;
import com.bcnc.testreactive.controllers.dto.mappers.PriceDTOMapper;
import com.bcnc.testreactive.domain.ports.inbound.PriceService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * This is the main REST API endpoint for prices. It  uses the inbound port PriceService to access the business logic.
 */
@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    PriceService priceService;
    @Autowired
    PriceDTOMapper priceDTOMapper;

    @GetMapping("/{brandId}/{productId}")
    public Mono<PriceDTO> getActualPriceForDate(@RequestParam Date applicationDate, long productId, long brandId){
        return priceService.getActualPriceForDate(applicationDate, productId, brandId)
                .map(priceDTOMapper::getFromDOM);

    }

}
