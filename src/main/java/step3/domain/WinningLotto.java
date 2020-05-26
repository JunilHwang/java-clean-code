package step3.domain;

public class WinningLotto {

  private final Lotto winningLotto;
  private final LottoNumber bonusNumber;

  private WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
    this.winningLotto = lotto;
    this.bonusNumber = bonusNumber;
  }

  public Rank getRankOfLotto (Lotto lotto) {
    long same = winningLotto.sameCount(lotto);
    boolean matchBonus = lotto.has(bonusNumber);
    return Rank.valueOf(same, matchBonus);
  }

}
