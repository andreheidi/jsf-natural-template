package br.com.moriya.service.impl;

import br.com.moriya.model.Person;
import br.com.moriya.model.repository.PersonRepository;
import br.com.moriya.model.repository.Repository;
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

    @Inject
    private Logger log;

    @Override
    public void save(Person person) {
        log.info("Chamando repository save");
        this.personRepository.save(person);
    }

    @Override
    public void delete(Person person) {
        this.personRepository.delete(person);
    }

    @Override
    public Person findByReference(Long id) {
        return this.personRepository.findByReference(id);
    }

    @Override
    public Person findById(Long id) {
        return this.personRepository.findById(id);
    }

    public List<Person> list() {
        log.info("Chamando repository list");
        return this.personRepository.list();
    }
}
