package com.devhoss.app.infraestructure.adapter.out.kafka.config;

import com.devhoss.app.domain.model.Offer;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.charset.StandardCharsets;

public class OfferSerializer implements Serializer<Offer> {
    @Override
    public byte[] serialize(String topic, Offer data) {
        String jsonString = data.toString();
        return jsonString.getBytes(StandardCharsets.UTF_8);
    }
}