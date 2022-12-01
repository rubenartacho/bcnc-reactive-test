package com.bcnc.testreactive.domain.utils;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This factory makes it easy to get a concrete ComputeActualPrice implementation at runtime.
 */
@Component
public class ComputeActualPriceFactory {

    Logger logger = LoggerFactory.getLogger(ComputeActualPriceFactory.class);

    @Autowired
    Map<String,ComputeActualPriceStrategy> computeActualPriceStrategyMap;

    public ComputeActualPriceStrategy getComputeActualPriceStrategy(String type){

        ComputeActualPriceStrategy computeActualPriceStrategy = computeActualPriceStrategyMap.get(type);
        if(computeActualPriceStrategy == null){
            logger.error("Unable to find ComputeActualPriceStrategy type : {}", type);
            throw new IllegalArgumentException();
        }
        return computeActualPriceStrategy;
    }

}
