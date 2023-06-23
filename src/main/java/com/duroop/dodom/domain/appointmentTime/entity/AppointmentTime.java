package com.duroop.dodom.domain.appointmentTime.entity;

import com.duroop.dodom.domain.appointment.entity.Appointment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentTime {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentTimeId;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime time;
    @ManyToOne @JoinColumn(name = "appointment_id")
    private Appointment appointment;
}
