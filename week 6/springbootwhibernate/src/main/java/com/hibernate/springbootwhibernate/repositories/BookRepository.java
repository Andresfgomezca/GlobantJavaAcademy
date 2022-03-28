package com.hibernate.springbootwhibernate.repositories;

import com.hibernate.springbootwhibernate.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
