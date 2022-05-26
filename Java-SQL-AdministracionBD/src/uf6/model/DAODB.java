package uf6.model;

import java.util.ArrayList;

public interface DAODB<T> {
    // CRUD
    boolean create(T t);
    T read(int t);
    boolean update(String s, T t);
    void delete(int t);
    // ALTRES
    boolean exists(T t);
    int count();
    ArrayList readTables();
    ArrayList ordenarTaules();
    ArrayList consultarTaules();
}
