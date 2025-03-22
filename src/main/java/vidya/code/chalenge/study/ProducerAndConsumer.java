package vidya.code.chalenge.study;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerAndConsumer {

  public static void main(String[] args) {
    Queue<Order> orderQueue = new LinkedBlockingQueue<>();
    Thread producerThread = new Thread(new Producer(orderQueue));
    Thread consumerThread = new Thread(new Consumer(orderQueue));
    producerThread.start();
    consumerThread.start();
  }
}

record Order(int id, String name) {}

class Producer implements Runnable {

  private Queue<Order> orderQueue;

  public Producer(Queue<Order> orderQueue) {
    this.orderQueue = orderQueue;
  }

  @Override
  public void run() {
    for (int i = 1; i <= 10; i++) {
      String name = "Order" + i;
      orderQueue.add(new Order(i, name));
      System.out.println("Produced: " + name);
    }
  }
}

class Consumer implements Runnable {
  private Queue<Order> orderQueue;
  public Consumer(Queue<Order> orderQueue) {
    this.orderQueue = orderQueue;
  }

  @Override
  public void run() {
    while (true) {
      Order order = orderQueue.poll();
      if (order != null) {
        System.out.println("Consumed and Processed: " + order.name());
      }
    }
  }
}
