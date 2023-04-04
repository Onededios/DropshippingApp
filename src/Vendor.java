import java.time.LocalDate;
import java.util.ArrayList;
public class Vendor {
    // * Attributes
    private int vendorId;
    private String vendorName;
    private final LocalDate vendorRegDate;
    private boolean vendorActive;
    private ArrayList<Product> products;
    Controller controller = new Controller();

    // * Constructor
    public Vendor(String vendorName, boolean vendorActive) {
        this.vendorId = getBiggestVendorId() + 1;
        this.vendorName = vendorName;
        this.vendorRegDate = LocalDate.now();
        this.vendorActive = vendorActive;
        this.products = new ArrayList<>();
    }

    // * Getters and Setters
    public int getVendorId() {
        return vendorId;
    }
    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }
    public String getVendorName() {
        return vendorName;
    }
    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }
    public LocalDate getVendorRegDate() {
        return vendorRegDate;
    }
    public boolean getVendorActive() {
        return vendorActive;
    }
    public void setVendorActive(boolean vendorActive) {
        this.vendorActive = vendorActive;
    }
    public ArrayList<Product> getProducts() {
        return products;
    }
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    public int getBiggestVendorId() {
        int maxVal = 0;
        if (controller.getVendorInstances().size() != 0) {
            for (int i = 0; i < controller.getVendorInstances().size(); i++) {
                if(maxVal < controller.getVendorInstances().get(i).getVendorId()) {maxVal = controller.getVendorInstances().get(i).getVendorId();}
            }
        }
        return maxVal;
    }

    // * Methods
    public String toString() {
        return    "   ╭────────────────────────────╮" +
                "\n     Vendor ▷ "+ vendorName + " ◁" +
                "\n    ────────────────────────────" +
                "\n     ID: "+vendorId +
                "\n     Name: "+vendorName +
                "\n     Reg. Date: "+vendorRegDate +
                "\n     Active: "+vendorActive +
                "\n   ╰────────────────────────────╯";
    }
}
