package observerPatternTest.view;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import javax.sound.sampled.Control;
import observerPatternTest.controller.Controller;
import observerPatternTest.model.Model;
import javax.swing.*;
import observerPatternTest.model.SlideListener;

public class View extends JFrame {

  private FlowLayout layout = new FlowLayout();

  private static final int FRAME_WIDTH = 200;
  private static final int FRAME_HEIGHT = 500;
  private final Dimension frameDimension = new Dimension(FRAME_WIDTH, FRAME_HEIGHT);
  JPanel panel = new JPanel(layout);

  JLabel labelMiles = new JLabel();
  JLabel labelKilometers = new JLabel();
  JSlider sliderKilometers = new JSlider( 0, 100);
  JSlider sliderMiles = new JSlider( 0, 100);

  /**
   * Create the Graphical User Interface.
   *
   */
  public View() throws HeadlessException {
    this.setTitle("Distance");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    //addEventListeners();
    setMinimumSize(frameDimension);
    setMaximumSize(frameDimension);
    setResizable(false);

    createView();
  }

  private void createView() {
    panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    panel.setMinimumSize(frameDimension);
    panel.setMaximumSize(frameDimension);
    setContentPane(panel);

    sliderMiles.setPaintTicks(true);
    sliderMiles.setPaintTrack(true);
    sliderMiles.setPaintLabels(true);
    sliderMiles.setName("MilesSlider");
    sliderMiles.setValue(50);

    sliderKilometers.setPaintTicks(true);
    sliderKilometers.setPaintTrack(true);
    sliderKilometers.setPaintLabels(true);
    sliderKilometers.setName("KilometersSlider");
    sliderKilometers.setValue(50);

    sliderKilometers.setMajorTickSpacing(20);
    sliderKilometers.setMinorTickSpacing(5);
    sliderMiles.setMajorTickSpacing(20);
    sliderMiles.setMinorTickSpacing(5);
    labelMiles.setText("Miles is =" + sliderMiles.getValue());
    labelKilometers.setText("Kilometers is =" + sliderKilometers.getValue());

    panel.add(labelMiles);
    panel.add(sliderMiles);
    panel.add(labelKilometers);
    panel.add(sliderKilometers);

  }

  public void addListeners(Controller controller) {
    SlideListener slideListenerKilometers = new SlideListener(controller);
    sliderKilometers.addChangeListener(slideListenerKilometers);
    SlideListener slideListenerMiles = new SlideListener(controller);
    sliderMiles.addChangeListener(slideListenerMiles);
  }

  public void updateSliderByName(String name, Model model) {
    switch (name) {
      case "KilometersSlider":
        labelMiles.setText("Miles is =" + model.getMiles());
        labelKilometers.setText("Kilometers is =" + model.getKilometers());
        sliderKilometers.setValue(model.getKilometers());
        break;
      case "MilesSlider":
        labelMiles.setText("Miles is =" + model.getMiles());
        labelKilometers.setText("Kilometers is =" + model.getKilometers());
        sliderMiles.setValue(model.getMiles());
        break;
      default:
        throw new IllegalStateException();
    }

  }


}