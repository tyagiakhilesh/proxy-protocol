package com.akhilesh.learning.resources;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

@Path("hello")
public class HelloResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello(@Context HttpServletRequest request) {
        return Response.ok().entity(String.format("Time is: %d, Host is: %s, Addr is: %s, Port is: %d",
                new Date().getTime(), request.getRemoteHost(), request.getRemoteAddr(), request.getRemotePort())).build();
    }
}
