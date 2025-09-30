
/*
 * Class: CMSC203 
 * Instructor: Professor Eivazi
 * Description: The patient and the procedure classes both act as blue prints for the driver to use, allowing the user to input personal details and information about procedures, outputting their details at the end and the cost of the procedures.  
 * Due: 09/29/2025
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Xander Rivera
*/

import java.util.Scanner;

public class PatientDriverApp {

	public static void main(String[] args) {
		// Create a Scanner object to read user input
		Scanner keyboard = new Scanner(System.in);

		// --- 1. Get Patient Data from User Input ---
		System.out.println("--- Entering Patient Information ---");

		System.out.print("Enter Patient First Name: ");
		String fName = keyboard.nextLine();

		System.out.print("Enter Patient Middle Name: ");
		String mName = keyboard.nextLine();

		System.out.print("Enter Patient Last Name: ");
		String lName = keyboard.nextLine();

		System.out.print("Enter Street Address: ");
		String street = keyboard.nextLine();

		System.out.print("Enter City: ");
		String city = keyboard.nextLine();

		System.out.print("Enter State: ");
		String state = keyboard.nextLine();

		System.out.print("Enter Zip Code: ");
		// Input validation for integer zip code
		while (!keyboard.hasNextInt()) {
			System.out.print("Invalid input. Please enter a numerical Zip Code: ");
			keyboard.next();
		}
		int zip = keyboard.nextInt();
		keyboard.nextLine(); // Consume the newline character

		System.out.print("Enter Phone Number: ");
		String phone = keyboard.nextLine();

		System.out.print("Enter Emergency Contact Name: ");
		String eName = keyboard.nextLine();

		System.out.print("Enter Emergency Contact Phone: ");
		String ePhone = keyboard.nextLine();

		// --- 2. Create Patient Object ---
		Patient patient = new Patient(fName, mName, lName, street, city, state, zip, phone, eName, ePhone);

		// --- 3. Get and Create Three Procedure Objects ---
		System.out.println("\n--- Entering Procedure 1 Details ---");
		Procedure proc1 = getInputProcedure(keyboard);

		System.out.println("\n--- Entering Procedure 2 Details ---");
		Procedure proc2 = getInputProcedure(keyboard);

		System.out.println("\n--- Entering Procedure 3 Details ---");
		Procedure proc3 = getInputProcedure(keyboard);

		// --- 4. Calculate Total Charges using the new method ---
		double totalCharges = calculateTotalCharges(proc1, proc2, proc3);

		// --- 5. Display Output using the new methods ---

		System.out.println("\nPatient info:");

		// Display Patient Information
		displayPatient(patient);

		// Display Procedure Information
		displayProcedure(proc1);
		displayProcedure(proc2);
		displayProcedure(proc3);

		System.out.println("");
		System.out.printf("Total Charges: $%,.2f", totalCharges);

		System.out.println("");
		System.out.println("\nStudent Name: Xander Rivera");
		System.out.println("MC# M21216811");
		System.out.println("Due Date: 09/29/25");

		// Close the scanner
		keyboard.close();
	}

	public static void displayPatient(Patient patient) {
		// Calls the Patient class's toString() method
		System.out.println(patient);
	}

	public static void displayProcedure(Procedure procedure) {
		// Calls the Procedure class's toString() method, which is tab-separated
		System.out.println(procedure);
	}

	public static double calculateTotalCharges(Procedure proc1, Procedure proc2, Procedure proc3) {
		return proc1.getCharges() + proc2.getCharges() + proc3.getCharges();
	}

	public static Procedure getInputProcedure(Scanner keyboard) {
		Procedure p = new Procedure();

		System.out.print("Enter Procedure Name: ");
		p.setName(keyboard.nextLine());

		System.out.print("Enter Procedure Date (e.g., MM/DD/YYYY): ");
		p.setDate(keyboard.nextLine());

		System.out.print("Enter Practitioner Name: ");
		p.setPractitioner(keyboard.nextLine());

		System.out.print("Enter Procedure Charges: ");
		// Input validation for double charges
		while (!keyboard.hasNextDouble()) {
			System.out.print("Invalid input. Please enter a numerical charge (e.g., 150.50): ");
			keyboard.next();
		}
		p.setCharges(keyboard.nextDouble());
		keyboard.nextLine(); // Consume the newline character

		return p;
	}
}