package facades;

import dtos.HobbyDTO;
import dtos.HobbysDTO;
import dtos.UsersDTO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author David
 */
public class HobbyFacade {

    private static EntityManagerFactory emf;
    private static HobbyFacade instance;

    private HobbyFacade() {

    }

    public static HobbyFacade getHobbyFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new HobbyFacade();
        }
        return instance;
    }

    public long getHobbyCount() {
        EntityManager em = emf.createEntityManager();
        try {
            long hobbyCount = (long) em.createQuery("SELECT COUNT(h) FROM Hobby h").getSingleResult();
            return hobbyCount;
        } finally {
            em.close();
        }
    }
    
    public HobbysDTO getAllHobby() {
        EntityManager em = emf.createEntityManager();
        try {
            return new HobbysDTO(em.createNamedQuery("Hobby.getAll").getResultList());
        } finally {
            em.close();
        }
    }
}
