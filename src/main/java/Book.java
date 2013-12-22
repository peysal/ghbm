package main.java;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String author;
    public String title;

    public Book() {

    }

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title + " by " + this.author;
    }
}
