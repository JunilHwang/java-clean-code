package me.cleancode.ladder.step4.domain.strategy;

import me.cleancode.ladder.step4.domain.Direction;

public class ToggleDirectionStrategy implements DirectionStrategy {

    private static final DirectionStrategy instance = new ToggleDirectionStrategy();

    private ToggleDirectionStrategy() {}

    @Override
    public Direction createBody(Direction prev) {
        return Direction.toggle(prev);
    }

    @Override
    public Direction createTail(Direction prev) {
        return Direction.toggle(prev);
    }

    public static DirectionStrategy getInstance () {
        return instance;
    }
}
