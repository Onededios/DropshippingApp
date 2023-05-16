import java.time.LocalDate;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
/**

 The Order class represents an order made by a client, including the order ID, date, client details,
 whether it has been paid or not, product quantity, total price and the products included in the order.
 */
public class Order {
    // * Attributes
    /**

     The unique identifier for this order.
     */
    @JsonProperty("orderID")
    private int orderID;
    /**

     The date when the order was made.
     */
    @JsonProperty("orderDate")
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate orderDate;
    /**

     The client who made the order.
     */
    @JsonProperty("client")
    private Client client;
    /**

     Whether the order has been paid for.
     */
    @JsonProperty("orderPaid")
    private boolean orderPaid;
    /**

     The total price of the order.
     */
    @JsonProperty("totalPrice")
    private float totalPrice;
    /**

     The list of products included in the order.
     */
    @JsonProperty("products")
    private ArrayList<ProductOnOrder> products;
    /**

     The controller used to manage this order instance.
     */
    @JsonIgnore
    final Controller controller = new Controller();
    // * Constructors
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
    public Order(Client client, ArrayList<ProductOnOrder> products) {
        this.orderID = getBiggestOrderId() + 1;
        this.orderDate = LocalDate.now();
        this.client = client;
        this.orderPaid = false;
        this.products = products;
        this.totalPrice = getTotalPrice(products);
    }

    public Order() {}

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

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ArrayList<ProductOnOrder> getProducts() {
        return products;
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

     Calculates and returns the total price of an ArrayList of ProductOnOrder objects.
     @param products the ArrayList of ProductOnOrder objects to calculate the total price of
     @return the total price of the ProductOnOrder objects in the ArrayList
     */
    public float getTotalPrice(ArrayList<ProductOnOrder> products) {
        float totalPrice = 0;
        for (int i = 0; i < products.size(); i++) {
            totalPrice += products.get(i).getTotalProductPrice();
        }
        return totalPrice;
    }
    // * Methods
    /**

     Returns a string representation of this order object.
     The returned string contains the order ID, order date, payment status, client ID, client name,
     total price, and a list of products in the order, including their ID, name, quantity, unit price,
     and total price. The shopping list is obtained by calling the {@code printOutProductList} method
     of the controller object associated with this order.
     @return a string representation of this order object.
     */

    public String toString() {
        return  "   ◢■■■■■■■■■■■■■■■■■■■■■■■■■■◣" +
                "\n     Order ▶ "+ orderID + " ◀"+
                "\n    ■■■■■■■■■■■■■■■■■■■■■■■■■■" +
                "\n     ID: " + orderID +
                "\n     Date: " + orderDate +
                "\n     Paid: " + orderPaid +
                "\n     Client ID: " + client.getClientID() +
                "\n     Client Name: " + client.getClientName() +
                "\n     Total Price: " + totalPrice + " €\n"+
                controller.getShoppingList(this.products) +
                "\n   ◥■■■■■■■■■■■■■■■■■■■■■■■■■■◤";
    }
}