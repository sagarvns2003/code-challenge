package vidya.code.chalenge.study;

public record Product(String item, Double price) {
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    price = price;
  }

  public String getItem() {
    return item;
  }
}
