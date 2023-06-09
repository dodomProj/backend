package com.duroop.dodom.domain.counselor.entity;

import com.duroop.dodom.domain.appointment.entity.Appointment;
import com.duroop.dodom.audit.BaseTimeEntity;
import com.duroop.dodom.domain.score.entity.Score;
import com.duroop.dodom.domain.tag.entity.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "counselors")
public class Counselor extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long counselorId;
    private Integer career;
    private String introduce;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "score_id")
    private Score score;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @OneToMany(mappedBy = "counselor", orphanRemoval = true)
    @JsonIgnore
    private List<Appointment> appointments = new ArrayList<>();
}
