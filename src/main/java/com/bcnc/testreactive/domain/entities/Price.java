package com.bcnc.testreactive.domain.entities;


import java.math.BigDecimal;
import java.util.Date;

/**
 * This is the domain class for storing Price information. It is used as part of the business logic inside the domain.
 */
public class Price {

    private long priceId;
    private long brandId;
    private Date startDate;
    private Date endDate;
    private long priceList;
    private long productId;
    private int priority;
    //Using BigDecimal for currency as it has the required precision . It may have some performance impact though.
    private BigDecimal price;

    public long getPriceId() {
        return priceId;
    }

    public void setPriceId(long priceId) {
        this.priceId = priceId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public Price() {
    }


}
