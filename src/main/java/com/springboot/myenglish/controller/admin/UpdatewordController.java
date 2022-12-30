package com.springboot.myenglish.controller.admin;

import com.github.pagehelper.PageInfo;
import com.springboot.myenglish.pojo.Word;
import com.springboot.myenglish.service.Impl.WordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UpdateWordController {
    @Autowired
    WordServiceImpl wordService;

    @RequestMapping("/admin/viewWord/{pageNum}")
    public String viewWord(HttpServletResponse response, Model model, @PathVariable("pageNum") Integer pageNum) {
        PageInfo<Word> word = wordService.queryWordByPages(pageNum, 10);
        model.addAttribute("word", word);
        Cookie cookie = new Cookie("currentWordPage", pageNum.toString());
        cookie.setMaxAge(60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "admin/Word-View";
    }

    @RequestMapping("/admin/toUpdateWord/{wordId}")
    public String toUpdateWord(@PathVariable("wordId") Integer wordId, Model model) {


        Word word = wordService.queryWordById(wordId);
        model.addAttribute("word", word);
        return "admin/Word-Update";
    }

    @RequestMapping("/admin/updateWord/{wordId}")
    public String updateNotice(@CookieValue("currentWordPage") String wordPage,
                               @PathVariable("wordId") Integer wordId,
                               Word word) {
        wordService.updateWord(word);
        return "redirect:/admin/viewWord/" + wordPage;
    }


    @RequestMapping("/admin/deleteWord/{wordId}")
    public String deleteNotice(@CookieValue("currentWordPage") String wordPage,
                               @PathVariable("wordId") Integer wordId) {

        wordService.deleteWord(wordId);

        return "redirect:/admin/viewWord/"+ wordPage;

    }


    @RequestMapping("/admin/toAddWord")
    public String toAddWord() {
        return "admin/Word-Add";
    }

    @PostMapping("/admin/addWord")
    public String addWord(Word word) {
        wordService.addWord(word);
        return "redirect:/admin/viewWord/1";
    }
}

