// TODO Falta añadir la javadoc
// TODO Falta hacer que en la lista salga el producto una vez, el importe por unidad, la cantidad de unidades y el precio final (preciounidad*qty)
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Menu menu = new Menu();
        Read read = new Read();
        Controller controller = new Controller();
        EditConsole editConsole = new EditConsole();
        String menuOpt;

        do {
            String name = "";
            boolean active = false;
            boolean added = false;
            double price = 0.0;
            char nutriscore = '0';
            int vendorID = 0;
            String vendorName = "";
            Vendor vendor = null;
            editConsole.clearScreen();
            menu.mainMenu();
            System.out.print("Your choice: ");
            menuOpt = read.readMenuOpt();
            editConsole.clearScreen();
            String option = "";
            switch (menuOpt) {
                case "AD":
                    editConsole.clearScreen();
                    controller.addDefaultObjects();
                    System.out.println("Default objects added.");
                    editConsole.stopScreen(menuOpt);
                    break;
                case "DD":
                    editConsole.clearScreen();
                    if (controller.getDefaultObjectsClient().size() > 0) {
                        controller.dropDefaultObjects();
                        System.out.println("Default objects dropped.");
                    }
                    else {System.out.println("Error: There are no default objects.");}
                    editConsole.stopScreen(menuOpt);
                    break;
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
                                if (name.length() < 3) {System.out.println("Error: Name must be at least 3 characters long.");}
                                else {added = true; controller.addVendorToInstances(name, active); System.out.println("Vendor added.");}
                                break;
                            case "EW":
                                System.out.println("Wiping all changes and returning to the main menu.");
                                break;
                            default:
                                System.out.println("Error: Invalid option");
                                break;
                        }
                        editConsole.stopScreen(option);
                        editConsole.clearScreen();
                    } while (!option.equals("EW") && !added);
                    break;
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
                                if (name.length() < 3) {System.out.println("Error: Name must be at least 3 characters long.");}
                                else {added = true; controller.addClientToInstances(name, active); System.out.println("Client added.");}
                                break;
                            case "EW":
                                editConsole.stopScreen(option);
                                System.out.println("Wiping all changes and returning to the main menu.");
                                break;
                            default:
                                System.out.println("Error: Invalid option");
                                break;
                        }
                        editConsole.stopScreen(option);
                        editConsole.clearScreen();
                    } while (!option.equals("EW") && !added);
                    break;
                case "CP":
                    do {
                        menu.createProductMenu(name, price, nutriscore, vendorID, vendorName);
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
                                    vendorID = vendor.getVendorId();
                                    vendorName = vendor.getVendorName();
                                }
                                else {System.out.println("Error: Vendor not found.");}
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
                                if (name.length() < 3) {System.out.println("Error: Name must be at least 3 characters long.");}
                                else {nameEntered = true;}
                                if (price == 0.0) {System.out.println("Error: Price must be higher than 0.0.");}
                                else {priceEntered = true;}
                                if ((int)nutriscore < 65 | (int)nutriscore > 90) {System.out.println("Error: The product must have a nutriscore");}
                                else {nutriscoreEntered = true;}
                                if (vendorID == 0) {System.out.println("Error: The vendor entered must be valid.");}
                                else {vendorIDEntered = true;}
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
                                System.out.println("Error: Invalid option");
                                editConsole.stopScreen(option);
                                break;
                        }
                    } while (!option.equals("EW") && !added);
                    break;
                case "CO":
                    // TODO Falta hacer el menú de crear Orders
                    menu.createOrderMenu();
                    System.out.print("Your choice: ");
                    option = read.readMenuOpt();
                    editConsole.clearScreen();
                    do {
                        switch (option) {
                            case "CI":
                                break;
                            case "CN":
                                break;
                            case "CA":
                                break;
                            case "FS":
                                System.out.println("Wiping all changes and returning to the main menu.");
                                editConsole.stopScreen(option);
                                break;
                            default:
                                System.out.println("Error: Invalid option");
                                editConsole.stopScreen(option);
                                break;
                        }
                    } while (!option.equals("FS"));
                    break;
                case "LA":
                    // TODO Falta hacer el menú de listarlo todo
                    break;
                case "LV":
                    menu.listVendorMenu();
                    editConsole.stopScreen(option);
                    break;
                case "LC":
                    menu.listClientMenu();
                    editConsole.stopScreen(option);
                    break;
                case "LP":
                    menu.listProductMenu();
                    editConsole.stopScreen(option);
                    break;
                case "LO":
                    menu.listOrderMenu();
                    editConsole.stopScreen(option);
                    break;
                case "LPV":
                    menu.listProductByVendorMenu(read.readInt());
                    editConsole.stopScreen(option);
                    break;
                case "LOC":
                    menu.listOrderByClientMenu(read.readInt());
                    editConsole.stopScreen(option);
                    break;
                    // TODO Falta hacer el menu de editar proveedores
                case "EV":
                    break;
                    // TODO Falta hacer el menu de editar clientes
                case "EC":
                    break;
                    // TODO Falta hacer el menu de editar productos
                case "EP":
                    break;
                    // TODO Falta hacer el menu de editar Orders
                case "EO":
                    break;
                case "EX":
                    editConsole.clearScreen();
                    menu.endMenu();
                    break;
                default:
                    System.out.println("Error: Invalid option");
                    editConsole.stopScreen(menuOpt);
                    break;
            }
        } while (!menuOpt.equals("EX"));
    }
}