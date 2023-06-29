package com.duroop.dodom.domain.appointment.dto;

import com.duroop.dodom.domain.counselor.entity.Counselor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

public class AppointmentDto {

    @Builder @Getter
    public static class Post{
        @NotBlank(message = "name must not be blank.")
        private String name;
        @NotBlank(message = "contact must not be blank.") @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 약식과 맞지 않습니다. 01x-xxx(x)-xxxx")
        private String contact;
        @NotBlank(message = "email must not be blank.") @Email
        private String email;
        @NotEmpty(message = "time must not be empty.") @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
        private List<LocalDateTime> timeList;
        @NotBlank(message = "type must not be blank.")
        private String type;
        @NotBlank(message = "result must not be blank.")
        private String result;
        private String inquiry;
        @NotBlank(message = "method must not be blank.")
        private String method;
        @NotNull @Positive
        private Long counselorId;
    }

    @Getter
    public static class Response {
        private Long appointmentId;
    }

    @Builder @Getter
    public static class reviewResponse{
        private boolean reviewExist;
        private Long counselorId;
    }
}
