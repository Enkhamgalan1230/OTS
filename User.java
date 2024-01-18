
/**
 * Write a description of class User here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class User
{
    // instance variables - replace the example below with your own
    String username;
    String[] tickets;
    int password;
    int consumerID;
     ProfileInfo profileInfo;
    
    /**
     * Constructor for objects of class User
     */
    public User(String username, int password, int consumerID,ProfileInfo profileInfo)
    {
        this.username = username;
        this.password = password;
        this.consumerID = consumerID;
        this.tickets = new String[10];
        this.profileInfo = profileInfo;
    }
    
    public ProfileInfo getProfileInfo() {
        return profileInfo;
    }

    public void setProfileInfo(ProfileInfo profileInfo) {
        this.profileInfo = profileInfo;
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

    public String[] getTickets() {
    // Add code to return the tickets array
        return tickets;
    }
    
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", consumerID=" + consumerID + "]";
    }
}
