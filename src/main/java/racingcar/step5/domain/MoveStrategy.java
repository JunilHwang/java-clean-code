package racingcar.step5.domain;

public interface MoveStrategy {
  boolean isMoved();
  boolean isMoved(int number);
}
