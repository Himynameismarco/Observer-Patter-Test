package observerPatternTest.model;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import observerPatternTest.controller.Controller;

public class SlideListener implements EventListeners, ChangeListener {

  private boolean stateChangedWithinThisSecond = false;
  private final Controller controller;

  public SlideListener(Controller controller) {
    this.controller = controller;
  }

  @Override
  public void userUpdatesKilometers(int kilometers) {
    System.out.println("Listener: Kilometers: " + kilometers);
    controller.updateMiles(kilometers);
  }

  @Override
  public void userUpdatesMiles(int miles) {
    System.out.println("Listener: Miles: " + miles);
    controller.updateKilometers(miles);
  }

  @Override
  public void stateChanged(ChangeEvent e) {
    JSlider source = (JSlider)e.getSource();
    if (!source.getValueIsAdjusting()) {
      System.out.println("State of " + source.getName() + " changed.");
      int fps = (int)source.getValue();
      switch (source.getName()) {
        case "KilometersSlider":
          if (!stateChangedWithinThisSecond) {
            //userUpdatesKilometers(fps);
          }
          stateChangedWithinThisSecond = true;
          break;
        case "MilesSlider":
          if (!stateChangedWithinThisSecond) {
            userUpdatesMiles(fps);
          }
          stateChangedWithinThisSecond = true;
          break;
        default:
          throw new IllegalStateException();
      }
    }


  }
}
