package step3.view;

import step3.Car;

import java.util.List;

public class ConsoleResultView implements ResultView {

  private ConsoleResultView () {};

  @Override
  public void print (List<Car> cars) {
    String result = "";
    for (Car car : cars) {
      result += car.toString() + "\n";
    }
    System.out.println(result);
  }

  public static ResultView of () { return new ConsoleResultView(); }

}
