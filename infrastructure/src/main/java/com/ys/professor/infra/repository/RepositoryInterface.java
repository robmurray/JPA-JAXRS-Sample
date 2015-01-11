package com.ys.professor.infra.repository;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by rob on 1/10/15.
 */
public interface RepositoryInterface<T, PK extends Serializable>  {

    public void add(T object);

    public void remove(T object);

    public void update(T object);

    public void retrieve(PK key);

    public T retrieveByID(Class<T> clazz, PK id);

    public Set<T> retrieveAll();

}
