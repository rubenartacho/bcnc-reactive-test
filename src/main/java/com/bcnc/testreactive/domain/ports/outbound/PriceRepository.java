package com.bcnc.testreactive.domain.ports.outbound;

import com.bcnc.testreactive.domain.entities.Price;
import java.util.Date;
import reactor.core.publisher.Flux;

/**
 * This is the outbound port
 */
public interface PriceRepository {

    Flux<Price> getPricesForDate(Date applicationDate, long productId,long brandId);

}
