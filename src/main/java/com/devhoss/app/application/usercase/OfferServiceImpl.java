package com.devhoss.app.application.usercase;


import com.devhoss.app.domain.model.Offer;
import com.devhoss.app.domain.port.in.IOfferServicePort;
import com.devhoss.app.domain.port.out.IOfferPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OfferServiceImpl implements IOfferServicePort {

    @Autowired
    IOfferPersistencePort offerpersistenceport;

    public Offer calculateActualPrice(Offer offer) {
        offer.setActualPrice(offer.getOriginalPrice() - ((offer.getDiscount() * offer.getOriginalPrice()) / 100));
        return offer;
    }

    @Override
    public Offer createOffer(Offer offer) {

        return offerpersistenceport.createOffer(calculateActualPrice(offer));
    }

    @Override
    public Offer getOfferById(Long id) {
        return offerpersistenceport.getOfferById(id);
    }

}
