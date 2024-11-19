package io.codeforall.fanstatics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Sandbox {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        Football football = new Football();
        Tennis tennis = new Tennis();

        football.setBalls(1);
        tennis.setRacket(2);

        em.getTransaction().begin();
        em.persist(football);
        em.persist(tennis);
        em.getTransaction().commit();
        em.close();

        emf.close();


    }
}
