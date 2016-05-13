package br.com.moriya.model.repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by andre on 5/9/16.
 */
public interface Repository<T, ID extends Serializable> {

    public void save(T entity);

    public List<T> list();
}
