package com.bcnc.testreactive.repositories.dao.mappers;

import com.bcnc.testreactive.domain.entities.Price;
import com.bcnc.testreactive.repositories.dao.entities.PriceDAO;
import org.springframework.stereotype.Component;

/**
 * Implementation of PriceDAO/Price mapper.
 * Harcoding the mapping instead of using a mapping framework as it tends to have better performance.
 */
@Component
public class PriceDAOMapper implements  DAOMapper<PriceDAO, Price>{

    @Override
    public Price getFromDAO(PriceDAO e) {
       Price price = new Price();

       price.setPriceId(e.getPriceId());
       price.setBrandId(e.getBrandId());
       price.setStartDate(e.getStartDate());
       price.setEndDate(e.getEndDate());
       price.setPriceList(e.getPriceList());
       price.setProductId(e.getProductId());
       price.setPriority(e.getPriority());
       price.setItemPrice(e.getPrice());
       price.setCurrency(e.getCurrency());

       return price;
    }

    @Override
    public PriceDAO getFromDOM(Price e) {
        PriceDAO priceDAO = new PriceDAO();
        priceDAO.setPriceId(e.getPriceId());
        priceDAO.setBrandId(e.getBrandId());
        priceDAO.setStartDate(e.getStartDate());
        priceDAO.setEndDate(e.getEndDate());
        priceDAO.setPriceList(e.getPriceList());
        priceDAO.setProductId(e.getProductId());
        priceDAO.setPriority(e.getPriority());
        priceDAO.setPrice(e.getItemPrice());
        priceDAO.setCurrency(e.getCurrency());

        return priceDAO;
    }
}
