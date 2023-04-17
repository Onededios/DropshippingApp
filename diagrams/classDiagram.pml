@startuml
class Client {
- int clientID
- String clientName
- LocalDate clientRegDate
- boolean clientActive
~ Controller controller
~ <<Create>> Client(String,boolean)
+ int getClientID()
+ void setClientID(int)
+ String getClientName()
+ void setClientName(String)
+ LocalDate getClientRegDate()
+ boolean getClientActive()
+ void setClientActive(boolean)
- int getBiggestClientId()
+ String toString()
}
note top of Client


 This class represents a client in the system.
 
end note
note left of Client::clientID


     The ID of the client.
     
end note
note right of Client::clientName


     The name of the client.
     
end note
note left of Client::clientRegDate


     The registration date of the client.
     
end note
note right of Client::clientActive


     The status of the client (active/inactive).
     
end note
note left of Client::controller


     The controller used by the client.
     
end note
note left of Client::Client(String,boolean)


     Creates a new client instance.
     @param clientName The name of the client.
     @param clientActive The status of the client (active/inactive).
     
end note
note right of Client::getClientID()


     Gets the client ID of this client.
     @return the client ID of this client.
     
end note
note left of Client::setClientID(int)


     Sets the client ID of this client.
     @param clientID the new client ID to be set.
     
end note
note right of Client::getClientName()


     Gets the name of this client.
     @return the name of this client.
     
end note
note left of Client::setClientName(String)


     Sets the name of this client.
     @param clientName the new name to be set.
     
end note
note right of Client::getClientRegDate()


     Gets the registration date of this client.
     @return the registration date of this client.
     
end note
note left of Client::getClientActive()


     Gets the active status of this client.
     @return the active status of this client.
     
end note
note right of Client::setClientActive(boolean)


     Sets the active status of this client.
     @param clientActive the new active status to be set.
     
end note
note left of Client::getBiggestClientId()


     Gets the biggest client ID among all existing client instances.
     @return the biggest client ID among all existing client instances.
     
end note
note right of Client::toString()


 Returns a string representation of the client instance.
 @return A string containing the client's name, ID, registration date and active status.
 
end note

class Order {
- int orderID
- LocalDate orderDate
- Client client
- boolean orderPaid
- float totalPrice
- ArrayList<Product> products
~ Controller controller
+ <<Create>> Order(Client,ArrayList<Product>)
+ int getOrderID()
+ void setOrderID(int)
+ LocalDate getOrderDate()
+ Client getClient()
+ void setClient(Client)
+ boolean getOrderPaid()
+ void setOrderPaid(boolean)
+ ArrayList<Product> getProducts()
+ void setProducts(ArrayList<Product>)
- int getBiggestOrderId()
+ float getTotalPrice()
+ String toString()
}
note top of Order


 The Order class represents an order made by a client, including the order ID, date, client details,
 whether it has been paid or not, product quantity, total price and the products included in the order.
 
end note
note left of Order::orderID


     The unique identifier for this order.
     
end note
note right of Order::orderDate


     The date when the order was made.
     
end note
note left of Order::client


     The client who made the order.
     
end note
note right of Order::orderPaid


     Whether the order has been paid for.
     
end note
note left of Order::totalPrice


     The total price of the order.
     
end note
note right of Order::products


     The list of products included in the order.
     
end note
note left of Order::controller


     The controller used to manage this order instance.
     
end note
note left of Order::Order(Client,ArrayList<Product>)


     Constructs an order object with the specified client and list of products.
     The order ID is automatically generated as the current largest order ID plus one.
     The order date is set to the current date.
     The payment status is set to false.
     The product quantity is set to the size of the product list.
     The total price is calculated as the sum of the prices of all products in the list.
     @param client the client who made the order
     @param products the list of products ordered
     
end note
note right of Order::getOrderID()


     Returns the order ID of this order.
     @return the order ID of this order.
     
end note
note left of Order::setOrderID(int)


     Sets the order ID of this order to the specified value.
     @param orderID the new order ID of this order.
     
end note
note right of Order::getOrderDate()


     Returns the order date of this order.
     @return the order date of this order.
     
end note
note left of Order::getClient()


     Returns the client of this order.
     @return the client of this order.
     
end note
note right of Order::setClient(Client)


     Sets the client of this order to the specified value.
     @param client the new client of this order.
     
end note
note left of Order::getOrderPaid()


     Returns true if this order has been paid for, false otherwise.
     @return true if this order has been paid for, false otherwise.
     
end note
note right of Order::setOrderPaid(boolean)


     Sets whether this order has been paid for.
     @param orderPaid true if this order has been paid for, false otherwise.
     
