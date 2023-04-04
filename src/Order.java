import java.time.LocalDate;
import java.util.ArrayList;
/**

 The Order class represents an order made by a client, including the order ID, date, client details,
 whether it has been paid or not, product quantity, total price and the products included in the order.
 */
public class Order {
    // * Attributes
    /**

     The unique identifier for this order.
     */
    private int orderID;
    /**

     The date when the order was made.
     */
    private LocalDate orderDate;
    /**

     The client who made the order.
     */
    private Client client;
    /**

     Whether or not the order has been paid for.
     */
    private boolean orderPaid;
    /**

     The total quantity of products in the order.
     */
    private int productQTY;
    /**

     The total price of the order.
     */
    private double totalPrice;
    /**

     The list of products included in the order.
     */
    private ArrayList<Product> products;
    /**

     The controller used to manage this order instance.
     */
    Controller controller = new Controller();
    /**

     Constructs an order object with the specified client and list of products.
     The order ID is automatically generated as the current largest order ID plus one.
     The order date is set to the current date.
     The payment status is set to false.
     The product quantity is set to the size of the product list.
     The total price is calculated as the sum of the prices of all products in the list.
     @param client the client who made the order
     @param products the list of products ordered
     */
    // * Constructors
    public Order(Client client, ArrayList<Product> products) {
        this.orderID = getBiggestOrderId() + 1;
        this.orderDate = LocalDate.now();
        this.client = client;
        this.orderPaid = false;
        this.products = products;
        this.productQTY = products.size();
        this.totalPrice = getTotalPrice();
    }

    // * Getters and Setters
    /**

     Returns the order ID of this order.
     @return the order ID of this order.
     */
    public int getOrderID() {
        return orderID;
    }
    /**

     Sets the order ID of this order to the specified value.
     @param orderID the new order ID of this order.
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    /**

     Returns the order date of this order.
     @return the order date of this order.
     */
    public LocalDate getOrderDate() {
        return orderDate;
    }
    /**

     Returns the client of this order.
     @return the client of this order.
     */
    public Client getClient() {
        return client;
    }
    /**

     Sets the client of this order to the specified value.
     @param client the new client of this order.
     */
    public void setClient(Client client) {
        this.client = client;
    }
    /**

     Returns true if this order has been paid for, false otherwise.
     @return true if this order has been paid for, false otherwise.
     */
    public boolean getOrderPaid() {
        return orderPaid;
    }
    /**

     Sets whether this order has been paid for.
     @param orderPaid true if this order has been paid for, false otherwise.
     */
    public void setOrderPaid(boolean orderPaid) {
        this.orderPaid = orderPaid;
    }
    /**

     Returns the list of products in this order.
     @return the list of products in this order.
     */
    public ArrayList<Product> getProducts() {
        return products;
    }
    /**

     Sets the list of products in this order to the specified value.
     @param products the new list of products in this order.
     */
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    /**

     Returns the biggest order ID in the controller's list of order instances.
     @return the biggest order ID
     */
    private int getBiggestOrderId() {
        int biggest = 0;
        if (controller.getOrderInstances().size() != 0) {
            for (int i = 0; i < controller.getOrderInstances().size(); i++) {
                if (biggest < controller.getOrderInstances().get(i).getOrderID()) {
                    biggest = controller.getOrderInstances().get(i).getOrderID();
                }
            }
        }
        return biggest;
    }
    /**

     Returns the total price of all products in the order.
     @return the total price of all products
     */
    private double getTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < products.size(); i++) {
            totalPrice += products.get(i).getProductPrice();
        }
        return totalPrice;
    }
    // * Methods
    /**

     Returns a string representation of the Order object, including order ID, date, payment status,
     client information, total number of products, total price and a list of products included in the order.
     @return a string containing the order information and the list of products included in the order.
     */
    public String toString() {
        String finalString =
              "   ◢■■■■■■■■■■■■■■■■■■■■■■■■■■◣" +
            "\n     Order ▶ "+ orderID + " ◀"+
            "\n    ■■■■■■■■■■■■■■■■■■■■■■■■■■" +
            "\n     ID: " + orderID +
            "\n     Date: " + orderDate +
            "\n     Paid: " + orderPaid +
            "\n     Client ID: " + client.getClientID() +
            "\n     Client Name: " + client.getClientName() +
            "\n     Total Products: "+ productQTY +
            "\n     Total Price: " + totalPrice;
        for (int i = 0; i < products.size(); i++) {finalString +=  "\n" + products.get(i).toString();}
        finalString +=  "\n   ◥■■■■■■■■■■■■■■■■■■■■■■■■■■◤";
        return finalString;
    }
}