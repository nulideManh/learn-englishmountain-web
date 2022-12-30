package com.springboot.myenglish.mapper;

import com.springboot.myenglish.pojo.Word;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WordMapper {


    /**
     * ############################
     *          Add
     * #############################
     */
    int addWord(Word word);


    /**
     *#############################
     *          Delete
     *#############################
     */
    int deleteWord(Integer wordId);

    /**
     *#############################
     *          Update
     *#############################
     */
    int updateWord(Word word);

    int updateWordStudy1(Integer wordId);
    int updateWordStudy0(Integer wordId);

    int updateWordRemember1(Integer wordId);
    int updateWordRemember0(Integer wordId);

    int updateWordStudyByGrade(Integer grade);


    int updateWordCollection1(Integer wordId);
    int updateWordCollection0(Integer wordId);

    /**
     *#############################
     *          Truy vấn
     *#############################
     */

    List<Word> queryAllWord();

    List<Word> queryWordByKeyWords(String keyWords);

    Word queryWordById(Integer wordId);

    /*
       ----------------------------
          Truy vấn từ ngẫu nhiên
       ----------------------------
     */

    Word queryWordStudy0ByGrade(Integer grade);


    /*
       ---------------------------
             Yêu thich
       ---------------------------
     */
    List<Word> queryAllWordCollection();

    List<Word> queryWordCollectionByGrade(Integer grade);


    /*
       ---------------------------
        Ghi nhớ hoặc chưa ghi nhớ
       ---------------------------
     */
    List<Word> queryAllRemember();

    List<Word> queryAllWordRememberByGrade(Integer grade);

    List<Word> queryAllUnremembered();

    List<Word> queryAllWordUnrememberedByGrade(Integer grade);


    /*
      ---------------------------
            Truy vấn số lượng
      ---------------------------
     */
    int queryAllWordNumberByGrade(Integer grade);
    int queryRememberNumberByGrade(Integer grade);
    int queryStudyNumberByGrade(Integer grade);

}

