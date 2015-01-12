package com.minorityhobbies.util.ee.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

abstract class JacksonJsonMessageBodyProvider {
	private final ObjectMapper mapper = new ObjectMapper();

	public JacksonJsonMessageBodyProvider() {
		super();
	}
	
	protected final void writeValue(Object object, OutputStream stream)
			throws JsonGenerationException, JsonMappingException, IOException {
		mapper.writerWithDefaultPrettyPrinter().writeValue(stream, object);
	}
	
	protected final <T> T readValue(InputStream stream, Class<T> type)
			throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(stream, type);
	}
}
