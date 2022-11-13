package com.springboot.myenglish.mapper;

import com.springboot.myenglish.entity.BookEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {
    //Truy vấn thông tin về sách theo ID
    BookEntity queryBookById(Integer bookId);
    //thêm sách
    int addBook(BookEntity book);
    //xóa sách
    int deleteBook(Integer bookId);
    //cập nhật sách
    int updateBook(BookEntity book);
    //Xem tất cả thông tin sách
    List<BookEntity> queryAllBook();

}