end note
note left of Order::getProducts()


     Returns the list of products in this order.
     @return the list of products in this order.
     
end note
note right of Order::setProducts(ArrayList<Product>)


     Sets the list of products in this order to the specified value.
     @param products the new list of products in this order.
     
end note
note left of Order::getBiggestOrderId()


     Returns the biggest order ID in the controller's list of order instances.
     @return the biggest order ID
     
end note
note right of Order::getTotalPrice()


     Calculates the total price of all products in the list.
     @return The total price of all products in the list.
     
end note
note left of Order::toString()


     Returns a string representation of this order object.
     The returned string contains the order ID, order date, payment status, client ID, client name,
     total price, and a list of products in the order, including their ID, name, quantity, unit price,
     and total price. The shopping list is obtained by calling the {@code printOutProductList} method
     of the controller object associated with this order.
     @return a string representation of this order object.
     
end note

class Read {
~ Controller controller
~ Scanner scanner
+ String readMenuOpt()
- char readChar()
+ int readInt()
+ float readFloat()
+ String changeName()
+ boolean changeActive()
+ char changeNutriScore()
+ float changePrice()
+ Vendor changeVendor()
+ Client changeClient()
+ int readProductQTY(int)
}
note top of Read


 The Read class is used for reading user input from the console and interacting with a Controller object.
 It has a Controller object and a Scanner object as instance variables, and provides methods for reading
 different types of user input and passing them to the Controller.
 All methods in this class must return something
 
end note
note left of Read::controller

The Controller object used by this Read instance.

end note
note right of Read::scanner

     The Scanner object used by this Read instance for reading user input from the console.
     
end note
note left of Read::readMenuOpt()


     Reads a string from standard input and returns it in uppercase.
     This method is commonly used to read user input for menu options.
     @return the user input string in uppercase
     
end note
note right of Read::readChar()


     Reads a single character from standard input and returns it as a char.
     @return the character read from standard input
     
end note
note left of Read::readInt()


     Reads a string from standard input and attempts to parse it as an integer.
     If the input is not a valid integer, an error message is printed and 0 is returned.
     @return the integer parsed from the user input, or 0 if the input is not a valid integer
     
end note
note right of Read::readFloat()


     Reads a string from standard input and attempts to parse it as a float.
     If the input is not a valid float, an error message is printed and 0 is returned.
     @return the float parsed from the user input, or 0 if the input is not a valid float
     
end note
note left of Read::changeName()


     Prompts the user to enter a new name and validates the input.
     If the name is less than 3 characters long, an error message is printed and an empty string is returned.
     Otherwise, the input is returned as a string and a success message is printed.
     @return the new name entered by the user as a string, or an empty string if the input is invalid
     
end note
note right of Read::changeActive()


     Prompts the user to set a new value for the "active" attribute.
     If the user enters "Y", true is returned and a success message is printed.
     If the user enters anything else, false is returned and a default message is printed.
     @return true if the user entered "Y", false otherwise
     
end note
note left of Read::changeNutriScore()


     Prompts the user to enter a new value for the "nutri score" attribute and validates the input.
     If the input is not a single uppercase letter between A and Z, an error message is printed and 0 is returned.
     Otherwise, the input is returned as a char and a success message is printed.
     @return the new nutri score entered by the user as a char, or 0 if the input is invalid
     
end note
note right of Read::changePrice()


     Prompts the user to enter a new value for the "price" attribute and validates the input.
     If the input is negative, an error message is printed and 0 is returned.
     Otherwise, the input is returned as a float and a success message is printed.
     @return the new price entered by the user as a float, or 0 if the input is invalid
     
end note
note left of Read::changeVendor()


     Prompts the user to enter a new vendor ID and searches for the corresponding vendor object.
     If a vendor with the specified ID is found, it is returned and a success message is printed.
     If no vendor with the specified ID is found, null is returned and an error message is printed.
     @return the updated vendor object with the specified ID, or null if no vendor is found
     
end note
note right of Read::changeClient()


     Prompts the user to enter a client ID and searches for a matching client instance in the controller's list of client instances.
     If a matching client instance is found, the method returns the client instance and prints "Client updated."
     If a matching client instance is not found, the method returns null.
     @return the updated client instance if a matching client is found, or null if no matching client is found
     
end note
note left of Read::readProductQTY(int)


     Reads the quantity of a given product ID from the user input.
     @param id The ID of the product to read the quantity for.
     @return The quantity of the given product ID read from user input.
     csharp
     Copy code
     Returns 0 if the product ID is not found.
     
end note

