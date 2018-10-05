package com.sf.zaches.service;

import com.sf.zaches.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName BookService
 * @Description
 * @Author 01371059
 * @Date 2018/10/3 下午11:28
 * @Version 1.0
 **/
public interface BookService {
    Book save(Book book);
    void delete(Book book);
    void deleteById(String id);
    Optional<Book> findOne(String id);

    Iterable<Book> findAll();
    Iterable<Book> findAllandPage(Pageable pageable);

    Page<Book> findByAuthor(String author, PageRequest pageRequest);

    List<Book> findByTitle(String title);

}
