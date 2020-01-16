package com.WebH2JPA.WebH2JPA;

import com.WebH2JPA.WebH2JPA.models.Author;
import com.WebH2JPA.WebH2JPA.models.Book;
import com.WebH2JPA.WebH2JPA.models.Genre;
import com.WebH2JPA.WebH2JPA.repository.BookRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WebH2JpaApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(WebH2JpaApplication.class);
		BookRepo repository = context.getBean(BookRepo.class);

		Genre p = new Genre("777");
		Genre p2 = new Genre("72");
		Author a = new Author("k");
		Author a2 = new Author("k2");

		Book b = new Book(a, p, "bbb");
		Book b2 = new Book(a2, p2, "bbb2");
		repository.insert(b);
		repository.insert(b2);

	}
}