class Vendor {
- int vendorId
- String vendorName
- LocalDate vendorRegDate
- boolean vendorActive
- ArrayList<Product> products
~ Controller controller
+ <<Create>> Vendor(String,boolean)
+ int getVendorId()
+ void setVendorId(int)
+ String getVendorName()
+ void setVendorName(String)
+ LocalDate getVendorRegDate()
+ boolean getVendorActive()
+ void setVendorActive(boolean)
+ ArrayList<Product> getProducts()
+ void setProducts(ArrayList<Product>)
+ int getBiggestVendorId()
+ String toString()
}
note top of Vendor


 This class represents a Vendor that provides products to the store.
 The vendor has a unique identifier, name, registration date, activity status,
 and a list of products they provide to the store.
 
end note
note left of Vendor::vendorId

     * An integer representing the unique identifier of the vendor.
     
end note
note right of Vendor::vendorName

     * A string representing the name of the vendor.
     
end note
note left of Vendor::vendorRegDate

     * A LocalDate representing the registration date of the vendor.
     
end note
note right of Vendor::vendorActive

     * A boolean representing the activity status of the vendor.
     
end note
note left of Vendor::products

     * An ArrayList of Products representing the products offered by the vendor.
     
end note
note right of Vendor::controller

     * A Controller object representing the controller that manages the system.
     
end note
note left of Vendor::Vendor(String,boolean)

     * Constructor for the Vendor class. Initializes a new vendor with a unique identifier,
     * name, registration date, and activity status.
     * @param vendorName A string representing the name of the vendor.
     * @param vendorActive A boolean value indicating whether the vendor is currently active.
     
end note
note right of Vendor::getVendorId()

     Returns the vendor's ID.
     @return an integer representing the vendor's ID.
     
end note
note left of Vendor::setVendorId(int)

     Sets the vendor's ID.
     @param vendorId an integer representing the new vendor ID.
     
end note
note right of Vendor::getVendorName()

     Returns the vendor's name.
     @return a String representing the vendor's name.
     
end note
note left of Vendor::setVendorName(String)

     Sets the vendor's name.
     @param vendorName a String representing the new vendor name.
     
end note
note right of Vendor::getVendorRegDate()

     Returns the vendor's registration date.
     @return a LocalDate object representing the vendor's registration date.
     
end note
note left of Vendor::getVendorActive()

     Returns a boolean indicating whether the vendor is active or not.
     @return a boolean indicating whether the vendor is active or not.
     
end note
note right of Vendor::setVendorActive(boolean)

     Sets whether the vendor is active or not.
     @param vendorActive a boolean indicating whether the vendor is active or not.
     
end note
note left of Vendor::getProducts()

     Returns the list of products associated with the vendor.
     @return an ArrayList of Product objects associated with the vendor.
     
end note
note right of Vendor::setProducts(ArrayList<Product>)

     Sets the list of products associated with the vendor.
     @param products an ArrayList of Product objects to associate with the vendor.
     
end note
note left of Vendor::getBiggestVendorId()

     Returns the biggest vendor ID currently in the system.
     @return an integer representing the biggest vendor ID in the system.
     
end note
note right of Vendor::toString()


     Returns a string representation of the vendor object, including the vendor's name, ID, registration date, and status.
     The string is formatted with decorative characters for better visualization.
     @return a string representation of the vendor object
     
end note

class Menu {
~ Controller controller
+ void mainMenu()
+ void endMenu()
+ void createVendorMenu(String,boolean)
+ void createClientMenu(String,boolean)
+ void createProductMenu(String,float,char,int,String)
+ void createOrderMenu(int,String,ArrayList<Product>)
+ void listAllObjectsMenu()
+ void listVendorMenu()
+ void listClientMenu()
+ void listProductMenu()
+ void listOrderMenu()
+ void listProductByVendorMenu(int)
+ void listOrderByClientMenu(int)
+ void selectClientMenu(String,int)
+ void editClientMenu(String,boolean)
+ void selectVendorMenu(String,int)
+ void editVendorMenu(String,boolean)
+ void selectProductMenu(String,int)
+ void editProductMenu(String,float,char,int,String)
+ void selectOrderMenu(int,boolean,int,String,float)
+ void editOrderMenu(int,String,boolean,ArrayList<Product>)
}
note top of Menu


 The Menu class displays the main menu of the Drop-shipping program, varios menus to create, list and edit
 objects and a goodbye message at the end of the menu.

 @author Joel Olivera
 
end note
note left of Menu::mainMenu()


     Prints the main menu for the Drop-shipping program.
     The menu displays various options for the user to choose from,
     such as adding default objects, creating new vendors/clients/products/orders,
     listing existing vendors/clients/products/orders, editing existing vendors/clients/products/orders,
     and exiting the program.
     
end note
note right of Menu::endMenu()


     This method prints a goodbye message at the end of the menu.
     It also displays my name and the name of the program.
     
