package com.sixthmass.JerseyMongo;

import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.sixthmass.util.ObjectIdSerializerModule;

/**
 * Custom configuration for Jetty jax-rs Server

 */
public class App extends ResourceConfig
{

    public App() {
    	
    	ObjectMapper mapper = new ObjectMapper();
	    mapper.enable(SerializationFeature.INDENT_OUTPUT);
	    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.setSerializationInclusion(Include.NON_NULL);
        mapper.registerModule(new ObjectIdSerializerModule());
        
        mapper.registerModule(new ParameterNamesModule())
        		.registerModule(new Jdk8Module())
        		.registerModule(new JavaTimeModule());
        
        JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
        provider.setMapper(mapper);
        
	    register(provider);
    	
    	packages("com.sixthmass.rest"); // location of jax-rs classes
    }
}
