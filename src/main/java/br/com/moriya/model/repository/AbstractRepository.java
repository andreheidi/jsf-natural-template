package br.com.moriya.model.repository;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

/**
 * Created by andre on 5/9/16.
 */
@Named
public class AbstractRepository<T, ID extends Serializable> implements Repository<T, ID> {

    private T type;
    @Inject
    private EntityManager entityManager;

    @Override
    public void save(T entity) {
        this.entityManager.persist(entity);
        this.entityManager.flush();
        this.entityManager.clear();
    }

    @Override
    public List<T> list() {
        return null;
    }
}
