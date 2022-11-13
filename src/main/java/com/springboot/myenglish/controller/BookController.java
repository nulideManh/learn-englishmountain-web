package com.springboot.myenglish.controller;

import com.springboot.myenglish.entity.BookEntity;
import com.springboot.myenglish.service.Impl.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class BookController {
    @Resource
    BookServiceImpl bookService;
    //xem tất cả sách
    @RequestMapping("/viewbook")
    public String ViewBook(Model model){
        List<BookEntity> book = bookService.queryAllBook();
        model.addAttribute("book",book);
        return "user/book/select-book";
    }
    //mục nhập cụ thể vào một cuốn sách
    @RequestMapping("/watchBook/{bookId}")
    public String watchBook(@PathVariable("bookId")Integer bookId, Model model){
        BookEntity book = bookService.queryBookById(bookId);

        model.addAttribute("book",book);
        return "user/book/watch-book";
    }

}