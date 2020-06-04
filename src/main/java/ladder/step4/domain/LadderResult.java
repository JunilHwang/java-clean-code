package ladder.step4.domain;

import ladder.step4.exception.LadderResultMaximumSizeException;

import java.util.HashMap;
import java.util.Map;

public class LadderResult {
    private static final Map<String, LadderResult> FACTORY = new HashMap<>();

    private final String value;

    private LadderResult(String value) {
        this.value = value;
    }

    public static LadderResult valueOf(String value) {
        validate(value);
        if (FACTORY.get(value) == null) {
            FACTORY.put(value, new LadderResult(value));
        }
        return FACTORY.get(value);
    }

    public static void validate(String value) {
        if (value.length() > 5) {
            throw new LadderResultMaximumSizeException();
        }
    }

    public String getValue() {
        return value;
    }
}
