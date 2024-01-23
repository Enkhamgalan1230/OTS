import java.util.Random;

public class Event  {
    private String eventName;
    private String eventDetails;
    private Date startDate;
    private Date endDate;
    private int totalSeats;
    private String[][] seatStatus;
    private Random random;
    private double[] rowPrices;
    private boolean discountApplied;
    private double discountPercentage;
    private static final int SEATS_PER_ROW = 10;
    
    /**
     * Constructor for objects of class Event
     */
    public Event(String eventName, String eventDetails, Date startDate, Date endDate, int totalSeats) {
        this.eventName = eventName;
        this.eventDetails = eventDetails;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalSeats = totalSeats;
        this.seatStatus = new String[5][10];
        
        
        
        // Initialize seatStatus array (all seats start as "free")
        for (int i = 0; i < seatStatus.length; i++) {
            for (int j = 0; j < seatStatus[i].length; j++) {
                seatStatus[i][j] = "free";
            }
        }
        initializeRowPrices();
        
        // Randomly reserve four seats
        randomlyReserveSeats(5);

        // Randomly sell two seats
        randomlySellSeats(5);
    }

    // Getters for event details
    public String getEventName() {
        return eventName;
    }

    public String getEventDetails() {
        return eventDetails;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public boolean isValidSeat(int row, int seat) {
        return row >= 1 && row <= seatStatus.length && seat >= 1 && seat <= seatStatus[0].length;
        
    }

    
    public void randomlyReserveSeats(int numSeatsToReserve) {
        Random random = new Random();
        int reservedSeats = 0;

        while (reservedSeats < numSeatsToReserve) {
            int randomRow = random.nextInt(seatStatus.length) + 1;
            int randomSeat = random.nextInt(seatStatus[0].length) + 1;

            if (seatStatus[randomRow - 1][randomSeat - 1].equals("free")) {
                seatStatus[randomRow - 1][randomSeat - 1] = "reserved";
                reservedSeats++;
            }
        }
    }

    public void randomlySellSeats(int numSeatsToSell) {
        Random random = new Random();
        int soldSeats = 0;

        while (soldSeats < numSeatsToSell) {
            int randomRow = random.nextInt(seatStatus.length);
            int randomSeat = random.nextInt(seatStatus[0].length);

            if (seatStatus[randomRow][randomSeat].equals("free")) {
                seatStatus[randomRow][randomSeat] = "sold";
                soldSeats++;
            }
        }
    }
    
    public int getAvailableSeats() {
        int availableSeats = 0;

        for (int i = 0; i < seatStatus.length; i++) {
            for (int j = 0; j < seatStatus[i].length; j++) {
                if (seatStatus[i][j].equals("free")) {
                    availableSeats++;
                }
            }
        }

        return availableSeats;
    }
    
    public String getSeatStatus(int row, int seat) {
        if (isValidSeat(row, seat)) {
            return seatStatus[row - 1][seat - 1];
        } else {
            return "Invalid seat";
        }
    }
    
    private void initializeRowPrices() {
        rowPrices = new double[seatStatus.length];
        for (int row = 0; row < seatStatus.length; row++) {
            rowPrices[row] = 50.0 + (row * 10.0);
        }
    }
    

    
     public int getTotalRows() {
        return seatStatus.length;
    }

    public double getPriceForRow(int row) {
        if (row >= 1 && row <= rowPrices.length) {
            return rowPrices[row - 1];
        } else {
            return 0.0;  // Return a default price for an invalid row
        }
    }
    
    public void purchaseTicket(int row, int seat) {
        if (isValidSeat(row, seat) && seatStatus[row - 1][seat - 1].equals("free")) {
            double ticketPrice = getPriceForRow(row);

            seatStatus[row - 1][seat - 1] = "sold";
            System.out.println("Ticket purchased successfully for seat " + row + "-" + seat);
            System.out.println("Price: $" + ticketPrice);
        } else {
            System.out.println("Seat " + row + "-" + seat + " is not available or already reserved/sold.");
        }
    }
    
    public void refundTicket(int row, int seat) {
        if (isValidSeat(row, seat)) {
            seatStatus[row - 1][seat - 1] = "free";
            System.out.println("Ticket refunded for seat " + row + "-" + seat);
        } else {
            System.out.println("Invalid seat for refund.");
        }
    }
    
    public int getTotalSeatsPerRow() {
        return SEATS_PER_ROW;
    }
    
    public void setPriceForRow(int row, double price) {
        if (row >= 1 && row <= rowPrices.length) {
            rowPrices[row - 1] = price;
        } else {
            System.out.println("Invalid row number.");
        }
    }
}