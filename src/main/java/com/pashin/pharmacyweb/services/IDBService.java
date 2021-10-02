package com.pashin.pharmacyweb.services;

import java.util.List;

public interface IDBService<T> {

    T add(T element);

    void deleteByID(long ID);

    T editElement(T element);

    T getByID(long ID);

    List<T> getAll();
}
