import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * Write a description of class OTS here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OTS
{
    // instance variables - replace the example below with your own
    
    public boolean isLoggedIn;
    private User currentUser;
    private Map<String, User> userDatabase;
    
    // Placeholder data for testing
    
    
        /**
     * Constructor for objects of class OTS
     */
    public OTS()
    {
        isLoggedIn = false;
        currentUser = null;
        userDatabase = new HashMap<>();
        
    }
    
    public void displayMenu(){
        
        if (isLoggedIn) {
            System.out.println("Logged in as: " + currentUser.getUsername());
            System.out.println("1. See Tickets");
            System.out.println("2. Cancel Tickets");
            System.out.println("3. See Events");
            System.out.println("4. Log Out");
        } else {
            System.out.println("");
            System.out.println("Hello Welcome to Online Ticketing System");
            System.out.println("1. Sign Up");
            System.out.println("2. Log In");
            System.out.println("3. Exit");
        }
    }
    
    
    public void SignUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a username: ");
        String newUsername = scanner.nextLine();

        // Check if the username is available
        if (userDatabase.containsKey(newUsername)) {
            System.out.println("Username already taken. Please choose another one.");
            return;
        }

        System.out.println("Enter a password: ");
        String passwordString = scanner.nextLine();

        int newPassword;
        try {
            newPassword = Integer.parseInt(passwordString);
        } catch (NumberFormatException e) {
            System.out.println("Invalid password format. Please enter a valid integer password.");
            return;
        }

        // Create a new ProfileInfo for the user
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Enter your address: ");
        String addressStreet = scanner.nextLine();
        // Add other profile information prompts as needed

        ProfileInfo profileInfo = new ProfileInfo(email, addressStreet, 0, "", 0);

        // Create a new User object with the provided information
        User newUser = new User(newUsername, newPassword, userDatabase.size() + 1, profileInfo);

        // Add the new user to the database
        userDatabase.put(newUsername, newUser);

        System.out.println("Sign up successful!");
    }
    
    public void LogIn(){
         Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();

        // Check if the username exists in the user database
        if (userDatabase.containsKey(username)) {
            System.out.println("Enter your password: ");
            int password = scanner.nextInt();

            // Validate the password
            User user = userDatabase.get(username);
            if (user.getPassword() == password) {
                isLoggedIn = true;
                currentUser = user;
                System.out.println("Login successful!");
                return;
            }
        }

        System.out.println("Invalid username or password. Please try again.");
    }
    
    public void logOut() {
        isLoggedIn = false;
        currentUser = null;
        System.out.println("Logged out successfully.");
    }
    
    public void SeeTickets(){
        if (isLoggedIn) {
            // Placeholder for displaying user's tickets
            System.out.println("Displaying tickets for user: " + currentUser.getUsername());
            String[] tickets = currentUser.getTickets();
            for (String ticket : tickets) {
                System.out.println(ticket);
            }
        } else {
            System.out.println("You need to log in first.");
        }
    }
    
    public void CancelTickets(){
        if (isLoggedIn) {
            // Placeholder for canceling tickets
            System.out.println("Cancelling tickets for user: " + currentUser.getUsername());
        } else {
            System.out.println("You need to log in first.");
        }
    
    }
    
    public void SeeEvents(){
         // Placeholder for displaying events
        System.out.println("Displaying events...");
    }
    

}