end note
note left of Menu::createVendorMenu(String,boolean)

     Displays a menu for creating a vendor with the given name and active status.
     The menu has options for changing the vendor's name and active status.
     Also, the user can choose to finish saving changes or exit without saving.
     @param name the name of the vendor to be created
     @param active the active value of the vendor to be created
    
end note
note right of Menu::createClientMenu(String,boolean)


     Displays a menu for creating a new client with the given name and active status.
     Allows the user to change the name and active status before finishing and saving the new client.
     @param name the name of the new client
     @param active the active status of the new client
     
end note
note left of Menu::createProductMenu(String,float,char,int,String)


     This method creates a product menu with the actual values of the product specified by the input parameters: name, price, nutriscore, and vendorId.
     The menu allows the user to view available vendors, and to change any of the product values: name, price, nutriscore, and vendorId.
        @param name the name of the product to be created
        @param price the price of the product to be created
        @param nutriscore the nutriscore of the product to be created
        @param vendorId the vendor ID of the product to be created
    
end note
note right of Menu::createOrderMenu(int,String,ArrayList<Product>)


     Creates a menu for creating an order, which displays client and product information
     @param id the ID of the client creating the order
     @param name the name of the client creating the order
     @param products the list of products to be displayed in the menu
     
end note
note left of Menu::listAllObjectsMenu()

     * Prints a formatted console menu that lists all available objects within the system, including vendors,
     * products, clients, and orders, and their associated actions.
     * <p>
     * The method invokes other methods to print out the specific options related to each object.
     *
     * @see #listVendorMenu()
     * @see #listProductMenu()
     * @see #listClientMenu()
     * @see #listOrderMenu()
     
end note
note right of Menu::listVendorMenu()


     This method displays a list of vendors in a bordered format.
     The list of vendors is retrieved using the 'getVendorInstances()' method from the provided 'controller' object,
     and is displayed using the 'toString()' method of each vendor instance.
     
end note
note left of Menu::listClientMenu()


     Displays a formatted list of all the clients stored in the controller's client instances list.
     Each client is printed using their toString method.
     
end note
note right of Menu::listProductMenu()

     * This method displays a list of products in a bordered format.
     * The list of products is retrieved using the 'getProductInstances()' method from the provided 'controller' object,
     * and is displayed using the 'toString()' method of each product instance.
     
end note
note left of Menu::listOrderMenu()


     This method displays a list of orders in a bordered format.
     The list of orders is retrieved using the 'getOrderInstances()' method from the provided 'controller' object,
     and is displayed using the 'toString()' method of each order instance.
     
end note
note right of Menu::listProductByVendorMenu(int)


     Displays a list of products associated with the given vendor ID in a bordered format.
     Retrieves the list of products using the 'getProductInstances()' method from the provided 'controller' object,
     and displays the product information using the 'toString()' method of each product instance.
     @param vendorID an integer representing the vendor ID whose associated products are to be listed
     
end note
note left of Menu::listOrderByClientMenu(int)

     * This method displays a list of orders placed by a specific client, identified by their client ID.
     * The list of orders is retrieved using the 'getOrderInstances()' method from the provided 'controller' object,
     * and is displayed using the 'toString()' method of each order instance.
     * @param orderID the ID of the client whose orders are to be displayed
     
end note
note right of Menu::selectClientMenu(String,int)


     Prints a client selection menu for editing purposes with the actual client information,
     available clients option, and change selected option.
     @param name The name of the client to be displayed.
     @param id The ID of the client to be displayed.
     
end note
note left of Menu::editClientMenu(String,boolean)


     Displays the menu to edit a client, including the actual values and options to change them.
     @param name the current name of the client
     @param active the current status of the client
     
end note
note right of Menu::selectVendorMenu(String,int)


     Displays a vendor menu with options to edit the selected vendor's values, view available vendors, drop the selected vendor, or change the selected vendor's values.
     @param name the name of the selected vendor
     @param id the ID of the selected vendor
     
end note
note left of Menu::editVendorMenu(String,boolean)


     Displays the edit vendor menu with the current vendor's name and active status as actual values,
     and the options to change them, drop the vendor, or exit without saving.
     @param name the current name of the vendor to display as an actual value
     @param active the current active status of the vendor to display as an actual value
     
end note
note right of Menu::selectProductMenu(String,int)


     Displays the select product menu with the current product information and options to change it
     @param name the name of the product to be selected
     @param id the ID of the product to be selected
     
end note
note left of Menu::editProductMenu(String,float,char,int,String)


     Displays the edit product menu with the current product information and options to change it
     @param name the name of the product
     @param price the price of the product
     @param nutriscore the nutriscore of the product
     @param vendorId the ID of the vendor associated with the product
     @param vendorName the name of the vendor associated with the product
     
