package me.cleancode.bowling.step3.controller;

import bowling.step3.view.*;
import me.cleancode.bowling.step3.domain.Player;
import me.cleancode.bowling.step3.domain.PlayerFrames;
import me.cleancode.bowling.step3.domain.ScoreType;
import me.cleancode.bowling.step3.domain.frame.Frame;
import me.cleancode.bowling.step3.domain.frame.NormalFrame;
import me.cleancode.bowling.step3.domain.scores.Scores;
import me.cleancode.bowling.step3.view.InputView;
import me.cleancode.bowling.step3.view.ResultView;

import java.util.Optional;

public class BowlingGame {
    private static final InputView inputView = InputView.getInstance();
    private static final ResultView resultView = ResultView.getInstance();

    private final PlayerFrames playerFrames;

    public BowlingGame(PlayerFrames playerFrames) {
        this.playerFrames = playerFrames;
    }

    private void frameView(Frame frame) {
        Scores scores = frame.getScores();
        frame.createNextFrameOfScores(scores.nextInit(inputView.inputScore(frame.getValue())));
        resultView.printFrames(playerFrames);
    }

    public void normalFrameView(Frame nowFrame) {
        frameView(nowFrame);
        if (!nowFrame.getScores().isType(ScoreType.STRIKE)) {
            frameView(nowFrame);
        }
    }

    public void finalFrameView(Frame frame) {
        frameView(frame);
        frameView(frame);
        Scores scores = frame.getScores();
        if (scores.isType(ScoreType.STRIKE) || scores.isType(ScoreType.SPARED)) {
            frameView(frame);
        }
    }

    public static void main(String[] args) {
        Player player = inputView.inputName();
        Frame temp = NormalFrame.start();
        PlayerFrames playerFrames = PlayerFrames.of(player, temp);

        BowlingGame game = new BowlingGame(playerFrames);

        resultView.printFrames(playerFrames);
        while (temp instanceof NormalFrame) {
            game.normalFrameView(temp);
            temp = Optional.ofNullable(temp.getNextFrame())
                           .orElse(temp);
        }
        game.finalFrameView(temp);
    }
}
