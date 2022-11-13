package com.springboot.myenglish.service;

import com.github.pagehelper.PageInfo;
import com.springboot.myenglish.entity.WordEntity;

import java.util.List;

public interface WordService {
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
    //xoá một từ
    int deleteWord(Integer wordId);

    /**
     *#############################
     *          Cập nhật
     *#############################
     */
    //cập nhật một từ
    int updateWord(WordEntity word);

    //Sửa đổi một từ study thành 1
    int updateWordStudy1(Integer wordId);
    //Sửa đổi một từ study thành 0
    int updateWordStudy0(Integer wordId);

    //Sửa một từ remember thành 1
    int updateWordRemember1(Integer wordId);
    //Sửa một từ remember thành 0
    int updateWordRemember0(Integer wordId);


    //Sửa một từ collection thành 1
    int updateWordCollection1(Integer wordId);
    //Sửa một từ collection thành 0
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

    //Truy vấn phân trang

    PageInfo<WordEntity> queryAllCollectionWordByPage(int pageNum, int pageSize);


    PageInfo<WordEntity> queryWordByPages(int pageNum, int pageSize);
    /*
       ----------------------------
       Tìm hiểu chức năng (truy vấn một từ ngẫu nhiên từ cơ sở dữ liệu)
       ----------------------------
     */

    //Truy vấn các từ không được ghi nhớ dựa trên grade
    WordEntity queryWordStudy0ByGrade(Integer grade);

    //học lại từ
    int updateWordStudyByGrade(Integer grade);

    /*
       ---------------------------
            Chức năng sưu tập
       ---------------------------
     */
    //Tìm kiếm tất cả các từ yêu thích
    List<WordEntity> queryAllWordCollection();

    //Truy vấn các từ yêu thích theo Grade
    List<WordEntity> queryWordCollectionByGrade(Integer grade);


    /*
       ---------------------------
             Các tính năng được ghi nhớ và chưa được ghi nhớ
       ---------------------------
     */
    //Tìm tất cả các từ đã ghi nhớ
    List<WordEntity> queryAllRemember();

    //Truy vấn các từ đã ghi nhớ dựa trên grade
    List<WordEntity> queryAllWordRememberByGrade(Integer grade);

    //Tìm tất cả các từ chưa được ghi nhớ
    List<WordEntity> queryAllUnremembered();

    //Truy vấn các từ chưa ghi nhớ dựa trên grade
    List<WordEntity> queryAllWordUnrememberedByGrade(Integer grade);

    //Truy vấn phân trang sách từ mới
    PageInfo<WordEntity> queryAllUnrememberedByPageNum(Integer pageNum, Integer pageSize);

    /*
      ---------------------------
            Chức năng truy vấn số lượng
      ---------------------------
     */
    //Truy vấn số lượng từ dựa trên grade
    int queryAllWordNumberByGrade(Integer grade);

    //Truy vấn số lượng từ đã biết theo grade
    int queryRememberNumberByGrade(Integer grade);
    //Truy vấn số lượng từ đã học dựa trên grade
    int queryStudyNumberByGrade(Integer grade);
}
