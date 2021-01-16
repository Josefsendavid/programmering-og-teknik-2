package dtos;

import entities.Hobby;

/**
 *
 * @author David
 */
public class HobbyDTO {

    private String name;
    private String type;

    public HobbyDTO() {
    }

    public HobbyDTO(Hobby hobby) {
        this.name = hobby.getName();
        this.type = hobby.getType();
    }

    public HobbyDTO(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
