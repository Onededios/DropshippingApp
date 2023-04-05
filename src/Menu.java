// TODO Falta añadir la javadoc
public class Menu {
    Controller controller = new Controller();
    /**

     Prints the main menu for the Dropshipping program.
     The menu displays various options for the user to choose from,
     such as adding default objects, creating new vendors/clients/products/orders,
     listing existing vendors/clients/products/orders, editing existing vendors/clients/products/orders,
     and exiting the program.
     */
    public void mainMenu() {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("     DROPSHIPPING By Joel Olivera   ");
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
        System.out.println("   ╭─────────────────────────────╮  ");
        System.out.println("               DEFAULT              ");
        System.out.println("    ─────────────────────────────   ");
        System.out.println("     AD. Add default objects        ");
        System.out.println("     DD. Drop default objects       ");
        System.out.println("   ╰─────────────────────────────╯  ");
        System.out.println("   ╭─────────────────────────────╮  ");
        System.out.println("               CREATE               ");
        System.out.println("    ─────────────────────────────   ");
        System.out.println("     CV. Create new Vendor          ");
        System.out.println("     CC. Create new Client          ");
        System.out.println("     CP. Create new Product         ");
        System.out.println("     CO. Create new Order           ");
        System.out.println("   ╰─────────────────────────────╯  ");
        System.out.println("   ╭─────────────────────────────╮  ");
        System.out.println("                LIST                ");
        System.out.println("    ─────────────────────────────   ");
        System.out.println("     LA. List All Objects           ");
        System.out.println("     LV. List Vendors               ");
        System.out.println("     LC. List Clients               ");
        System.out.println("     LP. List Products              ");
        System.out.println("     LO. List Orders                ");
        System.out.println("     LPV. List Products by Vendor   ");
        System.out.println("     LOC. List Orders by Client     ");
        System.out.println("   ╰─────────────────────────────╯  ");
        System.out.println("   ╭─────────────────────────────╮  ");
        System.out.println("                EDIT                ");
        System.out.println("    ─────────────────────────────   ");
        System.out.println("     EV. Edit Vendors               ");
        System.out.println("     EC. Edit Clients               ");
        System.out.println("     EP. Edit Products              ");
        System.out.println("     EO. Edit Orders                ");
        System.out.println("   ╰─────────────────────────────╯  ");
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
        System.out.println("     EX. Exit                       ");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }
    /**

     This method prints a goodbye message at the end of the menu.
     It also displays my name and the name of the program.
     */
    public void endMenu() {
        System.out.println("\n        ★ · ★ · ★ · ★ · ★ · ★");
        System.out.println(  "        ·      Goodbye!      ·");
        System.out.println(  "        ·  © DROPSHIPPING ©  ·");
        System.out.println(  "        ·  ©      By      ©  ·");
        System.out.println(  "        ·  © Joel Olivera ©  ·");
        System.out.println(  "        ★ · ★ · ★ · ★ · ★ · ★");
    }
    // ! Create
    /**
     Displays a menu for creating a vendor with the given name and active status.
     The menu has options for changing the vendor's name and active status.
     Also, the user can choose to finish saving changes or exit without saving.
     @param name the name of the vendor to be created
     @param active the active value of the vendor to be created
    */
    public void createVendorMenu(String name, boolean active) {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("             Create Vendor          ");
            System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
            System.out.println("   ╭─────────────────────────────╮  ");
            System.out.println("            Actual Values           ");
            System.out.println("    ─────────────────────────────   ");
            System.out.println("     Name: "+name);
            System.out.println("     Active: "+active);
            System.out.println("   ╰─────────────────────────────╯  ");
            System.out.println("   ╭─────────────────────────────╮  ");
            System.out.println("            Change Values           ");
            System.out.println("    ─────────────────────────────   ");
            System.out.println("     CN. Change Name                ");
            System.out.println("     CA. Change Active              ");
            System.out.println("   ╰─────────────────────────────╯  ");
            System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
            System.out.println("     FS. Finish and Save            ");
            System.out.println("     EW. Exit Without Saving        ");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }
    /**

     Displays a menu for creating a new client with the given name and active status.
     Allows the user to change the name and active status before finishing and saving the new client.
     @param name the name of the new client
     @param active the active status of the new client
     */
    public void createClientMenu(String name, boolean active) {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("            Create Client           ");
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
        System.out.println("   ╭─────────────────────────────╮  ");
        System.out.println("            Actual Values           ");
        System.out.println("    ─────────────────────────────   ");
        System.out.println("     Name: "+name);
        System.out.println("     Active: "+active);
        System.out.println("   ╰─────────────────────────────╯  ");
        System.out.println("   ╭─────────────────────────────╮  ");
        System.out.println("            Change Values           ");
        System.out.println("    ─────────────────────────────   ");
        System.out.println("     CN. Change Name                ");
        System.out.println("     CA. Change Active              ");
        System.out.println("   ╰─────────────────────────────╯  ");
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
        System.out.println("     FS. Finish and Save            ");
        System.out.println("     EW. Exit Without Saving        ");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }
    /**

     This method creates a product menu with the actual values of the product specified by the input parameters: name, price, nutriscore, and vendorId.
     The menu allows the user to view available vendors, and to change any of the product values: name, price, nutriscore, and vendorId.
        @param name the name of the product to be created
        @param price the price of the product to be created
        @param nutriscore the nutriscore of the product to be created
        @param vendorId the vendor ID of the product to be created
    */
    public void createProductMenu(String name, double price, char nutriscore, int vendorId, String vendorName) {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("            Create Product          ");
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
        System.out.println("   ╭─────────────────────────────╮  ");
        System.out.println("            Actual Values           ");
        System.out.println("    ─────────────────────────────   ");
        System.out.println("     Name: "+name);
        System.out.println("     Price: "+price);
        System.out.println("     NutriScore: "+nutriscore);
        System.out.println("     Vendor ID: "+vendorId);
        System.out.println("     Vendor Name: "+vendorName);
        System.out.println("   ╰─────────────────────────────╯  ");
        System.out.println("   ╭─────────────────────────────╮  ");
        System.out.println("             View Values            ");
        System.out.println("    ─────────────────────────────   ");
        System.out.println("     VAV. View Available Vendors    ");
        System.out.println("   ╰─────────────────────────────╯  ");
        System.out.println("   ╭─────────────────────────────╮  ");
        System.out.println("            Change Values           ");
        System.out.println("    ─────────────────────────────   ");
        System.out.println("     CN. Change Name                ");
        System.out.println("     CP. Change Price               ");
        System.out.println("     CS. Change NutriScore          ");
        System.out.println("     CV. Change Vendor Assigned     ");
        System.out.println("   ╰─────────────────────────────╯  ");
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
        System.out.println("     FS. Finish and Save            ");
        System.out.println("     EW. Exit Without Saving        ");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }
    // TODO Falta hacer el menu de creación de objetos Order
    public void createOrderMenu() {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("            Create Order            ");
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
        System.out.println("   ╭─────────────────────────────╮  ");
        System.out.println("            Actual Values           ");
        System.out.println("    ─────────────────────────────   ");
        System.out.println("     Client ID: "); // TODO Falta hacer que el valor se actualice
        System.out.println("     Client Name: "); // TODO Falta hacer que el valor se actualice
        System.out.println("     Product QTY: "); // TODO Falta hacer que el valor se actualice en función de los productos añadidos
        System.out.println("   ╰─────────────────────────────╯  ");
        System.out.println("   ╭─────────────────────────────╮  ");
        System.out.println("            Change Values           ");
        System.out.println("    ─────────────────────────────   ");
        System.out.println("     CC. Change Client              ");
        System.out.println("   ╰─────────────────────────────╯  ");
        System.out.println("   ╭─────────────────────────────╮  ");
        System.out.println("             View Values            ");
        System.out.println("    ─────────────────────────────   ");
        System.out.println("     VAV. View Available Vendors    ");
        System.out.println("   ╰─────────────────────────────╯  ");
        System.out.println("   ╭─────────────────────────────╮  ");
        System.out.println("            Product List            ");
        System.out.println("    ─────────────────────────────   ");
        // TODO Falta el for para saber los productos que tiene la orden
        System.out.println("   ╰─────────────────────────────╯  ");
        // TODO También hacen falta estas opciones en el menú
        System.out.println("   ╭─────────────────────────────╮  ");
        System.out.println("            Products                ");
        System.out.println("    ─────────────────────────────   ");
        System.out.println("     API. Add Product By ID         ");
        System.out.println("     RPI. Remove Product By ID      ");
        System.out.println("   ╰─────────────────────────────╯  ");
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
        System.out.println("     FS. Finish and Save            ");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }

