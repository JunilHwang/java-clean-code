package me.cleancode.ladder.step3.domain;

import me.cleancode.ladder.step3.domain.strategy.LadderLineStrategy;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Ladder {
    private final List<LadderLine> ladder;

    private Ladder(List<LadderLine> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(Participants participants, LadderHeight height, LadderLineStrategy strategy) {
        int width = participants.size() - 1;
        List<LadderLine> ladder = IntStream.range(0, height.getValue())
                                           .mapToObj(h -> LadderLine.of(width, strategy))
                                           .collect(toList());
        return new Ladder(ladder);
    }

    public Stream<LadderLine> stream() {
        return ladder.stream();
    }
}
