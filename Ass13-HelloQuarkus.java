package org.acme.hibernate.orm;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("hello")
@ApplicationScoped
public class HelloQuarkus {
    @GET
    public String getHello() {
        return "Hello Quarkus";
    }
}