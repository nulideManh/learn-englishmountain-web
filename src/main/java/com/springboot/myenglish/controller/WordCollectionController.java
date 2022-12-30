package com.springboot.myenglish.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.myenglish.pojo.Word;
import com.springboot.myenglish.service.Impl.WordServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/wordCollection")
public class WordCollectionController {
    @Resource
    WordServiceImpl wordService;

    @GetMapping("/{page}")
    public ResponseEntity<?> wordCollection (@PathVariable("page") Integer page) {
        PageInfo<Word> word = wordService.queryAllCollectionWordByPage(page, 10);
        return ResponseEntity.ok(word);
    }

    @DeleteMapping ("/{wordId}")
    public ResponseEntity<?> deleteWordCollection (@PathVariable("wordId") Integer wordId) {
        wordService.updateWordCollection0(wordId);
        return ResponseEntity.ok(wordId);
    }


}
