package com.wadedwyane.www.impl;

public interface IMailService {

    void sendSimpleMail(String to, String subject, String content);

    void sendAttachmentMail(String to, String subject, String content, String fileName);

    void sendTemplateMail(String to, String subject, String templateName);

}
