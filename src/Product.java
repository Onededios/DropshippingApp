/**

 This class represents a Product object with various attributes, a constructor to initialize them and various methods.
 */
public class Product {
    // * Attributes
    /**

     The ID of the product.
     */
    private int productId;
    /**

     The name of the product.
     */
    private String productName;
    /**

     The price of the product.
     */
    private float productPrice;
    /**
     * The Nutri-Score of the product.
     * <p>
     * This field is a single character representing the Nutri-Score of the product, which is a
     * rating system used in several countries to evaluate the nutritional quality of food products.
     * The Nutri-Score ranges from A (healthiest) to Z (least healthy). The value of this field should
     * be one of the characters from 'A' to 'Z'.
     */
    private char productNutriScore;
    /**

     The vendor of the product.
     */
    private Vendor vendor;
    /**

     A controller object used to interact with the product.
     */
    final Controller controller = new Controller();
    /**

     Constructs a new Product object with the given name, price, Nutri-Score, and vendor.
     @param productName the name of the product
     @param productPrice the price of the product
     @param productNutriScore the Nutri-Score of the product
     @param vendor the vendor of the product
     */
    public Product(String productName, float productPrice, char productNutriScore, Vendor vendor) {
        this.productId = getBiggestProductId() + 1;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productNutriScore = productNutriScore;
        int productQuantity = 0;
        this.vendor = vendor;
    }
    // * Getters & setters
    /**

     Returns the ID of the product.
     @return the ID of the product
     */
    public int getProductId() {
        return productId;
    }
    /**

     Sets the ID of the product to the specified value.
     @param productId the new ID of the product
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }
    /**

     Returns the name of the product.
     @return the name of the product
     */
    public String getProductName() {
        return productName;
    }
    /**

     Sets the name of the product to the specified value.
     @param productName the new name of the product
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }
    /**

     Returns the price of the product.
     @return the price of the product
     */
    public float getProductPrice() {
        return productPrice;
    }
    /**

     Sets the price of the product to the specified value.
     @param productPrice the new price of the product
     */
    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }
    /**

     Returns the Nutri-Score of the product.
     @return the Nutri-Score of the product
     */
    public char getProductNutriScore() {
        return productNutriScore;
    }
    /**

     Sets the Nutri-Score of the product to the specified value.
     @param productNutriScore the new Nutri-Score of the product
     */
    public void setProductNutriScore(char productNutriScore) {
        this.productNutriScore = productNutriScore;
    }
    /**

     Returns the vendor of the product.
     @return the vendor of the product
     */
    public Vendor getVendor() {
        return vendor;
    }
    /**

     Sets the vendor of the product to the specified value.
     @param vendor the new vendor of the product
     */
    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
    /**

     This method returns the largest product ID currently in use by the controller.
     @return the largest product ID currently in use by the controller
     */
    private int getBiggestProductId() {
        int maxVal = 0;
        if (controller.getProductInstances().size() != 0) {
            for (int i = 0; i < controller.getProductInstances().size(); i++) {
                if (maxVal < controller.getProductInstances().get(i).getProductId()) {
                    maxVal = controller.getProductInstances().get(i).getProductId();
                }
            }
        }
        return maxVal;
    }
    // * Methods
    /**

     Returns a string representation of the Product instance.
     @return a string representation of the Product instance
     */
    public String toString() {
        return    "   ┌─╼━━━━━━━━━━━━━━━━━━━━━━━━━╾─┐" +
                "\n     Product ▷ "+ productName + " ◁" +
                "\n    ─╼━━━━━━━━━━━━━━━━━━━━━━━━━╾─" +
                "\n     ID: "+productId +
                "\n     Name: "+productName +
                "\n     Price: "+productPrice +
                "\n     NutriScore: "+productNutriScore +
                "\n     Vendor Id: "+vendor.getVendorId() +
                "\n     Vendor Name: "+vendor.getVendorName() +
                "\n   └─╼━━━━━━━━━━━━━━━━━━━━━━━━━╾─┘";
    }
}