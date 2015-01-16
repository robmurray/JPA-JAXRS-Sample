package com.ys.professor.infra.repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * Created by rob on 1/10/15.
 */
public interface RepositoryInterface<T, PK extends Serializable>  {

    public void add(T object);

    public void remove(T object);

    public void update(T object);

    public T retrieveByID(PK id);

    public Collection<T> retrieveAll();

}
