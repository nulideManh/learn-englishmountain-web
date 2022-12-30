package com.springboot.myenglish.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.myenglish.mapper.BookMapper;
import com.springboot.myenglish.pojo.Book;
import com.springboot.myenglish.pojo.Word;
import com.springboot.myenglish.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;
    @Override
    public Book queryBookById(Integer bookId) {
        return bookMapper.queryBookById(bookId);
    }

    @Override
    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int deleteBook(Integer bookId) {
        return bookMapper.deleteBook(bookId);
    }

    @Override
    public int updateBook(Book book) {
        return bookMapper.updateBook(book);
    }
    @Override
    public List<Book> queryBookByKeyWords(String keyWords) {
        return bookMapper.queryBookByKeyWords(keyWords);
    }

    @Override
    public List<Book> queryAllBook() {
        return bookMapper.queryAllBook();
    }

}
