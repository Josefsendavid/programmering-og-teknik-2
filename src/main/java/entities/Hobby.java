package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author David
 */
@Entity
@NamedQueries({
@NamedQuery(name = "Hobby.deleteAllRows", query = "DELETE from Hobby"),
@NamedQuery(name = "Hobby.getAll", query = "SELECT h FROM Hobby h")})
public class Hobby implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    
    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name="USER_HOBBY")
    private List<User> users;

    public Hobby() {
    }

    public Hobby(String name, String type) {
        this.name = name;
        this.type = type;
        users = new ArrayList();
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    public List<User> getUsers() {
        return users;
    }

    public Hobby(Long id, String name, String type) {
        this.id = id;
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
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
