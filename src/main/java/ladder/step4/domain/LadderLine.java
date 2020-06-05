package ladder.step4.domain;

import ladder.step4.domain.strategy.DirectionStrategy;
import ladder.step4.domain.strategy.TailDirectionStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderLine {
    private final List<LadderPoint> lines;

    private LadderLine(List<LadderPoint> lines) {
        this.lines = lines;
    }

    public static LadderLine of(int countOfPerson, DirectionStrategy strategy) {
        final List<LadderPoint> ladderLine = new ArrayList<>();
        init(ladderLine, countOfPerson, strategy);
        return new LadderLine(ladderLine);
    }

    static private void init (List<LadderPoint> lines, int countOfPerson, DirectionStrategy strategy) {
        Direction prev = Direction.EMPTY;
        int i = 0;
        for (; i < countOfPerson - 1; i++) {
            Direction direction = strategy.create(prev);
            lines.add(LadderPoint.of(i, direction));
            prev = direction;
        }
        Direction tailDirection = TailDirectionStrategy.getInstance().create(prev);
        lines.add(LadderPoint.of(i, tailDirection));
    }

    public Stream<LadderPoint> stream() {
        return lines.stream();
    }

    public int move (int index) {
        return lines.get(index).move();
    }
}
