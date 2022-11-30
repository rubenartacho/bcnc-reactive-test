package com.bcnc.testreactive.domain.entities;


import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * This is the domain class for storing Price information. It is used as part of the business logic inside the domain.
 */
public class Price {

    private long priceId;
    private long brandId;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private long priceList;
    private long productId;
    private int priority;
    //Using BigDecimal for currency as it has the required precision . It may have some performance impact though.
    private BigDecimal itemPrice;


    public long getPriceId() {
        return priceId;
    }

    public void setPriceId(long priceId) {
        this.priceId = priceId;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public long getBrandId() {
        return brandId;
    }

    public void setBrandId(long brandId) {
        this.brandId = brandId;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
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


    @Override
    public String toString() {
        return "Price{" +
                "priceId=" + priceId +
                ", brandId=" + brandId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", priceList=" + priceList +
                ", productId=" + productId +
                ", priority=" + priority +
                ", itemPrice=" + itemPrice.toPlainString() +
                '}';
    }
}
