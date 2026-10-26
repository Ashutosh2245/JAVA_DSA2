package ConsoleBasedApplications.model;
public class Booking {
    private String pnr;
    private Passenger passenger;
    private Train train;
    private static int pnrCounter = 1001;

    public Booking(Passenger passenger, Train train) {
        this.pnr = "PNR" + pnrCounter++;
        this.passenger = passenger;
        this.train = train;
    }

    public String getPnr() {
        return pnr;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Train getTrain() {
        return train;
    }
}