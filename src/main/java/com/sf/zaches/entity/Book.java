package com.sf.zaches.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @ClassName Book
 * @Description
 * @Author 01371059
 * @Date 2018/10/3 下午11:24
 * @Version 1.0
 **/
@Data
@Document(indexName = "zaches", type = "books")
public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private String releaseDate;
    public Book() {
    }
    public Book(String id, String title, String author, String releaseDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
    }
    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
