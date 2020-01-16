package com.WebH2JPA.WebH2JPA.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
@Entity
public class Author {
    @Id
    @GeneratedValue
    private int id;

    public int getId() {
        return id;
    }

    private String name;
    public Author() {
    }
    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
