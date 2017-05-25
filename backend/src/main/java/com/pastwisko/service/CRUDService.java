package com.pastwisko.service;

import java.util.List;

public interface CRUDService<T> {
    List<T> listAll();

    T getById(int id);

    T saveOrUpdate(T t);

    void delete(int id);
}
