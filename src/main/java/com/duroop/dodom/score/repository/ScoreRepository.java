package com.duroop.dodom.score.repository;


import com.duroop.dodom.score.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}
