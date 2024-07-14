package com.devhoss.app.infraestructure.adapter.in.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferDto {

    Long discount;
    long originalPrice;
}