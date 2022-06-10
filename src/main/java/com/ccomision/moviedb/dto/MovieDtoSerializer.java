package com.ccomision.moviedb.dto;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class MovieDtoSerializer extends JsonSerializer<MovieDto> {

    @Override
    public void serialize(MovieDto movieDto, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("id", movieDto.getId());
        gen.writeStringField("title", movieDto.getTitle());
        gen.writeStringField("overview", movieDto.getOverview());
        gen.writeStringField("poster", movieDto.getPoster());
        gen.writeNumberField("popularity", movieDto.getPopularity());
        gen.writeNumberField("voteAverage", movieDto.getVoteAverage());
        gen.writeObjectField("releaseDate", movieDto.getReleaseDate());
        gen.writeEndObject();
    }
}
