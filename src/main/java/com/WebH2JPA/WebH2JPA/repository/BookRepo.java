package com.WebH2JPA.WebH2JPA.repository;
import com.WebH2JPA.WebH2JPA.models.Book;

import java.util.List;

public interface BookRepo {
    void insert(Book b);

    Book getById(int id);

    Book getFirst();

    List<Book> getAll();

    Book getByName(String name);
    public void delete(Book b);
}