end note
note right of Menu::selectOrderMenu(int,boolean,int,String,float)


     Displays the select order menu with actual, view, and change values.
     @param id the ID of the order
     @param paid true if the order has been paid, false otherwise
     @param clientId the ID of the client associated with the order
     @param clientName the name of the client associated with the order
     @param totalPrice the total price of the order
     
end note
note left of Menu::editOrderMenu(int,String,boolean,ArrayList<Product>)


     Displays the menu to edit an order with the actual values of the order.
     Allows the user to change the client, paid status and products of the order.
     @param id the ID of the client who made the order
     @param name the name of the client who made the order
     @param paid the paid status of the order
     @param products the list of products in the order
     
end note

class Controller {
- {static} ArrayList<Client> clientInstances
- {static} ArrayList<Vendor> vendorInstances
- {static} ArrayList<Order> orderInstances
- {static} ArrayList<Product> productInstances
- {static} ArrayList<Integer> defaultObjectsVendor
- {static} ArrayList<Integer> defaultObjectsClient
- {static} ArrayList<Integer> defaultObjectsProduct
- {static} ArrayList<Integer> defaultObjectsOrder
+ ArrayList<Client> getClientInstances()
+ ArrayList<Vendor> getVendorInstances()
+ ArrayList<Order> getOrderInstances()
+ ArrayList<Product> getProductInstances()
+ ArrayList<Integer> getDefaultObjectsVendor()
+ ArrayList<Integer> getDefaultObjectsClient()
+ ArrayList<Integer> getDefaultObjectsProduct()
+ ArrayList<Integer> getDefaultObjectsOrder()
+ void addProductToList(int,ArrayList<Product>,int)
+ void dropProductFromList(int,ArrayList<Product>,int)
+ String printOutProductList(int)
+ String printOutProductList(ArrayList<Product>)
+ void addProductToInstances(String,float,char,Vendor)
+ void addClientToInstances(String,boolean)
+ void addVendorToInstances(String,boolean)
+ void addOrderToInstances(Client,ArrayList<Product>)
+ void dropClientFromInstances(int)
+ void dropVendorFromInstances(int)
+ void dropProductFromInstances(int)
+ void dropOrderFromInstances(int)
+ void addDefaultObjects()
+ void dropDefaultObjects()
}
note top of Controller


 Controller class is responsible for managing instances of clients, vendors, orders and products.
 Also represents a collection of instances of various entities used in the system,
 including clients, vendors, orders, and products.
 
end note
note left of Controller::clientInstances


     A list of instances of clients in the system.
     
end note
note right of Controller::vendorInstances


     A list of instances of vendors in the system.
     
end note
note left of Controller::orderInstances


     A list of instances of orders in the system.
     
end note
note right of Controller::productInstances


     A list of instances of products in the system.
     
end note
note left of Controller::defaultObjectsVendor


     This is a private static final ArrayList of integers that stores the default objects related to vendors.
     
end note
note right of Controller::defaultObjectsClient


     This is a private static final ArrayList of integers that stores the default objects related to clients.
     
end note
note left of Controller::defaultObjectsProduct


     This is a private static final ArrayList of integers that stores the default objects related to products.
     
end note
note right of Controller::defaultObjectsOrder


     This is a private static final ArrayList of integers that stores the default objects related to orders.
     
end note
note left of Controller::getClientInstances()


     Returns the ArrayList containing all client instances.
     @return ArrayList containing all client instances.
     
end note
note right of Controller::getVendorInstances()


     Returns the ArrayList containing all vendor instances.
     @return ArrayList containing all vendor instances.
     
end note
note left of Controller::getOrderInstances()


     Returns the ArrayList containing all order instances.
     @return ArrayList containing all order instances.
     
end note
note right of Controller::getProductInstances()


     Returns the ArrayList containing all product instances.
     @return ArrayList containing all product instances.
     
end note
note left of Controller::getDefaultObjectsVendor()


     Returns the ArrayList of default objects related to vendors.
     @return the ArrayList of default objects related to vendors.
     
end note
note right of Controller::getDefaultObjectsClient()


     Returns the ArrayList of default objects related to clients.
     @return the ArrayList of default objects related to clients.
     
end note
note left of Controller::getDefaultObjectsProduct()


     Returns the ArrayList of default objects related to products.
     @return the ArrayList of default objects related to products.
     
end note
note right of Controller::getDefaultObjectsOrder()


     Returns the ArrayList of default objects related to orders.
     @return the ArrayList of default objects related to orders.
     
