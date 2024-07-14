package com.devhoss.app.infraestructure.adapter.out.kafka.mapper;

import com.devhoss.app.domain.model.Offer;
import com.devhoss.app.infraestructure.adapter.out.kafka.dto.OffertEntity;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface OfferKafkaMapper {

    OffertEntity toOffertEntity(Offer Offer);

    Offer toOffer(OffertEntity entity);



}
