package com.springboot.myenglish.mapper;

import com.springboot.myenglish.entity.GradeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface GradeMapper {
    //Truy vấn thông tin grade dựa trên ID
    GradeEntity queryGradeById(Integer gradeId);
    //thêm grade
    int addGrade(GradeEntity grade);
    //Xoá grade
    int deleteGrade(Integer gradeId);
    //cập nhật grade
    int updateGrade(GradeEntity grade);
    //Xem tất cả thông tin grade
    List<GradeEntity> queryAllGrade();
}

