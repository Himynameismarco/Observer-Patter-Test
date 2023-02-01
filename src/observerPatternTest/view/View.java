package observerPatternTest.view;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import observerPatternTest.controller.Controller;
import observerPatternTest.model.Model;
import javax.swing.*;
import observerPatternTest.model.SlideListener;

public class View extends JFrame {

  private FlowLayout layout = new FlowLayout();

  private static final Model model = new Model();
  private static final Controller controller = new Controller(model);

  private static final int FRAME_WIDTH = 200;
  private static final int FRAME_HEIGHT = 500;
  private final Dimension frameDimension = new Dimension(FRAME_WIDTH, FRAME_HEIGHT);

  /**
   * Create the Graphical User Interface.
   *
   * @param model the model that handles the logic.
   * @param controller the controller that is used to communicate with the view.
   */
  public View(Model model, Controller controller) throws HeadlessException {
    this.setTitle("Distance");
    //this.model = model;
    //this.controller = controller;
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    //addEventListeners();
    setMinimumSize(frameDimension);
    setMaximumSize(frameDimension);
    setResizable(false);

    createView();
  }

  private void createView() {
    JPanel panel = new JPanel(layout);
    panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    panel.setMinimumSize(frameDimension);
    panel.setMaximumSize(frameDimension);
    setContentPane(panel);

    JLabel labelMiles = new JLabel();
    JLabel labelKilometers = new JLabel();

    JSlider sliderMiles = new JSlider(SwingConstants.HORIZONTAL, 0, 100, controller.getMiles());
    sliderMiles.setPaintTicks(true);
    sliderMiles.setPaintTrack(true);
    sliderMiles.setPaintLabels(true);
    sliderMiles.setName("MilesSlider");

    JSlider sliderKilometers = new JSlider(SwingConstants.HORIZONTAL, 0, 100,
        controller.getKilometers());
    sliderKilometers.setPaintTicks(true);
    sliderKilometers.setPaintTrack(true);
    sliderKilometers.setPaintLabels(true);
    sliderKilometers.setName("KilometersSlider");

    sliderKilometers.setMajorTickSpacing(20);
    sliderKilometers.setMinorTickSpacing(5);
    sliderMiles.setMajorTickSpacing(20);
    sliderMiles.setMinorTickSpacing(5);
    labelMiles.setText("Miles is =" + sliderMiles.getValue());
    labelKilometers.setText("Kilometers is =" + sliderKilometers.getValue());
    SlideListener slideListenerKilometers = new SlideListener(controller);
    sliderKilometers.addChangeListener(slideListenerKilometers);
    SlideListener slideListenerMiles = new SlideListener(controller);
    sliderMiles.addChangeListener(slideListenerMiles);

    panel.add(labelMiles);
    panel.add(sliderMiles);
    panel.add(labelKilometers);
    panel.add(sliderKilometers);

  }


}