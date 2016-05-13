package br.com.moriya.producer;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by andre on 5/6/16.
 */
public class EntityManagerProducer {

    @Produces
    @PersistenceContext
    private EntityManager entityManager;

}
