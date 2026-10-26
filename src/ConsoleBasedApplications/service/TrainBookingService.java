package ConsoleBasedApplications.service;
import java.util.*;

import ConsoleBasedApplications.model.Train;
import ConsoleBasedApplications.model.Passenger;
import ConsoleBasedApplications.model.Booking;

public class TrainBookingService {

    private ArrayList<Train> trains;
    private HashMap <String, Booking> bookingMap;
    private HashMap<Integer, Queue<Passenger>> waitingLists;

    public TrainBookingService(ArrayList<Train> trains) {
        this.trains = trains;
        bookingMap = new HashMap<>();
        waitingLists = new HashMap<>();

        for (Train train : trains) {
            waitingLists.put(train.getTrainNumber(), new LinkedList<>());
        }
    }

    public Train findTrain(int trainNumber) {
        for (Train train : trains) {
            if (train.getTrainNumber() == trainNumber) {
                return train;
            }
        }

        return null;
    }

    public void searchTrain(String source, String destination) {
        boolean found = false;

        for (Train train : trains) {
            if (train.getSource().equalsIgnoreCase(source) && train.getDestination().equalsIgnoreCase(destination)) {

                System.out.println("\nTrain Number: " + train.getTrainNumber());
                System.out.println("Train Name: " + train.getTrainName());
                System.out.println("Source: " + train.getSource());
                System.out.println("Destination: " + train.getDestination());
                System.out.println("Available Seats: " + train.getAvailableSeats());

                found = true;
            }
        }

        if (!found) {
            System.out.println("No train found.");
        }
    }

    public Booking bookTicket(Train train, Passenger passenger) {

        if (train.getAvailableSeats() > 0) {
            Booking booking = new Booking(passenger, train);

            train.decreaseSeat();
            bookingMap.put(booking.getPnr(), booking);

            return booking;
        }

        Queue<Passenger> queue = waitingLists.get(train.getTrainNumber());

        queue.add(passenger);

        System.out.println("No seats available.");
        System.out.println("Passenger added to waiting list.");

        return null;
    }

    public void searchBookingByPNR(String pnr) {
        Booking booking = bookingMap.get(pnr);

        if (booking == null) {
            System.out.println("Booking not found.");
            return;
        }

        Passenger passenger = booking.getPassenger();
        Train train = booking.getTrain();

        System.out.println("\n----- Booking Details -----");
        System.out.println("PNR: " + booking.getPnr());
        System.out.println("Passenger ID: " + passenger.getPassengerId());
        System.out.println("Passenger Name: " + passenger.getName());
        System.out.println("Age: " + passenger.getAge());
        System.out.println("Train: " + train.getTrainName());
        System.out.println("Train Number: " + train.getTrainNumber());
        System.out.println("From: " + train.getSource());
        System.out.println("To: " + train.getDestination());
    }

    public void cancelTicket(String pnr) {

        Booking booking = bookingMap.remove(pnr);

        if (booking == null) {
            System.out.println("Booking not found.");
            return;
        }

        Train train = booking.getTrain();

        train.increaseSeat();

        System.out.println("Booking cancelled successfully.");
        System.out.println("Cancelled PNR: " + pnr);

        Queue <Passenger> queue = waitingLists.get(train.getTrainNumber());

        if (!queue.isEmpty()) {
            Passenger passenger = queue.poll();
            Booking newBooking = new Booking(passenger, train);
            train.decreaseSeat();

            bookingMap.put(newBooking.getPnr(), newBooking);
            System.out.println("Waiting list passenger confirmed.");
            System.out.println("Passenger: " + passenger.getName());
            System.out.println("New PNR: " + newBooking.getPnr());
        }
    }
}