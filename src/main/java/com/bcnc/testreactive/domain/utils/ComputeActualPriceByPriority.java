package com.bcnc.testreactive.domain.utils;

import com.bcnc.testreactive.domain.entities.Price;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * This implementation will pick the highest priority price among all prices from a given List
 */
@Component
public class ComputeActualPriceByPriority implements ComputeActualPriceStrategy{

    @Override
    public Price getActualPriceFromList(List<Price> prices) {
        Price price = new Price();
        price.setPriceId(0);
        price.setBrandId(0);
        price.setStartDate(OffsetDateTime.now());
        price.setEndDate(OffsetDateTime.now());
        price.setPriceList(0);
        price.setProductId(0);
        price.setPriority(0);
        price.setItemPrice(new BigDecimal(0));
        return price;
    }
}
