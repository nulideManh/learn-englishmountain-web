package com.springboot.myenglish.service;

import com.github.pagehelper.PageInfo;
import com.springboot.myenglish.pojo.Word;

import java.util.List;

public interface WordService {

    int addWord(Word word);


    int deleteWord(Integer wordId);

    int updateWord(Word word);

    int updateWordStudy1(Integer wordId);
    int updateWordStudy0(Integer wordId);


    int updateWordRemember1(Integer wordId);
    int updateWordRemember0(Integer wordId);


    int updateWordCollection1(Integer wordId);

    int updateWordCollection0(Integer wordId);


    List<Word> queryAllWord();


    Word queryWordById(Integer wordId);

    List<Word> queryWordByKeyWords(String keyWords);

    PageInfo<Word> queryAllCollectionWordByPage(int pageNum, int pageSize);


    PageInfo<Word> queryWordByPages(int pageNum, int pageSize);
    PageInfo<Word> queryWordSearchByPages(String keyWords, int pageNum, int pageSize);


    Word queryWordStudy0ByGrade(Integer grade);

    int updateWordStudyByGrade(Integer grade);


    List<Word> queryAllWordCollection();

    List<Word> queryWordCollectionByGrade(Integer grade);


    List<Word> queryAllRemember();

    List<Word> queryAllWordRememberByGrade(Integer grade);

    List<Word> queryAllUnremembered();

    List<Word> queryAllWordUnrememberedByGrade(Integer grade);

    PageInfo<Word> queryAllUnrememberedByPageNum(Integer pageNum, Integer pageSize);

    int queryAllWordNumberByGrade(Integer grade);

    int queryRememberNumberByGrade(Integer grade);
    int queryStudyNumberByGrade(Integer grade);



}

