package com.bcnc.testreactive.repositories.implementation;

import com.bcnc.testreactive.domain.entities.Price;
import com.bcnc.testreactive.domain.ports.outbound.PriceRepository;
import com.bcnc.testreactive.repositories.dao.mappers.PriceDAOMapper;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * This class acts as a Proxy for accessing Price's data backend. It handles conversion between DAO's and domain entities and decouples data access
 * from business logic.
 */
@Repository
public class PriceRepositoryImpl implements PriceRepository
{
    @Autowired
    ReactivePriceRepository reactivePriceRepository;

    @Autowired
    PriceDAOMapper priceDAOMapper;

    /**
     *
     * @param applicationDate The date when the Price is queried.
     * @param productId The Product ID number.
     * @param brandId The brand ID number.
     * @return A Flux with all the Price elements matching productID, brandID and applicationDate between Price.startDate and Price.endDate
     */
    @Override
    public Flux<Price> getPricesForDate(Date applicationDate, long productId, long brandId) {
        return reactivePriceRepository.findPricesForDate(applicationDate,productId,brandId)
                .map(priceDAOMapper::getFromDAO);
    }
}
