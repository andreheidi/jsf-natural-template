package br.com.moriya.model.annotation.validator;

import javax.persistence.EntityManager;

/**
 * Created by andre on 5/8/16.
 */
public interface EntityManagerValidator {

    void setEntityManager(EntityManager entityManager);

}