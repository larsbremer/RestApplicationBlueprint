package com.larsbremer.tempsub.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.larsbremer.tempsub.model.Datastore;

@Path("/sensor")
public class TemperatureSensor {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response writeData(TempReading reading) {
		System.out.println("HEY POST " + reading.getTemperature());

		Datastore.temp = reading.getTemperature();
		return Response.ok().build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getData() {
		System.out.println("HEY GET");

		TempReading reading = new TempReading();
		reading.setTemperature(Datastore.temp);

		return Response.ok(reading).build();
	}
}