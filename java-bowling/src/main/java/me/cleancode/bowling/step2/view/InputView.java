package me.cleancode.bowling.step2.view;

import me.cleancode.bowling.step2.domain.Player;
import me.cleancode.bowling.step2.domain.Score;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final InputView INSTANCE = new InputView();

    private InputView() { }

    public Player inputName() {
        System.out.print("플레이어 이름은(3 english letters)?: ");
        return Player.valueOf(SCANNER.nextLine());
    }

    public Score inputScore(int frame) {
        System.out.printf("%d프레임 투구 : ", frame);
        return Score.stringOf(SCANNER.nextLine());
    }

    public static InputView getInstance() {
        return INSTANCE;
    }
}