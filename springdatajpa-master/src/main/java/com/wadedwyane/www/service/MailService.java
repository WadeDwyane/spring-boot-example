package com.wadedwyane.www.service;

import com.wadedwyane.www.impl.IMailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
@EnableAutoConfiguration
public class MailService implements IMailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Value("${mail.fromMail.addr}")
    private String from;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);

        try {
            javaMailSender.send(simpleMailMessage);
            logger.info("简单邮件发送成功");
        }catch (Exception exception) {
            logger.error("简单邮件发送出现异常", exception);
        }
    }

    @Override
    public void sendAttachmentMail(String to, String subject, String content, String fileName) {

    }

    @Override
    public void sendTemplateMail(String to, String subject, String templateName) {

    }
}
