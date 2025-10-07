package com.ms.user.dtos;

public class EmailDTO{

    private Long userId;
    private String emailTo;
    private String subject;
    private  String text;

    public EmailDTO(Long userId, String emailTo, String subject, String text) {
        this.userId = userId;
        this.emailTo = emailTo;
        this.subject = subject;
        this.text = text;
    }

    public EmailDTO() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}