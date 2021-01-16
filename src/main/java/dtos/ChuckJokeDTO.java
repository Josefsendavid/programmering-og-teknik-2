package dtos;

import entities.ChuckJoke;

/**
 *
 * @author David
 */
public class ChuckJokeDTO {

    private String value;
    private String url;

    public ChuckJokeDTO(String value, String url) {
        this.value = value;
        this.url = url;
    }

    public ChuckJokeDTO() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
