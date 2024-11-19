package io.codeforall.fanstatics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Sandbox {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        Car car = new Car();
        Model model1 = new Model();
        Model model2 = new Model();
        Model model3 = new Model();

        model1.setName("M3");
        model2.setName("316i");
        model3.setName("i8");

        car.setMake("BMW");

        car.addModel(model1);
        car.addModel(model2);
        car.addModel(model3);

        em.getTransaction().begin();
        em.persist(car);
        em.getTransaction().commit();

        Car foundCar = em.find(Car.class, car.getId());
        Model model4 = new Model();
        model4.setName("m5");

        em.getTransaction().begin();
        foundCar.addModel(model4);
        em.merge(foundCar);
        em.getTransaction().commit();

        em.close();
        emf.close();


    }
}
