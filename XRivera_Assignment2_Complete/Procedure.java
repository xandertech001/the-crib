public class Procedure {
    private String procedureName;
    private String procedureDate;
    private String practitioner;
    private double charge;

    // No-arg constructor
    public Procedure() {
        this.procedureName = "";
        this.procedureDate = "";
        this.practitioner = "";
        this.charge = 0.0;
    }

    // Constructor with name and date
    public Procedure(String name, String date) {
        this();
        this.procedureName = name;
        this.procedureDate = date;
    }

    // Full constructor
    public Procedure(String name, String date, String doctor, double charge) {
        this.procedureName = name;
        this.procedureDate = date;
        this.practitioner = doctor;
        this.charge = charge;
    }

    // Getters and setters
    public String getProcedureName() { return procedureName; }
    public void setProcedureName(String name) { this.procedureName = name; }

    public String getProcedureDate() { return procedureDate; }
    public void setProcedureDate(String date) { this.procedureDate = date; }

    public String getPractitioner() { return practitioner; }
    public void setPractitioner(String doctor) { this.practitioner = doctor; }

    public double getCharge() { return charge; }
    public void setCharge(double charge) { this.charge = charge; }

    public String toString() {
        return "Procedure: " + procedureName + "\n" +
               "Date: " + procedureDate + "\n" +
               "Practitioner: " + practitioner + "\n" +
               String.format("Charge: $%,.2f", charge);
    }

    public void setDate(String validatedString) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDate'");
    }
}