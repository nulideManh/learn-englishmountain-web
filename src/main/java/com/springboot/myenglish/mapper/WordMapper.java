package com.springboot.myenglish.mapper;

import com.springboot.myenglish.entity.WordEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WordMapper {


    /**
     * ############################
     * Thêm
     * #############################
     */
    //thêm một từ
    int addWord(WordEntity word);


    /**
     *#############################
     *          Xoá
     *#############################
     */
    //xóa một từ
    int deleteWord(Integer wordId);

    /**
     *#############################
     *          Cập nhật từ
     *#############################
     */
    //sửa đổi một từ
    int updateWord(WordEntity word);

    //Sửa đổi một từ study thành 1
    int updateWordStudy1(Integer wordId);
    //Sửa đổi một từ study thành 0
    int updateWordStudy0(Integer wordId);

    //Sửa đổi một từ remember thành 1
    int updateWordRemember1(Integer wordId);
    //Sửa đổi một từ remember thành 0
    int updateWordRemember0(Integer wordId);

    //Đặt lại các từ tiến trình học thành 0
    int updateWordStudyByGrade(Integer grade);


    //Sửa đổi collection từ thành 1
    int updateWordCollection1(Integer wordId);
    //Sửa đổi collection từ thành 1
    int updateWordCollection0(Integer wordId);

    /**
     *#############################
     *          Truy vấn
     *#############################
     */

    //Truy vấn tất cả thông tin từ
    List<WordEntity> queryAllWord();

    //Truy vấn thông tin về một từ theo ID
    WordEntity queryWordById(Integer wordId);

    /*
       ----------------------------
       Tìm hiểu chức năng (truy vấn một từ ngẫu nhiên từ cơ sở dữ liệu)
       ----------------------------
     */

    //Truy vấn các từ không được phân loại theo grade
    WordEntity queryWordStudy0ByGrade(Integer grade);


    /*
       ---------------------------
            Hàm yêu thích
       ---------------------------
     */
    //Tìm kiếm tất cả các từ yêu thích
    List<WordEntity> queryAllWordCollection();

    //Truy vấn các từ yêu thích theo Grade
    List<WordEntity> queryWordCollectionByGrade(Integer grade);


    /*
       ---------------------------
             Các từ được ghi nhớ và chưa được ghi nhớ
       ---------------------------
     */
    //Tìm tất cả các từ đã ghi nhớ
    List<WordEntity> queryAllRemember();

    //Truy vấn các từ đã nhớ dựa trên grade
    List<WordEntity> queryAllWordRememberByGrade(Integer grade);

    //Tìm tất cả các từ chưa được đánh dấu
    List<WordEntity> queryAllUnremembered();

    //Truy vấn các từ không được đánh dấu dựa trên grade
    List<WordEntity> queryAllWordUnrememberedByGrade(Integer grade);


    /*
      ---------------------------
            Hàm truy vấn số lượng
      ---------------------------
     */
    //Truy vấn số lượng từ dựa trên grade
    int queryAllWordNumberByGrade(Integer grade);
    //Truy vấn số lượng từ đã biết theo grade
    int queryRememberNumberByGrade(Integer grade);
    //Truy vấn số lượng từ đã học dựa trên grade
    int queryStudyNumberByGrade(Integer grade);

}

