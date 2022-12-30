package com.springboot.myenglish.controller;

import com.springboot.myenglish.pojo.Book;
import com.springboot.myenglish.service.Impl.BookServiceImpl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Resource
    BookServiceImpl bookService;

    @GetMapping("viewbook")
    public List<Book> queryAllBook()
    {
        return bookService.queryAllBook();
    }

    @GetMapping("/watchbook/{bookId}")
    public Book queryBookById(int bookId) {
        return bookService.queryBookById(bookId);
    }
}
