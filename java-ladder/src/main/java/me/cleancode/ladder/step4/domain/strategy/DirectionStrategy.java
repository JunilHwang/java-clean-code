package me.cleancode.ladder.step4.domain.strategy;

import me.cleancode.ladder.step4.domain.Direction;

public interface DirectionStrategy {
  Direction createBody(Direction prev);
  Direction createTail(Direction prev);
}
