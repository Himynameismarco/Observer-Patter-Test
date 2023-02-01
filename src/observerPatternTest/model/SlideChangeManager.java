package observerPatternTest.model;

import java.util.ArrayList;

public class SlideChangeManager {

  private ArrayList<SlideListener> listeners = new ArrayList<>();

  public void subscribe(SlideListener slideListener) {
    listeners.add(slideListener);
  }

  public void notifyView() {

  }

}
