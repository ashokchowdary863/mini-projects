package com.ashok.resources;

import com.ashok.models.Counter;
import com.codahale.metrics.annotation.ResponseMetered;
import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.checkerframework.checker.units.qual.Time;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/count")
@Produces(MediaType.APPLICATION_JSON)
public class CounterResource {
    private final String applicationName="MyApp";
    private int count = 0;

    @GET
    @Timed(name = "count_api")
    @ResponseMetered(name = "count_api_response")
    @ApiOperation(value = "Counter API", notes = "Increments and returns counter")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Counter Successful...")})
    public Response getCount(){
        return Response.ok().entity(new Counter(this.applicationName, this.count++)).build();
    }
}
