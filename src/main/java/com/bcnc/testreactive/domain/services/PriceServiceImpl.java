package com.bcnc.testreactive.domain.services;

import com.bcnc.testreactive.domain.entities.Price;
import com.bcnc.testreactive.domain.ports.inbound.PriceService;
import com.bcnc.testreactive.domain.ports.outbound.PriceRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * This is the standard implementation  for PriceService
 */
@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    PriceRepository priceRepository;


    @Override
    public Mono<Price> getActualPriceForDate(Date applicationDate, long productId, long brandId) {
        return priceRepository.getPricesForDate(applicationDate,productId,brandId).log()
                .collectList()
                .map(t->{

                    return new Price();
                });
    }
}
