package me.cleancode.lotto.step4.controller;

import me.cleancode.lotto.step4.view.InputView;
import me.cleancode.lotto.step4.view.ResultView;
import me.cleancode.lotto.step4.domain.*;

import java.util.List;

public class LottoController {
  private final static InputView inputView = InputView.getInstance();
  private final static ResultView resultView = ResultView.getInstance();

  public static void main(String[] args) {

    long price = inputView.inputPrice();
    List<Lotto> lottosByDirectInput = inputView.inputLottoYourOwn();
    Lottos lottos = LottoShop.buyLotto(price, lottosByDirectInput);
    resultView.printLottoList(lottos);

    LottoResult lottoResult = LottoResult.of(lottos, WinningLotto.of(
      LottoGenerator.generateLotto(inputView.inputWinning()),
      inputView.inputBonus()
    ));

    resultView.printStat(lottoResult);
    resultView.printPayoffRatio(lottoResult.resultLottoGamePayOffRatio());

  }

}
