package br.com.moriya.service.impl;

import br.com.moriya.model.Person;
import br.com.moriya.model.repository.PersonRepository;
import br.com.moriya.service.PersonService;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by andre on 5/9/16.
 */
@Named
public class PersonServiceImpl implements PersonService {

    @Inject
    private PersonRepository personRepository;

    @Override
    public void save(Person person) {
        this.personRepository.save(person);
    }

    public List<Person> list() {
        return this.personRepository.list();
    }
}
