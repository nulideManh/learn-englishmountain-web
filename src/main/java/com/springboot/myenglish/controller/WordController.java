package com.springboot.myenglish.controller;

import com.springboot.myenglish.entity.GradeEntity;
import com.springboot.myenglish.entity.WordEntity;
import com.springboot.myenglish.service.Impl.GradeServiceImpl;
import com.springboot.myenglish.service.Impl.WordServiceImpl;
import com.springboot.myenglish.util.DataUtils;
import com.springboot.myenglish.util.ProgressUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WordController {
    @Autowired
    private WordServiceImpl wordService;
    @Autowired
    GradeServiceImpl gradeService;
    @Autowired
    private ProgressUtils progressUtils;
    @Autowired
    private DataUtils dataUtils;


    /**
     * Học cách vận hành
     */
    //Chọn sách tiếng Anh
    @RequestMapping("/selectWord")
    public String SelectWord(Model model){
        List<GradeEntity> grades = gradeService.queryAllGrade();
        GradeEntity toeic = grades.get(0);
        GradeEntity ielts = grades.get(1);
        //lấy ra tùy chọn id
        model.addAttribute("toeic",toeic.getGradeId());
        model.addAttribute("ielts",ielts.getGradeId());

        /**
         * cấp độ là toeic, tìm ra số lượng từ ghi nhớ và số lượng tất cả các từ, và nhận phần trăm
         */

        int ToeicRemember = wordService.queryRememberNumberByGrade(toeic.getGradeId());
        int ToeicNumber = wordService.queryAllWordNumberByGrade(toeic.getGradeId());
        model.addAttribute("ToeicRemember",ToeicRemember);
        model.addAttribute("ToeicNumber", ToeicNumber );
        //Gọi cho lớp tiện ích để nhận phần trăm
        String percentToeic = dataUtils.percent(ToeicRemember, ToeicNumber);
        model.addAttribute("percentToeic",percentToeic);

        /**
         * Hoạt động ở cấp độ ielts, tìm ra số lượng từ đã ghi nhớ và số lượng tất cả các từ, và nhận phần trăm
         */
        int IeltsRemember = wordService.queryRememberNumberByGrade(ielts.getGradeId());
        int IeltsNumber = wordService.queryAllWordNumberByGrade(ielts.getGradeId());
        model.addAttribute("IeltsNumber",IeltsNumber);
        model.addAttribute("IeltsRemember",IeltsRemember);
        //Gọi cho lớp tiện ích để nhận phần trăm
        String percentIelts = dataUtils.percent(IeltsRemember, IeltsNumber);
        model.addAttribute("percentIelts",percentIelts);
        return "user/word/select-word";

    }

    //bắt đầu học từ
    @RequestMapping("/studyWord/{grade}")
    public String StudyWord(@PathVariable("grade") Integer grade,Model model){
        //Ghi nhớ các từ khác nhau theo các cấp độ khác nhau đã chọn
        WordEntity word = wordService.queryWordStudy0ByGrade(grade);
        //Nếu có, hãy lùi lại, nếu không, nó sẽ trống rỗng.
        if (word!=null){
            model.addAttribute("word",word);

            //Công cụ process dùng để hiển thị các trang động js
//            progressUtils.Progress(model,grade);
            //Kiểm tra xem một từ đã được đánh dấu chưa
            progressUtils.getCollection(model,word);

            return "user/word/study-word";
        }else {
//            progressUtils.Progress(model,grade);
            model.addAttribute("grade",grade);
            model.addAttribute("msg","Xin chúc mừng, bạn đã học xong từ này! Vui lòng chọn một từ khác để tiếp tục học hoặc nhấp vào nút bên phải để học lại！");
            return "user/word/empty-word";
        }
    }


    //   học từ tiếp theo
    @RequestMapping("/studyNextWord/{grade}")
    public String StudyNextWord(@PathVariable("grade") Integer grade){


        return "redirect:/studyWord/"+grade;
    }

    // Học lại các từ Toeic
    @RequestMapping("/ResetWord/{grade}")
    public String ResetWord(@PathVariable("grade") Integer grade,Model model){

        //Xóa study, remember:0
        wordService.updateWordStudyByGrade(grade) ;

        return "redirect:/studyWord/"+grade;
    }


    //Ghi nhớ từ từ, remember cơ sở dữ liệu được ghi là 1, hiển thị giải thích
    @RequestMapping("/rememberWord/{wordId}")
    public String RememberWord(@PathVariable("wordId") Integer wordId, Model model){

        WordEntity word = wordService.queryWordById(wordId);
        wordService.updateWordRemember1(wordId);
        model.addAttribute("word",word);
//        progressUtils.Progress(model,word.getGrade());
        //thành tích học tập cộng 1
        wordService.updateWordStudy1(word.getWordId());
        return "user/word/remember-word";
    }


    //Lần đầu tiên tôi quên, cơ sở dữ liệu không sửa đổi dữ liệu và hiển thị trực tiếp lời giải thích
    @RequestMapping("/unrememberWord/{wordId}")
    public String UnRememberWord(@PathVariable("wordId") int wordId,Model model){
        WordEntity word = wordService.queryWordById(wordId);
        wordService.updateWordRemember0(wordId);
        model.addAttribute("word",word);
//        progressUtils.Progress(model,word.getGrade());
        return "user/word/unremembered-word";
    }


    //Lần đầu nhớ, lần 2 quên, cơ sở dữ liệu được sửa thành nhớ thành 0, tiếp tục học từ tiếp theo
    @RequestMapping("/forgetWord/{wordId}")
    public String ForgetWord(@PathVariable("wordId")int wordId,Model model){
        wordService.updateWordRemember0(wordId);
        WordEntity word = wordService.queryWordById(wordId);
        Integer grade = word.getGrade();
        System.out.println("Đã quên từ này rồi！");
//        progressUtils.Progress(model,grade);
        return "redirect:/studyWord/"+grade;
    }

    //   thêm vào mục yêu thích
    @RequestMapping("/addCollection/{wordId}")
    public String AddCollection(@PathVariable("wordId")int wordId,Model model){
        //Hãy xem nếu từ này đã được yêu thích
        WordEntity word = wordService.queryWordById(wordId);

        //hiển thị từ
        model.addAttribute("word",word);
//        progressUtils.Progress(model,word.getGrade());
        //Nếu không được đánh dấu, thì hãy đánh dấu

        if (word.getCollection()==0 ){
            wordService.updateWordCollection1(wordId);
            model.addAttribute("msg","Sưu tập thành công");
        }else {//Yêu thích, không yêu thích
            wordService.updateWordCollection0(wordId);
            model.addAttribute("msg","Không thích");
        }

        return "user/word/study-word";
    }

    @RequestMapping("/toDetail")
    public String toDetail(Model model) {
        progressUtils.Progress(model, 1);
        progressUtils.Progress1(model, 2);
        return "user/learn-detail";
    }
}

