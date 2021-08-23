package com.ms.consumer;

import com.ms.dto.EmailDto;
import com.ms.mapper.EmailMapper;
import com.ms.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDto emailDto) {
        var email = emailService.sendEmail(EmailMapper.map(emailDto));
        System.out.println("Email status: " + email.getStatusEmail().toString());

    }


}
