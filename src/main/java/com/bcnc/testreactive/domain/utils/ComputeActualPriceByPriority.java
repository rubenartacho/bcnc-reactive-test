package com.bcnc.testreactive.domain.utils;

import com.bcnc.testreactive.domain.entities.Price;
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
        int maxPriority = -1;
        for ( Price p : prices ) {
            if(p.getPriority()> maxPriority){
                maxPriority = p.getPriority();
                price = p;
            }
        }

        return price;
    }
}
