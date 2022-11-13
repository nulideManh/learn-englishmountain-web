package com.springboot.myenglish.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.myenglish.entity.WordEntity;
import com.springboot.myenglish.mapper.WordMapper;
import com.springboot.myenglish.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {
    @Autowired
    private WordMapper wordMapper;

    @Override
    public int addWord(WordEntity word1) {
        return wordMapper.addWord(word1);
    }

    @Override
    public int deleteWord(Integer wordId) {
        return wordMapper.deleteWord(wordId);
    }

    @Override
    public int updateWord(WordEntity word1) {
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
    public List<WordEntity> queryAllWord() {
        return wordMapper.queryAllWord();
    }

    @Override
    public WordEntity queryWordById(Integer wordId) {
        return wordMapper.queryWordById(wordId);
    }

    /**
     * Truy vấn phân trang, sưu tập nội dung
     */

    @Override
    public PageInfo<WordEntity> queryAllCollectionWordByPage(int pageNum, int pageSize) {
        //Đặt thông tin phân trang, là số trang hiện tại và tổng số bản ghi được hiển thị trên mỗi trang
        PageHelper.startPage(pageNum, pageSize);
        //Tìm kiếm tất cả các từ yêu thích
        List<WordEntity> word = wordMapper.queryAllWordCollection();
        //Những gì được trả về là một PageInfo, chứa tất cả thông tin phân trang
        PageInfo<WordEntity> pageInfo = new PageInfo<WordEntity>(word);
        return pageInfo;

    }

    @Override
    public PageInfo<WordEntity> queryWordByPages(int pageNum, int pageSize) {
        //Đặt thông tin phân trang, là số trang hiện tại và tổng số bản ghi được hiển thị trên mỗi trang
        PageHelper.startPage(pageNum, pageSize);
        //Tìm kiếm tất cả các từ yêu thích
        List<WordEntity> word = wordMapper.queryAllWord();
        //Những gì được trả về là một PageInfo, chứa tất cả thông tin phân trang
        PageInfo<WordEntity> pageInfo = new PageInfo<WordEntity>(word);
        return pageInfo;
    }

    @Override
    public WordEntity queryWordStudy0ByGrade(Integer grade) {
        return wordMapper.queryWordStudy0ByGrade(grade);
    }

    @Override
    public int updateWordStudyByGrade(Integer grade) {
        return wordMapper.updateWordStudyByGrade(grade);
    }


    @Override
    public List<WordEntity> queryAllWordCollection() {
        return wordMapper.queryAllWordCollection();
    }

    @Override
    public List<WordEntity> queryWordCollectionByGrade(Integer grade) {
        return wordMapper.queryWordCollectionByGrade(grade);
    }


    @Override
    public List<WordEntity> queryAllRemember() {
        return queryAllRemember();
    }

    @Override
    public List<WordEntity> queryAllWordRememberByGrade(Integer grade) {
        return wordMapper.queryAllWordRememberByGrade(grade);
    }


    @Override
    public List<WordEntity> queryAllUnremembered() {
        return wordMapper.queryAllUnremembered();
    }

    @Override
    public List<WordEntity> queryAllWordUnrememberedByGrade(Integer grade) {
        return wordMapper.queryAllWordUnrememberedByGrade(grade);
    }

    @Override
    public PageInfo<WordEntity> queryAllUnrememberedByPageNum(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<WordEntity> word1s = wordMapper.queryAllUnremembered();
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

