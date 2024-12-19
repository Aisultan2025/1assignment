import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Phone", 700.0, 10));
        products.add(new Product(2, "Laptop", 1500.0, 5));
        products.add(new Product(3, "Headphones", 150.0, 20));

        System.out.println("Welcome to the E-commerce platform!");

        // Создаем покупателя
        System.out.println("Enter the buyer's name:");
        String name = scanner.nextLine();
        System.out.println("Enter the buyer's last name:");
        String surname = scanner.nextLine();
        Shopper shopper = new Shopper(name, surname);

        boolean shopping = true;
        while (shopping) {
            System.out.println("\nAvailable products:");
            for (Product product : products) {
                System.out.println(product);
            }

            System.out.println("\nEnter the product ID to add to the order (or 0 to complete):");
            int productId = scanner.nextInt();

            if (productId == 0) {
                shopping = false;
                break;
            }

            System.out.println("Enter the quantity:");
            int quantity = scanner.nextInt();

            // Находим товар по ID
            Product selectedProduct = null;
            for (Product product : products) {
                if (product.getId() == productId) {
                    selectedProduct = product;
                    break;
                }
            }

            if (selectedProduct != null) {
                Order order = new Order();
                order.addProduct(selectedProduct, quantity);
                shopper.addOrder(order);
                System.out.println("The product has been added to the order!");
            } else {
                System.out.println("The product with this ID was not found.");
            }
        }

        // Печать итогов
        System.out.println("\nBuyer: " + shopper);
        System.out.println("List of orders:");
        for (Order order : shopper.getOrders()) {
            System.out.println(order);
        }
    }
}
