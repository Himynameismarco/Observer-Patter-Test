package observerPatternTest.controller;

import observerPatternTest.model.Model;

public class Controller {

  private final Model model;

  public Controller(Model model) {
    this.model = new Model();
  }

  public void updateMiles(int kilometers) {
    model.updateMiles(kilometers);
  }

  public void updateKilometers(int miles) {
    model.updateKilometers(miles);
  }

  public float getConversionRate() {
    return model.getCONVERSION_RATE();
  }

  public int getStartValue() {
    return model.getSTART_VALUE_MILES();
  }

  public int getKilometers() {
    return model.getKilometers();
  }

  public int getMiles() {
    return model.getMiles();
  }
}
