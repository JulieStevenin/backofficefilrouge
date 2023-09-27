package com.example.jakartafilrouge.singleton;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {

    private static EMF instance;
    private EntityManagerFactory emf;

    private EMF() {
        this.emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    }

    public static EntityManagerFactory getInstanceEmf() {
        if (instance == null) {
            instance = new EMF();
        }
        return instance.emf;
    }

    public static void shutdown() {
        if (instance != null && instance.emf != null) {
            instance.emf.close();
        }
    }
}


