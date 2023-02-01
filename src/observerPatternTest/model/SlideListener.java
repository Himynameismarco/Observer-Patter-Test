package observerPatternTest.model;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import observerPatternTest.controller.Controller;

public class SlideListener implements EventListeners, ChangeListener {

  private final Controller controller;
  public SlideListener(Controller controller) {
    this.controller = controller;
  }

  @Override
  public void kilometersUpdated(int value) {
    System.out.println("Kilometers: " + value);
    controller.updateKilometers(value);
  }

  @Override
  public void milesUpdated(int value) {
    System.out.println("Miles: " + value);
    controller.updateMiles(value);
  }

  @Override
  public void stateChanged(ChangeEvent e) {
    JSlider source = (JSlider)e.getSource();
    if (!source.getValueIsAdjusting()) {
      int fps = (int)source.getValue();
      switch (source.getName()) {
        case "KilometersSlider":
          kilometersUpdated(fps);
          break;
        case "MilesSlider":
          milesUpdated(fps);
          break;
        default:
          throw new IllegalStateException();
      }
    }

  }
}
