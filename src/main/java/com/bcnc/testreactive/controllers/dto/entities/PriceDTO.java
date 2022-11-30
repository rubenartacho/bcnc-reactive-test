package com.bcnc.testreactive.controllers.dto.entities;

import com.bcnc.testreactive.controllers.utils.View.Detailed;
import com.bcnc.testreactive.controllers.utils.View.Public;
import com.fasterxml.jackson.annotation.JsonView;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * This is the Price Data Transmission Object. Is used to decouple Data Transmission entities from the core domain entities.
 * It introduces some conversion overhead but in Hexagonal Architecture is necessary to keep domain entities strictly inside the domain so alternate
 * entities are used for data transmission.
 */
public class PriceDTO {
    @JsonView(Detailed.class)
    private long priceId;

    @JsonView(Public.class)
    private long brandId;

    @JsonView(Public.class)
    private OffsetDateTime startDate;

    @JsonView(Public.class)
    private OffsetDateTime endDate;

    @JsonView(Public.class)
    private long priceList;

    @JsonView(Public.class)
    private long productId;

    @JsonView(Detailed.class)
    private int priority;

    @JsonView(Public.class)
    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

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
        return "PriceDTO{" +
                "priceId=" + priceId +
                ", brandId=" + brandId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", priceList=" + priceList +
                ", productId=" + productId +
                ", priority=" + priority +
                ", price=" + price +
                '}';
    }
}
