package com.devhoss.app.domain.port.in;

import com.devhoss.app.domain.model.Offer;

public interface IOfferServicePort {

    public Offer createOffer(Offer offer);

    public Offer getOfferById(Long id);

}
