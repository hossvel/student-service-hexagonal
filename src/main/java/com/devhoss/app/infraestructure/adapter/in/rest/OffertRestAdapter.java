package com.devhoss.app.infraestructure.adapter.in.rest;

import com.devhoss.app.domain.model.Offer;
import com.devhoss.app.domain.port.in.IOfferServicePort;
import com.devhoss.app.infraestructure.adapter.in.rest.dto.OfferDto;
import com.devhoss.app.infraestructure.adapter.in.rest.mapper.IOffertRestMapper;
import com.devhoss.app.infraestructure.adapter.in.rest.mapper.IStudentRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/offerts")
public class OffertRestAdapter {

    private final IOfferServicePort _iOfferServicePort;

    @PostMapping("/v1/api")
    public OfferDto createOffer(@RequestBody OfferDto offerdto) {
        Offer offer = IOffertRestMapper.INSTANCE.offerDtoToOfferModel(offerdto);
        return IOffertRestMapper.INSTANCE.offerModelToOfferDto(_iOfferServicePort.createOffer(offer));
    }

    @GetMapping("/v1/api/{id}")
    public OfferDto getOffer(@PathVariable(value = "id") Long id) {
        return IOffertRestMapper.INSTANCE.offerModelToOfferDto(_iOfferServicePort.getOfferById(id));

    }
}
