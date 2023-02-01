package observerPatternTest.model;

public class Model {

  private final int START_VALUE_MILES = 50;
  private final float CONVERSION_RATE = (float) 1.609344;
  private int miles = START_VALUE_MILES;
  private int kilometers = (int) (START_VALUE_MILES / CONVERSION_RATE);

  public void updateMiles(int kilometers) {
    System.out.println("updating miles based on a kilometers value of " + kilometers);
    this.setMiles((int) (CONVERSION_RATE * kilometers));
  }

  public void updateKilometers(int miles) {
    System.out.println("updating kilometers based on a miles value of " + miles);
    this.setKilometers((int) (miles / CONVERSION_RATE));
  }

  public float getCONVERSION_RATE() {
    return CONVERSION_RATE;
  }

  public int getSTART_VALUE_MILES() {
    return START_VALUE_MILES;
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
