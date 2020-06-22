package me.cleancode.lotto.step4.domain;

import me.cleancode.lotto.step3.domain.Lotto;
import me.cleancode.lotto.step3.domain.LottoNumber;
import me.cleancode.lotto.step3.domain.Rank;
import me.cleancode.lotto.step3.domain.WinningLotto;
import me.cleancode.lotto.step3.domain.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static me.cleancode.lotto.step3.domain.LottoGenerator.generateLotto;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinningLottoTest {

  private static final me.cleancode.lotto.step3.domain.LottoNumber BONUS_NUMBER = LottoNumber.of("7");

  @DisplayName("로또의 랭킹을 검증하는 테스트")
  @ParameterizedTest
  @MethodSource("provideWinningLottoAndLottoRank")
  void 로또_랭킹_테스트 (me.cleancode.lotto.step3.domain.WinningLotto winningLotto, Lotto lotto, me.cleancode.lotto.step3.domain.Rank expected) {
    assertEquals(expected, winningLotto.getRankOfLotto(lotto));
  }

  private static Stream<Arguments> provideWinningLottoAndLottoRank () {
    final me.cleancode.lotto.step3.domain.WinningLotto winningLotto = WinningLotto.of(
      LottoGenerator.generateLotto("1,2,3,4,5,6"),
      BONUS_NUMBER
    );
    return Stream.of(
      Arguments.of(winningLotto, LottoGenerator.generateLotto("1,2,3,4,5,6"), me.cleancode.lotto.step3.domain.Rank.FIRST),
      Arguments.of(winningLotto, LottoGenerator.generateLotto("1,2,3,4,5,7"), me.cleancode.lotto.step3.domain.Rank.SECOND),
      Arguments.of(winningLotto, LottoGenerator.generateLotto("1,2,3,4,5,8"), me.cleancode.lotto.step3.domain.Rank.THIRD),
      Arguments.of(winningLotto, LottoGenerator.generateLotto("1,2,3,4,8,7"), me.cleancode.lotto.step3.domain.Rank.FORTH),
      Arguments.of(winningLotto, LottoGenerator.generateLotto("1,2,3,9,8,7"), me.cleancode.lotto.step3.domain.Rank.FIFTH),
      Arguments.of(winningLotto, LottoGenerator.generateLotto("1,2,13,14,15,16"), me.cleancode.lotto.step3.domain.Rank.MISS),
      Arguments.of(winningLotto, LottoGenerator.generateLotto("1,12,13,14,15,16"), me.cleancode.lotto.step3.domain.Rank.MISS),
      Arguments.of(winningLotto, LottoGenerator.generateLotto("11,12,13,14,15,16"), Rank.MISS)
    );
  }
}
