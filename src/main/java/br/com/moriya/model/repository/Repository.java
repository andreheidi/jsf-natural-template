package br.com.moriya.model.repository;

import br.com.moriya.model.Person;

import java.io.Serializable;
import java.util.List;

/**
 * Created by andre on 5/9/16.
 */
public interface Repository<T, ID extends Serializable> {

    void save(T entity);

    void delete(T entity);

    T findById(Long id);

    List<T> list();
}
