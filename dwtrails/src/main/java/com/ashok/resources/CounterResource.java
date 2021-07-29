package com.ashok.resources;

import com.ashok.models.Counter;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/count")
@Produces(MediaType.APPLICATION_JSON)
public class CounterResource {
    private final String applicationName;
    private int count = 0;
    public CounterResource(String applicationName) {
        this.applicationName = applicationName;
    }

    @GET
    @Timed
    public Counter getCount(){
        return new Counter(this.applicationName, this.count++);
    }
}
