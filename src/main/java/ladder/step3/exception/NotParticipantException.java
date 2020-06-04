package ladder.step3.exception;

import ladder.step3.domain.Participant;

public class NotParticipantException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "%s는 참여자가 아닙니다.";

    public NotParticipantException(Participant participant) {
        super(String.format(ERROR_MESSAGE, participant.getValue()));
    }

}
