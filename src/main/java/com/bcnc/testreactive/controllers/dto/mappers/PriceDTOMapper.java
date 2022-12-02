package com.bcnc.testreactive.controllers.dto.mappers;

import com.bcnc.testreactive.controllers.dto.entities.PriceDTO;
import com.bcnc.testreactive.domain.entities.Price;
import org.springframework.stereotype.Component;

/**
 * DTO to DOM mapping implementation. Made manually as it usually has better performance.
 */
@Component
public class PriceDTOMapper implements DTOMapper<PriceDTO, Price>
{

    @Override
    public Price getFromDTO(PriceDTO e) {
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
    public PriceDTO getFromDOM(Price e) {
        PriceDTO priceDTO = new PriceDTO();

        priceDTO.setPriceId(e.getPriceId());
        priceDTO.setBrandId(e.getBrandId());
        priceDTO.setStartDate(e.getStartDate());
        priceDTO.setEndDate(e.getEndDate());
        priceDTO.setPriceList(e.getPriceList());
        priceDTO.setProductId(e.getProductId());
        priceDTO.setPriority(e.getPriority());
        priceDTO.setPrice(e.getItemPrice());
        priceDTO.setCurrency(e.getCurrency());

        return priceDTO;
    }
}
