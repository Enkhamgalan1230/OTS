import java.util.Scanner;

public class MainApp {
    public static void startMenu(String[] args) {
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
                            onlineTicketingSystem.SignUp();
                        } else {
                            onlineTicketingSystem.SeeTickets();
                        }
                        break;
                    case 2:
                        if (!onlineTicketingSystem.isLoggedIn) {
                            onlineTicketingSystem.LogIn();
                        } else {
                            onlineTicketingSystem.cancelTicket();
                        }
                        break;
                    case 3:
                        if (!onlineTicketingSystem.isLoggedIn) {
                            isRunning = false;
                        } else {
                            onlineTicketingSystem.seeEvents(); 
                        }
                        break;
                    case 4:
                        if (onlineTicketingSystem.isLoggedIn) {
                            onlineTicketingSystem.buyTickets();  
                        } else {
                            System.out.println("You need to log in first.");
                        }
                        break;

                    case 5:
                        if (onlineTicketingSystem.isLoggedIn) {
                            onlineTicketingSystem.logOut();
                            System.out.println("Logged out successfully.");
                        }
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next();  // Consume the invalid input
            }
        }
    }
}