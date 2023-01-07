package com.springboot.myenglish.controller;

import com.springboot.myenglish.pojo.Word;
import com.springboot.myenglish.service.Impl.GradeServiceImpl;
import com.springboot.myenglish.service.Impl.WordServiceImpl;
import com.springboot.myenglish.util.DataUtils;
import com.springboot.myenglish.util.ProgressUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/word")
public class WordController {
    @Autowired
    private WordServiceImpl wordService;
    @Autowired
    GradeServiceImpl gradeService;
    @Autowired
    private ProgressUtils progressUtils;
    @Autowired
    private DataUtils dataUtils;

    // bắt đầu học từ theo từng Unit
    @GetMapping("/study/{grade}")
    public ResponseEntity<?> StudyWord(@PathVariable("grade") Integer grade){
        // Các từ khác nhau theo các grade khác nhau
        Word word = wordService.queryWordStudy0ByGrade(grade);
        // Nếu có, nó sẽ được ghi nhớ, nếu không, prompt sẽ trống
        return ResponseEntity.ok(word);
    }


    // Những từ đã nhớ
    @GetMapping("/remember")
    public ResponseEntity<?> RememberWord(){
        return ResponseEntity.ok(wordService.queryAllRemember());
    }



    // Lần đầu nhớ, lần 2 quên, sửa remember về 0
    @RequestMapping("/forgot/{wordId}")
    public ResponseEntity<Word> ForgetWord(@PathVariable("wordId")int wordId){
        wordService.updateWordRemember0(wordId);
        Word word = wordService.queryWordById(wordId);
//        Integer grade = word.getGrade();
        System.out.println("Đã quên từ này rồi！");
//        progressUtils.Progress(model,grade);
        return ResponseEntity.ok(word);
    }

}
