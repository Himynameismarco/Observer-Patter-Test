package observerPatternTest;


import observerPatternTest.controller.Controller;
import observerPatternTest.model.Model;
import observerPatternTest.view.View;

public class Main {

  public static void main(String[] args) {
    Model model = new Model();
    View view = new View();
    Controller controller = new Controller(model, view);

    view.addListeners(controller);
    view.setVisible(true);
  }

}