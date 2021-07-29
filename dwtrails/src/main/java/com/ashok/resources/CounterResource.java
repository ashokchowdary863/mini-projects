package com.ashok.resources;

import com.ashok.models.Counter;
import com.codahale.metrics.annotation.ResponseMetered;
import com.codahale.metrics.annotation.Timed;
import org.checkerframework.checker.units.qual.Time;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/count")
@Produces(MediaType.APPLICATION_JSON)
public class CounterResource {
    private final String applicationName;
    private int count = 0;
    public CounterResource(String applicationName) {
        this.applicationName = applicationName;
    }

    @GET
    @Timed(name = "count_api")
    @ResponseMetered(name = "count_api_response")
    public Response getCount(){
        return Response.ok().entity(new Counter(this.applicationName, this.count++)).build();
    }
}
