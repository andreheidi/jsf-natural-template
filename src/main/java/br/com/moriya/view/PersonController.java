package br.com.moriya.view;

import br.com.moriya.model.Person;
import br.com.moriya.service.PersonService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andre on 5/6/16.
 */
@Named
@RequestScoped
public class PersonController implements Serializable{

    private Person person;

    private List<Person> personList;

    @Inject
    private PersonService personService;

    public PersonController() {
    }

    @PostConstruct
    public void init() {
        this.setPerson(new Person());
        this.setPersonList(this.personService.list());
    }

    public String save() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            this.personService.save(person);

            this.setPersonList(this.personService.list());
            context.addMessage("Success", new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Success"));
        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(e.getCause().getMessage(), new FacesMessage(FacesMessage.SEVERITY_INFO, e.getCause().getMessage(), e.getCause().getMessage()));

        }
        return "personList?faces-redirect=true";
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
