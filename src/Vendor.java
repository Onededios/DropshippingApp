import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.time.LocalDate;
import java.util.ArrayList;
/**

 This class represents a Vendor that provides products to the store.
 The vendor has a unique identifier, name, registration date, activity status,
 and a list of products they provide to the store.
 */
public class Vendor {
    // * Attributes
    /**
     * An integer representing the unique identifier of the vendor.
     */
    @JsonProperty("vendorID")
    private int vendorId;
    /**
     * A string representing the name of the vendor.
     */
    @JsonProperty("vendorName")
    private String vendorName;
    /**
     * A LocalDate representing the registration date of the vendor.
     */
    @JsonProperty("vendorRegDate")
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate vendorRegDate;
    /**
     * A boolean representing the activity status of the vendor.
     */
    @JsonProperty("vendorActive")
    private boolean vendorActive;
    /**
     * A Controller object representing the controller that manages the system.
     */
    @JsonIgnore
    final Controller controller = new Controller();
    // * Constructor
    /**
     * Constructor for the Vendor class. Initializes a new vendor with a unique identifier,
     * name, registration date, and activity status.
     * @param vendorName A string representing the name of the vendor.
     * @param vendorActive A boolean value indicating whether the vendor is currently active.
     */
    public Vendor(String vendorName, boolean vendorActive) {
        this.vendorId = getBiggestVendorId() + 1;
        this.vendorName = vendorName;
        this.vendorRegDate = LocalDate.now();
        this.vendorActive = vendorActive;
    }

    public Vendor() {}

    // * Getters and Setters
    /**
     Returns the vendor's ID.
     @return an integer representing the vendor's ID.
     */
    public int getVendorId() {
        return vendorId;
    }
    /**
     Sets the vendor's ID.
     @param vendorId an integer representing the new vendor ID.
     */
    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }
    /**
     Returns the vendor's name.
     @return a String representing the vendor's name.
     */
    public String getVendorName() {
        return vendorName;
    }
    /**
     Sets the vendor's name.
     @param vendorName a String representing the new vendor name.
     */
    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }
    /**
     Returns the vendor's registration date.
     @return a LocalDate object representing the vendor's registration date.
     */
    public LocalDate getVendorRegDate() {
        return vendorRegDate;
    }
    /**
     Returns a boolean indicating whether the vendor is active or not.
     @return a boolean indicating whether the vendor is active or not.
     */
    public boolean getVendorActive() {
        return vendorActive;
    }
    /**
     Sets whether the vendor is active or not.
     @param vendorActive a boolean indicating whether the vendor is active or not.
     */
    public void setVendorActive(boolean vendorActive) {
        this.vendorActive = vendorActive;
    }
    @JsonIgnore
    /**
     Returns the biggest vendor ID currently in the system.
     @return an integer representing the biggest vendor ID in the system.
     */
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
    /**

     Returns a string representation of the vendor object, including the vendor's name, ID, registration date, and status.
     The string is formatted with decorative characters for better visualization.
     @return a string representation of the vendor object
     */
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
