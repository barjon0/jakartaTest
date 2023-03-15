package com.example.tech11;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDatabase {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    public static void addUser(User user) {     //adds entity to database

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static User findUser(int id) {           //searches for entity in database
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println(id);
        User user = entityManager.find(User.class, id);

        entityManager.close();

        return user;
    }

    public static void replaceUser(User oldUser, User updatedUser) {        //overwrites entity in database

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        oldUser.setFirstName(updatedUser.getFirstName());
        oldUser.setLastName(updatedUser.getLastName());
        oldUser.setBirthday(updatedUser.getBirthday());
        oldUser.setPassword(updatedUser.getPassword());
        oldUser.setEmail(updatedUser.getEmail());

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
