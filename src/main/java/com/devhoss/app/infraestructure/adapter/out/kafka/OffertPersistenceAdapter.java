package com.devhoss.app.infraestructure.adapter.out.kafka;

import com.devhoss.app.domain.model.Offer;
import com.devhoss.app.domain.port.out.IOfferPersistencePort;
import com.devhoss.app.infraestructure.adapter.out.kafka.dto.OffertEntity;
import com.devhoss.app.infraestructure.adapter.out.kafka.mapper.OfferKafkaMapper;
import com.devhoss.app.infraestructure.adapter.out.persistence.mapper.StudentPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OffertPersistenceAdapter  implements IOfferPersistencePort {

   @Autowired
    KafkaTemplate<String, OffertEntity> kafkaTemplate;

    private static final String topic = "Topic-student";

    public static final org.slf4j.Logger log = LoggerFactory.getLogger(OffertPersistenceAdapter.class);

   // @Autowired
    private final OfferKafkaMapper _offerKafkaMapper;
    @Override
    public Offer createOffer(Offer offer) {

        OffertEntity offertEntity = _offerKafkaMapper.toOffertEntity(offer);
        log.info("Envio a Topico : " + offertEntity.toString());
        kafkaTemplate.send(topic, offertEntity);
        return offer;
    }

    @Override
    public Offer getOfferById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOfferById'");
    }

   /*
    @Override
    public Offer createOffer(Offer offer) {
        OffertEntity offertEntity = new OffertEntity();
        kafkaTemplate.send(topic, offertEntity);
       // kafkaTemplate.send("testtopicreplication3",Integer.valueOf(i),"Mensaje BATCH - " + (i + 1));
        return offer;
    }

    @Override
    public Offer getOfferById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOfferById'");
    }
    */
}
