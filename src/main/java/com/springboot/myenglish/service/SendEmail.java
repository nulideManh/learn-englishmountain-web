package com.springboot.myenglish.service;

public interface SendEmail {

    void SendEmail(String to, String subject, String content);
}
