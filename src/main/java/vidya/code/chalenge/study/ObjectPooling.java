package vidya.code.chalenge.study;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ExpensiveObject {
  private int objectNumber;

  public ExpensiveObject(int objectNumber) {
    this.objectNumber = objectNumber;
  }

  public void doTask() {
    System.out.println("Task done with ExpensiveObject number: " + this.objectNumber);
  }
}

interface ObjectFactory<T> {
  T createObject(int objectNumber);
}

class ExpensiveObjectFactory implements ObjectFactory<ExpensiveObject> {
  @Override
  public ExpensiveObject createObject(int objectNumber) {
    return new ExpensiveObject(objectNumber);
  }
}

class ObjectPool<T> {
  private BlockingQueue<T> pool;

  public ObjectPool(int poolSize, ObjectFactory<T> objectFactory) {
    this.pool = new LinkedBlockingQueue<>(poolSize);
    for (int i = 1; i <= poolSize; i++) {
      this.pool.offer(objectFactory.createObject(i));
    }
  }

  public T borrowObject() throws InterruptedException {
    return pool.take();
  }

  public boolean returnObject(T poolObject) {
    return this.pool.offer(poolObject);
  }

  public int getPoolSize() {
    return this.pool.size();
  }
}

public class ObjectPooling {

  public static void main(String[] args) {
    ObjectPool<ExpensiveObject> pool = new ObjectPool<>(5, new ExpensiveObjectFactory());
    System.out.println("Initial object pool size: " + pool.getPoolSize());
    try {
      ExpensiveObject expensiveObject1 = pool.borrowObject();
      expensiveObject1.doTask();
      ExpensiveObject expensiveObject2 = pool.borrowObject();
      expensiveObject2.doTask();
      System.out.println("Object pool size: " + pool.getPoolSize());

      pool.returnObject(expensiveObject1);
      System.out.println("Object pool size: " + pool.getPoolSize());
      pool.returnObject(expensiveObject2);
      System.out.println("Object pool size: " + pool.getPoolSize());

    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
