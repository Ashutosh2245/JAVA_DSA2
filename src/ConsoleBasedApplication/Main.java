package ConsoleBasedApplication;
import java.util.*;

class Train {
    int trainNumber;
    String trainName;
    String source;
    String destination;
    int totalSeats;
    int availableSeats;

    Train(int trainNumber, String trainName, String source, String destination, int totalSeats) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }
}

class Passenger {
    int passengerId;
    String name;
    int age;

    Passenger(int passengerId, String name, int age) {
        this.passengerId = passengerId;
        this.name = name;
        this.age = age;
    }
}

class Booking {
    String pnr;
    Passenger passenger;
    Train train;

    static int pnrCounter = 1001;

    Booking(Passenger passenger, Train train) {
        this.pnr = "PNR" + pnrCounter++;
        this.passenger = passenger;
        this.train = train;
    }
}

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int passengerCounter = 101;

    static Booking bookTicket(Train train, Passenger passenger, HashMap<Integer, Queue<Passenger>> waitingLists) {

        if (train.availableSeats > 0) {
            Booking booking = new Booking(passenger, train);
            train.availableSeats--;
            return booking;
        }

        Queue<Passenger> queue = waitingLists.get(train.trainNumber);
        queue.add(passenger);

        System.out.println("No seats available.");
        System.out.println("Passenger added to waiting list.");

        return null;
    }

    static void searchTrain(ArrayList<Train> trains, String source, String destination) {
        boolean found = false;

        for (Train train : trains) {
            if (train.source.equalsIgnoreCase(source) && train.destination.equalsIgnoreCase(destination)) {

                System.out.println("\nTrain Number: " + train.trainNumber);
                System.out.println("Train Name: " + train.trainName);
                System.out.println("Source: " + train.source);
                System.out.println("Destination: " + train.destination);
                System.out.println("Available Seats: " + train.availableSeats);

                found = true;
            }
        }

        if (!found) {
            System.out.println("No train found.");
        }
    }

    static void searchBookingByPNR(HashMap<String, Booking> bookingMap, String pnr) {

        Booking booking = bookingMap.get(pnr);

        if (booking == null) {
            System.out.println("Booking not found.");
            return;
        }

        System.out.println("\n----- Booking Details -----");
        System.out.println("PNR: " + booking.pnr);
        System.out.println("Passenger ID: " + booking.passenger.passengerId);
        System.out.println("Passenger Name: " + booking.passenger.name);
        System.out.println("Age: " + booking.passenger.age);
        System.out.println("Train: " + booking.train.trainName);
        System.out.println("Train Number: " + booking.train.trainNumber);
        System.out.println("From: " + booking.train.source);
        System.out.println("To: " + booking.train.destination);
        System.out.println("Available Seats: " + booking.train.availableSeats);
    }

    static void cancelTicket(String pnr, HashMap<String, Booking> bookingMap, HashMap<Integer, Queue<Passenger>> waitingLists) {

        Booking booking = bookingMap.get(pnr);

        if (booking == null) {
            System.out.println("Booking not found.");
            return;
        }

        Train train = booking.train;
        bookingMap.remove(pnr);
        train.availableSeats++;

        System.out.println("Booking cancelled successfully.");
        System.out.println("Cancelled PNR: " + pnr);

        Queue<Passenger> queue = waitingLists.get(train.trainNumber);

        if (!queue.isEmpty()) {
            Passenger passenger = queue.poll();

            Booking newBooking = new Booking(passenger, train);
            train.availableSeats--;

            bookingMap.put(newBooking.pnr, newBooking);

            System.out.println("Waiting list passenger confirmed.");
            System.out.println("Passenger: " + passenger.name);
            System.out.println("Passenger ID: " + passenger.passengerId);
            System.out.println("New PNR: " + newBooking.pnr);
        }
    }

    public static void main(String[] args) {

        ArrayList<Train> trains = new ArrayList<>();

        HashMap<String, Booking> bookingMap = new HashMap<>();

        HashMap<Integer, Queue<Passenger>> waitingLists = new HashMap<>();

        Train t1 = new Train(12951, "Mumbai Rajdhani", "Mumbai", "Delhi", 1);
        Train t2 = new Train(12301, "Howrah Rajdhani", "Howrah", "Delhi", 2);
        Train t3 = new Train(23456, "Delhi Mumbai SF EXP", "Delhi", "Mumbai",12);

        trains.add(t1);
        trains.add(t2);
        trains.add(t3);

        waitingLists.put(t1.trainNumber, new LinkedList<>());
        waitingLists.put(t2.trainNumber, new LinkedList<>());
        waitingLists.put(t3.trainNumber, new LinkedList<>());

        System.out.print("Enter your name: ");
        String cName = sc.nextLine();
        System.out.println("Hello "+cName);
        System.out.println("Welcome to train reservation system.");

        while (true) {

            System.out.println("\n==============================");
            System.out.println("     TRAIN BOOKING SYSTEM");
            System.out.println("==============================");

            System.out.println("1. Search Train");
            System.out.println("2. Book Ticket");
            System.out.println("3. Search Booking by PNR");
            System.out.println("4. Cancel Ticket");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter source: ");
                String source = sc.nextLine();

                System.out.print("Enter destination: ");
                String destination = sc.nextLine();

                searchTrain(trains, source, destination);

            } else if (choice == 2) {

                System.out.print("Enter train number: ");
                int trainNumber = sc.nextInt();
                sc.nextLine();

                Train selectedTrain = null;

                for (Train train : trains) {
                    if (train.trainNumber == trainNumber) {
                        selectedTrain = train;
                        break;
                    }
                }

                if (selectedTrain == null) {
                    System.out.println("Train not found.");
                    continue;
                }

                System.out.print("Enter passenger name: ");
                String name = sc.nextLine();

                System.out.print("Enter passenger age: ");
                int age = sc.nextInt();
                sc.nextLine();

                Passenger passenger = new Passenger(passengerCounter++, name, age);
                Booking booking = bookTicket(selectedTrain, passenger, waitingLists);

                if (booking != null) {
                    bookingMap.put(booking.pnr, booking);

                    System.out.println("Booking successful!");
                    System.out.println("Passenger ID: " + passenger.passengerId);
                    System.out.println("PNR: " + booking.pnr);
                }

            } else if (choice == 3) {

                System.out.print("Enter PNR: ");
                String pnr = sc.nextLine();

                searchBookingByPNR(bookingMap, pnr);

            } else if (choice == 4) {

                System.out.print("Enter PNR: ");
                String pnr = sc.nextLine();

                cancelTicket(pnr, bookingMap, waitingLists);

            } else if (choice == 5) {
                System.out.println("Thank you for using Train Booking System.");
                break;

            }
            else {
                System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}



