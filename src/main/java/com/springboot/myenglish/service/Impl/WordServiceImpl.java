package com.springboot.myenglish.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.myenglish.mapper.WordMapper;
import com.springboot.myenglish.pojo.Word;
import com.springboot.myenglish.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {
    @Autowired
    @Lazy
    private WordMapper wordMapper;

    @Override
    public int addWord(Word word1) {
        return wordMapper.addWord(word1);
    }

    @Override
    public int deleteWord(Integer wordId) {
        return wordMapper.deleteWord(wordId);
    }

    @Override
    public int updateWord(Word word1) {
        return wordMapper.updateWord(word1);
    }

    @Override
    public int updateWordStudy1(Integer wordId) {
        return wordMapper.updateWordStudy1(wordId);
    }

    @Override
    public int updateWordStudy0(Integer wordId) {
        return wordMapper.updateWordStudy0(wordId);
    }

    @Override
    public int updateWordRemember1(Integer wordId) {
        return wordMapper.updateWordRemember1(wordId);
    }

    @Override
    public int updateWordRemember0(Integer wordId) {
        return wordMapper.updateWordRemember0(wordId);
    }




    @Override
    public int updateWordCollection1(Integer wordId) {
        return wordMapper.updateWordCollection1(wordId);
    }

    @Override
    public int updateWordCollection0(Integer wordId) {
        return wordMapper.updateWordCollection0(wordId);
    }

    @Override
    public List<Word> queryAllWord() {
        return wordMapper.queryAllWord();
    }
    @Override
    public List<Word> queryWordByKeyWords(String keyWords) {
        return wordMapper.queryWordByKeyWords(keyWords);
    }

    @Override
    public Word queryWordById(Integer wordId) {
        return wordMapper.queryWordById(wordId);
    }

    @Override
    public PageInfo<Word> queryAllCollectionWordByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Word> word = wordMapper.queryAllWordCollection();
        PageInfo<Word> pageInfo = new PageInfo<Word>(word);
        return pageInfo;
    }
    @Override
    public PageInfo<Word> queryWordSearchByPages(String keyWords,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Word> word = wordMapper.queryWordByKeyWords(keyWords);
        PageInfo<Word> pageInfo = new PageInfo<Word>(word);
        return pageInfo;
    }

    @Override
    public PageInfo<Word> queryWordByPages(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Word> word = wordMapper.queryAllWord();
        PageInfo<Word> pageInfo = new PageInfo<Word>(word);
        return pageInfo;
    }

    @Override
    public Word queryWordStudy0ByGrade(Integer grade) {
        return wordMapper.queryWordStudy0ByGrade(grade);
    }

    @Override
    public int updateWordStudyByGrade(Integer grade) {
        return wordMapper.updateWordStudyByGrade(grade);
    }


    @Override
    public List<Word> queryAllWordCollection() {
        return wordMapper.queryAllWordCollection();
    }

    @Override
    public List<Word> queryWordCollectionByGrade(Integer grade) {
        return wordMapper.queryWordCollectionByGrade(grade);
    }


    @Override
    public List<Word> queryAllRemember() {
        return queryAllRemember();
    }

    @Override
    public List<Word> queryAllWordRememberByGrade(Integer grade) {
        return wordMapper.queryAllWordRememberByGrade(grade);
    }


    @Override
    public List<Word> queryAllUnremembered() {
        return wordMapper.queryAllUnremembered();
    }

    @Override
    public List<Word> queryAllWordUnrememberedByGrade(Integer grade) {
        return wordMapper.queryAllWordUnrememberedByGrade(grade);
    }

    @Override
    public PageInfo<Word> queryAllUnrememberedByPageNum(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Word> word1s = wordMapper.queryAllUnremembered();
        return new PageInfo<>(word1s);
    }

    @Override
    public int queryAllWordNumberByGrade(Integer grade) {
        return wordMapper.queryAllWordNumberByGrade(grade);
    }

    @Override
    public int queryRememberNumberByGrade(Integer grade) {
        return wordMapper.queryRememberNumberByGrade(grade);
    }

    @Override
    public int queryStudyNumberByGrade(Integer grade) {
        return wordMapper.queryStudyNumberByGrade(grade);
    }

}

