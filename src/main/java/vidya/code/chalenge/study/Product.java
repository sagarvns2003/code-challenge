package vidya.code.chalenge.study;

public record Product(String item, Integer price) {
  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    price = price;
  }

  public String getItem() {
    return item;
  }
}
