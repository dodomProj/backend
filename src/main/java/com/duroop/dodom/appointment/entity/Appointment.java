package com.duroop.dodom.appointment.entity;

import com.duroop.dodom.counselor.entity.Counselor;
import com.duroop.dodom.review.entity.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class Appointment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime date;
    private String inquiry;
    private String method;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "review_id")
    private Review review;

    @ManyToOne @JoinColumn(name = "counselor_id")
    private Counselor counselor;
}
