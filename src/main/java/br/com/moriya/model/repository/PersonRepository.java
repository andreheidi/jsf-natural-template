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
        this.entityManager.merge(entity);
        this.entityManager.flush();
        this.entityManager.clear();
    }

    @Override
    @Transactional
    public void delete(Person entity) {
        this.entityManager.remove(entity);
        this.entityManager.flush();
        this.entityManager.clear();
    }

    public Person findByReference(Long id) {
        Person person = this.entityManager.getReference(Person.class, id);
        return person;
    }

    public Person findById(Long id) {
        Person person = this.entityManager.find(Person.class, id);
        return person;
    }

    @Override
    public List<Person> list() {
        List<Person> list = null;
        TypedQuery<Person> query = this.entityManager.createQuery("select p from Person p", Person.class);
        list = query.getResultList();
        return list;
    }
}
