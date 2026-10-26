package ConsoleBasedApplications.model;
public class Passenger {
    private int passengerId;
    private String name;
    private int age;

    public Passenger(int passengerId, String name, int age) {
        this.passengerId = passengerId;
        this.name = name;
        this.age = age;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}