package com.WebH2JPA.WebH2JPA.repository;

import com.WebH2JPA.WebH2JPA.models.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
@SuppressWarnings("JpaQlInspection")
@Repository
@Transactional
public class BookRepoJPA implements BookRepo{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insert(Book b) {
        em.persist(b);
    }

    @Override
    public Book getById(int id) {
        return em.find(Book.class, id);
    }

    @Override
    public void delete(Book b) {
        em.remove(em.contains(b) ? b : em.merge(b));
    }

    @Override
    public Book getFirst() {
        return null;
    }

    @Override
    public List<Book> getAll() {
        TypedQuery<Book> query = em.createQuery("select b from Book b", Book.class);
        return query.getResultList();
    }

    @Override
    public Book getByName(String name) {
        return null;
    }
}
