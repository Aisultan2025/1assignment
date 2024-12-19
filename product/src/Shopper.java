import java.util.ArrayList;
import java.util.List;

public class Shopper {
    private String name;
    private String surname;
    private List<Order> orders = new ArrayList<>();

    // Конструктор
    public Shopper(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<Order> getOrders() {
        return orders;
    }

    // Метод для добавления заказа
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public String toString() {
        return "Shopper: " + name + " (" + surname + ")";
    }
}

