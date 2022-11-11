package com.springboot.myenglish.entity;

import lombok.Data;

@Data
public class BookEntity {
    private int bookId;
    private String bookName;
    private String bookUser;
    private String description;
    private String content;
}
