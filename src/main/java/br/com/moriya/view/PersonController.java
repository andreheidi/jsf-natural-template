package br.com.moriya.view;

import br.com.moriya.model.Person;
import br.com.moriya.service.PersonService;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by andre on 5/6/16.
 */
@Named
@Stateless
public class PersonController implements Serializable {

    private Person person = new Person();

    private List<Person> personList;

    @Inject
    private Logger log;

    @Inject
    private PersonService personService;

    @PostConstruct
    public void init() {
        log.info("Initializing PersonController");

        this.setPersonList(this.personService.list());

        log.info("PersonController successfully initialized");
    }

    public String add() {
        this.setPerson(new Person());
        return "person?faces-redirect=true";
    }

    public String save() {
        log.info("Saving Person");
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            log.info("Calling service [ save ]");
            this.personService.save(person);
            log.info("Service [ save ] successfully executed");

            this.setPersonList(this.personService.list());

            this.setPerson(new Person());
            context.addMessage("Success", new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Success"));
        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(e.getCause().getMessage(), new FacesMessage(FacesMessage.SEVERITY_INFO, e.getCause().getMessage(), e.getCause().getMessage()));

        }
        return "person?faces-redirect=true";
    }

    public String edit(Person person) {
        this.setPerson(this.personService.findById(person.getId()));
        return "person?faces-redirect=true";
    }

    public String remove(Person person) {
        this.personService.delete(this.personService.findByReference(person.getId()));
        this.setPersonList(this.personService.list());
        return "person?faces-redirect=true";
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
