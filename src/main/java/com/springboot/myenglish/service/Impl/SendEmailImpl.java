package com.springboot.myenglish.service.Impl;

import com.springboot.myenglish.service.SendEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
public class SendEmailImpl implements SendEmail {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    JavaMailSenderImpl mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void SendEmail(String to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setSubject(subject);
            helper.setTo(to);
            helper.setText(content, true);
            mailSender.send(message);
            //log information
            logger.info("Mail đã được gửi。");
        } catch (MessagingException e) {
            logger.error("Đã xảy ra lỗi khi gửi email！", e);
        }

    }
}

