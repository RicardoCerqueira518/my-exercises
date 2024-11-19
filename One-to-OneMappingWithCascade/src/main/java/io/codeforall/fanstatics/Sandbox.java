package io.codeforall.fanstatics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Sandbox {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        Car car = new Car();
        Owner owner = new Owner();

        owner.setId(1);
        owner.setName("Joca");

        car.setId(1);
        car.setMake("BMW");
        car.setModel("M3");

        owner.setCar(car);
        car.setOwner(owner);

        em.getTransaction().begin();
        em.persist(owner);
        em.persist(car);

        em.getTransaction().commit();
        em.close();

        emf.close();


    }
}
