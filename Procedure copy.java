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


public class Procedure {

	private String name;
	private String date;
	private String practitioner;
	private double charges;

	public Procedure() {
	}

	public Procedure(String name, String date) {

		this.name = name;
		this.date = date;

	}

	public Procedure(String name, String date, String practitioner, double charges) {

		this.name = name;
		this.date = date;
		this.practitioner = practitioner;
		this.charges = charges;
	}

	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}

	public String getPractitioner() {
		return practitioner;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setPractitioner(String practitioner) {
		this.practitioner = practitioner;
	}

	public double getCharges() {
		return charges;
	}

	public void setCharges(double charges) {
		this.charges = charges;
	}

	// toString method
	public String toString() {
		String formattedCharge = String.format("%.2f", charges);

		return "\n\tProcedure: " + name + "\n\tProcedureDate: " + date + "\n\tPractitioner: " + practitioner
				+ "\n\tCharge: $" + formattedCharge;
	}

}
