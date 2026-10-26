package ConsoleBasedApplications.ui;
import java.util.*;

import ConsoleBasedApplications.model.Train;
import ConsoleBasedApplications.model.Passenger;
import ConsoleBasedApplications.model.Booking;
import ConsoleBasedApplications.service.TrainBookingService;

public class ConsoleMenu {

    private Scanner sc;
    private TrainBookingService service;
    private int passengerCounter = 101;

    public ConsoleMenu(TrainBookingService service) {
        this.service = service;
        this.sc = new Scanner(System.in);
    }

    public void start() {

        System.out.print("Enter your name: ");
        String customerName = sc.nextLine();

        System.out.println("Hello " + customerName);
        System.out.println("Welcome to Train Reservation System.");

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

            switch (choice) {

                case 1:
                    System.out.print("Enter source: ");
                    String source = sc.nextLine();

                    System.out.print("Enter destination: ");
                    String destination = sc.nextLine();

                    service.searchTrain(source, destination);
                    break;

                case 2:
                    System.out.print("Enter train number: ");
                    int trainNumber = sc.nextInt();
                    sc.nextLine();

                    Train train = service.findTrain(trainNumber);

                    if (train == null) {
                        System.out.println("Train not found.");
                        break;
                    }

                    System.out.print("Enter passenger name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter passenger age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    if (age <= 0) {
                        System.out.println("Invalid age.");
                        break;
                    }

                    Passenger passenger = new Passenger(
                            passengerCounter++, name, age
                    );

                    Booking booking =
                            service.bookTicket(train, passenger);

                    if (booking != null) {
                        System.out.println("Booking successful!");

                        System.out.println("Passenger ID: "
                                + passenger.getPassengerId());

                        System.out.println("PNR: "
                                + booking.getPnr());
                    }

                    break;

                case 3:
                    System.out.print("Enter PNR: ");
                    String pnr = sc.nextLine();

                    service.searchBookingByPNR(pnr);
                    break;

                case 4:
                    System.out.print("Enter PNR: ");
                    String cancelPnr = sc.nextLine();

                    service.cancelTicket(cancelPnr);
                    break;

                case 5:
                    System.out.println("Thank you for using Train Booking System.");

                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}