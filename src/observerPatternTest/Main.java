package observerPatternTest;


import observerPatternTest.controller.Controller;
import observerPatternTest.model.Model;
import observerPatternTest.view.View;

public class Main {

  public static void main(String[] args) {
    Model model = new Model();
    Controller controller = new Controller(model);
    View view = new View(model, controller);
    view.setVisible(true);
  }

}