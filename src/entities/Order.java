package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static DateTimeFormatter fmt =  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static DateTimeFormatter fmt2 =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final LocalDateTime moment = LocalDateTime.now();
    private Client client;
    private OrderStatus status;
    private List<OrderItem> itens = new ArrayList<>();

    public Order() {
    }

    public Order(Client client, OrderStatus status) {
        this.client = client;
        this.status = status;
    }

    public LocalDateTime getMoment() {
        return moment;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(OrderItem item){
        itens.add(item);
    }
    public void removeItem(OrderItem item){
        itens.remove(item);
    }
    public Double total(){
        Double sum = 0.00;
        for (OrderItem i : itens){
            sum += i.subTotal();
        }
        return sum;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY\n");
        sb.append("Order moment: " + moment.format(fmt) + "\n");
        sb.append("Order status: " + status + "\n");
        sb.append("Client: " + client.getName());
        sb.append(" (" + client.getBirthDate().format(fmt2) + ") - ");
        sb.append(client.getEmail()+ "\n");
        sb.append("Order items: \n");
        for (OrderItem i : itens){
            sb.append(i.getProduct().getName() + ", ");
            sb.append("$" + String.format("%.2f",i.getPrice()) + ", ");
            sb.append("Quantity: " + i.getQuantity() + ", ");
            sb.append("Subtotal: " + i.subTotal() + "\n");
        }
        sb.append("Total price: $" + total());
        return sb.toString();

    }

}
