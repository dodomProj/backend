package com.duroop.dodom.score.entity;

import com.duroop.dodom.counselor.entity.Counselor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Score {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scoreId;

    private Double score = 5.0;

}
