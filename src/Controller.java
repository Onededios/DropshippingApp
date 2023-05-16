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

     A list of ProductOnOrder objects that represents the products on an order.
     */
    private static final ArrayList<ProductOnOrder> productOnOrderInstances = new ArrayList<>();

    // ! Default objects
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
    /**

     A list of integers representing the default objects for the ProductOnOrder class.
     */
    private static final ArrayList<Integer> defaultObjectsProductOnOrder = new ArrayList<>();

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
     * Returns an ArrayList of ProductOnOrder instances.
     *
     * @return The ArrayList of ProductOnOrder instances.
     */
    public static ArrayList<ProductOnOrder> getProductOnOrderInstances() {
        return productOnOrderInstances;
    }


    // ! Default objects
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
    /**

     Returns a list of integers representing the default objects for the ProductOnOrder class.
     @return an ArrayList of integers representing the default objects for the ProductOnOrder class.
     */
    public ArrayList<Integer> getDefaultObjectsProductOnOrder() {return defaultObjectsProductOnOrder;}

    // * Methods
    /**

     Returns the Product object with the specified ID.
     @param id the ID of the Product to retrieve
     @return the Product object with the specified ID, or null if no Product with the specified ID is found
     */
    public Product getProductById(int id){
        for (int i = 0; i < productInstances.size(); i++) {
            if (productInstances.get(i).getProductId() == id) {
                return productInstances.get(i);
            }
        }
        return null;
    }
    /**

     Returns whether a Product object is in an ArrayList of ProductOnOrder objects.
     @param product the Product object to search for
     @param products the ArrayList of ProductOnOrder objects to search in
     @return true if the Product object is found in the ArrayList, false otherwise
     */
    public boolean isProductInOrder(Product product, ArrayList<ProductOnOrder> products) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProduct().getProductId() == product.getProductId()) {
                return true;
            }
        }
        return false;
    }
    /**

     Adds a specified quantity of a Product object to an ArrayList of ProductOnOrder objects.
     @param product the Product object to add
     @param products the ArrayList of ProductOnOrder objects to add to
     @param qty the quantity of the Product object to add
     @return a String message indicating whether the Product object was successfully added to the ArrayList or not
     */
    public String addProductToOrder(Product product, ArrayList<ProductOnOrder> products, int qty) {
        if (qty > 0) {
            if(isProductInOrder(product, products)){
                for (int i = 0; i < products.size(); i++) {
                    if (products.get(i).getProduct().getProductId() == product.getProductId()) {
                        products.get(i).setQty(products.get(i).getQty() + qty);
                    }
                }
            }
            else {
                ProductOnOrder productOnOrder = new ProductOnOrder(product, qty, products);
                products.add(productOnOrder);
            }

            return  "Products added to order.";
        }
        return "Error: Quantity to add must be greater than 0. Added nothing.";
    }
    /**

     Drops a specified quantity of a ProductOnOrder object from an ArrayList of ProductOnOrder objects.
     @param id the ID of the ProductOnOrder object to drop
     @param products the ArrayList of ProductOnOrder objects to drop from
     @param qty the quantity of the ProductOnOrder object to drop
     @return a String message indicating whether the ProductOnOrder object was successfully dropped from the ArrayList or not
     */
    public String dropProductFromOrder(int id, ArrayList<ProductOnOrder> products, int qty) {
        if (qty > 0) {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId() == id) {
                    if (products.get(i).getQty() > qty) {
                        products.get(i).setQty(products.get(i).getQty() - qty);
                    }
                    else {
                        products.remove(i);
                    }
                }
            }
            return "Products dropped from order.";
        }
        return "Error: Quantity to drop must be greater than 0. Dropped nothing.";
    }

    /**

     Returns a formatted String representation of an ArrayList of ProductOnOrder objects, representing a shopping list.
     @param products the ArrayList of ProductOnOrder objects to represent as a shopping list
     @return a formatted String representation of the shopping list
     */
    public String getShoppingList(ArrayList<ProductOnOrder> products) {
        String finalString =    "     ***************************" +
                                "\n     *      SHOPPING LIST      *" +
                                "\n     *   ID|Name|€/U|QTY|€/T   *" +
                                "\n     *  *********************  *";
        for (int i = 0; i < products.size(); i++) {
            finalString +=      "\n     *  "+products.get(i);
        }
        finalString +=          "\n     ***************************";
        return finalString;
    }

    /**

     Searches for an Order object in the system by its ID.
     If the ID is associated with a default object, an error message is printed and null is returned.
     If the ID is not found in the system, an error message is printed and null is returned.
     @param id the ID of the Order object to search for
     @return the Order object with the given ID if found, null otherwise
     */
    public Order findOrderById(int id) {
        boolean defaultObj = false;
        for (int j = 0; j < getDefaultObjectsOrder().size(); j++) {
            if (getDefaultObjectsOrder().get(j) == id) {
                defaultObj = true;
                System.out.println(EditConsole.RED_BRIGHT+"Error: You cannot edit a default object."+EditConsole.RESET);
            }
        }
        boolean found = false;
        if (!defaultObj) {
            for (int i = 0; i < getOrderInstances().size(); i++) {
                if (getOrderInstances().get(i).getOrderID() == id) {
                    System.out.println(EditConsole.GREEN_BRIGHT+"Order selected."+EditConsole.RESET);
                    return getOrderInstances().get(i);
                }
            }
        }
        System.out.println(EditConsole.RED_BRIGHT+"Error: Order not found."+EditConsole.RESET);
        return null;
    }
    // ! To add instances
        /**

         Creates a new product with the specified name, price, nutrition grade, and vendor, and adds it to the list of product instances.
         @param name the name of the product
         @param price the price of the product
         @param nutri the nutrition grade of the product
         @param vendor the vendor of the product
         */
        public void addProductToInstances(String name, float price, char nutri, Vendor vendor) {
            Product product = new Product(name, price, nutri, vendor);
            productInstances.add(product);
        }
        /**
         * Creates a new client with the specified name and active status, and adds it to the list of client instances.
         *
         * @param name the name of the client
         */
        public Client addClientToInstances(String name, boolean active) {
            Client client = new Client(name, active);
            clientInstances.add(client);
            return client;
        }

        public void addClientToInstancesJson(Client client) {
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
        public void addOrderToInstances(Client client, ArrayList<ProductOnOrder> products) {
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
        Vendor vendor3 = new Vendor( "Comunicaciones Avanzadas Ltd.", false);
        vendorInstances.add(vendor3);
        defaultObjectsVendor.add(vendor3.getVendorId());

        // * Default products
        Product p1 = new Product( "Apple", 1.99F, 'A', vendor1);
        productInstances.add(p1);
        defaultObjectsProduct.add(p1.getProductId());
        Product p2 = new Product( "Banana", 0.99F, 'B', vendor1);
        productInstances.add(p2);
        defaultObjectsProduct.add(p2.getProductId());
        Product p3 = new Product( "Orange", 2.99F, 'C', vendor3);
        productInstances.add(p3);
        defaultObjectsProduct.add(p3.getProductId());
        Product p4 = new Product( "Grape", 3.99F, 'D', vendor2);
        productInstances.add(p4);
        defaultObjectsProduct.add(p4.getProductId());
        Product p5 = new Product( "Pineapple", 4.99F, 'E', vendor2);
        productInstances.add(p5);
        defaultObjectsProduct.add(p5.getProductId());
        Product p6 = new Product( "Strawberry", 5.99F, 'F', vendor1);
        productInstances.add(p6);
        defaultObjectsProduct.add(p6.getProductId());
        Product p7 = new Product( "Cherry", 6.99F, 'G', vendor3);
        productInstances.add(p7);
        defaultObjectsProduct.add(p7.getProductId());
        Product p8 = new Product( "Mango", 7.99F, 'H', vendor2);
        productInstances.add(p8);
        defaultObjectsProduct.add(p8.getProductId());
        Product p9 = new Product( "Pear", 8.99F, 'I', vendor1);
        productInstances.add(p9);
        defaultObjectsProduct.add(p9.getProductId());
        Product p10 = new Product( "Peach", 9.99F, 'J', vendor2);
        productInstances.add(p10);
        defaultObjectsProduct.add(p10.getProductId());
        Product p11 = new Product( "Kiwi", 10.99F, 'K', vendor3);
        productInstances.add(p11);
        defaultObjectsProduct.add(p11.getProductId());
        Product p12 = new Product( "Lemon", 11.99F, 'L', vendor1);
        productInstances.add(p12);
        defaultObjectsProduct.add(p12.getProductId());
        Product p13 = new Product( "Grapefruit", 12.99F, 'M', vendor1);
        productInstances.add(p13);
        defaultObjectsProduct.add(p13.getProductId());
        Product p14 = new Product( "Pineapple", 13.99F, 'N', vendor2);
        productInstances.add(p14);
        defaultObjectsProduct.add(p14.getProductId());
        Product p15 = new Product( "Strawberry", 14.99F, 'O', vendor3);
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
        ArrayList<ProductOnOrder> products1 = new ArrayList<>();
        addProductToOrder(p1, products1, 3);
        addProductToOrder(p2, products1, 5);
        addProductToOrder(p3, products1, 7);
        addProductToOrder(p7, products1, 1);
        addProductToOrder(p8, products1, 4);


        ArrayList<ProductOnOrder> products2 = new ArrayList<>();
        addProductToOrder(p2, products2, 1);
        addProductToOrder(p9, products2, 8);
        addProductToOrder(p10, products2, 3);
        addProductToOrder(p12, products2, 10);
        addProductToOrder(p13, products2, 20);

        ArrayList<ProductOnOrder> products3 = new ArrayList<>();
        addProductToOrder(p8, products3, 123);
        addProductToOrder(p14, products3, 1);
        addProductToOrder(p15, products3, 2);
        addProductToOrder(p2, products3, 4);
        addProductToOrder(p6, products3, 8);


        Order order1 = new Order(c1, products1);
        orderInstances.add(order1);
        defaultObjectsOrder.add(order1.getOrderID());
        Order order2 = new Order(c2, products2);
        orderInstances.add(order2);
        defaultObjectsOrder.add(order2.getOrderID());
        Order order3 = new Order(c1, products1);
        orderInstances.add(order3);
        defaultObjectsOrder.add(order3.getOrderID());
        Order order4 = new Order(c3, products3);
        orderInstances.add(order4);
        defaultObjectsOrder.add(order4.getOrderID());
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