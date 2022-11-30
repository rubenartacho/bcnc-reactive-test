package com.bcnc.testreactive.domain.utils;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This factory makes it easy to get a concrete ComputeActualPrice implementation at runtime.
 */
@Component
public class ComputeActualPriceFactory {
    @Autowired
    Map<String,ComputeActualPriceStrategy> computeActualPriceStrategyMap;

    public ComputeActualPriceStrategy getComputeActualPriceStrategy(String type){

        ComputeActualPriceStrategy computeActualPriceStrategy = computeActualPriceStrategyMap.get(type);
        if(computeActualPriceStrategy == null){
            throw new NullPointerException();
        }
        return computeActualPriceStrategy;
    }

}
