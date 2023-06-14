package com.duroop.dodom.score.service;

import com.duroop.dodom.counselor.entity.Counselor;
import com.duroop.dodom.score.entity.Score;
import com.duroop.dodom.score.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScoreService {

    private final ScoreRepository scoreRepository;

    public void patchScore(Counselor counselor, double plusScore){

        Score score = getOriginScore(counselor);

        double newScore = calculateScore(score.getScore(),plusScore, score.getCount());
        score.setScore(newScore);

        scoreRepository.save(score);
    }

    private Score getOriginScore(Counselor counselor) {
        return counselor.getScore();
    }

    private double calculateScore(double origin, double plus, int count) {
        log.info("count : " + count);
        log.info("sum : " + origin * count);
        double num = (origin * count + plus) / (count + 1);
        return Math.round(num * 100) / 100.0;
    }

}
