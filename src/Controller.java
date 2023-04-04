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
    private static final ArrayList<Client> clientInstances = new ArrayList<>();
    /**

     A list of instances of vendors in the system.
     */
    private static final ArrayList<Vendor> vendorInstances = new ArrayList<>();
    /**

     A list of instances of orders in the system.
     */
    private static final ArrayList<Order> orderInstances = new ArrayList<>();
    /**

     A list of instances of products in the system.
     */
    private static final ArrayList<Product> productInstances = new ArrayList<>();
    /**

     This is a private static final ArrayList of integers that stores the default objects related to vendors.
     */
    private static final ArrayList<Integer> defaultObjectsVendor = new ArrayList<>();
    /**

     This is a private static final ArrayList of integers that stores the default objects related to clients.
     */
    private static final ArrayList<Integer> defaultObjectsClient = new ArrayList<>();
    /**

     This is a private static final ArrayList of integers that stores the default objects related to products.
     */
    private static final ArrayList<Integer> defaultObjectsProduct = new ArrayList<>();
    /**

     This is a private static final ArrayList of integers that stores the default objects related to orders.
     */
    private static final ArrayList<Integer> defaultObjectsOrder = new ArrayList<>();

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
    /**

     Returns the ArrayList of default objects related to vendors.
     @return the ArrayList of default objects related to vendors.
     */
    public ArrayList<Integer> getDefaultObjectsVendor() {return defaultObjectsVendor;}
    /**

     Returns the ArrayList of default objects related to clients.
     @return the ArrayList of default objects related to clients.
     */
    public ArrayList<Integer> getDefaultObjectsClient() {return defaultObjectsClient;}
    /**

     Returns the ArrayList of default objects related to products.
     @return the ArrayList of default objects related to products.
     */
    public ArrayList<Integer> getDefaultObjectsProduct() {return defaultObjectsProduct;}
    /**

     Returns the ArrayList of default objects related to orders.
     @return the ArrayList of default objects related to orders.
     */
    public ArrayList<Integer> getDefaultObjectsOrder() {return defaultObjectsOrder;}
    // * Methods
        // ! To add instances
        /**
         Adds the given product to the vendor's list of products, if the vendor exists in the system.
         If the vendor is not found, a message is printed to the console indicating that the vendor was not found.
         @param product the product to add to the vendor's list of products
         */
        public void addProductToVendor(Product product) {
            boolean found = false;
            for (Vendor vendorInstance : vendorInstances) {
                if (vendorInstance.getVendorId() == product.getVendor().getVendorId()) {
                    vendorInstance.getProducts().add(product);
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
            for (Order orderInstance : orderInstances) {
                if (orderInstance.getOrderID() == order.getOrderID()) {
                    orderInstance.getProducts().add(product);
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
        public void addOrderToInstances(Client client, ArrayList<Product> products) {
            Order order = new Order(client, products);
            orderInstances.add(order);
        }

        // ! To drop instances
    /**

     This method removes the client instance with the given client ID from the clientInstances ArrayList.
     @param clientID the ID of the client to be removed
     */
        public void dropClientFromInstances(int clientID) {
            for (int i = 0; i < clientInstances.size(); i++) {
                if (clientInstances.get(i).getClientID() == clientID) {
                    clientInstances.remove(i);
                }
            }
        }
    /**

     This method removes the vendor instance with the given vendor ID from the vendorInstances ArrayList.
     @param vendorID the ID of the vendor to be removed
     */
        public void dropVendorFromInstances(int vendorID) {
            for (int i = 0; i < vendorInstances.size(); i++) {
                if (vendorInstances.get(i).getVendorId() == vendorID) {
                    vendorInstances.remove(i);
                }
            }
        }
    /**

     This method removes the product instance with the given product ID from the productInstances ArrayList.
     @param productID the ID of the product to be removed
     */
        public void dropProductFromInstances(int productID) {
            for (int i = 0; i < productInstances.size(); i++) {
                if (productInstances.get(i).getProductId() == productID) {
                    productInstances.remove(i);
                }
            }
        }
    /**

     This method removes the order instance with the given order ID from the orderInstances ArrayList.
     @param orderID the ID of the order to be removed
     */
        public void dropOrderFromInstances(int orderID) {
            for (int i = 0; i < orderInstances.size(); i++) {
                if (orderInstances.get(i).getOrderID() == orderID) {
                    orderInstances.remove(i);
                }
            }
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
        defaultObjectsVendor.add(vendor1.getVendorId());
        Vendor vendor2 = new Vendor( "TecnoGlobal Group", true);
        vendorInstances.add(vendor2);
        defaultObjectsVendor.add(vendor2.getVendorId());
        Vendor vendor3 = new Vendor( "Comunicaciones Avanzadas Ltda.", false);
        vendorInstances.add(vendor3);
        defaultObjectsVendor.add(vendor3.getVendorId());

        // * Default products
        Product p1 = new Product( "Apple", 1.99, 'A', vendor1);
        productInstances.add(p1);
        defaultObjectsProduct.add(p1.getProductId());
        Product p2 = new Product( "Banana", 0.99, 'B', vendor1);
        productInstances.add(p2);
        defaultObjectsProduct.add(p2.getProductId());
        Product p3 = new Product( "Orange", 2.99, 'C', vendor3);
        productInstances.add(p3);
        defaultObjectsProduct.add(p3.getProductId());
        Product p4 = new Product( "Grape", 3.99, 'D', vendor2);
        productInstances.add(p4);
        defaultObjectsProduct.add(p4.getProductId());
        Product p5 = new Product( "Pineapple", 4.99, 'E', vendor2);
        productInstances.add(p5);
        defaultObjectsProduct.add(p5.getProductId());
        Product p6 = new Product( "Strawberry", 5.99, 'F', vendor1);
        productInstances.add(p6);
        defaultObjectsProduct.add(p6.getProductId());
        Product p7 = new Product( "Cherry", 6.99, 'G', vendor3);
        productInstances.add(p7);
        defaultObjectsProduct.add(p7.getProductId());
        Product p8 = new Product( "Mango", 7.99, 'H', vendor2);
        productInstances.add(p8);
        defaultObjectsProduct.add(p8.getProductId());
        Product p9 = new Product( "Pear", 8.99, 'I', vendor1);
        productInstances.add(p9);
        defaultObjectsProduct.add(p9.getProductId());
        Product p10 = new Product( "Peach", 9.99, 'J', vendor2);
        productInstances.add(p10);
        defaultObjectsProduct.add(p10.getProductId());
        Product p11 = new Product( "Kiwi", 10.99, 'K', vendor3);
        productInstances.add(p11);
        defaultObjectsProduct.add(p11.getProductId());
        Product p12 = new Product( "Lemon", 11.99, 'L', vendor1);
        productInstances.add(p12);
        defaultObjectsProduct.add(p12.getProductId());
        Product p13 = new Product( "Grapefruit", 12.99, 'M', vendor1);
        productInstances.add(p13);
        defaultObjectsProduct.add(p13.getProductId());
        Product p14 = new Product( "Pineapple", 13.99, 'N', vendor2);
        productInstances.add(p14);
        defaultObjectsProduct.add(p14.getProductId());
        Product p15 = new Product( "Strawberry", 14.99, 'O', vendor3);
        productInstances.add(p15);
        defaultObjectsProduct.add(p15.getProductId());

        // * Default clients
        Client c1 = new Client("John", true);
        clientInstances.add(c1);
        defaultObjectsClient.add(c1.getClientID());
        Client c2 = new Client( "Jane", false);
        clientInstances.add(c2);
        defaultObjectsClient.add(c2.getClientID());
        Client c3 = new Client("Mary", true);
        clientInstances.add(c3);
        defaultObjectsClient.add(c3.getClientID());

        // * Default orders
        ArrayList<Product> products1 = new ArrayList<>();
        products1.add(p1);
        products1.add(p2);
        products1.add(p15);
        products1.add(p12);
        products1.add(p10);

        ArrayList<Product> products2 = new ArrayList<>();
        products2.add(p3);
        products2.add(p15);
        products2.add(p11);

        ArrayList<Product> products3 = new ArrayList<>();
        products3.add(p5);
        products3.add(p4);
        products3.add(p8);
        products3.add(p9);

        Order order1 = new Order(c1, products1);
        orderInstances.add(order1);
        defaultObjectsOrder.add(order1.getOrderID());
        Order order2 = new Order(c2, products2);
        orderInstances.add(order2);
        defaultObjectsOrder.add(order1.getOrderID());
        Order order3 = new Order(c1, products1);
        orderInstances.add(order3);
        defaultObjectsOrder.add(order1.getOrderID());
        Order order4 = new Order(c3, products3);
        orderInstances.add(order4);
        defaultObjectsOrder.add(order1.getOrderID());
    }
    /**

     This method drops the default objects related to clients, products, orders, and vendors
     from their respective lists of default objects.
     It calls the methods to drop each client, vendor, product, and order from their instances
     and removes them from their respective lists of default objects.
     Note that the defaultObjectsClient, defaultObjectsProduct, defaultObjectsOrder, and
     defaultObjectsVendor lists must be initialized and populated prior to calling this method.
     */
    public void dropDefaultObjects() {
        int defCliSize = defaultObjectsClient.size() - 1;
        int defProSize = defaultObjectsProduct.size() - 1;
        int defOrdSize = defaultObjectsOrder.size() - 1;
        int defVendSize = defaultObjectsVendor.size() - 1;
        for (int i = defCliSize; i >= 0; i--) {
            dropClientFromInstances(defaultObjectsClient.get(i));
            defaultObjectsClient.remove(i);
        }
        for (int i = defVendSize; i >= 0; i--) {
            dropVendorFromInstances(defaultObjectsVendor.get(i));
            defaultObjectsVendor.remove(i);
        }
        for (int i = defProSize; i >= 0; i--) {
            dropProductFromInstances(defaultObjectsProduct.get(i));
            defaultObjectsProduct.remove(i);
        }
        for (int i = defOrdSize; i >= 0; i--) {
            dropOrderFromInstances(defaultObjectsOrder.get(i));
            defaultObjectsOrder.remove(i);
        }
    }
}