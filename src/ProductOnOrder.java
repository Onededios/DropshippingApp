import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

/**

 The ProductOnOrder class represents a product that has been added to an order.
 It contains information about the product, its quantity, and its total price.
 */
public class ProductOnOrder {
    /*

    The product added to the order.
    */
    private Product product;
    @JsonIgnore
    /**

     The controller instance for managing the shopping list.
     */
    final Controller controller = new Controller();
    /**

     The quantity of the product added to the order.
     */
    private int qty;
    /**

     The unique identifier for this product on order.
     */
    private int id;
    /**

     The total price of the product in the order.
     */
    private float totalProductPrice;
    /**
     * Constructs a new empty ProductOnOrder object.
     */
    public ProductOnOrder() {}

    /**
     * Constructs a new ProductOnOrder object with the given product, quantity, and list of products.
     * @param product the product to add to the order
     * @param qty the quantity of the product to add to the order
     * @param products the list of products on the order
     */
    public ProductOnOrder(Product product, int qty, ArrayList<ProductOnOrder> products) {
        this.id = getBiggestProductOnOrderId(products) + 1;
        this.product = product;
        this.qty = qty;
        this.totalProductPrice = product.getProductPrice() * this.qty;
    }

    /**
     * Returns the product on the order.
     * @return the product on the order
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the product on the order.
     * @param product the product to set on the order
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Returns the controller.
     * @return the controller
     */
    public Controller getController() {
        return controller;
    }

    /**
     * Returns the quantity of the product on the order.
     * @return the quantity of the product on the order
     */
    public int getQty() {
        return qty;
    }

    /**
     * Sets the quantity of the product on the order.
     * @param qty the quantity of the product to set on the order
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * Returns the ID of the product on the order.
     * @return the ID of the product on the order
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the product on the order.
     * @param id the ID of the product to set on the order
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the total price of the product on the order.
     * @return the total price of the product on the order
     */
    public float getTotalProductPrice() {
        return totalProductPrice;
    }

    /**
     * Sets the total price of the product on the order.
     * @param totalProductPrice the total price of the product to set on the order
     */
    public void setTotalProductPrice(float totalProductPrice) {
        this.totalProductPrice = totalProductPrice;
    }
    @JsonIgnore
    /**
     * Returns the biggest ID of the products on the order.
     * @param product the list of products on the order
     * @return the biggest ID of the products on the order
     */
    private int getBiggestProductOnOrderId(ArrayList<ProductOnOrder> product) {
        int maxVal = 0;
        if (product.size() != 0) {
            for (int i = 0; i < product.size(); i++) {
                if (maxVal < product.get(i).id) {
                    maxVal = product.get(i).id;
                }
            }
        }
        return maxVal;
    }
    public String toString() {
        return  id + " | " +
                getProduct().getProductName() + " | " +
                getProduct().getProductPrice() + " € | " +
                qty + " | " +
                totalProductPrice+" €";
    }
}
