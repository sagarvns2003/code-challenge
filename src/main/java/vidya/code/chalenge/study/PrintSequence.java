package vidya.code.chalenge.study;

class Sequence {

  private int state = 0;
  private int count = 1;
  private final int maxCount = 4;

  public synchronized void printZero() {
    for (int i = 0; i <= maxCount; i++) {
      while (state % 3 != 0) {
        try {
          wait();
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }
      System.out.print(0 + " ");
      state++;
      notifyAll();
    }
  }

  public synchronized void printEven() {
    for (int i = 2; i <= maxCount * 2; i += 2) {
      while (state % 3 != 1) {
        try {
          wait();
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }
      System.out.print(i + " ");
      state++;
      notifyAll();
    }
  }

  public synchronized void printOdd() {
    for (int i = 1; i <= maxCount * 2; i += 2) {
      while (state % 3 != 2) {
        try {
          wait();
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }
      System.out.print(i + " ");
      state++;
      notifyAll();
    }
  }
}

public class PrintSequence {
  public static void main(String[] args) {
    Sequence sequence = new Sequence();

    Thread t1 = new Thread(sequence::printZero);
    Thread t2 = new Thread(sequence::printEven);
    Thread t3 = new Thread(sequence::printOdd);

    t1.start();
    t2.start();
    t3.start();
  }
}
