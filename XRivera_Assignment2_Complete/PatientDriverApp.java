/* 
 *   

 Class: CMSC203 CRN 40539 

 Program: Assignment # 2

 Instructor: Dr. Grinberg

 Summary of Description: Classes are used to take in input about a patient, along with their procedures, to calculate their total cost.

 Due Date: July 1st, 2025 

 Integrity Pledge: I pledge that I have completed the programming assignment independently. 

 I have not copied the code from a student or any source. 

  
 */


import java.util.Scanner;

public class PatientDriverApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // === Patient Info ===
        String first = getValidatedName(input, "Enter Patient's First Name: ");
        String middle = getValidatedName(input, "Enter Patient's Middle Name: ");
        String last = getValidatedName(input, "Enter Patient's Last Name: ");
        String address = getNonEmptyInput(input, "Enter Patient's Address: ");
        String city = getValidatedName(input, "Enter City: ");
        String state = getValidatedName(input, "Enter State: ");
        String zip = getValidatedZIP(input, "Enter ZIP Code (5 digits): ");
        String phone = getValidatedPhone(input, "Enter Phone Number (e.g., 301-123-4567): ");
        String emergencyName = getValidatedName(input, "Enter Emergency Contact Name: ");
        String emergencyPhone = getValidatedPhone(input, "Enter Emergency Contact Phone (e.g., 301-123-4567): ");

        Patient patient = new Patient(first, middle, last, address, city, state, zip, phone, emergencyName, emergencyPhone);

        // === Procedure 1 ===
        System.out.println("\nEnter Procedure 1 Details:");
        String proc1Name = getValidatedName(input, "Name: ");
        String proc1Date = getNonEmptyInput(input, "Date (MM/DD/YYYY): ");
        String proc1Doc = getValidatedName(input, "Practitioner: ");
        double proc1Charge = getValidatedCharge(input, "Charge: ");
        Procedure proc1 = new Procedure(proc1Name, proc1Date, proc1Doc, proc1Charge);

        // === Procedure 2 ===
        System.out.println("\nEnter Procedure 2 Details:");
        String proc2Name = getValidatedName(input, "Name: ");
        String proc2Date = getNonEmptyInput(input, "Date (MM/DD/YYYY): ");
        Procedure proc2 = new Procedure(proc2Name, proc2Date);
        proc2.setPractitioner(getValidatedName(input, "Practitioner: "));
        proc2.setCharge(getValidatedCharge(input, "Charge: "));

        // === Procedure 3 ===
        System.out.println("\nEnter Procedure 3 Details:");
        Procedure proc3 = new Procedure();
        proc3.setProcedureName(getValidatedName(input, "Name: "));
        proc3.setProcedureDate(getNonEmptyInput(input, "Date (MM/DD/YYYY): "));
        proc3.setPractitioner(getValidatedName(input, "Practitioner: "));
        proc3.setCharge(getValidatedCharge(input, "Charge: "));

        // === Display Output ===
        System.out.println("\n--- Patient Information ---");
        displayPatient(patient);

        System.out.println("\n--- Procedures ---");
        displayProcedure(proc1);
        displayProcedure(proc2);
        displayProcedure(proc3);

        System.out.printf("\nTotal Charges: $%,.2f\n", calculateTotalCharges(proc1, proc2, proc3));
        System.out.println("\nThe program was developed by Student: Xander Rivera <07/1/25>");
    }

    // === VALIDATION METHODS ===

    public static String getValidatedName(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("This field cannot be empty.");
            } else if (!input.matches("^[A-Za-z\\-'.\\ ]{2,30}$")) {
                System.out.println("Name must be 2–30 letters only. Hyphens and apostrophes allowed.");
                input = "";
            }
        } while (input.isEmpty());
        return input;
    }

    public static String getValidatedPhone(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (!input.matches("^\\d{3}-\\d{3}-\\d{4}$")) {
                System.out.println("Phone number must match format 123-456-7890.");
            }
        } while (!input.matches("^\\d{3}-\\d{3}-\\d{4}$"));
        return input;
    }

    public static String getValidatedZIP(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (!input.matches("^\\d{5}$")) {
                System.out.println("ZIP Code must be exactly 5 digits.");
            }
        } while (!input.matches("^\\d{5}$"));
        return input;
    }

    public static double getValidatedCharge(Scanner scanner, String prompt) {
        double value = -1;
        do {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                value = Double.parseDouble(input);
                if (value < 0 || value > 100000) {
                    System.out.println("Charge must be between $0 and $100,000.");
                    value = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        } while (value < 0);
        return value;
    }

    public static String getNonEmptyInput(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("This field cannot be left blank.");
            }
        } while (input.isEmpty());
        return input;
    }

    // === DISPLAY METHODS ===

    public static void displayPatient(Patient p) {
        System.out.println(p);
    }

    public static void displayProcedure(Procedure p) {
        System.out.println(p);
    }

    public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3) {
        return p1.getCharge() + p2.getCharge() + p3.getCharge();
    }
}
