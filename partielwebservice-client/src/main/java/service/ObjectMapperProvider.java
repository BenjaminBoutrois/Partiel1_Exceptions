package service;

import javax.ws.rs.ext.ContextResolver;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperProvider implements ContextResolver<ObjectMapper> {

	final ObjectMapper defaultObjectMapper ;
	
	
	
	
	public ObjectMapperProvider(ObjectMapper defaultObjectMapper) {
		super();
		this.defaultObjectMapper = defaultObjectMapper;
	}


	@Override
	public ObjectMapper getContext(Class<?> type) {
		// TODO Auto-generated method stub
		return defaultObjectMapper;
	}
	
	 private static ObjectMapper createDefaultMapper() {
	        final ObjectMapper result = new ObjectMapper();
	        result.configure(Feature.IGNORE_UNDEFINED, true);

	        return result;
	    }

}
