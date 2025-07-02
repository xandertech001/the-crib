public class Patient {
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String emergencyContactName;
    private String emergencyContactPhone;

    // No-arg constructor
    public Patient() {
        this.firstName = "";
        this.middleName = "";
        this.lastName = "";
        this.address = "";
        this.city = "";
        this.state = "";
        this.zip = "";
        this.phone = "";
        this.emergencyContactName = "";
        this.emergencyContactPhone = "";
    }

    // Constructor with only name
    public Patient(String first, String middle, String last) {
        this();
        this.firstName = first;
        this.middleName = middle;
        this.lastName = last;
    }

    // Full constructor
    public Patient(String first, String middle, String last, String address, String city, String state, String zip,
                   String phone, String emergencyName, String emergencyPhone) {
        this.firstName = first;
        this.middleName = middle;
        this.lastName = last;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.emergencyContactName = emergencyName;
        this.emergencyContactPhone = emergencyPhone;
    }

    // Getters and setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmergencyContactName() { return emergencyContactName; }
    public void setEmergencyContactName(String name) { this.emergencyContactName = name; }

    public String getEmergencyContactPhone() { return emergencyContactPhone; }
    public void setEmergencyContactPhone(String phone) { this.emergencyContactPhone = phone; }

    public String buildFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    public String buildAddress() {
        return address + ", " + city + ", " + state + " " + zip;
    }

    public String buildEmergencyContact() {
        return emergencyContactName + " " + emergencyContactPhone;
    }

    public String toString() {
        return "Patient: " + buildFullName() + "\n" +
               "Address: " + buildAddress() + "\n" +
               "Emergency Contact: " + buildEmergencyContact();
    }
}
