package dtos;

import entities.Hotel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class HotelsDTO {

    List<HotelDTO> all = new ArrayList();

    public HotelsDTO(List<Hotel> hotelEntities) {
        hotelEntities.forEach((h) -> {
            all.add(new HotelDTO(h));
        });
    }

    public HotelsDTO() {
    }

    public List<HotelDTO> getAll() {
        return all;
    }

    public void setAll(List<HotelDTO> all) {
        this.all = all;
    }
}
