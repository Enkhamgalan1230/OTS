import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class EventTest {
    private Event event;

    @Before
    public void setUp() {
        // This method is called before each test case
        // Initialize the Event object here or create a new one for each test
        // For simplicity, I'll create a new Event for each test case
        Date startDate = new Date(2024, 2, 10);
        Date endDate = new Date(2024, 2,17 );
        this.event = new Event("Test Artist ", "Test Concert", startDate, endDate, 50);
    }
    
    @Test
    public void testInitialization() {
        // Test if the Event object is initialized correctly
        assertEquals("Test Artist ", event.getEventName());
        assertEquals("Test Concert", event.getEventDetails());
        assertEquals(5, event.getTotalRows());
        assertEquals(10, event.getTotalSeatsPerRow());
        // Add more assertions as needed
    }

    @Test
    public void testRandomlyReserveSeats() {
        // Test if seats are randomly reserved
        int initialAvailableSeats = event.getAvailableSeats();

        event.randomlyReserveSeats(5);

        int finalAvailableSeats = event.getAvailableSeats();

        assertEquals(initialAvailableSeats - 5, finalAvailableSeats);
        // Add more assertions as needed
    }

    @Test
    public void testRandomlySellSeats() {
        int initialAvailableSeats = event.getAvailableSeats();
    
        event.randomlySellSeats(5);

        int finalAvailableSeats = event.getAvailableSeats();

        assertEquals(initialAvailableSeats - 5, finalAvailableSeats);
    }
    // Add more test methods as needed

    // Example test for the purchaseTicket method
    @Test
    public void testPurchaseTicket() {
        // Test the purchaseTicket method
        int initialAvailableSeats = event.getAvailableSeats();

        // Assuming we purchase a ticket for seat 1 in row 1
        event.purchaseTicket(1, 1);

        int finalAvailableSeats = event.getAvailableSeats();

        assertEquals(initialAvailableSeats - 1, finalAvailableSeats);
        assertEquals("sold", event.getSeatStatus(1, 1));
        // Add more assertions as needed
    }

}
