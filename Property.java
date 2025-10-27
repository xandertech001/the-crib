
public class Property {
    private String propertyName;
    private String city;
    private String owner;
    private double rentalAmount;
    private Plot plot;

    // Default constructor
    public Property() {
        this.propertyName = "";
        this.city = "";
        this.owner = "";
        this.rentalAmount = 0.0;
        this.plot = new Plot();
    }

    // Constructor without plot (uses default Plot)
    public Property(String propertyName, String city, double rentalAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentalAmount = rentalAmount;
        this.owner = owner;
        this.plot = new Plot();
    }

    // Constructor with plot coordinates
    public Property(String propertyName, String city, double rentalAmount, String owner,
                    int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentalAmount = rentalAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    // Copy constructor
    public Property(Property other) {
        if (other == null) {
            this.propertyName = "";
            this.city = "";
            this.owner = "";
            this.rentalAmount = 0.0;
            this.plot = new Plot();
        } else {
            this.propertyName = other.propertyName;
            this.city = other.city;
            this.owner = other.owner;
            this.rentalAmount = other.rentalAmount;
            this.plot = new Plot(other.plot);
        }
    }

    // Getters and setters
    public String getPropertyName() { return propertyName; }
    public void setPropertyName(String propertyName) { this.propertyName = propertyName; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }

    public double getRentAmount() { return rentalAmount; }
    public void setRentAmount(double rentalAmount) { this.rentalAmount = rentalAmount; }

    public Plot getPlot() { return new Plot(plot); } // return a copy
    public void setPlot(Plot plot) { this.plot = new Plot(plot); }

    @Override
    public String toString() {
        // Format: [property name],[ city],[ owner],[ rental amount]
        // Note: spec says no space between attributes; here they used commas without extra spaces.
        return propertyName + "," + city + "," + owner + "," + rentalAmount;
    }
}
