package ua.magazines;

import ua.magazines.entity.Role;
import ua.magazines.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainTest {
    public static void main(String[] args) {
  /*      UserService userService = UserServiceImpl.getUserService();
        userService.create(new User("Vitaliy", "Kym", "kim@gmail.com", "kimBirthday"));
*/
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "StorePersistence" );
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User user = new User();
        user.setFirstName("Test");
        user.setLastName("TestTest");
        user.setEmail("test@gmail.com");
        user.setPassword("test");
        user.setId(222);
        user.setRole(Role.USER);

        User user2 = em.find(User.class, 5.0);
        em.flush();

        em.persist(user);
        em.getTransaction().commit();
    }
}
