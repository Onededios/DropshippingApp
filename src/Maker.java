import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Class responsible for initializing files and objects used for data management.
 */
public class Maker {
    private File dir = new File("data");
    private File clientFile = new File(dir.getName() + "/clients.json");
    private File orderFile = new File(dir.getName() + "/orders.json");
    private File productFile = new File(dir.getName() + "/products.json");
    private File vendorFile = new File(dir.getName() + "/vendors.json");
    Controller controller = new Controller();
    ObjectMapper objectMapper = new ObjectMapper();

    StringWriter sw = new StringWriter();
    /**
     * Constructs a new Maker instance.
     */
    public Maker() {
    }
    /**
     * Pauses the execution for a total of 2 seconds by printing dots ('.') every second.
     * The method sleeps for 1 second between each dot.
     */
    public void untilItSleeps() {
        try {
            for (int i = 0; i < 2; i++) {
                System.out.print(".");
                Thread.sleep(1000); // sleep for 2 seconds
            }
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * Initializes the JSON files used for data storage and performs necessary operations if the files already exist.
     * The method creates directories if they don't exist and creates files if they don't exist.
     * If the files already exist, the method reads data from them and adds it to the system.
     * After initializing the files, the method resumes the application process after a brief pause.
     *
     * @throws IOException if an I/O error occurs during file creation or reading.
     */
    public void initJson() throws IOException {
        if (dir.mkdir()) {
            System.out.println("Directory '" + dir.getName() + "' has been created.");
        } else {
            System.out.println("Directory '" + dir.getName() + "' found.");
        }

        if (clientFile.createNewFile()) {
            System.out.println("The file '" + clientFile.getName() + "' has been added to the '" + dir.getName() + "' directory.");
        } else {
            System.out.println("File '" + clientFile.getName() + "' found.");
            readClientsFromJson();
            System.out.println("Clients added to the system.");
        }

        if (vendorFile.createNewFile()) {
            System.out.println("The file '" + vendorFile.getName() + "' has been added to the '" + dir.getName() + "' directory.");
        } else {
            System.out.println("File '" + vendorFile.getName() + "' found.");
            readVendorsFromJson();
            System.out.println("Vendors added to the system.");
        }

        if (productFile.createNewFile()) {
            System.out.println("The file '" + productFile.getName() + "' has been added to the '" + dir.getName() + "' directory.");
        } else {
            System.out.println("File '" + productFile.getName() + "' found.");
            readProductsFromJson();
            System.out.println("Products added to the system.");
        }

        if (orderFile.createNewFile()) {
            System.out.println("The file '" + orderFile.getName() + "' has been added to the '" + dir.getName() + "' directory.");
        } else {
            System.out.println("File '" + orderFile.getName() + "' found.");
            readOrdersFromJson();
            System.out.println("Orders added to the system.");
        }

        System.out.print("\nResuming the application process");
        untilItSleeps();
    }
    /**
     * Writes the client instances to the clients.json file.
     * The method converts the client instances into JSON format and writes them to the file.
     *
     * @throws IOException if an I/O error occurs during file writing.
     */
    public void addClientInstancesToJson() throws IOException {
        FileWriter myWriter = new FileWriter(clientFile);
        myWriter.write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(controller.getClientInstances()));
        myWriter.close();
    }
    /**
     * Writes the vendor instances to the vendors.json file.
     * The method converts the vendor instances into JSON format and writes them to the file.
     *
     * @throws IOException if an I/O error occurs during file writing.
     */
    public void addVendorInstancesToJson() throws IOException {
        FileWriter myWriter = new FileWriter(vendorFile);
        myWriter.write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(controller.getVendorInstances()));
        myWriter.close();
    }
    /**
     * Writes the product instances to the products.json file.
     * The method converts the product instances into JSON format and writes them to the file.
     *
     * @throws IOException if an I/O error occurs during file writing.
     */
    public void addProductInstancesToJson() throws IOException {
        FileWriter myWriter = new FileWriter(productFile);
        myWriter.write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(controller.getProductInstances()));
        myWriter.close();
    }
    /**
     * Writes the order instances to the orders.json file.
     * The method converts the order instances into JSON format and writes them to the file.
     *
     * @throws IOException if an I/O error occurs during file writing.
     */
    public void addOrderInstancesToJson() throws IOException {
        try {
            FileWriter myWriter = new FileWriter(orderFile);
            myWriter.write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(controller.getOrderInstances()));
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * Adds all instances (clients, vendors, products, and orders) to their respective JSON files.
     * The method first drops the default objects from the system.
     * Then it adds the client instances to the clients.json file using the addClientInstancesToJson() method.
     * Next, it adds the vendor instances to the vendors.json file using the addVendorInstancesToJson() method.
     * Then it adds the product instances to the products.json file using the addProductInstancesToJson() method.
     * Finally, it adds the order instances to the orders.json file using the addOrderInstancesToJson() method.
     *
     * @throws IOException if an I/O error occurs during file writing.
     */
    public void addAllInstancesToJson() throws IOException {
        controller.dropDefaultObjects();
        addClientInstancesToJson();
        addVendorInstancesToJson();
        addProductInstancesToJson();
        addOrderInstancesToJson();
    }
    /**
     * Reads client data from the clients.json file and populates the client instances in the system.
     * The method reads the JSON data from the clients.json file using an ObjectMapper.
     * It then adds the client instances to the system by populating the client instances list in the Controller class.
     *
     * @throws IOException if an I/O error occurs during file reading.
     */
    public void readClientsFromJson() throws IOException {
        Scanner scanner = new Scanner(clientFile);
        if (scanner.hasNextLine()) {controller.getClientInstances().addAll(objectMapper.readValue(clientFile, new TypeReference<ArrayList<Client>>() {
        }));}
    }
    /**
     * Reads vendor data from the vendors.json file and populates the vendor instances in the system.
     * The method reads the JSON data from the vendors.json file using an ObjectMapper.
     * It then adds the vendor instances to the system by populating the vendor instances list in the Controller class.
     *
     * @throws IOException if an I/O error occurs during file reading.
     */
    public void readVendorsFromJson() throws IOException {
        Scanner scanner = new Scanner(vendorFile);
        if (scanner.hasNextLine()) {
            controller.getVendorInstances().addAll(objectMapper.readValue(vendorFile, new TypeReference<ArrayList<Vendor>>() {
            }));
        }
    }
    /**
     * Reads product data from the products.json file and populates the product instances in the system.
     * The method reads the JSON data from the products.json file using an ObjectMapper.
     * It then adds the product instances to the system by populating the product instances list in the Controller class.
     *
     * @throws IOException if an I/O error occurs during file reading.
     */
    public void readProductsFromJson() throws IOException {
        Scanner scanner = new Scanner(productFile);
        if (scanner.hasNextLine()) {
            controller.getProductInstances().addAll(objectMapper.readValue(productFile, new TypeReference<ArrayList<Product>>() {
            }));
        }
    }
    /**
     * Reads order data from the orders.json file and populates the order instances in the system.
     * The method reads the JSON data from the orders.json file using an ObjectMapper.
     * It then adds the order instances to the system by populating the order instances list in the Controller class.
     *
     * @throws IOException if an I/O error occurs during file reading.
     */
    public void readOrdersFromJson() throws IOException {
        Scanner scanner = new Scanner(orderFile);
        if (scanner.hasNextLine()) {
            controller.getOrderInstances().addAll(objectMapper.readValue(orderFile, new TypeReference<ArrayList<Order>>() {
            }));
        }
    }
    /**
     * Reads all instances (clients, vendors, products, and orders) from their respective JSON files and populates the system.
     * The method reads the client instances from the clients.json file using the readClientsFromJson() method.
     * Then it reads the vendor instances from the vendors.json file using the readVendorsFromJson() method.
     * Next, it reads the product instances from the products.json file using the readProductsFromJson() method.
     * Finally, it reads the order instances from the orders.json file using the readOrdersFromJson() method.
     *
     * @throws IOException if an I/O error occurs during file reading.
     */
    public void readAllInstancesFromJson() throws IOException {
        readClientsFromJson();
        readVendorsFromJson();
        readProductsFromJson();
        readOrdersFromJson();
    }
}

// Needed to create this cause the jackson parser does not accept/support the LocalDate object to parse it
/**
 * Custom deserializer for LocalDate objects.
 * The class extends the StdDeserializer class and handles the deserialization of LocalDate objects.
 * It uses the ISO_LOCAL_DATE format to parse the date string into a LocalDate object.
 */
class LocalDateDeserializer extends StdDeserializer<LocalDate> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
    /**
     * Constructs a new LocalDateDeserializer instance.
     */
    public LocalDateDeserializer() {
        this(null);
    }
    /**
     * Constructs a new LocalDateDeserializer instance with the specified value class.
     *
     * @param vc The value class.
     */
    public LocalDateDeserializer(Class<?> vc) {
        super(vc);
    }
    /**
     * Deserializes the date string into a LocalDate object.
     *
     * @param jsonparser The JsonParser object.
     * @param context    The DeserializationContext object.
     * @return The deserialized LocalDate object.
     * @throws IOException if an I/O error occurs during deserialization.
     */
    @Override
    public LocalDate deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException {
        String date = jsonparser.getText();
        return LocalDate.parse(date, formatter);
    }
}