package com.example.demo;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class TestController {

    private final UserService userService;

    @Inject
    public TestController(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("hello")
    public String hello() {
        return "Hello Quarkus";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("hellodb")
    public String hellodb() {
        long startTime = System.currentTimeMillis();
        User user = userService.getUserById(1L);
        long endTime = System.currentTimeMillis();

        return String.format("Hello %s, %d ms", user.getName(), endTime-startTime);
    }
}