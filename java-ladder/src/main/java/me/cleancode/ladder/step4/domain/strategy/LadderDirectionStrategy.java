package me.cleancode.ladder.step4.domain.strategy;

import me.cleancode.ladder.step4.domain.Direction;

public class LadderDirectionStrategy implements DirectionStrategy {

  private static final DirectionStrategy instance = new LadderDirectionStrategy();

  private LadderDirectionStrategy() {}

  @Override
  public Direction createBody(Direction prev) {
    if (prev == Direction.RIGHT) {
      return Direction.LEFT;
    }
    return Direction.createOptional(Direction.RIGHT);
  }

  @Override
  public Direction createTail(Direction prev) {
    if (prev == Direction.RIGHT) {
      return Direction.LEFT;
    }
    return Direction.EMPTY;
  }

  public static DirectionStrategy getInstance () {
    return instance;
  }
}
