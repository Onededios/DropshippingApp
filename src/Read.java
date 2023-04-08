import java.util.Scanner;
/**

 The Read class is used for reading user input from the console and interacting with a Controller object.
 It has a Controller object and a Scanner object as instance variables, and provides methods for reading
 different types of user input and passing them to the Controller.
 All methods in this class must return something
 */
public class Read {
    /**
The Controller object used by this Read instance.
*/
    final Controller controller = new Controller();
    /**
     The Scanner object used by this Read instance for reading user input from the console.
     */
    final Scanner scanner = new Scanner(System.in);
    /**

     Reads a string from standard input and returns it in uppercase.
     This method is commonly used to read user input for menu options.
     @return the user input string in uppercase
     */
    public String readMenuOpt() {
        return scanner.nextLine().toUpperCase();
    }
    /**

     Reads a single character from standard input and returns it as a char.
     @return the character read from standard input
     */
    private char readChar() {
        String opt = scanner.nextLine().toUpperCase();
        if (opt.length() > 1) {System.out.println("Error: A char is just one character length."); return 0;}
        return opt.charAt(0);
    }
    /**

     Reads a string from standard input and attempts to parse it as an integer.
     If the input is not a valid integer, an error message is printed and 0 is returned.
     @return the integer parsed from the user input, or 0 if the input is not a valid integer
     */
    public int readInt() {
        String inp = scanner.nextLine();
        try {
            return Integer.parseInt(inp);
        } catch (NumberFormatException e) {
            System.out.println("The input is not a valid integer.");
            return 0;
        }
    }
    /**

     Reads a string from standard input and attempts to parse it as a float.
     If the input is not a valid float, an error message is printed and 0 is returned.
     @return the float parsed from the user input, or 0 if the input is not a valid float
     */
    public float readFloat() {
        String inp = scanner.nextLine();
        try {
            return Float.parseFloat(inp);
        } catch (NumberFormatException e) {
            System.out.println("The input is not a valid float.");
            return 0;
        }
    }
    /**

     Prompts the user to enter a new name and validates the input.
     If the name is less than 3 characters long, an error message is printed and an empty string is returned.
     Otherwise, the input is returned as a string and a success message is printed.
     @return the new name entered by the user as a string, or an empty string if the input is invalid
     */
    public String changeName() {
        System.out.print("Enter the new name: ");
        String opt = readMenuOpt();
        System.out.println();
        if (opt.length() < 3) {System.out.println("Error: Name must be at least 3 characters long."); return "";}
        System.out.println("Value updated."); return opt;
    }
    /**

     Prompts the user to set a new value for the "active" attribute.
     If the user enters "Y", true is returned and a success message is printed.
     If the user enters anything else, false is returned and a default message is printed.
     @return true if the user entered "Y", false otherwise
     */
    public boolean changeActive() {
        System.out.print("Set active/paid? (Y/N): ");
        String opt = readMenuOpt();
        System.out.println();
        if (opt.equals("Y")) {System.out.println("Value updated."); return true;}
        System.out.println("Applying false for default value."); return false;
    }
    /**

     Prompts the user to enter a new value for the "nutri score" attribute and validates the input.
     If the input is not a single uppercase letter between A and Z, an error message is printed and 0 is returned.
     Otherwise, the input is returned as a char and a success message is printed.
     @return the new nutri score entered by the user as a char, or 0 if the input is invalid
     */
    public char changeNutriScore() {
        System.out.print("Enter the new nutri score: ");
        char nutriscore = readChar();
        System.out.println();
        if ((int)nutriscore < 65 | (int)nutriscore > 90) {System.out.println("Error: Nutriscore must be between A-Z."); return 0;}
        System.out.println("Value updated."); return nutriscore;
    }
    /**

     Prompts the user to enter a new value for the "price" attribute and validates the input.
     If the input is negative, an error message is printed and 0 is returned.
     Otherwise, the input is returned as a float and a success message is printed.
     @return the new price entered by the user as a float, or 0 if the input is invalid
     */
    public float changePrice() {
        System.out.print("Enter the new price: ");
        float price = readFloat();
        System.out.println();
        if (price < 0) {System.out.println("Error: Price must be positive."); return 0;}
        System.out.println("Value updated.");
        return price;
    }
    /**

     Prompts the user to enter a new vendor ID and searches for the corresponding vendor object.
     If a vendor with the specified ID is found, it is returned and a success message is printed.
     If no vendor with the specified ID is found, null is returned and an error message is printed.
     @return the updated vendor object with the specified ID, or null if no vendor is found
     */
    public Vendor changeVendor() {
        System.out.print("Enter the vendor ID: ");
        int id = readInt();
        System.out.println();
        for (int i = 0; i < controller.getVendorInstances().size(); i++) {
            if (controller.getVendorInstances().get(i).getVendorId() == id) {
                System.out.println("Vendor updated.");
                return controller.getVendorInstances().get(i);
            }
        }
        return null;
    }
    /**

     Prompts the user to enter a client ID and searches for a matching client instance in the controller's list of client instances.
     If a matching client instance is found, the method returns the client instance and prints "Client updated."
     If a matching client instance is not found, the method returns null.
     @return the updated client instance if a matching client is found, or null if no matching client is found
     */
    public Client changeClient() {
        System.out.print("Enter the client ID: ");
        int id = readInt();
        System.out.println();
        for (int i = 0; i < controller.getClientInstances().size(); i++) {
            if (controller.getClientInstances().get(i).getClientID() == id) {
                System.out.println("Client updated.");
                return controller.getClientInstances().get(i);
            }
        }
        return null;
    }
    /**

     Reads the quantity of a given product ID from the user input.
     @param id The ID of the product to read the quantity for.
     @return The quantity of the given product ID read from user input.
     csharp
     Copy code
     Returns 0 if the product ID is not found.
     */
    public int readProductQTY(int id) {
        int qty = 0;
        boolean found = false;
        for (int i = 0; i < controller.getProductInstances().size(); i++) {
            if (controller.getProductInstances().get(i).getProductId() == id) {
                System.out.print("Enter the quantity: ");
                qty = readInt();
                found = true;
                if (qty < 1) {System.out.println("Error: Entered qty must be higher than 0.");}
            }
        }
        System.out.println(found?"Product found.":"Error: Product not found.");
        return qty;
    }
}
