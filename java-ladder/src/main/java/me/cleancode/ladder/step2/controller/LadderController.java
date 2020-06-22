package me.cleancode.ladder.step2.controller;

import me.cleancode.ladder.step2.domain.Ladder;
import me.cleancode.ladder.step2.domain.LadderHeight;
import me.cleancode.ladder.step2.domain.Participants;
import me.cleancode.ladder.step2.domain.strategy.LadderLineStrategyImpl;
import ladder.step2.view.*;
import me.cleancode.ladder.step2.view.InputView;
import me.cleancode.ladder.step2.view.ResultView;

public class LadderController {
  private static final InputView INPUT_VIEW = InputView.getInstance();
  private static final ResultView RESULT_VIEW = ResultView.getInstance();

  public static void main(String[] args) {
    Participants participants = INPUT_VIEW.inputParticipants();
    LadderHeight ladderHeight = INPUT_VIEW.inputHeight();

    Ladder ladder = Ladder.of(
      participants,
      ladderHeight,
      LadderLineStrategyImpl.getInstance()
    );

    RESULT_VIEW.viewLadder(ladder, participants);
  }
}
