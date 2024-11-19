package io.codeforall.fanstatics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Sandbox {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        Atlets atlets = new Atlets();
        History history = new History();


        atlets.setName("Ricardo");
        history.setAwards("Best Programmer");

        em.getTransaction().begin();
        em.persist(atlets);
        em.persist(history);
        em.getTransaction().commit();
        em.close();

        emf.close();


    }
}
