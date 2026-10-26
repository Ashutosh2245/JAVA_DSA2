package ConsoleBasedApplications.util;
import java.util.ArrayList;
import ConsoleBasedApplications.model.Train;
public class TrainData {

    public static ArrayList<Train> getTrains() {
        ArrayList<Train> trains = new ArrayList<>();

        trains.add(new Train(12951, "Mumbai Rajdhani",
                        "Mumbai", "Delhi", 1));

        trains.add(new Train(12301, "Howrah Rajdhani",
                        "Howrah", "Delhi", 2));

        trains.add(new Train(23456, "Delhi Mumbai SF EXP",
                        "Delhi", "Mumbai", 12));

        return trains;
    }
}