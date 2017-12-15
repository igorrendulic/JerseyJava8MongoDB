package com.sixthmass.rest;

import java.time.LocalDateTime;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sixthmass.module.Ping;

@Path("ping")
public class PingService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Ping getPing() {
		Ping ping = new Ping(LocalDateTime.now());
		return ping;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Ping postPing(Ping ping) {
		return ping;
	}
	
}
