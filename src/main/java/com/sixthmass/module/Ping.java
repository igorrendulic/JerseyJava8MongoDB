package com.sixthmass.module;

import java.time.LocalDateTime;
import java.util.Date;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("ping")
public class Ping {
	
	@Id public ObjectId id;
	public LocalDateTime now;
	
	public Ping() {}
	
	public Ping(LocalDateTime date) {
		this.now = date;
		this.id = new ObjectId(new Date());
	}
}