    // ! LIST
    /**
     * Prints a formatted console menu that lists all available objects within the system, including vendors,
     * products, clients, and orders, and their associated actions.
     * <p>
     * The method invokes other methods to print out the specific options related to each object.
     *
     * @see #listVendorMenu()
     * @see #listProductMenu()
     * @see #listClientMenu()
     * @see #listOrderMenu()
     */
    public void listAllObjectsMenu() {
        System.out.println("     \uD83E\uDF00\uD83E\uD83E\uDF02\uD83E\uDF03\uD83E\uDF04\uD83E\uDF05\uD83E\uDF06\uD83E\uDF07\uD83E\uDF08\uD83E\uDF09\uD83E\uDF0A\uD83E\uDF0B\uD83E\uDF0C\uD83E\uDF0D\uD83E\uDF0E\uD83E\uDF0F\uD83E\uDF10\uD83E\uDF11\uD83E\uDF12\uD83E\uDF13\uD83E\uDF14\uD83E\uDF15");
        System.out.println("           Listing All             ");
        System.out.println("        \uD83E\uDF16\uD83E\uDF17\uD83E\uDF18\uD83E\uDF19\uD83E\uDF1A\uD83E\uDF1B\uD83E\uDF1C\uD83E\uDF1D\uD83E\uDF1E\uD83E\uDF1F\uD83E\uDF20\uD83E\uDF21\uD83E\uDF22\uD83E\uDF23\uD83E\uDF24\uD83E\uDF25\uD83E\uDF26\uD83E\uDF27");
        listVendorMenu();
        listProductMenu();
        listClientMenu();
        listOrderMenu();
        System.out.println("     \uD83E\uDF2E\uD83E\uDF2F\uD83E\uDF30\uD83E\uDF31\uD83E\uDF32\uD83E\uDF33\uD83E\uDF34\uD83E\uDF35\uD83E\uDF36\uD83E\uDF37\uD83E\uDF38\uD83E\uDF39\uD83E\uDF3A\uD83E\uDF3B\uD83E\uDF18\uD83E\uDF19\uD83E\uDF1A\uD83E\uDF1B\uD83E\uDF1C\uD83E\uDF1D\uD83E\uDF1E\uD83E\uDF1F\uD83E\uDF20\uD83E\uDF21\uD83E\uDF22\uD83E\uDF23");
    }
    /**

     This method displays a list of vendors in a bordered format.
     The list of vendors is retrieved using the 'getVendorInstances()' method from the provided 'controller' object,
     and is displayed using the 'toString()' method of each vendor instance.
     */
    public void listVendorMenu() {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("           Listing Vendors          ");
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
        for (int i = 0; i < controller.getVendorInstances().size() ; i++) {System.out.println(controller.getVendorInstances().get(i).toString());}
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }
    /**

     Displays a formatted list of all the clients stored in the controller's client instances list.
     Each client is printed using their toString method.
     */
    public void listClientMenu() {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("           Listing Clients          ");
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
        for (int i = 0; i < controller.getClientInstances().size() ; i++) {System.out.println(controller.getClientInstances().get(i).toString());}
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }
    /**
     * This method displays a list of products in a bordered format.
     * The list of products is retrieved using the 'getProductInstances()' method from the provided 'controller' object,
     * and is displayed using the 'toString()' method of each product instance.
     */
    public void listProductMenu() {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("          Listing Products          ");
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
        for (int i = 0; i < controller.getProductInstances().size() ; i++) {System.out.println(controller.getProductInstances().get(i).toString());}
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }
    /**

     This method displays a list of orders in a bordered format.
     The list of orders is retrieved using the 'getOrderInstances()' method from the provided 'controller' object,
     and is displayed using the 'toString()' method of each order instance.
     */
    public void listOrderMenu() {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("           Listing Orders          ");
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
        for (int i = 0; i < controller.getOrderInstances().size(); i++) {
            System.out.println(controller.getOrderInstances().get(i).toString());
        }
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }
    /**

     Displays a list of products associated with the given vendor ID in a bordered format.
     Retrieves the list of products using the 'getProductInstances()' method from the provided 'controller' object,
     and displays the product information using the 'toString()' method of each product instance.
     @param vendorID an integer representing the vendor ID whose associated products are to be listed
     */
    public void listProductByVendorMenu(int vendorID) {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("   Listing products by Vendor "+vendorID);
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
        for (int i = 0; i < controller.getProductInstances().size() ; i++) {
            if (controller.getProductInstances().get(i).getVendor().getVendorId() == vendorID) {
                System.out.println(controller.getProductInstances().get(i).toString());
            }
        }
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }
    /**
     * This method displays a list of orders placed by a specific client, identified by their client ID.
     * The list of orders is retrieved using the 'getOrderInstances()' method from the provided 'controller' object,
     * and is displayed using the 'toString()' method of each order instance.
     * @param orderID the ID of the client whose orders are to be displayed
     */
    public void listOrderByClientMenu(int orderID) {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("   Listing Order By Client "+orderID);
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
        for (int i = 0; i < controller.getOrderInstances().size() ; i++) {
            if (controller.getOrderInstances().get(i).getOrderID() == orderID) {
                System.out.println(controller.getOrderInstances().get(i).toString());
            }
        }
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }

