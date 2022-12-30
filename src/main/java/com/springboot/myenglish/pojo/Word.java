package com.springboot.myenglish.pojo;

import lombok.Data;

@Data
public class Word {
    private static final long serialVersionUID = -45047932150360127L;
    private Integer wordId;
    private String wordName;
    private String audio;
    private String explanation;
    private String englishInstance1;
    private String vietnameseInstance1;
    private String englishInstance2;
    private String vietnameseInstance2;
    private String pron;
    private Integer grade;
    private Integer study;
    private Integer remember;
    private Integer collection;
}
