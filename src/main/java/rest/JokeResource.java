/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.ChuckJokeDTO;
import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import utils.HttpUtils;

/**
 * REST Web Service
 *
 * @author David
 */
@Path("joke")
public class JokeResource {

    private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of JokeResource
     */
    public JokeResource() {
    }

    /**
     * Retrieves representation of an instance of rest.JokeResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("chuck")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws IOException {
        String chuck = HttpUtils.fetchData("https://api.chucknorris.io/jokes/random");
        ChuckJokeDTO joke = GSON.fromJson(chuck, ChuckJokeDTO.class);
        
        return GSON.toJson(joke);
    }
}
