package org.acme.hibernate.orm;

import java.util.Calendar;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("dateTime")
public class Add45Date {

    @POST
    @Path("/add45Date")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add45Date(DateTimeRequest body) {
        Calendar c = Calendar.getInstance();
        c.setTime(body.getInputDate());
        c.add(Calendar.DATE, 45);
        return Response.ok().entity(c.getTime()).build();
    }
}