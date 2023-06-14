package com.duroop.dodom.appointment.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;

public class AppointmentDto {

    @Builder @Getter
    public static class Post{
        private String email;
        @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
        private LocalDateTime date;
        private String inquiry;
        private String method;
        private Long counselorId;
    }

    @Getter
    public static class Response {
        private Long appointmentId;
    }
}
