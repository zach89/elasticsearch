package com.sf.zaches.controller;

import com.alibaba.fastjson.JSONObject;
import com.sf.zaches.entity.Book;
import com.sf.zaches.service.BookService;
import com.sf.zaches.utils.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @ClassName BookController
 * @Description
 * @Author 01371059
 * @Date 2018/10/3 下午11:54
 * @Version 1.0
 **/
@RequestMapping("/book")
@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping(value = "",method = RequestMethod.POST)
    public Res create(@RequestBody Book book){
//        String id = req.getString("id");
//        String title = req.getString("title");
//        String author = req.getString("author");
//        String releaseData = req.getString("releaseData");
//        Book book = new Book(id,title,author,releaseData);
        bookService.save(book);
        return Res.buildOk("创建成功");
    }
    @SuppressWarnings("deprecation")
    @RequestMapping(value= "/lists",method = RequestMethod.GET)
    public Res list(@RequestParam(value = "currentPage") Integer currentPage,@RequestParam(value = "pageSize") Integer pageSize){
        Pageable pageable = new PageRequest(currentPage,pageSize);
        Iterable lists = bookService.findAllandPage(pageable);
        return Res.buildOk(lists);
    }
    @RequestMapping(value= "/{id}",method = RequestMethod.GET)
    public Res get(@PathVariable("id") String id){
        Optional<Book> book = bookService.findOne(id);
        return Res.buildOk(book);
    }
    @RequestMapping(value= "/{id}",method = RequestMethod.DELETE)
    public Res remove(@PathVariable("id") String id){
        bookService.deleteById(id);
        return Res.buildOk("删除成功");
    }
}
