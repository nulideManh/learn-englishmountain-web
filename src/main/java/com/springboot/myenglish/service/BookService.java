package com.springboot.myenglish.service;


import com.github.pagehelper.PageInfo;
import com.springboot.myenglish.pojo.Book;
import com.springboot.myenglish.pojo.Word;

import java.util.List;
public interface BookService {
    Book queryBookById(Integer bookId);
    int addBook(Book book);
    int deleteBook(Integer bookId);
    int updateBook(Book book);
    List<Book> queryAllBook();
    List<Book> queryBookByKeyWords(String keyWords);

}
