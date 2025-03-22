package vidya.code.chalenge.dp.creational;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Singleton {
  private Singleton() {}

  // Using 'volatile' to ensure visibility of changes to 'instance' across threads
  private static volatile Singleton instance;

  public static Singleton getInstance() {
    if (null == instance) {
      synchronized (Singleton.class) {
        if (null == instance) {
          instance = new Singleton();
        }
      }
    }
    return instance;
  }

  public static void main(String[] args) {

    Singleton s1 = Singleton.getInstance();
    Singleton s2 = Singleton.getInstance();
    log.info("All are single object: {}", s1.equals(s2));
    log.info("S1 hashcode: {}, S2 hashcode: {}", s1.hashCode(), s2.hashCode());
    /*if(Objects.compare(s1, s2, (o1,o2) -> o1.hashCode() - o2.hashCode()) == 0){
      log.info("equal");
    }*/

  }
}
