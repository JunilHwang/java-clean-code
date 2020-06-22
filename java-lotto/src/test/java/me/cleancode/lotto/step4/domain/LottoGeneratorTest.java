package me.cleancode.lotto.step4.domain;

import me.cleancode.lotto.step3.domain.Lotto;
import me.cleancode.lotto.step3.domain.LottoGenerator;
import me.cleancode.lotto.step3.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoGeneratorTest {

  @DisplayName("로또가 1 ~ 45 사이의 숫자로 생성되는지 검증")
  @Test
  void 로또_번호_범위_검증 () {
    int expected = 0;
    final BinaryOperator<Integer>
          reducer = (sum, v) -> sum + (v < me.cleancode.lotto.step3.domain.LottoNumber.MIN_VALUE || v > me.cleancode.lotto.step3.domain.LottoNumber.MAX_VALUE ? 1 : 0);
    for (int i = 0; i < 1000000; i++) {
      assertEquals(expected, me.cleancode.lotto.step3.domain.LottoGenerator.generateLotto()
                                           .stream()
                                           .map(LottoNumber::getNumber)
                                           .reduce(0, reducer));
    }
  }

  @DisplayName("로또가 1 ~ 45 사이의 숫자로 생성되는지 검증")
  @Test
  void 로또_번호_갯수_검증 () {
    long expected = Lotto.SIZE;
    for (int i = 0; i < 1000000; i++) {
      assertEquals(expected, LottoGenerator.generateLotto().stream().count());
    }
  }
}
