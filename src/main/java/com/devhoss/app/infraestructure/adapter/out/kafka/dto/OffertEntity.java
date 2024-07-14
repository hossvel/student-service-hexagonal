package com.devhoss.app.infraestructure.adapter.out.kafka.dto;
public class OffertEntity {
    Long id;
    Long discount;
    long actualPrice;
    long originalPrice;

    public OffertEntity() {

    }


    @Override
    public String toString() {
        return "Offer [id=" + id + ", discount=" + discount + ", actualPrice=" + actualPrice + ", originalPrice="
                + originalPrice + "]";
    }
    public void setId(Long id) {
        this.id = id;
    }
    public OffertEntity(Long id, Long discount, long actualPrice, long originalPrice) {
        this.id = id;
        this.discount = discount;
        this.actualPrice = actualPrice;
        this.originalPrice = originalPrice;
    }
    public void setDiscount(Long discount) {
        this.discount = discount;
    }
    public void setActualPrice(long actualPrice) {
        this.actualPrice = actualPrice;
    }
    public void setOriginalPrice(long originalPrice) {
        this.originalPrice = originalPrice;
    }
    public Long getId() {
        return id;
    }
    public Long getDiscount() {
        return discount;
    }
    public long getActualPrice() {
        return actualPrice;
    }
    public long getOriginalPrice() {
        return originalPrice;
    }




}
