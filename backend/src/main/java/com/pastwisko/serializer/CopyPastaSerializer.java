package com.pastwisko.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.pastwisko.model.CopyPasta;

import java.io.IOException;

public class CopyPastaSerializer extends JsonSerializer<CopyPasta> {

    @Override
    public void serialize(CopyPasta copyPasta, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", copyPasta.getId());
        jsonGenerator.writeStringField("title", copyPasta.getTitle());
        jsonGenerator.writeStringField("text", copyPasta.getText());
        jsonGenerator.writeObjectField("creationDate", copyPasta.getCreationDate());
        jsonGenerator.writeStringField("author", copyPasta.getAuthor().getUserName());
        jsonGenerator.writeObjectField("comments", copyPasta.getComments());
        jsonGenerator.writeObjectField("ratings", copyPasta.getRatings());
        jsonGenerator.writeObjectField("tags", copyPasta.getTags());
        jsonGenerator.writeEndObject();
    }


}
