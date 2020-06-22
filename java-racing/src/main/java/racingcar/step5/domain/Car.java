package racingcar.step5.domain;

public class Car {
  private final String name;
  private int position;

  private Car(final String name) {
    this.name = name;
  }

  public Car move (MoveStrategy strategy) {
    if (strategy.isMoved())
      this.position += 1;
    return this;
  }

  public Car move (int n) {
    this.position += n;
    return this;
  }

  public int getPosition () {
    return this.position;
  }

  public String getName () {
    return this.name;
  }

  public static Car of (String name) {
    return new Car(name);
  }

  public static Car of () {
    return new Car("Car");
  }
}
