import java.util.ArrayList;

public class ProductOnOrder {
    private Product product;
    final Controller controller = new Controller();
    private int qty;
    private int id;
    private float totalProductPrice;

    public ProductOnOrder() {}
    public ProductOnOrder(Product product, int qty, ArrayList<ProductOnOrder> products) {
        this.id = getBiggestProductOnOrderId(products) + 1;
        this.product = product;
        this.qty = qty;
        this.totalProductPrice = product.getProductPrice() * this.qty;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Controller getController() {
        return controller;
    }
    public int getQty() {
        return qty;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotalProductPrice() {
        return totalProductPrice;
    }

    public void setTotalProductPrice(float totalProductPrice) {
        this.totalProductPrice = totalProductPrice;
    }

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
