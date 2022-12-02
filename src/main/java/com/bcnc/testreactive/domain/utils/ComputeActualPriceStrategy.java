package com.bcnc.testreactive.domain.utils;

import com.bcnc.testreactive.domain.entities.Price;
import java.util.List;

/**
 * This is the interface for a Strategy pattern. This will enable the runtime exchanging of the actual price computing algorithm.
 */
public interface ComputeActualPriceStrategy {

    /**
     * Will get the actual Price from a given List
     * @param prices The Prices list
     * @return The actual Price
     */
    Price getActualPriceFromList(List<Price> prices);

}
