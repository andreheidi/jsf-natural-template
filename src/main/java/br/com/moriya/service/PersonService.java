package br.com.moriya.service;

import br.com.moriya.model.Person;
import br.com.moriya.model.repository.PersonRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by andre on 5/9/16.
 */
public interface PersonService {

    void save(Person person);

    void delete(Person person);

    Person findByReference(Long id);

    Person findById(Long id);

    List<Person> list();
}
