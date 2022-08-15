package com.gcu.site.data;
import java.util.List;

//Data interface for site tool controllers
public interface DataAccessInterface<T> {
    public List<T> findAll();
    public T findById(int id);
    public boolean create(T t);
    public boolean update(T t);
    public boolean delete(T t);
}
