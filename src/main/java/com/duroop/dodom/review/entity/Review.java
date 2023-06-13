package com.duroop.dodom.review.entity;

import com.duroop.dodom.appointment.entity.Appointment;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private String name;
    private double score;
    private String review1;
    private String review2;

    @OneToOne
    private Appointment appointment;
}
