package Class_;

public class Car {
    public String brand = "BYD";
    public int price = 200000;
    public String color = "white";


    @Override
    public String toString() {
        return "car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
