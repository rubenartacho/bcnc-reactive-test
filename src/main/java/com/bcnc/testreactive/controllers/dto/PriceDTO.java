package com.bcnc.testreactive.controllers.dto;

import java.util.Date;

/**
 * This is the Price Data Transmission Object. Is used to decouple Data Transmission entities from the core domain entities.
 * It introduces some conversion overhead but in Hexagonal Architecture is necessary to keep domain entities strictly inside the domain so alternate
 * entities are used for data transmission.
 */
public class PriceDTO {
    private long priceId;
    private long brandId;
    private Date startDate;
    private Date endDate;
    private long priceList;
    private long productId;
    private int priority;


    public long getPriceId() {
        return priceId;
    }

    public void setPriceId(long priceId) {
        this.priceId = priceId;
    }

    public long getBrandId() {
        return brandId;
    }

    public void setBrandId(long brandId) {
        this.brandId = brandId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public long getPriceList() {
        return priceList;
    }

    public void setPriceList(long priceList) {
        this.priceList = priceList;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public PriceDTO() {
    }

    public PriceDTO(long brandId, Date startDate, Date endDate, long priceList, long productId, int priority) {
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
    }

}
