package me.cleancode.ladder.step2.view;

import me.cleancode.ladder.step2.domain.Ladder;
import me.cleancode.ladder.step2.domain.LadderLine;
import me.cleancode.ladder.step2.domain.Participants;

import static java.util.stream.Collectors.joining;

public class ResultView {
  private static final ResultView INSTANCE = new ResultView();
  private static final String IS_LINE = "-----|";
  private static final String NO_LINE = "     |";
  private static final String NEW_LINE = System.lineSeparator();

  private ResultView () { }

  public void viewLadder (Ladder ladder, Participants participants) {
    System.out.printf(
      NEW_LINE + "실행결과" + NEW_LINE + "%s" + NEW_LINE + "%s",
      toStringOfParticipants(participants),
      toStringOfLadder(ladder)
    );
  }

  private String toStringOfParticipants (Participants participants) {
    return participants.stream()
                       .map(participant -> String.format("%6s", participant.getName()))
                       .collect(joining(""));
  }

  private static String toStringOfLadder (Ladder ladder) {
    return ladder.stream()
                 .map(ResultView::toStringOfLadderLine)
                 .collect(joining(NEW_LINE));
  }

  private static String toStringOfLadderLine (LadderLine ladderLine) {
    return NO_LINE + ladderLine.stream()
                               .map(v -> v ? IS_LINE : NO_LINE)
                               .collect(joining(""));
  }

  public static ResultView getInstance () {
    return INSTANCE;
  }

}
