package com.springboot.myenglish.controller.admin;

import com.github.pagehelper.PageInfo;
import com.springboot.myenglish.pojo.Book;
import com.springboot.myenglish.pojo.Word;
import com.springboot.myenglish.service.Impl.BookServiceImpl;
import com.springboot.myenglish.util.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.util.List;

@Controller
public class UpdateBookController {

    @Autowired
    DataUtils dataUtils;
    @Autowired
    BookServiceImpl bookService;

    /**
     *
     * Xem sách
     */
    @RequestMapping("/admin/viewBook")
    public String viewBook(Model model){
        List<Book> book = bookService.queryAllBook();
        model.addAttribute("book",book);
        return "admin/Book-View";
    }


    /**
     *
     *  Sửa đổi sách
     */
    //đi đến trang chỉnh sửa
    @RequestMapping("/admin/toUpdateBook/{bookId}")
    public String toUpdateBook(@PathVariable("bookId")Integer bookId, Model model){

        Book book = bookService.queryBookById(bookId);
        model.addAttribute("book",book);
        return "admin/Book-Update";
    }
    //Thực hiện các thay đổi và gửi, quay lại trang view
    @RequestMapping("/admin/updateBook/{bookId}")
    public String updateBook(@PathVariable("bookId")Integer bookId,Book book){


        bookService.updateBook(book);
        return "redirect:/admin/viewBook";
    }
    /**
     *
     *  xóa sách
     */

    @RequestMapping("/admin/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") Integer bookId){

        bookService.deleteBook(bookId);

        return "redirect:/admin/viewBook";
    }

    /**
     *
     *  thêm sách
     */

    @RequestMapping("/admin/toAddBook")
    public String toAddBook(){
        return "admin/Book-Add";
    }
    @PostMapping("/admin/addBook")
    public String addBook(Book book) throws ParseException {


        bookService.addBook(book);
        return "redirect:/admin/viewBook";
    }

}


