import java.util.ArrayList;
/**
 * This class is the main class of the Dropshipping application.
 * It contains the main method that runs the application.
 * @author John Smith
 * @version 1.0
 */
public class Main {
    /**
     * The main method of the Dropshipping application.
     * It initializes the application and runs the menu loop until the user quits.
     *
     * @param args The command line arguments passed to the application.
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        Read read = new Read();
        Controller controller = new Controller();
        EditConsole editConsole = new EditConsole();
        String menuOpt;
        do {
            /**
             * Those are the variables required to run the application.
             * There are only false/null/0 values, required to change 'em later.
             */
            String name = "";
            boolean active = false;
            boolean added = false;
            boolean edited = false;
            float price = 0;
            char nutriscore = '0';
            int id = 0;
            int vendorId = 0;
            int index = 0;
            String vendorName = "";
            Vendor vendor = null;
            Client client = null;
            editConsole.clearScreen();
            menu.mainMenu();
            System.out.print("Your choice: ");
            menuOpt = read.readMenuOpt();
            editConsole.clearScreen();
            String option = "";
            boolean wantedToExit;
            ArrayList<Product> products = new ArrayList<>();
            int productId;
            /**
             * Here starts the main menu switch, which needs the param. 'menuOpt' to work with the switch.
             */
            switch (menuOpt) {
                /**
                 * This is the option to add the default objects.
                 */
                case "AD":
                    editConsole.clearScreen();
                    controller.addDefaultObjects();
                    System.out.println("Default objects added.");
                    editConsole.stopScreen(menuOpt);
                    break;
                /**
                 * This is the option to delete the default objects.
                 */
                case "DD":
                    editConsole.clearScreen();
                    if (controller.getDefaultObjectsClient().size() > 0) {
                        controller.dropDefaultObjects();
                        System.out.println("Default objects dropped.");
                    } else {
                        System.out.println(EditConsole.RED_BRIGHT+"Error: There are no default objects."+EditConsole.RESET);
                    }
                    editConsole.stopScreen(menuOpt);
                    break;
                /**
                 * This is the option to create a new object Vendor.
                 */
                case "CV":
                    do {
                        menu.createVendorMenu(name, active);
                        System.out.print("Your choice: ");
                        option = read.readMenuOpt();
                        editConsole.clearScreen();
                        switch (option) {
                            case "CN":
                                editConsole.clearScreen();
                                name = read.changeName();
                                break;
                            case "CA":
                                editConsole.clearScreen();
                                active = read.changeActive();
                                break;
                            case "FS":
                                editConsole.clearScreen();
                                if (name.length() < 3) {
                                    System.out.println(EditConsole.RED_BRIGHT+"Error: Name must be at least 3 characters long."+EditConsole.RESET);
                                } else {
                                    added = true;
                                    controller.addVendorToInstances(name, active);
                                    System.out.println("Vendor added.");
                                }
                                break;
                            case "EW":
                                System.out.println("Wiping all changes and returning to the main menu.");
                                break;
                            default:
                                System.out.println(EditConsole.RED_BRIGHT+"Error: Invalid option"+EditConsole.RESET);
                                break;
                        }
                        editConsole.stopScreen(option);
                        editConsole.clearScreen();
                    } while (!option.equals("EW") && !added);
                    break;
                /**
                 * This is the option to create a new object Client.
                 */
                case "CC":
                    do {
                        menu.createClientMenu(name, active);
                        System.out.print("Your choice: ");
                        option = read.readMenuOpt();
                        editConsole.clearScreen();
                        switch (option) {
                            case "CN":
                                editConsole.clearScreen();
                                name = read.changeName();
                                break;
                            case "CA":
                                editConsole.clearScreen();
                                active = read.changeActive();
                                break;
                            case "FS":
                                editConsole.clearScreen();
                                if (name.length() < 3) {
                                    System.out.println(EditConsole.RED_BRIGHT+"Error: Name must be at least 3 characters long."+EditConsole.RESET);
                                } else {
                                    added = true;
                                    controller.addClientToInstances(name, active);
                                    System.out.println("Client added.");
                                }
                                break;
                            case "EW":
                                editConsole.stopScreen(option);
                                System.out.println("Wiping all changes and returning to the main menu.");
                                break;
                            default:
                                System.out.println(EditConsole.RED_BRIGHT+"Error: Invalid option"+EditConsole.RESET);
                                break;
                        }
                        editConsole.stopScreen(option);
                        editConsole.clearScreen();
                    } while (!option.equals("EW") && !added);
                    break;
                /**
                 * This is the option to create a new object Product.
                 */
                case "CP":
                    do {
                        menu.createProductMenu(name, price, nutriscore, id, vendorName);
                        System.out.print("Your choice: ");
                        option = read.readMenuOpt();
                        editConsole.clearScreen();
                        switch (option) {
                            case "CN":
                                editConsole.clearScreen();
                                name = read.changeName();
                                read.readMenuOpt();
                                break;
                            case "CP":
                                editConsole.clearScreen();
                                price = read.changePrice();
                                read.readMenuOpt();
                                break;
                            case "CS":
                                editConsole.clearScreen();
                                nutriscore = read.changeNutriScore();
                                read.readMenuOpt();
                                break;
                            case "CV":
                                editConsole.clearScreen();
                                vendor = read.changeVendor();
                                if (vendor != null) {
                                    id = vendor.getVendorId();
                                    vendorName = vendor.getVendorName();
                                } else {
                                    System.out.println(EditConsole.RED_BRIGHT+"Error: Vendor not found."+EditConsole.RESET);
                                }
                                read.readMenuOpt();
                                break;
                            case "VAV":
                                editConsole.clearScreen();
                                menu.listVendorMenu();
                                editConsole.stopScreen(option);
                                break;
                            case "FS":
                                boolean nameEntered = false;
                                boolean priceEntered = false;
                                boolean nutriscoreEntered = false;
                                boolean vendorIDEntered = false;
                                editConsole.clearScreen();
                                if (name.length() < 3) {
                                    System.out.println(EditConsole.RED_BRIGHT+"Error: Name must be at least 3 characters long."+EditConsole.RESET);
                                } else {
                                    nameEntered = true;
                                }
                                if (price == 0.0) {
                                    System.out.println(EditConsole.RED_BRIGHT+"Error: Price must be higher than 0.0."+EditConsole.RESET);
                                } else {
                                    priceEntered = true;
                                }
                                if ((int) nutriscore < 65 | (int) nutriscore > 90) {
                                    System.out.println(EditConsole.RED_BRIGHT+"Error: The product must have a nutriscore"+EditConsole.RESET);
                                } else {
                                    nutriscoreEntered = true;
                                }
                                if (id == 0) {
                                    System.out.println(EditConsole.RED_BRIGHT+"Error: The vendor entered must be valid."+EditConsole.RESET);
                                } else {
                                    vendorIDEntered = true;
                                }
                                editConsole.stopScreen(option);
                                if (nameEntered && priceEntered && nutriscoreEntered && vendorIDEntered) {
                                    added = true;
                                    controller.addProductToInstances(name, price, nutriscore, vendor);
                                    System.out.println("Product added.");
                                }
                                break;
                            case "EW":
                                System.out.println("Wiping all changes and returning to the main menu.");
                                editConsole.stopScreen(option);
                                break;
                            default:
                                System.out.println(EditConsole.RED_BRIGHT+"Error: Invalid option"+EditConsole.RESET);
                                editConsole.stopScreen(option);
                                break;
                        }
                    } while (!option.equals("EW") && !added);
                    break;
                /**
                 * This is the option to create a new object Order.
                 */
                case "CO":
                    do {
                        menu.createOrderMenu(id, name, products);
                        System.out.print("Your choice: ");
                        option = read.readMenuOpt();
                        editConsole.clearScreen();
                        switch (option) {
                            case "CC":
                                editConsole.clearScreen();
                                client = read.changeClient();
                                if (client != null) {
                                    id = client.getClientID();
                                    name = client.getClientName();
                                } else {
                                    System.out.println(EditConsole.RED_BRIGHT+"Error: Client not found."+EditConsole.RESET);
                                }
                                read.readMenuOpt();
                                break;
                            case "VAC":
                                editConsole.clearScreen();
                                menu.listClientMenu();
                                editConsole.stopScreen(option);
                                break;
                            case "VAP":
                                editConsole.clearScreen();
                                menu.listProductMenu();
                                editConsole.stopScreen(option);
                                break;
                            case "API":
                                editConsole.clearScreen();
                                System.out.print("Enter the product ID: ");
                                productId = read.readInt();
                                controller.addProductToList(productId, products, read.readProductQTY(productId));
                                editConsole.stopScreen(option);
                                break;
                            case "DPI":
                                editConsole.clearScreen();
                                System.out.print("Enter the product ID: ");
                                productId = read.readInt();
                                controller.dropProductFromList(productId, products, read.readProductQTY(productId));
                                editConsole.stopScreen(option);
                                break;
                            case "FS":
                                editConsole.clearScreen();
                                boolean clientAdded = false;
                                boolean productAdded = false;
                                if (client != null) {clientAdded = true;}
                                else {System.out.println(EditConsole.RED_BRIGHT+"Error: There is no Client selected."+EditConsole.RESET);}
                                if (products.size() > 0) {productAdded = true;}
                                else {System.out.println(EditConsole.RED_BRIGHT+"Error: There are no Products added."+EditConsole.RESET);}
                                if (clientAdded && productAdded) {
                                    controller.addOrderToInstances(client, products);
                                    added = true;
                                    System.out.println("Order added.");
                                }
                                editConsole.stopScreen(option);
                                break;
                            case "EW":
                                editConsole.clearScreen();
                                System.out.println("Wiping all changes and returning to the main menu.");
                                editConsole.stopScreen(option);
                                break;
                            default:
                                System.out.println(EditConsole.RED_BRIGHT+"Error: Invalid option"+EditConsole.RESET);
                                editConsole.stopScreen(option);
                                break;
                        }
                    } while (!option.equals("EW") && !added);
                    break;
                /**
                 * This is the option to list all the objects added to the running program.
                 */
                case "LA":
                    menu.listAllObjectsMenu();
                    editConsole.stopScreen(option);
                    break;
                /**
                 * This is the option to list all the Vendor objects added to the running program.
                 */
                case "LV":
                    menu.listVendorMenu();
                    editConsole.stopScreen(option);
                    break;
                /**
                 * This is the option to list all the Client objects added to the running program.
                 */
                case "LC":
                    menu.listClientMenu();
                    editConsole.stopScreen(option);
                    break;
                /**
                 * This is the option to list all the Product objects added to the running program.
                 */
                case "LP":
                    menu.listProductMenu();
                    editConsole.stopScreen(option);
                    break;
                /**
                 * This is the option to list all the Order objects added to the running program.
                 */
                case "LO":
                    menu.listOrderMenu();
                    editConsole.stopScreen(option);
                    break;
                /**
                 * This is the option to list all the Product objects by only the ID from a specified object Vendor added to the running program.
                 */
                case "LPV":
                    menu.listProductByVendorMenu(read.readInt());
                    editConsole.stopScreen(option);
                    break;
                /**
                 * This is the option to list all the Order objects by only the ID from a specified object Client added to the running program.
                 */
                case "LOC":
                    menu.listOrderByClientMenu(read.readInt());
                    editConsole.stopScreen(option);
                    break;
                /**
                 * This is the option to edit a Vendor object by the ID assigned to it.
                 */
                case "EV":
                    boolean vendorSelected = false;
                    wantedToExit = false;
                    do {
                        menu.selectVendorMenu(name, id);
                        System.out.print("Your choice: ");
                        option = read.readMenuOpt();
                        editConsole.clearScreen();
                        switch (option) {
                            case "VAV":
                                editConsole.clearScreen();
                                menu.listVendorMenu();
                                break;
                            case "CS":
                                boolean found = false;
                                boolean notADefaultObject = true;
                                System.out.print("\nOk, so tell me the ID to edit: ");
                                id = read.readInt();
                                for (int i = 0; i < controller.getVendorInstances().size(); i++) {
                                    if (controller.getVendorInstances().get(i).getVendorId() == id) {
                                        for (int j = 0; j < controller.getDefaultObjectsVendor().size(); j++) {
                                            if (controller.getDefaultObjectsVendor().get(j) == id) {
                                                notADefaultObject = false;
                                                break;
                                            }
                                        }
                                        if (notADefaultObject) {
                                            name = controller.getVendorInstances().get(i).getVendorName();
                                            active = controller.getVendorInstances().get(i).getVendorActive();
                                            index = i;
                                        }
                                        found = true;
                                    }
                                }
                                if (!found) {
                                    System.out.println(EditConsole.RED_BRIGHT+"Error: Vendor not found."+EditConsole.RESET);
                                } else if (!notADefaultObject) {
                                    System.out.println(EditConsole.RED_BRIGHT+"Error: You cannot edit a default object."+EditConsole.RESET);
                                    id = 0;
                                } else {
                                    vendorSelected = true;
                                    System.out.println("Vendor selected.");
                                }
                                break;
                            case "C":
                                if (vendorSelected) {
                                    System.out.println("Continuing to the edit menu...");
                                } else {
                                    System.out.println(EditConsole.RED_BRIGHT+"Error: You must select a Vendor first."+EditConsole.RESET);
                                }
                                break;
                            case "EW":
                                wantedToExit = true;
                                System.out.println("Wiping all changes and returning to the main menu.");
                                break;
                        }
                        editConsole.stopScreen(option);
                        editConsole.clearScreen();
                    } while (!option.equals("EW") && (!option.equals("C") || !vendorSelected));
                    if (vendorSelected && !wantedToExit) {
                        do {
                            menu.editVendorMenu(name, active);
                            System.out.print("Your choice: ");
                            option = read.readMenuOpt();
                            editConsole.clearScreen();
                            switch (option) {
                                case "CN":
                                    editConsole.clearScreen();
                                    name = read.changeName();
                                    edited = true;
                                    break;
                                case "CA":
                                    editConsole.clearScreen();
                                    active = read.changeActive();
                                    edited = true;
                                    break;
                                case "DROP":
                                    editConsole.clearScreen();
                                    controller.getVendorInstances().remove(index);
                                    System.out.println("Vendor dropped.");
                                    added = true;
                                    break;
                                case "FS":
                                    editConsole.clearScreen();
                                    if (edited) {
                                        if (name.length() < 3) {
                                            System.out.println(EditConsole.RED_BRIGHT+"Error: Name must be at least 3 characters long."+EditConsole.RESET);
                                        } else {
                                            added = true;
                                            for (int i = 0; i < controller.getVendorInstances().size(); i++) {
                                                if (controller.getVendorInstances().get(i).getVendorId() == id) {
                                                    controller.getVendorInstances().get(i).setVendorName(name);
                                                    controller.getVendorInstances().get(i).setVendorActive(active);
                                                }
                                            }
                                            System.out.println("Vendor changed.");
                                        }
                                    }
                                    else {System.out.println(EditConsole.RED_BRIGHT+"Error: You must change a value or just go 'EW'."+EditConsole.RESET);}
                                    break;
                                case "EW":
                                    System.out.println("Wiping all changes and returning to the main menu.");
                                    break;
                                default:
                                    System.out.println(EditConsole.RED_BRIGHT+"Error: Invalid option"+EditConsole.RESET);
                                    break;
                            }
                            editConsole.stopScreen(option);
                            editConsole.clearScreen();
                        } while (!option.equals("EW") && !added);
                    }
                    break;
                /**
                 * This is the option to edit a Client object by the ID assigned to it.
                 */
                case "EC":
                    boolean clientSelected = false;
                    wantedToExit = false;
                    do {
                        menu.selectClientMenu(name, id);
                        System.out.print("Your choice: ");
                        option = read.readMenuOpt();
                        editConsole.clearScreen();
                        switch (option) {
                            case "VAC":
                                editConsole.clearScreen();
                                menu.listClientMenu();
                                break;
                            case "CS":
                                boolean found = false;
                                boolean notADefaultObject = true;
                                System.out.print("\nOk, so tell me the ID to edit: ");
                                id = read.readInt();
                                for (int i = 0; i < controller.getClientInstances().size(); i++) {
                                    if (controller.getClientInstances().get(i).getClientID() == id) {
                                        for (int j = 0; j < controller.getDefaultObjectsClient().size(); j++) {
                                            if (controller.getDefaultObjectsClient().get(j) == id) {
                                                notADefaultObject = false;
                                                break;
                                            }
                                        }
                                        if (notADefaultObject) {
                                            name = controller.getClientInstances().get(i).getClientName();
                                            active = controller.getClientInstances().get(i).getClientActive();
                                            index = i;
                                        }
                                        found = true;
                                    }
                                }
                                if (!found) {
                                    System.out.println(EditConsole.RED_BRIGHT+"Error: Client not found."+EditConsole.RESET);
                                } else if (!notADefaultObject) {
                                    System.out.println(EditConsole.RED_BRIGHT+"Error: You cannot edit a default object."+EditConsole.RESET);
                                    id = 0;
                                } else {
                                    clientSelected = true;
                                    System.out.println("Client selected.");
                                }
                                break;
                            case "C":
                                if (clientSelected) {
                                    System.out.println("Continuing to the edit menu...");
                                } else {
                                    System.out.println(EditConsole.RED_BRIGHT+"Error: You must select a Client first."+EditConsole.RESET);
                                }
                                break;
                            case "EW":
                                wantedToExit = true;
                                System.out.println("Wiping all changes and returning to the main menu.");
                                break;
                        }
                        editConsole.stopScreen(option);
                        editConsole.clearScreen();
                    } while (!option.equals("EW") && (!option.equals("C") || !clientSelected));
                    if (clientSelected && !wantedToExit) {
                        do {
                            menu.editClientMenu(name, active);
                            System.out.print("Your choice: ");
                            option = read.readMenuOpt();
                            editConsole.clearScreen();
                            switch (option) {
                                case "CN":
                                    editConsole.clearScreen();
                                    name = read.changeName();
                                    edited = true;
                                    break;
                                case "CA":
                                    editConsole.clearScreen();
                                    active = read.changeActive();
                                    edited = true;
                                    break;
                                case "DROP":
                                    editConsole.clearScreen();
                                    controller.getClientInstances().remove(index);
                                    System.out.println("Client dropped.");
                                    added = true;
                                    break;
                                case "FS":
                                    editConsole.clearScreen();
                                    if (edited) {
                                        if (name.length() < 3) {
                                            System.out.println(EditConsole.RED_BRIGHT+"Error: Name must be at least 3 characters long."+EditConsole.RESET);
                                        } else {
                                            added = true;
                                            for (int i = 0; i < controller.getClientInstances().size(); i++) {
                                                if (controller.getClientInstances().get(i).getClientID() == id) {
                                                    controller.getClientInstances().get(i).setClientName(name);
                                                    controller.getClientInstances().get(i).setClientActive(active);
                                                }
                                            }
                                            System.out.println("Client changed.");
                                        }
                                    }
                                    else {System.out.println(EditConsole.RED_BRIGHT+"Error: You must change a value or just go 'EW'."+EditConsole.RESET);}
                                    break;
                                case "EW":
                                    System.out.println("Wiping all changes and returning to the main menu.");
                                    break;
                                default:
                                    System.out.println(EditConsole.RED_BRIGHT+"Error: Invalid option"+EditConsole.RESET);
                                    break;
                            }
                            editConsole.stopScreen(option);
                            editConsole.clearScreen();
                        } while (!option.equals("EW") && !added);
                    }
                    break;
                /**
                 * This is the option to edit a Product object by the ID assigned to it.
                 */
                case "EP":
                    boolean productSelected = false;
                    wantedToExit = false;
                    do {
                        menu.selectProductMenu(name, id);
                        System.out.print("Your choice: ");
                        option = read.readMenuOpt();
                        editConsole.clearScreen();
                        switch (option) {
                            case "VAP":
                                editConsole.clearScreen();
                                menu.listProductMenu();
                                break;
                            case "CS":
                                boolean found = false;
                                boolean notADefaultObject = true;
                                System.out.print("\nOk, so tell me the ID to edit: ");
                                id = read.readInt();
                                for (int i = 0; i < controller.getProductInstances().size(); i++) {
                                    if (controller.getProductInstances().get(i).getProductId() == id) {
                                        for (int j = 0; j < controller.getDefaultObjectsProduct().size(); j++) {
                                            if (controller.getDefaultObjectsProduct().get(j) == id) {
                                                notADefaultObject = false;
                                                break;
                                            }
                                        }
                                        if (notADefaultObject) {
                                            name = controller.getProductInstances().get(i).getProductName();
                                            price = controller.getProductInstances().get(i).getProductPrice();
                                            nutriscore = controller.getProductInstances().get(i).getProductNutriScore();
                                            vendorId = controller.getProductInstances().get(i).getVendor().getVendorId();
                                            vendorName = controller.getProductInstances().get(i).getVendor().getVendorName();
                                            index = i;}
                                        found = true;
                                    }
                                }
                                if (!found) {
                                    System.out.println(EditConsole.RED_BRIGHT+"Error: Product not found."+EditConsole.RESET);
                                } else if (!notADefaultObject) {
                                    System.out.println(EditConsole.RED_BRIGHT+"Error: You cannot edit a default object."+EditConsole.RESET);
                                    id = 0;
                                } else {
                                    productSelected = true;
                                    System.out.println("Product selected.");
                                }
                                break;
                            case "C":
                                if (productSelected) {
                                    System.out.println("Continuing to the edit menu...");
                                } else {
                                    System.out.println(EditConsole.RED_BRIGHT+"Error: You must select a Product first."+EditConsole.RESET);
                                }
                                break;
                            case "EW":
                                wantedToExit = true;
                                System.out.println("Wiping all changes and returning to the main menu.");
                                break;
                        }
                        editConsole.stopScreen(option);
                        editConsole.clearScreen();
                    } while (!option.equals("EW") && (!option.equals("C") || !productSelected));
                    if (productSelected && !wantedToExit) {
                        do {
                            menu.editProductMenu(name, price, nutriscore, vendorId, vendorName);
                            System.out.print("Your choice: ");
                            option = read.readMenuOpt();
                            editConsole.clearScreen();
                            switch (option) {
                                case "CN":
                                    editConsole.clearScreen();
                                    name = read.changeName();
                                    read.readMenuOpt();
                                    edited = true;
                                    break;
                                case "CP":
                                    editConsole.clearScreen();
                                    price = read.changePrice();
                                    read.readMenuOpt();
                                    edited = true;
                                    break;
                                case "CS":
                                    editConsole.clearScreen();
                                    nutriscore = read.changeNutriScore();
                                    read.readMenuOpt();
                                    edited = true;
                                    break;
                                case "CV":
                                    editConsole.clearScreen();
                                    vendor = read.changeVendor();
                                    if (vendor != null) {
                                        id = vendor.getVendorId();
                                        vendorName = vendor.getVendorName();
                                        edited = true;
                                    } else {
                                        System.out.println(EditConsole.RED_BRIGHT+"Error: Vendor not found."+EditConsole.RESET);
                                    }
                                    read.readMenuOpt();
                                    break;
                                case "DROP":
                                    editConsole.clearScreen();
                                    controller.getProductInstances().remove(index);
                                    System.out.println("Product dropped.");
                                    added = true;
                                    break;
                                case "VAV":
                                    editConsole.clearScreen();
                                    menu.listVendorMenu();
                                    editConsole.stopScreen(option);
                                    break;
                                case "FS":
                                    if (edited) {
                                        boolean nameEntered = false;
                                        boolean priceEntered = false;
                                        boolean nutriscoreEntered = false;
                                        boolean vendorIDEntered = false;
                                        editConsole.clearScreen();
                                        if (name.length() < 3) {
                                            System.out.println(EditConsole.RED_BRIGHT+"Error: Name must be at least 3 characters long."+EditConsole.RESET);
                                        } else {
                                            nameEntered = true;
                                        }
                                        if (price == 0.0) {
                                            System.out.println(EditConsole.RED_BRIGHT+"Error: Price must be higher than 0.0."+EditConsole.RESET);
                                        } else {
                                            priceEntered = true;
                                        }
                                        if ((int) nutriscore < 65 | (int) nutriscore > 90) {
                                            System.out.println(EditConsole.RED_BRIGHT+"Error: The product must have a nutriscore"+EditConsole.RESET);
                                        } else {
                                            nutriscoreEntered = true;
                                        }
                                        if (id == 0) {
                                            System.out.println(EditConsole.RED_BRIGHT+"Error: The vendor entered must be valid."+EditConsole.RESET);
                                        } else {
                                            vendorIDEntered = true;
                                        }
                                        if (nameEntered && priceEntered && nutriscoreEntered && vendorIDEntered) {
                                            added = true;
                                            for (int i = 0; i < controller.getProductInstances().size(); i++) {
                                                if (controller.getProductInstances().get(i).getProductId() == id) {
                                                    controller.getProductInstances().get(i).setProductName(name);
                                                    controller.getProductInstances().get(i).setProductPrice(price);
                                                    controller.getProductInstances().get(i).setProductNutriScore(nutriscore);
                                                    for (int j = 0; j < controller.getVendorInstances().size(); j++) {
                                                        if (controller.getVendorInstances().get(j).getVendorId() == vendorId) {
                                                            controller.getProductInstances().get(i).setVendor(controller.getVendorInstances().get(j));
                                                        }
                                                    }
                                                }
                                            }
                                            System.out.println("Product changed.");
                                        }
                                    }
                                    else {System.out.println(EditConsole.RED_BRIGHT+"Error: You must change a value or just go 'EW'."+EditConsole.RESET);}
                                    break;
                                case "EW":
                                    System.out.println("Wiping all changes and returning to the main menu.");
                                    break;
                                default:
                                    System.out.println(EditConsole.RED_BRIGHT+"Error: Invalid option"+EditConsole.RESET);
                                    break;
                            }
                            editConsole.stopScreen(option);
                            editConsole.clearScreen();
                        } while (!option.equals("EW") && !added);
                    }
                    break;
                /**
                 * This is the option to edit a Order object by the ID assigned to it.
                 */
                case "EO":
                    boolean orderSelected = false;
                    wantedToExit = false;
                    do {
                        /*
                            ! Remember that in this case:
                            !   active: is the same as paid, just to reutilice attributes
                            !   vendorID: is an attribute of client, just to reutilice attributes
                            !   vendorName: is an attribute of client, just to reutilice attributes
                         */
                        menu.selectOrderMenu(id, active, vendorId, vendorName, price);
                        System.out.print("Your choice: ");
                        option = read.readMenuOpt();
                        editConsole.clearScreen();
                        switch (option) {
                            case "VAO":
                                editConsole.clearScreen();
                                menu.listOrderMenu();
                                break;
                            case "CS":
                                boolean found = false;
                                boolean notADefaultObject = true;
                                System.out.print("\nOk, so tell me the ID to edit: ");
                                id = read.readInt();
                                for (int i = 0; i < controller.getOrderInstances().size(); i++) {
                                    if (controller.getOrderInstances().get(i).getOrderID() == id) {
                                        index = i;
                                        for (int j = 0; j < controller.getDefaultObjectsOrder().size(); j++) {
                                            if (controller.getDefaultObjectsOrder().get(j) == id) {
                                                notADefaultObject = false;
                                                break;
                                            }
                                        }
                                        if (notADefaultObject) {
                                            id = controller.getOrderInstances().get(i).getOrderID();
                                            vendorId = controller.getOrderInstances().get(i).getClient().getClientID();
                                            vendorName = controller.getOrderInstances().get(i).getClient().getClientName();
                                            price = controller.getOrderInstances().get(i).getTotalPrice();
                                            active = controller.getOrderInstances().get(i).getOrderPaid();
                                        }
                                        found = true;
                                    }
                                }
                                if (!found) {
                                    System.out.println(EditConsole.RED_BRIGHT+"Error: Order not found."+EditConsole.RESET);
                                } else if (!notADefaultObject) {
                                    System.out.println(EditConsole.RED_BRIGHT+"Error: You cannot edit a default object."+EditConsole.RESET);
                                    id = 0;
                                } else {
                                    orderSelected = true;
                                    System.out.println("Order selected.");
                                }
                                break;
                            case "C":
                                if (orderSelected) {
                                    System.out.println("Continuing to the edit menu...");
                                } else {
                                    System.out.println(EditConsole.RED_BRIGHT+"Error: You must select an Order first."+EditConsole.RESET);
                                }
                                break;
                            case "EW":
                                wantedToExit = true;
                                System.out.println("Wiping all changes and returning to the main menu.");
                                break;
                        }
                        editConsole.stopScreen(option);
                        editConsole.clearScreen();
                    } while (!option.equals("EW") && (!option.equals("C") || !orderSelected));
                    products = controller.getOrderInstances().get(index).getProducts();
                    client = controller.getOrderInstances().get(index).getClient();
                    if (orderSelected && !wantedToExit) {
                        do {
                            menu.editOrderMenu(vendorId, vendorName, active, products);
                            System.out.print("Your choice: ");
                            option = read.readMenuOpt();
                            editConsole.clearScreen();
                            switch (option) {
                                case "CC":
                                    editConsole.clearScreen();
                                    client = read.changeClient();
                                    if (client != null) {
                                        vendorId = client.getClientID();
                                        vendorName = client.getClientName();
                                    } else {
                                        System.out.println(EditConsole.RED_BRIGHT+"Error: Client not found."+EditConsole.RESET);
                                    }
                                    read.readMenuOpt();
                                    edited = true;
                                    break;
                                case "CP":
                                    editConsole.clearScreen();
                                    active = read.changeActive();
                                    read.readMenuOpt();
                                    edited = true;
                                    break;
                                case "DROP":
                                    editConsole.clearScreen();
                                    controller.getOrderInstances().remove(index);
                                    System.out.println("Order dropped.");
                                    added = true;
                                    break;
                                case "VAC":
                                    editConsole.clearScreen();
                                    menu.listClientMenu();
                                    editConsole.stopScreen(option);
                                    break;
                                case "VAP":
                                    editConsole.clearScreen();
                                    menu.listProductMenu();
                                    editConsole.stopScreen(option);
                                    break;
                                case "API":
                                    editConsole.clearScreen();
                                    System.out.print("Enter the product ID: ");
                                    productId = read.readInt();
                                    controller.addProductToList(productId, products, read.readProductQTY(productId));
                                    editConsole.stopScreen(option);
                                    break;
                                case "DPI":
                                    editConsole.clearScreen();
                                    System.out.print("Enter the product ID: ");
                                    productId = read.readInt();
                                    controller.dropProductFromList(productId, products, read.readProductQTY(productId));
                                    editConsole.stopScreen(option);
                                    break;
                                case "FS":
                                    if (edited) {
                                        editConsole.clearScreen();
                                        boolean clientAdded = false;
                                        boolean productAdded = false;
                                        if (client != null) {
                                            clientAdded = true;
                                        } else {
                                            System.out.println(EditConsole.RED_BRIGHT+"Error: There is no Client selected."+EditConsole.RESET);
                                        }
                                        if (products.size() > 0) {
                                            productAdded = true;
                                        } else {
                                            System.out.println(EditConsole.RED_BRIGHT+"Error: There are no Products added."+EditConsole.RESET);
                                        }
                                        if (clientAdded && productAdded) {
                                            controller.getOrderInstances().get(id).setClient(client);
                                            controller.getOrderInstances().get(id).setOrderPaid(active);
                                            controller.getOrderInstances().get(id).setProducts(products);
                                            added = true;
                                            System.out.println("Order changed.");
                                        }
                                    }
                                    else {System.out.println(EditConsole.RED_BRIGHT+"Error: You must change a value or just go 'EW'."+EditConsole.RESET);}
                                    break;
                                case "EW":
                                    System.out.println("Wiping all changes and returning to the main menu.");
                                    break;
                                default:
                                    System.out.println(EditConsole.RED_BRIGHT+"Error: Invalid option"+EditConsole.RESET);
                                    break;
                            }
                            editConsole.stopScreen(option);
                            editConsole.clearScreen();
                        } while (!option.equals("EW") && !added);
                    }
                    break;
                /**
                 * This is the option is the default option for the main menu to exit the program.
                 */
                case "EX":
                    editConsole.clearScreen();
                    menu.endMenu();
                    break;
                default:
                    System.out.println(EditConsole.RED_BRIGHT+"Error: Invalid option"+EditConsole.RESET);
                    editConsole.stopScreen(menuOpt);
                    break;
            }
        } while (!menuOpt.equals("EX"));
    }
}