package br.com.moriya.model.repository;

import br.com.moriya.model.Person;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Qualifier;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andre on 5/9/16.
 */
@Named
public class PersonRepository implements Repository<Person, Long> {

    @Inject
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Person entity) {
        this.entityManager.persist(entity);

        this.entityManager.flush();

    }

    @Override
    public List<Person> list() {
        List<Person> list = new ArrayList<>();
        TypedQuery<Person> query = this.entityManager.createQuery("select p from Person p", Person.class);
        list = query.getResultList();
        return list;
    }
}