    // ! EDIT
    /**

     Displays the Edit Client menu, allowing the user to view and modify the values of a specific client instance.
     @param clientID the ID of the client instance to be edited
     */
    public void editClientMenu(int clientID) {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("            Edit Client             ");
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
        System.out.println("   ╭─────────────────────────────╮  ");
        System.out.println("            Actual Values           ");
        System.out.println("    ─────────────────────────────   ");
        for (int i = 0; i < controller.getClientInstances().size(); i++) {
            if (controller.getClientInstances().get(i).getClientID() == clientID) {
                System.out.println("     Name: "+controller.getClientInstances().get(i).getClientName());
                System.out.println("     Active: "+controller.getClientInstances().get(i).getClientActive());
            }
        }
        System.out.println("   ╰─────────────────────────────╯  ");
        System.out.println("   ╭─────────────────────────────╮  ");
        System.out.println("            Change Values           ");
        System.out.println("    ─────────────────────────────   ");
        System.out.println("     CN. Change Name                ");
        System.out.println("     CA. Change Active              ");
        System.out.println("   ╰─────────────────────────────╯  ");
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
        System.out.println("     FS. Finish and Save            ");
        System.out.println("     EW. Exit Without Saving        ");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }
    /**

     Displays a menu to edit the values of a product identified by the given product ID.
     The menu shows the current values of the product and allows the user to view available vendors,
     change the name, price, nutriScore, and vendor assigned to the product. The user can choose to finish and save
     the changes or exit without saving.
     @param productID the ID of the product to edit
     */
    public void editProductMenu(int productID) {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("            Create Product          ");
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
        System.out.println("   ╭─────────────────────────────╮  ");
        System.out.println("            Actual Values           ");
        System.out.println("    ─────────────────────────────   ");
        for (int i = 0; i < controller.getProductInstances().size(); i++) {
            if (controller.getProductInstances().get(i).getProductId() == productID) {
                System.out.println("     Name: "+controller.getProductInstances().get(i).getProductName());
                System.out.println("     Price: "+controller.getProductInstances().get(i).getProductPrice());
                System.out.println("     NutriScore: "+controller.getProductInstances().get(i).getProductNutriScore());
                System.out.println("     Vendor ID: "+controller.getProductInstances().get(i).getVendor().getVendorId());
                System.out.println("     Vendor Name: "+controller.getProductInstances().get(i).getVendor().getVendorName());
            }
        }
        System.out.println("   ╰─────────────────────────────╯  ");
        System.out.println("   ╭─────────────────────────────╮  ");
        System.out.println("             View Values            ");
        System.out.println("    ─────────────────────────────   ");
        System.out.println("     VAV. View Available Vendors    ");
        System.out.println("   ╰─────────────────────────────╯  ");
        System.out.println("   ╭─────────────────────────────╮  ");
        System.out.println("            Change Values           ");
        System.out.println("    ─────────────────────────────   ");
        System.out.println("     CN. Change Name                ");
        System.out.println("     CP. Change Price               ");
        System.out.println("     CS. Change NutriScore          ");
        System.out.println("     CV. Change Vendor Assigned     ");
        System.out.println("   ╰─────────────────────────────╯  ");
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
        System.out.println("     FS. Finish and Save            ");
        System.out.println("     EW. Exit Without Saving        ");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }
    /**

     Displays the edit vendor menu, showing the current values of the vendor with the given ID
     and the available options for changing them.
     @param vendorID the ID of the vendor to be edited
     */
    public void editVendorMenu(int vendorID) {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("            Edit Vendor             ");
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
        System.out.println("   ╭─────────────────────────────╮  ");
        System.out.println("            Actual Values           ");
        System.out.println("    ─────────────────────────────   ");
        for (int i = 0; i < controller.getVendorInstances().size(); i++) {
            if (controller.getVendorInstances().get(i).getVendorId() == vendorID) {
                System.out.println("     Name: "+controller.getVendorInstances().get(i).getVendorName());
                System.out.println("     Active: "+controller.getVendorInstances().get(i).getVendorActive());
            }
        }
        System.out.println("   ╰─────────────────────────────╯  ");
        System.out.println("   ╭─────────────────────────────╮  ");
        System.out.println("            Change Values           ");
        System.out.println("    ─────────────────────────────   ");
        System.out.println("     CN. Change Name                ");
        System.out.println("     CA. Change Active              ");
        System.out.println("   ╰─────────────────────────────╯  ");
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  ");
        System.out.println("     FS. Finish and Save            ");
        System.out.println("     EW. Exit Without Saving        ");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }
    // TODO Falta por hacer el menu de editar ordenes
    public void editOrderMenu() {}
}