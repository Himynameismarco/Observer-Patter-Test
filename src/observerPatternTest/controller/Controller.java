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

  public void updateMiles(int kilometer) {
    model.updateMiles(kilometer);
    view.updateSliderByName("MilesSlider", model);
  }

  public void updateKilometers(int miles) {
    model.updateKilometers(miles);
    view.updateSliderByName("KilometersSlider", model);
  }

  public int getKilometers() {
    return model.getKilometers();
  }

  public int getMiles() {
    return model.getMiles();
  }
}
