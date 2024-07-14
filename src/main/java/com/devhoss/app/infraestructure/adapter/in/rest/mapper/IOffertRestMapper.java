package com.devhoss.app.infraestructure.adapter.in.rest.mapper;

import com.devhoss.app.domain.model.Offer;
import com.devhoss.app.infraestructure.adapter.in.rest.dto.OfferDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IOffertRestMapper {

    IOffertRestMapper INSTANCE = Mappers.getMapper(IOffertRestMapper.class);

    OfferDto offerModelToOfferDto(Offer offer);

    Offer offerDtoToOfferModel(OfferDto offerdto);
}