end note
note left of Controller::addProductToList(int,ArrayList<Product>,int)


     Adds the specified quantity of a product with the given ID to the provided list of products.
     @param id The ID of the product to be added.
     @param products The list of products to which the product will be added.
     @param qty The quantity of the product to be added.
     
end note
note right of Controller::dropProductFromList(int,ArrayList<Product>,int)


     Removes a specified quantity of a product with a given ID from the provided list of products.
     @param id the ID of the product to be dropped
     @param products the list of products to be modified
     @param qty the quantity of the product to be dropped
     
end note
note left of Controller::printOutProductList(int)


     Returns a string that contains a formatted list of products ordered for a given order ID.
     The list includes product ID, name, quantity, price per item, and total price for each unique product.
     @param orderID the ID of the order to print the product list for
     @return a formatted string with the list of products ordered for the given order ID
     
end note
note right of Controller::printOutProductList(ArrayList<Product>)


     Generates a string that represents a list of products along with their respective details, based on an input ArrayList.
     @param productList the list of products to be included in the output string
     @return a string containing the product information for each unique product ID in the input ArrayList, including the ID, name, number of occurrences, price, and total cost for that product
     
end note
note left of Controller::addProductToInstances(String,float,char,Vendor)


         Creates a new product with the specified name, price, nutrition grade, and vendor, and adds it to the list of product instances.
         @param name the name of the product
         @param price the price of the product
         @param nutri the nutrition grade of the product
         @param vendor the vendor of the product
         
end note
note right of Controller::addClientToInstances(String,boolean)


         Creates a new client with the specified name and active status, and adds it to the list of client instances.
         @param name the name of the client
         @param active the active status of the client
         
end note
note left of Controller::addVendorToInstances(String,boolean)


         Creates a new vendor with the specified name and active status, and adds it to the list of vendor instances.
         @param name the name of the vendor
         @param active the active status of the vendor
         
end note
note right of Controller::addOrderToInstances(Client,ArrayList<Product>)

         Adds the specified order to the list of order instances.
         
end note
note left of Controller::dropClientFromInstances(int)


     This method removes the client instance with the given client ID from the clientInstances ArrayList.
     @param clientID the ID of the client to be removed
     
end note
note right of Controller::dropVendorFromInstances(int)


     This method removes the vendor instance with the given vendor ID from the vendorInstances ArrayList.
     @param vendorID the ID of the vendor to be removed
     
end note
note left of Controller::dropProductFromInstances(int)


     This method removes the product instance with the given product ID from the productInstances ArrayList.
     @param productID the ID of the product to be removed
     
end note
note right of Controller::dropOrderFromInstances(int)


     This method removes the order instance with the given order ID from the orderInstances ArrayList.
     @param orderID the ID of the order to be removed
     
end note
note left of Controller::addDefaultObjects()


 This method initializes default instances for vendors, products, clients and orders.
 The vendors, products and clients are added to their respective instance lists.
 The orders are created using the default products and clients and added to the order instance list.
 
end note
note right of Controller::dropDefaultObjects()


     This method drops the default objects related to clients, products, orders, and vendors
     from their respective lists of default objects.
     It calls the methods to drop each client, vendor, product, and order from their instances
     and removes them from their respective lists of default objects.
     Note that the defaultObjectsClient, defaultObjectsProduct, defaultObjectsOrder, and
     defaultObjectsVendor lists must be initialized and populated prior to calling this method.
     
end note

class Main {
+ {static} void main(String[])
}
note top of Main

 * This class is the main class of the Drop-shipping application.
 * It contains the main method that runs the application.
 *
 * @author John Smith
 * @version 1.0
 
end note
note left of Main::main(String[])

     * The main method of the Drop-shipping application.
     * It initializes the application and runs the menu loop until the user quits.
     *
     * @param args The command line arguments passed to the application.
     
end note

class Product {
- int productId
- String productName
- float productPrice
- char productNutriScore
- Vendor vendor
~ Controller controller
+ <<Create>> Product(String,float,char,Vendor)
+ int getProductId()
+ void setProductId(int)
+ String getProductName()
+ void setProductName(String)
+ float getProductPrice()
+ void setProductPrice(float)
+ char getProductNutriScore()
+ void setProductNutriScore(char)
+ Vendor getVendor()
+ void setVendor(Vendor)
- int getBiggestProductId()
+ String toString()
}
note top of Product


 This class represents a Product object with various attributes, a constructor to initialize them and various methods.
 
end note
note left of Product::productId


     The ID of the product.
     
end note
note right of Product::productName


     The name of the product.
     
end note
note left of Product::productPrice


     The price of the product.
     
