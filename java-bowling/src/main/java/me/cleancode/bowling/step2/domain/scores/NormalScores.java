package me.cleancode.bowling.step2.domain.scores;

import me.cleancode.bowling.step2.domain.Score;
import me.cleancode.bowling.step2.domain.ScoreType;

import java.util.List;
import java.util.stream.Stream;

public class NormalScores extends Scores {

    private NormalScores(Score firstScore, Score secondScore) {
        super(firstScore, secondScore);
    }

    public static NormalScores of(Score firstScore, Score secondScore) {
        return new NormalScores(firstScore, secondScore);
    }

    public static NormalScores init() {
        return of(null, null);
    }

    public static boolean isSparedOf(List<Score> scores) {
        if (scores.get(0) == Score.getStrike()) {
            return false;
        }
        return of(scores.get(0), scores.get(1)).isType(ScoreType.SPARED);
    }

    @Override
    public Scores nextInit(Score score) {
        if (firstScore == null) {
            return of(score, null);
        }
        return of(firstScore, score);
    }

    @Override
    public boolean isFullOf() {
        return firstScore != null && secondScore != null;
    }

    @Override
    public Stream<Score> stream() {
        return Stream.of(firstScore, secondScore);
    }
}