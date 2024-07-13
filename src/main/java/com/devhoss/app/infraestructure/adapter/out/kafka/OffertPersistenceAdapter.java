package com.devhoss.app.infraestructure.adapter.out.kafka;

import com.devhoss.app.domain.model.Offer;
import com.devhoss.app.domain.port.out.IOfferPersistencePort;
import com.devhoss.app.infraestructure.adapter.out.kafka.dto.OffertEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OffertPersistenceAdapter  implements IOfferPersistencePort {

    @Autowired
    KafkaTemplate<String, OffertEntity> kafkaTemplate;


    private static final String topic = "Topic";

    @Override
    public Offer createOffer(Offer offer) {
        OffertEntity offertEntity = new OffertEntity();
        kafkaTemplate.send(topic, offertEntity);
        return offer;
    }

    @Override
    public Offer getOfferById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOfferById'");
    }
}
