package com.duroop.dodom.domain.score.repository;


import com.duroop.dodom.domain.score.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}
