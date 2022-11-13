package com.springboot.myenglish.controller.admin;

import com.github.pagehelper.PageInfo;
import com.springboot.myenglish.entity.WordEntity;
import com.springboot.myenglish.service.Impl.WordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class UpdatewordController {
    @Controller
    public class UpdateWordController {
        @Autowired
        WordServiceImpl wordService;

        /**
         * Xem các từ
         */
        @RequestMapping("/admin/viewWord/{pageNum}")
        public String viewWord(Model model, @PathVariable("pageNum") Integer pageNum) {
            PageInfo<WordEntity> word = wordService.queryWordByPages(pageNum, 10);
            model.addAttribute("word", word);
            return "admin/Word-View";
        }


        /**
         * sửa đổi từ
         */
        //đi đến trang chỉnh sửa
        @RequestMapping("/admin/toUpdateWord/{wordId}")
        public String toUpdateWord(@PathVariable("wordId") Integer wordId, Model model) {


            WordEntity word = wordService.queryWordById(wordId);
            model.addAttribute("word", word);
            return "admin/Word-Update";
        }

        //Thực hiện các thay đổi và gửi, quay lại trang xem
        @RequestMapping("/admin/updateWord/{wordId}")
        public String updateNotice(@PathVariable("wordId") Integer wordId, WordEntity word) {

            wordService.updateWord(word);
            return "redirect:/admin/viewWord";
        }

        /**
         * xóa từ
         */

        @RequestMapping("/admin/deleteWord/{wordId}")
        public String deleteNotice(@PathVariable("wordId") Integer wordId) {

            wordService.deleteWord(wordId);


            return "redirect:/admin/viewWord";
        }

        /**
         * thêm từ
         */
//
        @RequestMapping("/admin/toAddWord")
        public String toAddWord() {
            return "admin/Word-Add";
        }

        @PostMapping("/admin/addWord")
        public String addWord(WordEntity word) {
            wordService.addWord(word);
            return "redirect:/admin/viewWord";
        }
    }

}
