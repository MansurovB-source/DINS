package com.example.phoneBook.service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public interface StoreService<T> {
    List<T> getAll();

    T create(T t);

    T getById(long id);

    T removeById(long id);

    T updateById(long id, T t);

}
