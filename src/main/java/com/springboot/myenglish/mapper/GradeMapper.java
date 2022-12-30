package com.springboot.myenglish.mapper;

import com.springboot.myenglish.pojo.Grade;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface GradeMapper {
    Grade queryGradeById(Integer gradeId);
    int addGrade(Grade grade);
    int deleteGrade(Integer gradeId);
    int updateGrade(Grade grade);
    List<Grade> queryAllGrade();
}
