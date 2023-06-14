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

    @Value("${domain}")
    private String domain;

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
        mailMessage.setText("테스트입니다. 이곳에 리뷰 페이지 리다이렉트 링크가 들어갈 예정입니다.");
        sendEmail(mailMessage);
    }
}
