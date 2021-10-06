package com.pashin.pharmacyweb.service;

import java.util.List;

public interface IDBService<T, ID> {

    T add(T element);

    void deleteByID(ID id);

    T editElement(T element);

    T getByID(ID id);

    List<T> getAll();
}
