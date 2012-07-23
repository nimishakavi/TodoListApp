package com.todoapp.util;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.ClientResponse.Status;

@SuppressWarnings("serial")
public class AppException extends WebApplicationException {
	
    public AppException(String errorMessage) {
    	
        super(Response.status(Status.NOT_FOUND).entity(errorMessage).type(MediaType.TEXT_PLAIN).build());
        
    }

}