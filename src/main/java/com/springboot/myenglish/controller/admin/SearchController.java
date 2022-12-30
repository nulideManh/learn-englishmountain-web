package com.springboot.myenglish.controller.admin;

import com.github.pagehelper.PageInfo;
import com.springboot.myenglish.pojo.Book;
import com.springboot.myenglish.pojo.Word;
import com.springboot.myenglish.service.Impl.BookServiceImpl;
import com.springboot.myenglish.service.Impl.WordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SearchController {
    /** Search book */
    @Autowired
    BookServiceImpl bookService;
    @RequestMapping("/admin/searchBook")
    public String searchWords(String keyWords, Model model){
        List<Book> book = bookService.queryBookByKeyWords(keyWords);
        model.addAttribute("book", book);
        return "admin/Book-Search";
    }

    /** Search word */
    @Autowired
    WordServiceImpl wordService;
    @RequestMapping("/admin/searchWord/{pageNum}")
    public String searchWords(String keyWords, Model model, @PathVariable("pageNum") Integer pageNum){
        PageInfo<Word> word = wordService.queryWordSearchByPages(keyWords, pageNum, 20);
        model.addAttribute("word", word);
        return "admin/Word-Search";
    }
}
