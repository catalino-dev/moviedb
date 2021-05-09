package com.ccomision.moviedb.integration.tmdb;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class TmdbPosterImageDeserializer extends JsonDeserializer<String> {

    private static final String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500";

    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken posterPath = jsonParser.currentToken();
        if (posterPath == JsonToken.VALUE_STRING) {
            return String.format("%s" + jsonParser.getValueAsString(), BASE_IMAGE_URL);
        }
        return null;
    }
}
