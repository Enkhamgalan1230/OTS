public class Ticket {
    private String eventName;
    private int row;
    private int seat;

    public Ticket(String eventName, int row, int seat) {
        this.eventName = eventName;
        this.row = row;
        this.seat = seat;
    }

    public String getEventName() {
        return eventName;
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "eventName='" + eventName + '\'' +
                ", row=" + row +
                ", seat=" + seat +
                '}';
    }
}
