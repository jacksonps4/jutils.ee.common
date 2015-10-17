package com.minorityhobbies.util.ee.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

abstract class JacksonJsonMessageBodyProvider {
	private final ObjectMapper mapper = new ObjectMapper();

	public JacksonJsonMessageBodyProvider() {
		super();
		mapper.registerModule(new JavaTimeModule());
	}
	
	protected final void writeValue(Object object, OutputStream stream)
			throws IOException {
		mapper.writerWithDefaultPrettyPrinter().writeValue(stream, object);
	}
	
	protected final <T> T readValue(InputStream stream, Class<T> type)
			throws IOException {
		return mapper.readValue(stream, type);
	}
}
