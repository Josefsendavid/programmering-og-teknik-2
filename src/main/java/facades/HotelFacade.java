package facades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.BookingDTO;
import dtos.HotelDTO;
import entities.Booking;
import entities.Hotel;
import entities.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import rest.HotelResource;
import utils.EMF_Creator;
import utils.HttpUtils;

/**
 *
 * @author David
 */
public class HotelFacade {

    private static EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    private static HotelFacade instance;
    private static HotelResource rest;
    private Gson GSON;

    public HotelFacade() {

    }

    public static HotelFacade getHotelFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new HotelFacade();
        }
        return instance;
    }

    public static String fetchHotels(ExecutorService threadPool, Gson GSON) throws InterruptedException, ExecutionException, TimeoutException {
        String url = "http://exam.cphdat.dk:8000/hotel/all";
        Callable<HotelDTO[]> task = new Callable<HotelDTO[]>() {
            @Override
            public HotelDTO[] call() throws Exception {
                String allHotels = HttpUtils.fetchData(url);
                HotelDTO[] hotelsDTO = GSON.fromJson(allHotels, HotelDTO[].class);
                
                return hotelsDTO;
            }
        };
            Future<HotelDTO[]> futureHotels = threadPool.submit(task);
            
            HotelDTO[] result = futureHotels.get(5, TimeUnit.SECONDS);
            
            String combinedJSON = GSON.toJson(result);
            
            return combinedJSON;
        
    }

//    public String fetchHotels() throws IOException {
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        List<HotelDTO> hotels = new ArrayList();
//        String url = "http://exam.cphdat.dk:8000/hotel/all";
//        String hotelData = HttpUtils.fetchData(url);
//        return hotelData;
//    }
    
    

    public BookingDTO addBooking(BookingDTO b, String hotelId) throws IOException {
        EntityManager em = emf.createEntityManager();
        
        String hotelDTO = rest.getHotelById(hotelId);
        Hotel hotel = GSON.fromJson(hotelDTO, Hotel.class);
        
        Booking booking = new Booking(b.getName(), b.getNights(), b.getNightPrice(), b.getStartDate());
        booking.setHotel(hotel);
        
        User user = em.find(User.class, b.getName());
        user.addBooking(booking);
        
        try {
        em.getTransaction().begin();
        em.merge(user);
        em.persist(new Booking(b.getStartDate(), b.getNights(), b.getNightPrice(), b.getName()));
        em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new BookingDTO(booking);
    }

    public ArrayList<BookingDTO> getAllBookings(String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Booking> query = em.createQuery("SELECT b FROM Booking b WHERE b.name = '" + name + "'", Booking.class);

        em.getTransaction().commit();
        ArrayList<BookingDTO> list = new ArrayList();
        for (Booking b : query.getResultList()) {
            list.add(new BookingDTO(b));
        }
        return list;
    }
    
    public BookingDTO deleteBooking(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Booking b = em.find(Booking.class, id);
        em.remove(b);
        em.getTransaction().commit();
        return new BookingDTO(b);
    }
    
    public BookingDTO editBooking(BookingDTO booking) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Booking b = em.find(Booking.class, booking.getId());
        b.setNightPrice(booking.getNightPrice());
        b.setNights(booking.getNights());
        b.setStartDate(booking.getStartDate());
        b.setName(booking.getName());
        em.getTransaction().commit();
        return new BookingDTO(b);
    }
}
