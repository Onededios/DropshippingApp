import java.time.LocalDate;
import java.util.ArrayList;
/**

 The Order class represents an order made by a client, including the order ID, date, client details,
 whether it has been paid or not, product quantity, total price and the products included in the order.
 */
@SuppressWarnings({"ALL", "GrazieInspection"})
public class Order {
    // * Attributes
    /**

     The unique identifier for this order.
     */
    private int orderID;
    /**

     The date when the order was made.
     */
    private final LocalDate orderDate;
    /**

     The client who made the order.
     */
    private Client client;
    /**

     Whether the order has been paid for.
     */
    private boolean orderPaid;
    /**

     The total price of the order.
     */
    private final float totalPrice;
    /**

     The list of products included in the order.
     */
    private ArrayList<Product> products;
    /**

     The controller used to manage this order instance.
     */
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
    public Order(Client client, ArrayList<Product> products) {
        this.orderID = getBiggestOrderId() + 1;
        this.orderDate = LocalDate.now();
        this.client = client;
        this.orderPaid = false;
        this.products = products;
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

     Calculates the total price of all products in the list.
     @return The total price of all products in the list.
     */
    public float getTotalPrice() {
        float totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getProductPrice();
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
        String finalString =
              "   ◢■■■■■■■■■■■■■■■■■■■■■■■■■■◣" +
            "\n     Order ▶ "+ orderID + " ◀"+
            "\n    ■■■■■■■■■■■■■■■■■■■■■■■■■■" +
            "\n     ID: " + orderID +
            "\n     Date: " + orderDate +
            "\n     Paid: " + orderPaid +
            "\n     Client ID: " + client.getClientID() +
            "\n     Client Name: " + client.getClientName() +
            "\n     Total Price: " + totalPrice +
            "\n     ***************************" +
            "\n     *      SHOPPING LIST      *" +
            "\n     *   ID|Name|QTY|€/U|€/T   *" +
            "\n     *  *********************  *";
            finalString += controller.printOutProductList(orderID);
        finalString +=
            "\n     ***************************"+
            "\n   ◥■■■■■■■■■■■■■■■■■■■■■■■■■■◤";
        return finalString;
    }
}