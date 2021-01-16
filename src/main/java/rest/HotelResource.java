/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.BookingDTO;
import dtos.HotelDTO;
import dtos.HotelsDTO;
import entities.Booking;
import entities.Hotel;
import facades.FetchFacade;
import facades.HotelFacade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import utils.HttpUtils;

/**
 * REST Web Service
 *
 * @author David
 */
@Path("hotel")
public class HotelResource {

    private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static ExecutorService exec = Executors.newCachedThreadPool();
    private static FetchFacade FACADE = new FetchFacade();
    private static HotelFacade FACADE2 = new HotelFacade();

    @Context
    private UriInfo context;

    @GET
    @Path("TEST")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEndpoints() throws IOException, InterruptedException, ExecutionException {
        List<String> list = FACADE.fetchParallel();
        return GSON.toJson(list);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String getHotelDTO(@PathParam("id") String id) throws IOException {
        String url = "http://exam.cphdat.dk:8000/hotel/" + id;
        String hotelData = HttpUtils.fetchData(url);

        Hotel hotel = GSON.fromJson(hotelData, Hotel.class);

        return GSON.toJson(hotel);
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("all")
//    public String getHotels() throws IOException {
//        String hotelList = FACADE2.fetchHotels();
////        String url = "http://exam.cphdat.dk:8000/hotel/all";
////        String hotelData = HttpUtils.fetchData(url);
////        Hotel hotelList = GSON.fromJson(hotelData, Hotel.class);
//        return GSON.toJson(hotelList);
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String getHotelsTest() throws IOException, InterruptedException, ExecutionException, TimeoutException {
        String hotelList = FACADE2.fetchHotelsTest(exec, GSON);
//        String url = "http://exam.cphdat.dk:8000/hotel/all";
//        String hotelData = HttpUtils.fetchData(url);
//        Hotel hotelList = GSON.fromJson(hotelData, Hotel.class);
        String result = hotelList;
        return result;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addBooking(String booking) {
        BookingDTO bDTO = GSON.fromJson(booking, BookingDTO.class);
        FACADE2.addBooking(bDTO);
        return GSON.toJson(bDTO);
    }

    @GET
    @Path("/bookings/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllBookings(@PathParam("name") String name) {
        ArrayList<BookingDTO> list = FACADE2.getAllBookings(name);
        return GSON.toJson(list);
    }
}
