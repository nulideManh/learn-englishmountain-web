package com.springboot.myenglish.service;

import com.springboot.myenglish.entity.GradeEntity;

import java.util.List;

public interface GradeService {
    //Truy vấn thông tin grade một dựa trên ID
    GradeEntity queryGradeById(Integer gradeId);

    //thêm grade
    int addGrade(GradeEntity grade);

    //xoá grade
    int deleteGrade(Integer gradeId);

    //Cập nhật grade
    int updateGrade(GradeEntity grade);

    //Xem tất cả thông tin grade
    List<GradeEntity> queryAllGrade();

}

