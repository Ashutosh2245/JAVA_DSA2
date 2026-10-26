package ConsoleBasedApplications;
import java.util.ArrayList;
import ConsoleBasedApplications.model.Train;
import ConsoleBasedApplications.util.TrainData;
import ConsoleBasedApplications.service.TrainBookingService;
import ConsoleBasedApplications.ui.ConsoleMenu;

public class Main {
    public static void main(String[] args) {
        ArrayList<Train> trains = TrainData.getTrains();
        TrainBookingService service = new TrainBookingService(trains);
        ConsoleMenu menu = new ConsoleMenu(service);
        menu.start();
    }
}