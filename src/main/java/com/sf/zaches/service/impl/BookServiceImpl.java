package com.sf.zaches.service.impl;

import com.sf.zaches.entity.Book;
import com.sf.zaches.repository.BookRepository;
import com.sf.zaches.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @ClassName BookServiceImpl
 * @Description
 * @Author 01371059
 * @Date 2018/10/3 下午11:28
 * @Version 1.0
 **/
@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public Book save(Book book) {
        if(!bookRepository.existsById(book.getId())){
            book.setId(UUID.randomUUID().toString());
        }
        return bookRepository.save(book);
    }

    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public void deleteById(String id) {
        bookRepository.deleteById(id);
    }

    public Optional<Book> findOne(String id) {
        return bookRepository.findById(id);
    }

    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Iterable<Book> findAllandPage(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    public Page<Book> findByAuthor(String author, PageRequest pageRequest) {
        return bookRepository.findByAuthor(author, pageRequest);
    }

    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}
