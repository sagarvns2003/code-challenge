package vidya.code.chalenge.dp.behavior;

import java.util.ArrayList;
import java.util.List;

interface Observer {
  void update(String message);
}

class ConcreteObserver1 implements Observer {
  private String name;

  public ConcreteObserver1(String name) {
    this.name = name;
  }

  @Override
  public void update(String message) {
    System.out.println(name + " received message: " + message);
  }
}

class ConcreteObserver2 implements Observer {
  private String name;

  public ConcreteObserver2(String name) {
    this.name = name;
  }

  @Override
  public void update(String message) {
    System.out.println(name + " received message: " + message);
  }
}

class Subject {
  private List<Observer> observers = new ArrayList<>();
  private String message;

  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  public void notifyObservers() {
    for (Observer observer : observers) {
      observer.update(message);
    }
  }

  public void setMessage(String message) {
    this.message = message;
    notifyObservers();
  }
}

public class ObserverPatternDemo {
  public static void main(String[] args) {
    Subject subject = new Subject();

    Observer observer1 = new ConcreteObserver1("Observer 1");
    Observer observer2 = new ConcreteObserver2("Observer 2");

    subject.addObserver(observer1);
    subject.addObserver(observer2);

    subject.setMessage("Hello, Observers!");
    subject.setMessage("Another message for Observers!");
  }
}
