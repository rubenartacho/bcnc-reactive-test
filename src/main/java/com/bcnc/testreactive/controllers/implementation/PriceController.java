package com.bcnc.testreactive.controllers.implementation;

import com.bcnc.testreactive.controllers.dto.entities.PriceDTO;
import com.bcnc.testreactive.controllers.utils.View.Public;
import com.bcnc.testreactive.ports.inbound.PriceServiceAdapter;
import com.fasterxml.jackson.annotation.JsonView;
import java.time.OffsetDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * This is the main REST API endpoint for prices. It  uses the inbound port PriceService to access the business logic.
 */
@RestController
public class PriceController {

    @Autowired
    PriceServiceAdapter priceServiceAdapter;
    Logger logger = LoggerFactory.getLogger(PriceController.class);

    @GetMapping("/brand/{brandId}/product/{productId}/appDate/{applicationDate}")
    @JsonView(Public.class)
    public Mono<PriceDTO> getActualPriceForDate(@PathVariable String applicationDate,@PathVariable long productId,@PathVariable long brandId){

        logger.debug("GET query at the endpoint");

        return  priceServiceAdapter.getActualPriceForDate(applicationDate, productId, brandId);
    }

}
