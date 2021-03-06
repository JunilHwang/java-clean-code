package me.cleancode.bowling.step4.domain;

import java.util.List;

public enum ScoreType {
    STRIKE("X"),
    SPARED("/"),
    GUTTER("-");

    private final String value;

    ScoreType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String toScoreTypeValue(List<Score> scores, int index) {
        if (scores.get(index).isType(GUTTER)) {
            return GUTTER.getValue();
        }
        if (scores.get(index).isType(STRIKE)) {
            return STRIKE.getValue();
        }
        if (index == 1 && ScoresType.SPARED.of(scores)) {
            return SPARED.getValue();
        }
        return scores.get(index).toString();
    }
}
