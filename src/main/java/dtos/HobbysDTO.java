package dtos;

import entities.Hobby;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class HobbysDTO {

    List<HobbyDTO> all = new ArrayList();

    public HobbysDTO(List<Hobby> hobbyEntities) {
        hobbyEntities.forEach((h) -> {
            all.add(new HobbyDTO(h));
        });
    }

    public HobbysDTO() {
    }

    public List<HobbyDTO> getAll() {
        return all;
    }

    public void setAll(List<HobbyDTO> all) {
        this.all = all;
    }

}
