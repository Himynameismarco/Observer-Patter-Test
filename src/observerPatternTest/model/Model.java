package observerPatternTest.model;

public class Model {

  private final int START_VALUE_MILES = 50;
  private final float CONVERSION_RATE = (float) 1.609344;
  private int miles = START_VALUE_MILES;
  private int kilometers = (int) (START_VALUE_MILES / CONVERSION_RATE);

  public Model() {
    this.miles = miles;
    this.kilometers = kilometers;
  }

  public void updateMiles(int kilometers) {
    System.out.println("Model: updating miles based on a kilometers value of " + kilometers);
    this.setKilometers(kilometers);
    this.setMiles((int) (kilometers / CONVERSION_RATE));
    System.out.println("Model: new miles: " + (int) (kilometers / CONVERSION_RATE));
  }

  public void updateKilometers(int miles) {
    System.out.println("Model: updating kilometers based on a miles value of " + miles);
    this.setMiles(miles);
    this.setKilometers((int) (CONVERSION_RATE * miles));
    System.out.println("Model: new kilometers: " + (int) (CONVERSION_RATE * miles));
  }

  public void setMiles(int miles) {
    this.miles = miles;
  }

  public void setKilometers(int kilometers) {
    this.kilometers = kilometers;
  }

  public int getMiles() {
    return miles;
  }

  public int getKilometers() {
    return kilometers;
  }
}
