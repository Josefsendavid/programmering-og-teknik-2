package utils;

import entities.Hobby;
import entities.Role;
import entities.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author David
 */
public class SetupTestHobby {

    public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    
    // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
    // CHANGE the three passwords below, before you uncomment and execute the code below
    // Also, either delete this file, when users are created or rename and add to .gitignore
    // Whatever you do DO NOT COMMIT and PUSH with the real passwords

    Hobby hobby1 = new Hobby("Bowling", "Konkurrence");
    Hobby hobby2 = new Hobby("Svømning", "Konkurrence");
    Hobby hobby3 = new Hobby("Airsoft", "Udendørs");

    em.getTransaction().begin();
    em.persist(hobby1);
    em.persist(hobby2);
    em.persist(hobby3);
    em.getTransaction().commit(); 
  }
}
