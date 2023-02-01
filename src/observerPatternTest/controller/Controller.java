package observerPatternTest.controller;

import observerPatternTest.model.Model;
import observerPatternTest.view.View;

public class Controller {

  private final Model model;
  private final View view;

  public Controller(Model model, View view) {
    this.model = model;
    this.view = view;
  }

  public void updateMiles(int kilometers) {
    model.updateMiles(kilometers);
    view.updateSliderByName("KilometersSlider", model);
  }

  public void updateKilometers(int miles) {
    model.updateKilometers(miles);
    view.updateSliderByName("MilesSlider", model);
  }

  public int getKilometers() {
    return model.getKilometers();
  }

  public int getMiles() {
    return model.getMiles();
  }
}
