package com.ccomision.moviedb.dto;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.data.domain.Page;

import java.io.IOException;

@JsonComponent
public class PageSerializer extends JsonSerializer<Page<?>> {

    @Override
    public void serialize(Page movieDto, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        gen.writeStartObject();
        gen.writeObjectField("content", movieDto.getContent());
        gen.writeNumberField("totalElements", movieDto.getTotalElements());
        gen.writeNumberField("totalPages", movieDto.getTotalPages());
        gen.writeEndObject();
    }
}