end note
note right of Product::productNutriScore

     * The Nutri-Score of the product.
     * <p>
     * This field is a single character representing the Nutri-Score of the product, which is a
     * rating system used in several countries to evaluate the nutritional quality of food products.
     * The Nutri-Score ranges from A (healthiest) to Z (least healthy). The value of this field should
     * be one of the characters from 'A' to 'Z'.
     
end note
note left of Product::vendor


     The vendor of the product.
     
end note
note right of Product::controller


     A controller object used to interact with the product.
     
end note
note left of Product::Product(String,float,char,Vendor)


     Constructs a new Product object with the given name, price, Nutri-Score, and vendor.
     @param productName the name of the product
     @param productPrice the price of the product
     @param productNutriScore the Nutri-Score of the product
     @param vendor the vendor of the product
     
end note
note right of Product::getProductId()


     Returns the ID of the product.
     @return the ID of the product
     
end note
note left of Product::setProductId(int)


     Sets the ID of the product to the specified value.
     @param productId the new ID of the product
     
end note
note right of Product::getProductName()


     Returns the name of the product.
     @return the name of the product
     
end note
note left of Product::setProductName(String)


     Sets the name of the product to the specified value.
     @param productName the new name of the product
     
end note
note right of Product::getProductPrice()


     Returns the price of the product.
     @return the price of the product
     
end note
note left of Product::setProductPrice(float)


     Sets the price of the product to the specified value.
     @param productPrice the new price of the product
     
end note
note right of Product::getProductNutriScore()


     Returns the Nutri-Score of the product.
     @return the Nutri-Score of the product
     
end note
note left of Product::setProductNutriScore(char)


     Sets the Nutri-Score of the product to the specified value.
     @param productNutriScore the new Nutri-Score of the product
     
end note
note right of Product::getVendor()


     Returns the vendor of the product.
     @return the vendor of the product
     
end note
note left of Product::setVendor(Vendor)


     Sets the vendor of the product to the specified value.
     @param vendor the new vendor of the product
     
end note
note right of Product::getBiggestProductId()


     This method returns the largest product ID currently in use by the controller.
     @return the largest product ID currently in use by the controller
     
end note
note left of Product::toString()


     Returns a string representation of the Product instance.
     @return a string representation of the Product instance
     
end note

class EditConsole {
+ {static} String RESET
+ {static} String BLACK
+ {static} String RED
+ {static} String GREEN
+ {static} String YELLOW
+ {static} String BLUE
+ {static} String PURPLE
+ {static} String CYAN
+ {static} String WHITE
+ {static} String BLACK_BOLD
+ {static} String RED_BOLD
+ {static} String GREEN_BOLD
+ {static} String YELLOW_BOLD
+ {static} String BLUE_BOLD
+ {static} String PURPLE_BOLD
+ {static} String CYAN_BOLD
+ {static} String WHITE_BOLD
+ {static} String BLACK_UNDERLINED
+ {static} String RED_UNDERLINED
+ {static} String GREEN_UNDERLINED
+ {static} String YELLOW_UNDERLINED
+ {static} String BLUE_UNDERLINED
+ {static} String PURPLE_UNDERLINED
+ {static} String CYAN_UNDERLINED
+ {static} String WHITE_UNDERLINED
+ {static} String BLACK_BACKGROUND
+ {static} String RED_BACKGROUND
+ {static} String GREEN_BACKGROUND
+ {static} String YELLOW_BACKGROUND
+ {static} String BLUE_BACKGROUND
+ {static} String PURPLE_BACKGROUND
+ {static} String CYAN_BACKGROUND
+ {static} String WHITE_BACKGROUND
+ {static} String BLACK_BRIGHT
+ {static} String RED_BRIGHT
+ {static} String GREEN_BRIGHT
+ {static} String YELLOW_BRIGHT
+ {static} String BLUE_BRIGHT
+ {static} String PURPLE_BRIGHT
+ {static} String CYAN_BRIGHT
+ {static} String WHITE_BRIGHT
+ {static} String BLACK_BOLD_BRIGHT
+ {static} String RED_BOLD_BRIGHT
+ {static} String GREEN_BOLD_BRIGHT
+ {static} String YELLOW_BOLD_BRIGHT
+ {static} String BLUE_BOLD_BRIGHT
+ {static} String PURPLE_BOLD_BRIGHT
+ {static} String CYAN_BOLD_BRIGHT
+ {static} String WHITE_BOLD_BRIGHT
+ {static} String BLACK_BACKGROUND_BRIGHT
+ {static} String RED_BACKGROUND_BRIGHT
+ {static} String GREEN_BACKGROUND_BRIGHT
+ {static} String YELLOW_BACKGROUND_BRIGHT
+ {static} String BLUE_BACKGROUND_BRIGHT
+ {static} String PURPLE_BACKGROUND_BRIGHT
+ {static} String CYAN_BACKGROUND_BRIGHT
+ {static} String WHITE_BACKGROUND_BRIGHT
+ void clearScreen()
+ void stopScreen(String)
}note left of EditConsole::RESET
 Text Reset
