package com.devhoss.app.infraestructure.adapter.out.kafka.config;

import com.devhoss.app.domain.model.Offer;
import com.devhoss.app.infraestructure.adapter.out.kafka.dto.OffertEntity;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.charset.StandardCharsets;
public class OffertEntitySerializer implements Serializer<OffertEntity> {
    @Override
    public byte[] serialize(String topic, OffertEntity data) {
        String jsonString = data.toString();
        return jsonString.getBytes(StandardCharsets.UTF_8);
    }
}
