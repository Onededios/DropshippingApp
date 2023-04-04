// TODO Falta añadir la javadoc
import java.time.LocalDate;
public class Client {
    // * Attributes
    private int clientID;
    private String clientName;
    private LocalDate clientRegDate;
    private boolean clientActive;
    Controller controller = new Controller();

    // * Constructors
    Client(String clientName, boolean clientActive) {
        this.clientID = getBiggestClientId() + 1;
        this.clientName = clientName;
        this.clientRegDate = LocalDate.now();
        this.clientActive = clientActive;
    }

    // * Getters and Setters
    public int getClientID() {
        return clientID;
    }
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }
    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public LocalDate getClientRegDate() {
        return clientRegDate;
    }
    public boolean getClientActive() {
        return clientActive;
    }
    public void setClientActive(boolean clientActive) {
        this.clientActive = clientActive;
    }
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