end note
note right of EditConsole::BLACK
 BLACK
end note
note left of EditConsole::RED
 RED
end note
note right of EditConsole::GREEN
 GREEN
end note
note left of EditConsole::YELLOW
 YELLOW
end note
note right of EditConsole::BLUE
 BLUE
end note
note left of EditConsole::PURPLE
 PURPLE
end note
note right of EditConsole::CYAN
 CYAN
end note
note left of EditConsole::WHITE
 WHITE
end note
note right of EditConsole::BLACK_BOLD
 BLACK
end note
note left of EditConsole::RED_BOLD
 RED
end note
note right of EditConsole::GREEN_BOLD
 GREEN
end note
note left of EditConsole::YELLOW_BOLD
 YELLOW
end note
note right of EditConsole::BLUE_BOLD
 BLUE
end note
note left of EditConsole::PURPLE_BOLD
 PURPLE
end note
note right of EditConsole::CYAN_BOLD
 CYAN
end note
note left of EditConsole::WHITE_BOLD
 WHITE
end note
note right of EditConsole::BLACK_UNDERLINED
 BLACK
end note
note left of EditConsole::RED_UNDERLINED
 RED
end note
note right of EditConsole::GREEN_UNDERLINED
 GREEN
end note
note left of EditConsole::YELLOW_UNDERLINED
 YELLOW
end note
note right of EditConsole::BLUE_UNDERLINED
 BLUE
end note
note left of EditConsole::PURPLE_UNDERLINED
 PURPLE
end note
note right of EditConsole::CYAN_UNDERLINED
 CYAN
end note
note left of EditConsole::WHITE_UNDERLINED
 WHITE
end note
note right of EditConsole::BLACK_BACKGROUND
 BLACK
end note
note left of EditConsole::RED_BACKGROUND
 RED
end note
note right of EditConsole::GREEN_BACKGROUND
 GREEN
end note
note left of EditConsole::YELLOW_BACKGROUND
 YELLOW
end note
note right of EditConsole::BLUE_BACKGROUND
 BLUE
end note
note left of EditConsole::PURPLE_BACKGROUND
 PURPLE
end note
note right of EditConsole::CYAN_BACKGROUND
 CYAN
end note
note left of EditConsole::WHITE_BACKGROUND
 WHITE
end note
note right of EditConsole::BLACK_BRIGHT
 BLACK
end note
note left of EditConsole::RED_BRIGHT
 RED
end note
note right of EditConsole::GREEN_BRIGHT
 GREEN
end note
note left of EditConsole::YELLOW_BRIGHT
 YELLOW
end note
note right of EditConsole::BLUE_BRIGHT
 BLUE
end note
note left of EditConsole::PURPLE_BRIGHT
 PURPLE
end note
note right of EditConsole::CYAN_BRIGHT
 CYAN
end note
note left of EditConsole::WHITE_BRIGHT
 WHITE
end note
note right of EditConsole::BLACK_BOLD_BRIGHT
 BLACK
end note
note left of EditConsole::RED_BOLD_BRIGHT
 RED
end note
note right of EditConsole::GREEN_BOLD_BRIGHT
 GREEN
end note
note left of EditConsole::YELLOW_BOLD_BRIGHT
 YELLOW
end note
note right of EditConsole::BLUE_BOLD_BRIGHT
 BLUE
end note
note left of EditConsole::PURPLE_BOLD_BRIGHT
 PURPLE
end note
note right of EditConsole::CYAN_BOLD_BRIGHT
 CYAN
end note
note left of EditConsole::WHITE_BOLD_BRIGHT
 WHITE
end note
note right of EditConsole::BLACK_BACKGROUND_BRIGHT
 BLACK
end note
note left of EditConsole::RED_BACKGROUND_BRIGHT
 RED
end note
note right of EditConsole::GREEN_BACKGROUND_BRIGHT
 GREEN
end note
note left of EditConsole::YELLOW_BACKGROUND_BRIGHT
 YELLOW
end note
note right of EditConsole::BLUE_BACKGROUND_BRIGHT
 BLUE
end note
note left of EditConsole::PURPLE_BACKGROUND_BRIGHT
 PURPLE
end note
note right of EditConsole::CYAN_BACKGROUND_BRIGHT
 CYAN
end note
note left of EditConsole::WHITE_BACKGROUND_BRIGHT
 WHITE
end note
note left of EditConsole::clearScreen()
 Clear the screen
end note

@enduml