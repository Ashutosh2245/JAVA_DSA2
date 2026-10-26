package HospitalManagementSystem.service;

import HospitalManagementSystem.model.Bill;
import HospitalManagementSystem.model.BillItem;
import HospitalManagementSystem.model.Medicine;
import HospitalManagementSystem.model.Patient;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HospitalService {
    private final Map<Integer, Patient> patients = new LinkedHashMap<>();
    private final Map<Integer, Medicine> medicines = new LinkedHashMap<>();
    private final List<Bill> bills = new ArrayList<>();
    private int nextPatientId = 1;
    private int nextMedicineId = 1;
    private int nextBillId = 1001;

    public HospitalService() {
        addMedicine("Paracetamol 500mg", 2.50, 200);
        addMedicine("Cetirizine 10mg", 4.00, 100);
        addMedicine("ORS Sachet", 20.00, 50);
        addMedicine("Antiseptic Cream", 45.00, 30);
        addMedicine("Vitamin C Tablet", 3.00, 150);
    }

    public Patient registerPatient(String name, int age, String phone) {
        Patient patient = new Patient(nextPatientId++, name, age, phone);
        patients.put(patient.getId(), patient);
        return patient;
    }

    public List<Patient> getPatients() {
        return new ArrayList<>(patients.values());
    }

    public Patient findPatient(int id) {
        return patients.get(id);
    }

    public Medicine addMedicine(String name, double price, int stock) {
        Medicine medicine = new Medicine(nextMedicineId++, name, price, stock);
        medicines.put(medicine.getId(), medicine);
        return medicine;
    }

    public List<Medicine> getMedicines() {
        return new ArrayList<>(medicines.values());
    }

    public Medicine findMedicine(int id) {
        return medicines.get(id);
    }

    public Bill createBill(int patientId) {
        Patient patient = findPatient(patientId);
        if (patient == null) return null;
        Bill bill = new Bill(nextBillId++, patient);
        bills.add(bill);
        return bill;
    }

    public boolean addGeneralCharge(Bill bill, String description, int quantity, double unitPrice) {
        if (bill == null || description == null || description.isBlank()
                || quantity <= 0 || unitPrice < 0) return false;
        bill.addItem(new BillItem(description, quantity, unitPrice));
        return true;
    }

    public boolean addMedicineToBill(Bill bill, int medicineId, int quantity) {
        if (bill == null || quantity <= 0) return false;
        Medicine medicine = findMedicine(medicineId);
        if (medicine == null || medicine.getStock() < quantity) return false;
        if (!medicine.reduceStock(quantity)) return false;
        bill.addItem(new BillItem(medicine.getName(), quantity, medicine.getPrice()));
        return true;
    }

    public List<Bill> getBills() {
        return new ArrayList<>(bills);
    }
}
