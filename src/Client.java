import java.time.LocalDate;
/**

 This class represents a client in the system.
 */
public class Client {
    // * Attributes
    /**

     The ID of the client.
     */
    private int clientID;
    /**

     The name of the client.
     */
    private String clientName;
    /**

     The registration date of the client.
     */
    private final LocalDate clientRegDate;
    /**

     The status of the client (active/inactive).
     */
    private boolean clientActive;
    /**

     The controller used by the client.
     */
    final Controller controller = new Controller();
    // * Constructors
    /**

     Creates a new client instance.
     @param clientName The name of the client.
     @param clientActive The status of the client (active/inactive).
     */
    Client(String clientName, boolean clientActive) {
        this.clientID = getBiggestClientId() + 1;
        this.clientName = clientName;
        this.clientRegDate = LocalDate.now();
        this.clientActive = clientActive;
    }

    // * Getters and Setters
    /**

     Gets the client ID of this client.
     @return the client ID of this client.
     */
    public int getClientID() {
        return clientID;
    }
    /**

     Sets the client ID of this client.
     @param clientID the new client ID to be set.
     */
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }
    /**

     Gets the name of this client.
     @return the name of this client.
     */
    public String getClientName() {
        return clientName;
    }
    /**

     Sets the name of this client.
     @param clientName the new name to be set.
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    /**

     Gets the registration date of this client.
     @return the registration date of this client.
     */
    public LocalDate getClientRegDate() {
        return clientRegDate;
    }
    /**

     Gets the active status of this client.
     @return the active status of this client.
     */
    public boolean getClientActive() {
        return clientActive;
    }
    /**

     Sets the active status of this client.
     @param clientActive the new active status to be set.
     */
    public void setClientActive(boolean clientActive) {
        this.clientActive = clientActive;
    }
    /**

     Gets the biggest client ID among all existing client instances.
     @return the biggest client ID among all existing client instances.
     */
    private int getBiggestClientId() {
        int maxVal = 0;
        if (controller.getClientInstances().size() != 0) {
            for (int i = 0; i < controller.getClientInstances().size(); i++) {
                if (maxVal < controller.getClientInstances().get(i).getClientID()) {
                    maxVal = controller.getClientInstances().get(i).getClientID();
                }
            }
        }
        return maxVal;
    }

    // * Methods
/**

 Returns a string representation of the client instance.
 @return A string containing the client's name, ID, registration date and active status.
 */
    public String toString() {
        return    "   ╭────────────────────────────╮" +
                "\n     Client ▷ "+ clientName + " ◁" +
                "\n    ────────────────────────────" +
                "\n     ID: "+clientID +
                "\n     Name: "+clientName +
                "\n     Reg. Date: "+clientRegDate +
                "\n     Active: "+clientActive +
                "\n   ╰────────────────────────────╯";
    }
}
