package bowling.step3.domain.frame;

import bowling.step3.domain.ScoreType;
import bowling.step3.domain.scores.Scores;

public abstract class Frame {
    public static final int EMPTY_CALC = -1;

    protected final int frame;
    protected Scores scores;

    protected Frame(int frame, Scores scores) {
        this.frame = frame;
        this.scores = scores;
    }

    public Scores getScores() {
        return scores;
    }

    public int getValue() {
        return frame;
    }

    public int calculateScore() {
        if (scores == null || !scores.isFull()) {
            return EMPTY_CALC;
        }
        if (scores.isType(ScoreType.STRIKE)) {
            return calculateScoreOfStrike();
        }
        if (scores.isType(ScoreType.SPARED)) {
            return calculateScoreOfSpared();
        }
        return scores.totalScore();
    }

    abstract protected int calculateScoreOfSpared();

    abstract protected int calculateScoreOfStrike();

    abstract protected int calculateScoreOfTwoStrike(int totalScore);

    abstract public void createNextFrameOfScores(Scores scores);

    abstract public Frame getNextFrame();
}