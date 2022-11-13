package com.springboot.myenglish.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.myenglish.entity.WordEntity;
import com.springboot.myenglish.service.Impl.WordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CollectionController {
    @Autowired
    WordServiceImpl wordService;


    //đi đến bộ sưu tập từ
    @RequestMapping("/wordCollection/{pageNum}")
    public String wordCollection(Model model, @PathVariable("pageNum") Integer pageNum) {

        PageInfo<WordEntity> word = wordService.queryAllCollectionWordByPage(pageNum, 10);
        model.addAttribute("word", word);

        return "user/word/collection-word";
    }

    //Hủy từ ưa thích
    @RequestMapping("/deleteWordCollection/{wordId}/{pageNum}")
    public String deleteWordCollection(@PathVariable("wordId") Integer wordId, @PathVariable("pageNum") Integer pageNum) {

        wordService.updateWordCollection0(wordId);
        return "redirect:/wordCollection/" + pageNum;
    }

    //vốn từ vựng bị thoái hóa
    @RequestMapping("/wordRaw/{pageNum}")
    public String wordRaw(Model model,@PathVariable("pageNum") Integer pageNum){
        /*10 mỗi trang theo mặc định*/
        PageInfo<WordEntity> wordPageInfo = wordService.queryAllUnrememberedByPageNum(pageNum, 10);
        wordPageInfo.getPageNum();
        model.addAttribute("word", wordPageInfo);

        return "user/word/raw-word";
    }

    //Hủy các từ mới
    @RequestMapping("/deleteWordRaw/{wordId}/{pageNum}")
    public String deleteWordRaw(@PathVariable("wordId") Integer wordId, @PathVariable("pageNum") Integer pageNum) {
        wordService.updateWordRemember1(wordId);


        return "redirect:/wordRaw/" + pageNum;
    }

    @RequestMapping("/deleteWordRaw1/{wordId}/{pageNum}")
    public String deleteWordRaw1(@PathVariable("wordId") Integer wordId, @PathVariable("pageNum") Integer pageNum) {
        wordService.updateWordRemember1(wordId);


        return "redirect:/admin/viewWord/" + pageNum;
    }

}

