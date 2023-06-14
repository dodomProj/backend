package com.duroop.dodom.score.entity;

import com.duroop.dodom.audit.BaseTimeEntity;
import com.duroop.dodom.counselor.entity.Counselor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class Score extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scoreId;

    private Double score = 5.0;

    private int count = 1;

}
