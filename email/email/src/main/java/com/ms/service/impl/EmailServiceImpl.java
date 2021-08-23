package com.ms.service.impl;

import com.ms.enums.StatusEmailEnum;
import com.ms.model.Email;
import com.ms.repository.EmailRepository;
import com.ms.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public Email sendEmail(Email email) {
        email.setSendDateEmail(LocalDateTime.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            emailSender.send(message);

            email.setStatusEmail(StatusEmailEnum.SENT);
        } catch (MailException e) {
            email.setStatusEmail(StatusEmailEnum.ERROR);
        }
        return emailRepository.save(email);
    }
}
