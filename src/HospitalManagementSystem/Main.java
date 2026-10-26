package HospitalManagementSystem;

import HospitalManagementSystem.service.HospitalService;
import HospitalManagementSystem.ui.HospitalMenu;

public class Main {
    public static void main(String[] args) {
        HospitalService service = new HospitalService();
        new HospitalMenu(service).start();
    }
}
