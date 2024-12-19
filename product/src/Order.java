import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products = new ArrayList<>();
    private double totalCost = 0;

    // Метод для добавления продукта в заказ
    public void addProduct(Product product, int quantity) {
        if (product.reduceQuantity(quantity)) {
            products.add(new Product(product.getId(), product.getName(), product.getPrice(), quantity));
            totalCost += product.getPrice() * quantity;
        } else {
            System.out.println("There is not enough product in stock:" + product.getName());
        }
    }

    // Итоговая стоимость заказа
    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder("Order Details:\n");
        for (Product product : products) {
            details.append(product.getName())
                    .append(" x ")
                    .append(product.getQuantity())
                    .append(" = ")
                    .append(product.getPrice() * product.getQuantity())
                    .append("\n");
        }
        details.append("Total Cost: ").append(totalCost);
        return details.toString();
    }
}
