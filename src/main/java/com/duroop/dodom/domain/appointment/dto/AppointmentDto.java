package com.duroop.dodom.domain.appointment.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.List;

public class AppointmentDto {

    @Builder @Getter
    public static class Post{
        private String name;
        private String contact;
        private String email;
        @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
        private List<LocalDateTime> timeList;
        private String type;
        private String result;
        private String inquiry;
        private String method;
        private Long counselorId;
    }

    @Getter
    public static class Response {
        private Long appointmentId;
    }
}
