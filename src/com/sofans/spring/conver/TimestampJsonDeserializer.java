package com.sofans.spring.conver;

import java.io.IOException;
import java.sql.Timestamp;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class TimestampJsonDeserializer extends JsonDeserializer<Timestamp> {

	@Override
	public Timestamp deserialize(JsonParser arg0, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		 try {
	            return Timestamp.valueOf(arg0.getText());
	        } catch (Exception e) {
	            return null;  
	        }
	}

}
