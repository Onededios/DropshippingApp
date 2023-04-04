import java.util.ArrayList;
/**

 Controller class is responsible for managing instances of clients, vendors, orders and products.
 Also represents a collection of instances of various entities used in the system,
 including clients, vendors, orders, and products.
 */
public class Controller {
    // * All instances
    /**

     A list of instances of clients in the system.
     */
    private static final ArrayList<Client> clientInstances = new ArrayList<Client>();
    /**

     A list of instances of vendors in the system.
     */
    private static final ArrayList<Vendor> vendorInstances = new ArrayList<Vendor>();
    /**

     A list of instances of orders in the system.
     */
    private static final ArrayList<Order> orderInstances = new ArrayList<Order>();
    /**

     A list of instances of products in the system.
     */
    private static final ArrayList<Product> productInstances = new ArrayList<Product>();

    // * Gets instances
    /**

     Returns the ArrayList containing all client instances.
     @return ArrayList containing all client instances.
     */
    public ArrayList<Client> getClientInstances() {
        return clientInstances;
    }
    /**

     Returns the ArrayList containing all vendor instances.
     @return ArrayList containing all vendor instances.
     */
    public ArrayList<Vendor> getVendorInstances() {
        return vendorInstances;
    }
    /**

     Returns the ArrayList containing all order instances.
     @return ArrayList containing all order instances.
     */
    public ArrayList<Order> getOrderInstances() {
        return orderInstances;
    }
    /**

     Returns the ArrayList containing all product instances.
     @return ArrayList containing all product instances.
     */
    public ArrayList<Product> getProductInstances() {
        return productInstances;
    }

    // * Methods
        // ! To add instances
        /**
         Adds the given product to the vendor's list of products, if the vendor exists in the system.
         If the vendor is not found, a message is printed to the console indicating that the vendor was not found.
         @param product the product to add to the vendor's list of products
         */
        public void addProductToVendor(Product product) {
            boolean found = false;
            for (int i = 0; i < vendorInstances.size(); i++) {
                if (vendorInstances.get(i).getVendorId() == product.getVendor().getVendorId()) {
                    vendorInstances.get(i).getProducts().add(product);
                    found = true;
                }
            }
            System.out.println(!found?"Product added to vendor":"Vendor not found");
            }
        /**

         Adds the given product to the specified order in the list of order instances.
         If the order is found, the product is added to its list of products, and a success message is printed.
         If the order is not found, an error message is printed.
         @param product the product to add to the order
         @param order the order to which the product is added
         */
        public void addProductToOrder(Product product, Order order) {
            boolean found = false;
            for (int i = 0; i < orderInstances.size(); i++) {
                if (orderInstances.get(i).getOrderID() == order.getOrderID()) {
                    orderInstances.get(i).getProducts().add(product);
                    found = true;
                }
            }
            System.out.println(!found?"Product added to order":"Order not found");
        }
        /**

         Creates a new product with the specified name, price, nutrition grade, and vendor, and adds it to the list of product instances.
         @param name the name of the product
         @param price the price of the product
         @param nutri the nutrition grade of the product
         @param vendor the vendor of the product
         */
        public void addProductToInstances(String name, double price, char nutri, Vendor vendor) {
            Product product = new Product(name, price, nutri, vendor);
            productInstances.add(product);
        }
        /**

         Creates a new client with the specified name and active status, and adds it to the list of client instances.
         @param name the name of the client
         @param active the active status of the client
         */
        public void addClientToInstances(String name, boolean active) {
            Client client = new Client(name, active);
            clientInstances.add(client);
        }
        /**

         Creates a new vendor with the specified name and active status, and adds it to the list of vendor instances.
         @param name the name of the vendor
         @param active the active status of the vendor
         */
        public void addVendorToInstances(String name, boolean active) {
            Vendor vendor = new Vendor(name, active);
            vendorInstances.add(vendor);
        }
        /**
         Adds the specified order to the list of order instances.
         */
        public void addOrderToInstances(Client client, ArrayList products) {
            Order order = new Order(client, products);
            orderInstances.add(order);
        }
/**

 This method initializes default instances for vendors, products, clients and orders.
 The vendors, products and clients are added to their respective instance lists.
 The orders are created using the default products and clients and added to the order instance list.
 */
    public void addDefaultObjects() {
        // * Default vendors
        Vendor vendor1 = new Vendor( "Soluciones Innovadoras S.A.", true);
        vendorInstances.add(vendor1);
        Vendor vendor2 = new Vendor( "TecnoGlobal Group", true);
        vendorInstances.add(vendor2);
        Vendor vendor3 = new Vendor( "Comunicaciones Avanzadas Ltda.", false);
        vendorInstances.add(vendor3);

        // * Default products
        Product p1 = new Product( "Apple", 1.99, 'A', vendor1);
        productInstances.add(p1);
        Product p2 = new Product( "Banana", 0.99, 'B', vendor1);
        productInstances.add(p2);
        Product p3 = new Product( "Orange", 2.99, 'C', vendor3);
        productInstances.add(p3);
        Product p4 = new Product( "Grape", 3.99, 'D', vendor2);
        productInstances.add(p4);
        Product p5 = new Product( "Pineapple", 4.99, 'E', vendor2);
        productInstances.add(p5);
        Product p6 = new Product( "Strawberry", 5.99, 'F', vendor1);
        productInstances.add(p6);
        Product p7 = new Product( "Cherry", 6.99, 'G', vendor3);
        productInstances.add(p7);
        Product p8 = new Product( "Mango", 7.99, 'H', vendor2);
        productInstances.add(p8);
        Product p9 = new Product( "Pear", 8.99, 'I', vendor1);
        productInstances.add(p9);
        Product p10 = new Product( "Peach", 9.99, 'J', vendor2);
        productInstances.add(p10);
        Product p11 = new Product( "Kiwi", 10.99, 'K', vendor3);
        productInstances.add(p11);
        Product p12 = new Product( "Lemon", 11.99, 'L', vendor1);
        productInstances.add(p12);
        Product p13 = new Product( "Grapefruit", 12.99, 'M', vendor1);
        productInstances.add(p13);
        Product p14 = new Product( "Pineapple", 13.99, 'N', vendor2);
        productInstances.add(p14);
        Product p15 = new Product( "Strawberry", 14.99, 'O', vendor3);
        productInstances.add(p15);

        // * Default clients
        Client c1 = new Client("John", true);
        clientInstances.add(c1);
        Client c2 = new Client( "Jane", false);
        clientInstances.add(c2);
        Client c3 = new Client("Mary", true);
        clientInstances.add(c3);

        // * Default orders
        ArrayList<Product> products1 = new ArrayList<Product>();
        products1.add(p1);
        products1.add(p2);
        products1.add(p15);
        products1.add(p12);
        products1.add(p10);

        ArrayList<Product> products2 = new ArrayList<Product>();
        products2.add(p3);
        products2.add(p15);
        products2.add(p11);

        ArrayList<Product> products3 = new ArrayList<Product>();
        products3.add(p5);
        products3.add(p4);
        products3.add(p8);
        products3.add(p9);

        Order order1 = new Order( c1, products1);
        orderInstances.add(order1);
        Order order2 = new Order( c2, products2);
        orderInstances.add(order2);
        Order order3 = new Order( c1, products1);
        orderInstances.add(order3);
        Order order4 = new Order( c3, products3);
        orderInstances.add(order4);
}
    // TODO Falta hacer que se puedan eliminar los objetos por defecto
    public  void dropDefaultObjects() {}
}
