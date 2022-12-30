package com.springboot.myenglish.util;

import com.springboot.myenglish.pojo.Word;
import com.springboot.myenglish.service.Impl.WordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Gọi DataUtils để xử lý phần trăm tạo dữ liệu，
 * Sau đó, chuyển giá trị cho trang
 */
@Controller
public class ProgressUtils {
    @Autowired
    WordServiceImpl wordService;

    @Autowired
    DataUtils dataUtils;

    public void Progress(Integer grade) {

        int Remember = wordService.queryRememberNumberByGrade(grade);
        int Number = wordService.queryAllWordNumberByGrade(grade);
        int study = wordService.queryStudyNumberByGrade(grade);
        String studypercent = dataUtils.percent(study, Number);
        String percent = dataUtils.percent(Remember, Number);
        String unpercent = dataUtils.unpercent(Remember, Number);

        return;
    }

    public void Progress1(Integer grade) {

        int Remember = wordService.queryRememberNumberByGrade(grade);
        int Number = wordService.queryAllWordNumberByGrade(grade);
        int study = wordService.queryStudyNumberByGrade(grade);
        String studypercent = dataUtils.percent(study, Number);
        String percent = dataUtils.percent(Remember, Number);
        String unpercent = dataUtils.unpercent(Remember, Number);

        return;
    }

    // Nhận thông tin collection
    public void getCollection(Word word) {

        //Truy vấn xem một từ đã được yêu thích chưa
        Integer collection = word.getCollection();
        if (collection == 0) {
            System.out.println("add");
        } else {
            System.out.println("added");
        }
    }
}