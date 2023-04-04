@startuml
!theme crt-green

class Menu {
~ Controller controller
+ void mainMenu()
+ void endMenu()
+ void createVendorMenu(String,boolean)
+ void createClientMenu(String,boolean)
+ void createProductMenu(String,double,char,int,String)
+ void createOrderMenu()
+ void listAllObjectsMenu()
+ void listVendorMenu()
+ void listClientMenu()
+ void listProductMenu()
+ void listOrderMenu()
+ void listProductByVendorMenu(int)
+ void listOrderByClientMenu(int)
+ void editProductMenu()
+ void editVendorMenu()
+ void editOrderMenu()
}
class Main {
+ {static} void main(String[])
}
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
}
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
+ void addProductToVendor(Product)
+ void addProductToOrder(Product,Order)
+ void addProductToInstances(String,double,char,Vendor)
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
class Product {
- int productId
- String productName
- double productPrice
- char productNutriScore
- Vendor vendor
~ Controller controller
+ int getProductId()
+ void setProductId(int)
+ String getProductName()
+ void setProductName(String)
+ double getProductPrice()
+ void setProductPrice(double)
+ char getProductNutriScore()
+ void setProductNutriScore(char)
+ Vendor getVendor()
+ void setVendor(Vendor)
- int getBiggestProductId()
+ String toString()
}
class Client {
- int clientID
- String clientName
- LocalDate clientRegDate
- boolean clientActive
~ Controller controller
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
class Order {
- int orderID
- LocalDate orderDate
- Client client
- boolean orderPaid
- int productQTY
- double totalPrice
- ArrayList<Product> products
~ Controller controller
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
- double getTotalPrice()
+ String toString()
}
class Read {
~ Controller controller
~ Scanner scanner
+ String readMenuOpt()
- char readChar()
+ int readInt()
+ double readDouble()
+ String changeName()
+ boolean changeActive()
+ char changeNutriScore()
+ double changePrice()
+ Vendor changeVendor()
}
class Vendor {
- int vendorId
- String vendorName
- LocalDate vendorRegDate
- boolean vendorActive
- ArrayList<Product> products
~ Controller controller
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
@enduml