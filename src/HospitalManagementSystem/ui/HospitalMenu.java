package HospitalManagementSystem.ui;

import HospitalManagementSystem.model.Bill;
import HospitalManagementSystem.model.Medicine;
import HospitalManagementSystem.model.Patient;
import HospitalManagementSystem.service.HospitalService;
import HospitalManagementSystem.util.InputUtil;

import java.util.List;

public class HospitalMenu {
    private final HospitalService service;
    private final InputUtil input = new InputUtil();

    public HospitalMenu(HospitalService service) {
        this.service = service;
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\n========== HOSPITAL MANAGEMENT SYSTEM ==========");
            System.out.println("1. Register Patient");
            System.out.println("2. View Patients");
            System.out.println("3. View Medicine Inventory");
            System.out.println("4. Add Medicine to Inventory");
            System.out.println("5. Create Patient Bill");
            System.out.println("6. View All Bills");
            System.out.println("7. Exit");
            int choice = input.readInt("Choose an option: ");

            switch (choice) {
                case 1 -> registerPatient();
                case 2 -> viewPatients();
                case 3 -> viewMedicines();
                case 4 -> addMedicine();
                case 5 -> createBill();
                case 6 -> viewBills();
                case 7 -> {
                    running = false;
                    System.out.println("Thank you for using the system.");
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void registerPatient() {
        String name = input.readString("Patient name: ");
        int age = input.readInt("Age: ");
        String phone = input.readString("Phone: ");
        if (name.isBlank() || age < 0 || age > 130 || phone.isBlank()) {
            System.out.println("Invalid patient details.");
            return;
        }
        Patient patient = service.registerPatient(name, age, phone);
        System.out.println("Patient registered successfully. Patient ID: " + patient.getId());
    }

    private void viewPatients() {
        List<Patient> patients = service.getPatients();
        if (patients.isEmpty()) {
            System.out.println("No patients registered yet.");
            return;
        }
        for (Patient patient : patients) System.out.println(patient);
    }

    private void viewMedicines() {
        List<Medicine> medicines = service.getMedicines();
        System.out.println("\n----------- MEDICINE INVENTORY -----------");
        for (Medicine medicine : medicines) System.out.println(medicine);
    }

    private void addMedicine() {
        String name = input.readString("Medicine name: ");
        double price = input.readDouble("Price per unit (Rs.): ");
        int stock = input.readInt("Opening stock quantity: ");
        if (name.isBlank() || price < 0 || stock < 0) {
            System.out.println("Invalid medicine details.");
            return;
        }
        Medicine medicine = service.addMedicine(name, price, stock);
        System.out.println("Medicine added. Medicine ID: " + medicine.getId());
    }

    private void createBill() {
        viewPatients();
        int patientId = input.readInt("Enter patient ID for billing: ");
        Bill bill = service.createBill(patientId);
        if (bill == null) {
            System.out.println("Patient not found. Register the patient first.");
            return;
        }

        boolean adding = true;
        while (adding) {
            System.out.println("\n---------- BILL BUILDER ----------");
            System.out.println("1. Add Consultation Fee");
            System.out.println("2. Add Room Charge");
            System.out.println("3. Add Lab/Test Charge");
            System.out.println("4. Add Medicine");
            System.out.println("5. Finish and Print Invoice");
            int choice = input.readInt("Choose an option: ");

            switch (choice) {
                case 1 -> addCustomCharge(bill, "Consultation Fee");
                case 2 -> addCustomCharge(bill, "Room Charge");
                case 3 -> addCustomCharge(bill, "Lab/Test Charge");
                case 4 -> addMedicineLine(bill);
                case 5 -> {
                    adding = false;
                    bill.printInvoice();
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void addCustomCharge(Bill bill, String label) {
        double amount = input.readDouble(label + " amount (Rs.): ");
        if (amount < 0) {
            System.out.println("Amount cannot be negative.");
            return;
        }
        if (service.addGeneralCharge(bill, label, 1, amount)) {
            System.out.println(label + " added.");
        }
    }

    private void addMedicineLine(Bill bill) {
        viewMedicines();
        int medicineId = input.readInt("Medicine ID: ");
        int quantity = input.readInt("Quantity: ");
        if (service.addMedicineToBill(bill, medicineId, quantity)) {
            System.out.println("Medicine added to bill and stock updated.");
        } else {
            System.out.println("Could not add medicine. Check medicine ID, quantity, and stock.");
        }
    }

    private void viewBills() {
        List<Bill> bills = service.getBills();
        if (bills.isEmpty()) {
            System.out.println("No bills created yet.");
            return;
        }
        for (Bill bill : bills) bill.printInvoice();
    }
}
