package com.ms.mail.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;    
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import com.ms.mail.entities.Email;
import com.ms.mail.services.EmailService;

import com.ms.mail.dtos.EmailDTO;

@Component
public class EmailConsumer {

 private final EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailDto dto){
        var email =  new Email();
        BeanUtils.copyProperties(dto, email);
        emailService.sendEmail(email);
        System.out.println("Email enviado");
    }


}