package me.cleancode.lotto.step4.domain;

import me.cleancode.lotto.step3.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

  @DisplayName("보너스 볼과 일치하는 로또 번호로부터 랭크를 가져")
  @ParameterizedTest
  @MethodSource("provideEqualRank")
  void 랭크_일치_테스트 (int same, boolean matchBonus, me.cleancode.lotto.step3.domain.Rank expected) {
    assertThat(expected).isEqualTo(me.cleancode.lotto.step3.domain.Rank.valueOf(same, matchBonus));
  }

  private static Stream<Arguments> provideEqualRank () {
    return Stream.of(
      Arguments.of(1, true, me.cleancode.lotto.step3.domain.Rank.MISS),
      Arguments.of(1, false, me.cleancode.lotto.step3.domain.Rank.MISS),
      Arguments.of(2, true, me.cleancode.lotto.step3.domain.Rank.MISS),
      Arguments.of(2, false, me.cleancode.lotto.step3.domain.Rank.MISS),
      Arguments.of(3, true, me.cleancode.lotto.step3.domain.Rank.FIFTH),
      Arguments.of(3, false, me.cleancode.lotto.step3.domain.Rank.FIFTH),
      Arguments.of(4, true, me.cleancode.lotto.step3.domain.Rank.FORTH),
      Arguments.of(4, false, me.cleancode.lotto.step3.domain.Rank.FORTH),
      Arguments.of(5, true, me.cleancode.lotto.step3.domain.Rank.SECOND),
      Arguments.of(5, false, me.cleancode.lotto.step3.domain.Rank.THIRD),
      Arguments.of(6, true, me.cleancode.lotto.step3.domain.Rank.FIRST),
      Arguments.of(6, false, Rank.FIRST)
    );
  }
}
