package com.devhoss.app.domain.port.out;

import com.devhoss.app.domain.model.Offer;

public interface IOfferPersistencePort {
    public Offer createOffer(Offer offer);

    public Offer getOfferById(Long id);

}
