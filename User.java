import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class User here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class User
{
    String username;
    List<Ticket> userTickets = new ArrayList<>();
    int password;
    int consumerID;
    ProfileInfo profileInfo;
    private Event currentEvent;
    
    /**
     * Constructor for objects of class User
     */
    public User(String username, int password, int consumerID, ProfileInfo profileInfo) {
        this.username = username;
        this.password = password;
        this.consumerID = consumerID;
        this.profileInfo = profileInfo;
    }
    
    public void setProfileInfo(ProfileInfo profileInfo) {
        this.profileInfo = profileInfo;
    }
    
    public ProfileInfo getProfileInfo() {
        return profileInfo;
    }
    
    public String getUsername() {
    return username;
    }

    public int getPassword() {
        return password;
    }

    public int getConsumerID() {
        return consumerID;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }   

    public void setPassword(int password) {
        this.password = password;
    }

    public void setConsumerID(int consumerID) {
        this.consumerID = consumerID;
    }
    
    public void addTicket(String ticket) {
    // Add code to add a ticket to the tickets array
    }

    public void removeTicket(String ticket) {
    // Add code to remove a ticket from the tickets array
    }
    
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", consumerID=" + consumerID + "]";
    }
    
    public void addTicket(String eventName, int row, int seat) {
        // Assuming you have a Ticket class to represent individual tickets
        Ticket newTicket = new Ticket(eventName, row, seat);
        userTickets.add(newTicket);
        System.out.println("Ticket added to your profile:\n" + newTicket.toString());
    }

    public List<Ticket> getTickets(Event selectedEvent) {
        List<Ticket> validTickets = new ArrayList<>();

        for (Ticket ticket : userTickets) {
            int row = ticket.getRow();
            int seat = ticket.getSeat();

            // Check the seat status using the getSeatStatus method in the Event class
            String seatStatus = selectedEvent.getSeatStatus(row, seat);

            // Modify the condition to check if seatStatus is "free"
            if (row >= 1 && row <= selectedEvent.getTotalRows() &&
                seat >= 1 && seat <= selectedEvent.getTotalSeats() &&
                seatStatus.equals("free")) {
                validTickets.add(ticket);
            }
        }

        return validTickets;
    }
    
    public List<Ticket> getTickets() {
    return userTickets;
    }
}
