
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        OTS onlineTicketingSystem = new OTS();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            onlineTicketingSystem.displayMenu();
            
            System.out.println("Enter your choice: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        if (!onlineTicketingSystem.isLoggedIn) {
                            onlineTicketingSystem.SignUp();  // Use SignUp() instead of signUp()
                        } else {
                            onlineTicketingSystem.SeeTickets();  // Use SeeTickets() instead of seeTickets()
                        }
                        break;
                    case 2:
                        if (!onlineTicketingSystem.isLoggedIn) {
                            onlineTicketingSystem.LogIn();  // Use LogIn() instead of logIn()
                        } else {
                            onlineTicketingSystem.CancelTickets();  // Use CancelTickets() instead of cancelTickets()
                        }
                        break;
                    case 3:
                        if (!onlineTicketingSystem.isLoggedIn) {
                            isRunning = false;
                        } else {
                            onlineTicketingSystem.SeeEvents();  // Use SeeEvents() instead of SeeEvents()
                        }
                        break;
                    case 4:
                        if (onlineTicketingSystem.isLoggedIn) {
                            onlineTicketingSystem.logOut();  // Use logOut() instead of logOut()
                            System.out.println("Logged out successfully.");
                        }
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }
}