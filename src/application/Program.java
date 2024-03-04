package application;

import entities.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt =  DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        LocalDate birthDate = LocalDate.parse(sc.next(),fmt);

        Client client = new Client(clientName,email,birthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String status = sc.next();

        Order order = new Order(client, OrderStatus.valueOf(status));

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        for(int i=1;i<=n;i++) {
            System.out.println("Enter #" + i + "item data:");
            System.out.print("Product name: ");
            String productName = sc.next();
            System.out.print("Product price: ");
            Double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            Integer quantity = sc.nextInt();
            Product product = new Product(productName,productPrice);
            OrderItem orderItem = new OrderItem(product,quantity,productPrice);
            order.addItem(orderItem);
        }

        System.out.println(order);

    }
}
