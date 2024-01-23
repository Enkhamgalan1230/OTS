import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class OTS here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OTS
{
    
    public boolean isLoggedIn;
    private User currentUser;
    private Map<String, User> userDatabase;
    private List<Event> eventList;
    private List<Promotion> promotions;
    
    
        /**
     * Constructor for objects of class OTS
     */
    public OTS()
    {
        isLoggedIn = false;
        currentUser = null;
        userDatabase = new HashMap<>();
        eventList = new ArrayList<>();
        promotions = new ArrayList<>();
        createPromotions();
        createEvents();
    }
    
    public boolean isLoggedIn() {
        return isLoggedIn;
    }
    
    public User getCurrentUser() {
        return currentUser;
    }

    public List<Event> getEventList() {
        return eventList;
    }
    
    public void displayMenu(){
        
        if (isLoggedIn) {
            System.out.println("Logged in as: " + currentUser.getUsername());
            System.out.println("1. See Tickets");
            System.out.println("2. Cancel Tickets");
            System.out.println("3. See Events");
            System.out.println("4. Buy Tickets");
             System.out.println("5. Log Out");
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

        // Checking if the username is available here
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

        System.out.println("Enter your email: ");
        String email = scanner.nextLine();

        System.out.println("Enter your address street: ");
        String addressStreet = scanner.nextLine();

        System.out.println("Enter your house number: ");
        int houseNumber = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Enter your Post code: ");
        String postalCode = scanner.nextLine();

        System.out.println("Enter your contact number: ");
        String contactNumber = scanner.nextLine();

        // Creating a new ProfileInfo for the user here
        ProfileInfo profileInfo = new ProfileInfo(email, addressStreet, houseNumber, postalCode, contactNumber);

        // Create a new User object with the provided informations 
        User newUser = new User(newUsername, newPassword, userDatabase.size() + 1, profileInfo);

        // Add the new user to the database
        userDatabase.put(newUsername, newUser);

        System.out.println("Sign up successful!\n");
    }

    public void seeEvents() {
        System.out.println("Available Events:");
        for (int i = 0; i < eventList.size(); i++) {
            Event event = eventList.get(i);
            System.out.println("");
            System.out.println((i + 1) + ". " + event.getEventName());
            System.out.println("   Details: " + event.getEventDetails());
            System.out.println("   Start Date: " + event.getStartDate());
            System.out.println("   End Date: " + event.getEndDate());
            System.out.println("   Available Seats: " + event.getAvailableSeats());
            System.out.println("   Seating Arrangement:");
            System.out.println("Free seats - f, Sold seats - s, Reserved seats - r"); 
            System.out.println(""); 
            displaySeatingArrangement(event);
            System.out.println("");
            
        }
    }
    
    public void LogIn(){
         Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();

        // Check if the username exists in the user database
        if (userDatabase.containsKey(username)) {
            System.out.println("Enter your password: ");
            int password = scanner.nextInt();

            // Check if the password matches
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
    
    public void SeeTickets() {
        if (isLoggedIn) {
            System.out.println("");
            System.out.println("Displaying tickets for user: " + currentUser.getUsername());
            List<Ticket> tickets = currentUser.getTickets();
    
            if (tickets.isEmpty()) {
                System.out.println("");
                System.out.println("No tickets purchased.");
            } else {
                System.out.println("");
                System.out.println("Number of tickets: " + tickets.size());
                for (Ticket ticket : tickets) {
                    System.out.println(ticket);
                }
            }
        } else {
            System.out.println("");
            System.out.println("You need to log in first.");
        }
    }

    public void CancelTickets(){
        if (isLoggedIn) {
            System.out.println("");
            System.out.println("Cancelling tickets for user: " + currentUser.getUsername());
        } else {
            System.out.println("");
            System.out.println("You need to log in first.");
        }
    }
    
    
    private void createEvents() {
        Date startDate1 = new Date(2024, 1, 18);
        Date endDate1 = new Date(2024, 1, 28);
        Event event1 = new Event("Ariana Grande Concert", "Concert in O2 Arena", startDate1, endDate1, 50);

        Date startDate2 = new Date(2024, 2, 13);
        Date endDate2 = new Date(2024, 2, 26);
        Event event2 = new Event("Travis Scott Concert", "Concert in Wembley Stadium", startDate2, endDate2, 50);
        
        Date startDate3 = new Date(2024, 2, 13);
        Date endDate3= new Date(2024, 2, 30);
        Event event3 = new Event("Billie Eilish World Tour ", "Billie Eilish World Tour Europe Take over", startDate3, endDate3, 50);
        
        Date startDate4 = new Date(2024, 2, 10);
        Date endDate4 = new Date(2024, 2,17 );
        Event event4 = new Event("Tamir B ", "Mongolian hip hop artist from USA, Kansas", startDate4, endDate4, 50);
        
        Date startDate5 = new Date(2024, 2, 13);
        Date endDate5 = new Date(2024, 2, 15);
        Event event5 = new Event("Some random asian guy", "Some where in China Town i guess", startDate5, endDate5, 50);
        
        eventList.add(event1);
        eventList.add(event2);
        eventList.add(event3);
        eventList.add(event4);
        eventList.add(event5);
    }
    
    private void displaySeatingArrangement(Event event) {
        int totalRows = event.getTotalRows();
        int totalSeatsPerRow = event.getTotalSeatsPerRow();

        for (int row = 1; row <= totalRows; row++) {
            for (int seat = 1; seat <= totalSeatsPerRow; seat++) {
                String status = event.getSeatStatus(row, seat);
                String seatStatusChar;

                switch (status) {
                    case "free":
                        seatStatusChar = "f";
                        break;
                    case "sold":
                        seatStatusChar = "s";
                        break;
                    case "reserved":
                        seatStatusChar = "r";
                        break;
                    default:
                        seatStatusChar = "?";
                }

                System.out.print("[" + row + "-" + seat + ": " + seatStatusChar + "] ");
            }
            System.out.println();
        }
    }
    
    public void addTicket() {
        Scanner scanner = new Scanner(System.in);
        // Display available events
        seeEvents();

        // Ask user to choose an event 
        System.out.println("Enter the number of the event you want to attend: ");
        int eventChoice = scanner.nextInt();

        // Validate event choice
        if (eventChoice >= 1 && eventChoice <= eventList.size()) {
            Event selectedEvent = eventList.get(eventChoice - 1);

            // Display pricing information for the selected event
            System.out.println("Event: " + selectedEvent.getEventName());
            System.out.println("Pricing Information:");

            for (int row = 1; row <= selectedEvent.getTotalRows(); row++) {
                System.out.println("Row " + row + ": £" + selectedEvent.getPriceForRow(row));
            }

            // Ask user to choose a seat
            System.out.println("Enter the row number: ");
            int selectedRow = scanner.nextInt();

            System.out.println("Enter the seat number: ");
            int selectedSeat = scanner.nextInt();

            // Purchase the ticket
            selectedEvent.purchaseTicket(selectedRow, selectedSeat);

            // Add the purchased ticket to the user's profile
            currentUser.addTicket(selectedEvent.getEventName(), selectedRow, selectedSeat);
        } else {
            System.out.println("Invalid event choice.");
        }
    }

    public void buyTickets() {
        Scanner scanner = new Scanner(System.in);

        // Display available events
        seeEvents();

        // Ask the user to choose an event
        System.out.println("Enter the number of the event you want to attend: ");
        int eventChoice = scanner.nextInt();
    
        // Validate the event choice
        if (eventChoice >= 1 && eventChoice <= eventList.size()) {
            Event selectedEvent = eventList.get(eventChoice - 1);

            // Display pricing information for the selected event
            System.out.println("Event: " + selectedEvent.getEventName());
            System.out.println("Pricing Information:");

            for (int row = 1; row <= selectedEvent.getTotalRows(); row++) {
                System.out.println("Row " + row + ": £" + selectedEvent.getPriceForRow(row));
            }

            // Ask the user to choose seats
            System.out.println("Enter the number of seats you want to purchase: ");
            int numSeatsToPurchase = scanner.nextInt();

            // Array to store selected seats
            int[][] selectedSeats = new int[numSeatsToPurchase][2];

            for (int i = 0; i < numSeatsToPurchase; i++) {
                System.out.println("Enter the row number for seat " + (i + 1) + ": ");
                selectedSeats[i][0] = scanner.nextInt();

                System.out.println("Enter the seat number for seat " + (i + 1) + ": ");
                selectedSeats[i][1] = scanner.nextInt();
            }

            // Display available promotions
            displayPromotions();

            // Ask the user to enter a promo code
            System.out.println("Enter a promo code (or enter 'none' for no promotion):");
            String promoCode = scanner.next();

            // Validate the promo code
            if (!promoCode.equalsIgnoreCase("none")) {
                applyPromotion(selectedEvent, promoCode);
            }

            // Purchase the selected seats
            for (int i = 0; i < numSeatsToPurchase; i++) {
                purchaseTicket(selectedEvent, selectedSeats[i][0], selectedSeats[i][1]);
            }
        } else {
            System.out.println("Invalid event choice.");
        }
    }

    private void createPromotions() {
        Promotion promo1 = new Promotion("PROMO1", 10.0);  
        Promotion promo2 = new Promotion("PROMO2", 15.0);
        Promotion promo3 = new Promotion("JUSTIN", 20.0);
        Promotion promo4 = new Promotion("OOSD", 25.0);
        Promotion promo5 = new Promotion("ENTWAN", 30.0);

        promotions.add(promo1);
        promotions.add(promo2);
        promotions.add(promo3);
        promotions.add(promo4);
        promotions.add(promo5);
    }
    
    public void displayPromotions() {
        System.out.println("Available Promotions:");
        for (Promotion promotion : promotions) {
            System.out.println(promotion.getPromoCode() + ": " + promotion.getDiscount() + "% off");
        }
    }
    
    private void applyPromotion(Event event, String promoCode) {
        for (Promotion promotion : promotions) {
            if (promotion.getPromoCode().equalsIgnoreCase(promoCode)) {
                double discountPercentage = promotion.getDiscount();
                double originalPrice = event.getPriceForRow(1);
                double discountedPrice = originalPrice - (originalPrice * (discountPercentage / 100));

                // Update the price for each row in the event
                for (int row = 1; row <= event.getTotalRows(); row++) {
                    event.setPriceForRow(row, discountedPrice);
                }

                System.out.println("Promo code applied! Discounted price: £" + discountedPrice);
                return;
            }
        }
    
        System.out.println("Invalid promo code. No discount applied.");
    }
    
    private void purchaseTicket(Event event, int selectedRow, int selectedSeat) {
        if (event.isValidSeat(selectedRow, selectedSeat) && event.getSeatStatus(selectedRow, selectedSeat).equals("free")) {
            double ticketPrice = event.getPriceForRow(selectedRow);
            // Update seat status and inform the user about the purchase and price
            event.purchaseTicket(selectedRow, selectedSeat);
            currentUser.addTicket(event.getEventName(), selectedRow, selectedSeat); 
            System.out.println("Ticket purchased successfully for seat " + selectedRow + "-" + selectedSeat);
            System.out.println("Price: £" + ticketPrice);
        } else {
            System.out.println("Seat " + selectedRow + "-" + selectedSeat + " is not available or already reserved/sold.");
        }
    }
    
    public void cancelTicket() {
        if (isLoggedIn) {
            System.out.println("Cancelling tickets for user: " + currentUser.getUsername());

            List<Ticket> tickets = currentUser.getTickets();

            if (tickets.isEmpty()) {
                System.out.println("No tickets purchased.");
            } else {
                // Display user's tickets for selection
                for (int i = 0; i < tickets.size(); i++) {
                    System.out.println((i + 1) + ". " + tickets.get(i));
                }

                // Ask user to choose a ticket
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the number of the ticket you want to cancel (or enter 0 to cancel nothing): ");
                int ticketChoice = scanner.nextInt();

                // Validate ticket choice
                if (ticketChoice >= 0 && ticketChoice <= tickets.size()) {
                    if (ticketChoice == 0) {
                    System.out.println("Ticket cancellation aborted.");
                    } else {
                        Ticket selectedTicket = tickets.get(ticketChoice - 1);

                        // Retrieve the event by name from the selectedTicket
                        Event event = getEventByName(selectedTicket.getEventName());

                        if (event != null) {
                            // Ask for confirmation
                            System.out.println("Are you sure you want to cancel this ticket? (yes/no)");
                            String confirmation = scanner.next().toLowerCase();

                            if (confirmation.equals("yes")) {
                                // Refund and remove the canceled ticket from the user's profile
                                refundTicket(event, selectedTicket);
                                currentUser.removeTicket(selectedTicket);
                                System.out.println("Ticket cancelled successfully.");
                            } else {
                                System.out.println("Ticket cancellation aborted.");
                            }
                        } else {
                            System.out.println("Event not found. Refund failed.");
                        }
                    }
                } else {
                    System.out.println("Invalid ticket choice.");
                }
            }
        } else {
            System.out.println("You need to log in first.");
        }
    }

    private void refundTicket(Event event, Ticket ticket) {
        int selectedRow = ticket.getRow();
        int selectedSeat = ticket.getSeat();

        // Refund logic here (e.g., update seat status, refund amount, etc.)
        event.refundTicket(selectedRow, selectedSeat);
        double refundAmount = event.getPriceForRow(selectedRow);
        System.out.println("Refund amount: £" + refundAmount);
    }    
    
    private Event getEventByName(String eventName) {
        for (Event event : eventList) {
            if (event.getEventName().equals(eventName)) {
                return event;
            }
        }
        return null;  // Event not found
    }
   
}
