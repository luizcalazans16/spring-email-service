package com.ms.controller;

import com.ms.dto.EmailDto;
import com.ms.mapper.EmailMapper;
import com.ms.model.Email;
import com.ms.service.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/email-service")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<EmailDto> sendEmail(@RequestBody @Valid EmailDto emailDto) {
        var email = emailService.sendEmail(EmailMapper.map(emailDto));

        return new ResponseEntity<>(EmailMapper.map(email),
                HttpStatus.CREATED);
    }
}
