package com.duroop.dodom.domain.appointment.entity;

import com.duroop.dodom.audit.BaseTimeEntity;
import com.duroop.dodom.domain.appointmentTime.entity.AppointmentTime;
import com.duroop.dodom.domain.counselor.entity.Counselor;
import com.duroop.dodom.domain.review.entity.Review;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
@Table(name = "appointments")
public class Appointment extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    private String name;
    private String contact;
    private String email;
    private String result;
    private String inquiry;
    private String method;

    @OneToOne(mappedBy = "appointment", orphanRemoval = true)
    private Review review;

    @ManyToOne @JoinColumn(name = "counselor_id")
    private Counselor counselor;

    @OneToMany(mappedBy = "appointment")
    private List<AppointmentTime> time;

//    @OneToMany(mappedBy = "volunteer", cascade = CascadeType.PERSIST, orphanRemoval = true)
//    private List<Review> reviewList = new ArrayList<>();
}
