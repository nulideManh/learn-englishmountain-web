package com.springboot.myenglish.mapper;

import com.springboot.myenglish.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface BookMapper {
    Book queryBookById(Integer bookId);
    int addBook(Book book);
    int deleteBook(Integer bookId);
    int updateBook(Book book);
    List<Book> queryAllBook();
    List<Book> queryBookByKeyWords(String keyWords);

}
