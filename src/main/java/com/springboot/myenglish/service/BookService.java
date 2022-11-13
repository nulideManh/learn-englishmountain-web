package com.springboot.myenglish.service;

import com.springboot.myenglish.entity.BookEntity;

import java.awt.print.Book;
import java.util.List;

public interface BookService {
    //Truy vấn thông tin về sách theo ID
    BookEntity queryBookById(Integer bookId);
    //thêm sách
    int addBook(BookEntity book);
    //xóa sách
    int deleteBook(Integer bookId);
    //Cập nhật sách
    int updateBook(BookEntity book);
    //Xem tất cả thông tin sách
    List<BookEntity> queryAllBook();
}
