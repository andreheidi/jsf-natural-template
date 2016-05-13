package br.com.moriya.model;

import br.com.moriya.model.annotation.UniqueColumn;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by andre on 5/6/16.
 */
@Entity
public class Person implements Serializable, Comparable<Person>{

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(length = 200, unique = true)
    private String name;

    @CPF
    @NotNull
    @Size(min = 11, max = 14)
    private String cpf;

    @Temporal(TemporalType.DATE)
    private Date birth;

    @Email(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    private String email;

    public Person() {

    }

    public Person(Long id, String name, String cpf, Date birth, String email) {
        this.setId(id);
        this.setName(name);
        this.setCpf(cpf);
        this.setBirth(birth);
        this.setEmail(email);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int compareTo(Person o) {
        if(this.getId() < o.getId())
            return -1;
        if(this.getId() > o.getId())
            return 1;
        return 0;
    }
}