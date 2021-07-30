package com.ashok.resources;

import com.ashok.dto.UserDto;
import com.codahale.metrics.annotation.ResponseMetered;
import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.BeanParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @POST
    @Timed(name = "addUser_api")
    @ResponseMetered(name = "addUser_statusCodes")
    @ApiOperation(value = "Create User", notes = "Creates user")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "", response = UserDto.class)})
    public Response addUser(@ApiParam @Valid @NotNull(message = "Data can't be null") UserDto user){
        return Response.accepted().build();
    }

}
