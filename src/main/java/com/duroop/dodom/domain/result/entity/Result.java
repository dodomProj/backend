package com.duroop.dodom.domain.result.entity;

import com.duroop.dodom.domain.appointment.entity.Appointment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long resultId;
    private String type;
    private String result;

    @OneToOne @JoinColumn(name = "appointment_id")
    private Appointment appointment;
}
