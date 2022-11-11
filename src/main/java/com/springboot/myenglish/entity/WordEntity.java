package com.springboot.myenglish.entity;

import lombok.Data;

@Data
public class WordEntity {
    private static final long serialVersionUID = -45047932150360127L;
    private Integer wordId;
    private String wordName;
    private String audio;
    private String explanation;
    private String englishinstance1;
    private String vietnameseinstance1;
    private String englishinstance2;
    private String vietnameseinstance2;
    private String pron;
    private Integer grade;
    private Integer study;
    private Integer remember;
    private Integer collection;
}
