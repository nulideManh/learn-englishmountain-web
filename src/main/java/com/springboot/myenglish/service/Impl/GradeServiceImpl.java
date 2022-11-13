package com.springboot.myenglish.service.Impl;

import com.springboot.myenglish.entity.GradeEntity;
import com.springboot.myenglish.mapper.GradeMapper;
import com.springboot.myenglish.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    GradeMapper gradeMapper;

    @Override
    public GradeEntity queryGradeById(Integer gradeId) {
        return gradeMapper.queryGradeById(gradeId);
    }

    @Override
    public int addGrade(GradeEntity grade) {
        return gradeMapper.addGrade(grade);
    }

    @Override
    public int deleteGrade(Integer gradeId) {
        return gradeMapper.deleteGrade(gradeId);
    }

    @Override
    public int updateGrade(GradeEntity grade) {
        return gradeMapper.updateGrade(grade);
    }

    @Override
    public List<GradeEntity> queryAllGrade() {
        return gradeMapper.queryAllGrade();
    }
}

