package com.duroop.dodom.domain.score.entity;

import com.duroop.dodom.audit.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
@Table(name = "scores")
public class Score extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scoreId;

    private Double score = 5.0;

    private int count = 1;

}
