import java.util.Scanner;
/**

 The Read class is used for reading user input from the console and interacting with a Controller object.
 It has a Controller object and a Scanner object as instance variables, and provides methods for reading
 different types of user input and passing them to the Controller.
 */
public class Read {
    /**
The Controller object used by this Read instance.
*/
    Controller controller = new Controller();
    /**
     The Scanner object used by this Read instance for reading user input from the console.
     */
    Scanner scanner = new Scanner(System.in);
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
            int number = Integer.parseInt(inp);
            return number;
        } catch (NumberFormatException e) {
            System.out.println("The input is not a valid double.");
            return 0;
        }
    }
    /**

     Reads a string from standard input and attempts to parse it as a double.
     If the input is not a valid double, an error message is printed and 0 is returned.
     @return the double parsed from the user input, or 0 if the input is not a valid double
     */
    public double readDouble() {
        String inp = scanner.nextLine();
        try {
            double number = Double.parseDouble(inp);
            return number;
        } catch (NumberFormatException e) {
            System.out.println("The input is not a valid double.");
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
        System.out.print("Set active? (Y/N): ");
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
     Otherwise, the input is returned as a double and a success message is printed.
     @return the new price entered by the user as a double, or 0 if the input is invalid
     */
    public double changePrice() {
        System.out.print("Enter the new price: ");
        double price = readDouble();
        System.out.println();
        if (price < 0) {System.out.println("Error: Price must be positive."); return 0;}
        System.out.println("Value updated."); return price;
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
}
