package com.sf.zaches.repository;

import com.sf.zaches.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @ClassName BookRepository
 * @Description
 * @Author 01371059
 * @Date 2018/10/3 下午11:23
 * @Version 1.0
 **/
public interface BookRepository extends ElasticsearchRepository<Book,String> {
    Page<Book> findByAuthor(String author, Pageable pageable);
    List<Book> findByTitle(String title);
}
