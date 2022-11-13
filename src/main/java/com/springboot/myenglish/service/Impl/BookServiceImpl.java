package com.springboot.myenglish.service.Impl;

import com.springboot.myenglish.entity.BookEntity;
import com.springboot.myenglish.mapper.BookMapper;
import com.springboot.myenglish.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;
    @Override
    public BookEntity queryBookById(Integer bookId) {
        return bookMapper.queryBookById(bookId);
    }

    @Override
    public int addBook(BookEntity book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int deleteBook(Integer bookId) {
        return bookMapper.deleteBook(bookId);
    }

    @Override
    public int updateBook(BookEntity book) {
        return bookMapper.updateBook(book);
    }

    @Override
    public List<BookEntity> queryAllBook() {
        return bookMapper.queryAllBook();
    }
}
