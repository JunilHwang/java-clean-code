package step3.view;

import step3.Car;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultView {

  private ResultView() {};

  public void printResultText () {
    System.out.println("실행 결과");
  }

  public void printRace (Stream<Car> stream) {
    System.out.println(
      stream.map(car -> car.getPositionString()).collect(Collectors.joining("\n"))
      + "\n"
    );
  }

  public static ResultView of () { return new ResultView(); }

}
