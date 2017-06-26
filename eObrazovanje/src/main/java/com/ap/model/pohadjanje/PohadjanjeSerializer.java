package com.ap.model.pohadjanje;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class PohadjanjeSerializer extends StdSerializer<Pohadjanje>{
	
	public PohadjanjeSerializer() {
		this(null);
	}
	
	public PohadjanjeSerializer(Class<Pohadjanje> p) {
		super(p);
	}

	@Override
	public void serialize(
			Pohadjanje pohadjanje,
			JsonGenerator jgen,
			SerializerProvider provider) throws IOException, JsonProcessingException {
		jgen.writeStartObject();
		jgen.writeStringField("nazivKursa", pohadjanje.getKurs().getNaziv());
		jgen.writeNumberField("brojBodova", pohadjanje.getPolaganje().getBrojBodova());
		jgen.writeNumberField("ocena", pohadjanje.getPolaganje().getOcena());
		jgen.writeObjectField("polaganje", pohadjanje.getPolaganje());
		jgen.writeEndObject();
	}
}
