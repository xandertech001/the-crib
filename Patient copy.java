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

public class Patient {

	private String firstName;
	private String middleName;
	private String lastName;
	private String streetAddress;
	private String city;
	private String state;
	private int zipCode;
	private String phoneNumber;
	private String nameEmergencyContact;
	private String emergencyPhone;

	public Patient() {
	}

	public Patient(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	public Patient(String first, String middle, String last, String street, String city, String state, int zipCode,
			String phone, String emergencyName, String emergencyPhone) {
		this.firstName = first;
		this.middleName = middle;
		this.lastName = last;
		this.streetAddress = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = phone;
		this.nameEmergencyContact = emergencyName;
		this.emergencyPhone = emergencyPhone;
	}

	// Setters
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setNameEmergencyContact(String nameEmergencyContact) {
		this.nameEmergencyContact = nameEmergencyContact;
	}

	public void setEmergencyPhone(String emergencyPhone) {
		this.emergencyPhone = emergencyPhone;
	}

	// Getters
	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getStreetAdress() {
		return streetAddress;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getNameEmergencyContact() {
		return nameEmergencyContact;
	}

	public String getEmergencyPhone() {
		return emergencyPhone;
	}

	public String buildFullName() {
		return firstName + " " + middleName + " " + lastName;
	}

	public String buildAddress() {
		return streetAddress + " " + city + " " + state + " " + zipCode;
	}

	public String buildEmergencyContact() {
		return nameEmergencyContact + " " + emergencyPhone;
	}

	// toString method
	public String toString() {
		return "  Full Name: " + buildFullName() + "\n  Address: " + buildAddress() + "\n  Phone: " + phoneNumber
				+ "\n  Emergency Contact: " + buildEmergencyContact();
	}
}
