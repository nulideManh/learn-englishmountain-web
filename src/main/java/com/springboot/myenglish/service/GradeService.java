package com.springboot.myenglish.service;



import com.springboot.myenglish.pojo.Grade;

import java.util.List;

public interface GradeService {
    //Truy vấn thông tin grade một dựa trên ID
    Grade queryGradeById(Integer gradeId);

    //thêm grade
    int addGrade(Grade grade);

    //xoá grade
    int deleteGrade(Integer gradeId);

    //Cập nhật grade
    int updateGrade(Grade grade);

    //Xem tất cả thông tin grade
    List<Grade> queryAllGrade();

}


