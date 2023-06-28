package com.duroop.dodom.email;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class EmailService {

    @Value("${s3domain}")
    private String s3domain;

    private final JavaMailSender javaMailSender;

    @Async
    public void sendEmail(SimpleMailMessage email){
        javaMailSender.send(email);
    }

    public void createEmail(Long appointmentId, String receiverEmail){

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("dodomsduroop@gmail.com");
        mailMessage.setTo(receiverEmail);
        mailMessage.setSubject("도돔에 대한 후기 작성");
        mailMessage.setText(s3domain + "/survey?appointmentId="+appointmentId);
        sendEmail(mailMessage);
    }
}
