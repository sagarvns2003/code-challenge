package vidya.code.chalenge.study;

import java.util.ArrayList;
import java.util.List;

/*
 * Creating an immutable class to ensure that the state of an object cannot be changed once it is created.
 * - Declare the class as final so it cannot be subclassed.
 * - Make all fields private and final to ensure they are not modified after initialization.
 * - Do not provide setters for any fields.
 * - Initialize all fields via a constructor.
 * - Ensure deep copies of mutable objects are returned in getters to prevent modification of internal state.
 */
public final class ImmutablePerson {
  private final String name;
  private final int age;
  private final List<String> hobbies;

  public ImmutablePerson(String name, int age, List<String> hobbies) {
    this.name = name;
    this.age = age;
    this.hobbies = new ArrayList<>(hobbies); // Deep copy
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public List<String> getHobbies() {
    return new ArrayList<>(hobbies); // Deep copy
  }
}
