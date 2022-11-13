package com.springboot.myenglish.util;

import com.springboot.myenglish.entity.WordEntity;
import com.springboot.myenglish.service.Impl.WordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class ProgressUtils {
    @Autowired
    WordServiceImpl wordService;

    @Autowired
    DataUtils dataUtils;
    public void Progress(Model model,Integer grade){

        int Remember = wordService.queryRememberNumberByGrade(grade);
        int Number = wordService.queryAllWordNumberByGrade(grade);
        int study = wordService.queryStudyNumberByGrade(grade);
        String studypercent = dataUtils.percent(study, Number);
        String percent = dataUtils.percent(Remember, Number);
        String unpercent = dataUtils.unpercent(Remember, Number);

        model.addAttribute("remember",percent);
        model.addAttribute("unremembered",unpercent);
        model.addAttribute("study",studypercent);

        return;
    }

    public void Progress1(Model model,Integer grade){

        int Remember = wordService.queryRememberNumberByGrade(grade);
        int Number = wordService.queryAllWordNumberByGrade(grade);
        int study = wordService.queryStudyNumberByGrade(grade);
        String studypercent = dataUtils.percent(study, Number);
        String percent = dataUtils.percent(Remember, Number);
        String unpercent = dataUtils.unpercent(Remember, Number);

        model.addAttribute("remember1", percent);
        model.addAttribute("unremembered1", unpercent);
        model.addAttribute("study1", studypercent);

        return;
    }

    //nhận được thông tin sưu tập
    public void getCollection(Model model, WordEntity word) {

        //Kiểm tra xem một từ đã được ghi nhớ chưa
        Integer collection = word.getCollection();
        if (collection == 0) {
            model.addAttribute("msg", "Thêm vào bộ sưu tập");
        } else {
            model.addAttribute("msg", "Đã sưu tập");
        }
    }
}

