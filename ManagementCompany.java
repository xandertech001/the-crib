
public class ManagementCompany {
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;

    private String name;
    private String taxID;
    private double mgmtFee; // percent (0-100)

    private Property[] properties;
    private Plot plot; // company's plot
    private int numberOfProperties;

    // Constructors
    public ManagementCompany() {
        this("", "", 0.0);
    }

    public ManagementCompany(String name, String taxID, double mgmtFee) {
        this.name = name;
        this.taxID = taxID;
        this.mgmtFee = mgmtFee;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.numberOfProperties = 0;
    }

    // constructor with explicit company plot coordinates
    public ManagementCompany(String name, String taxID, double mgmtFee,
                             int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmtFee = mgmtFee;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(x, y, width, depth);
        this.numberOfProperties = 0;
    }

    // Getters & setters
    public String getName() { return name; }
    public String getTaxID() { return taxID; }
    public double getMgmtFee() { return mgmtFee; }
    public Plot getPlot() { return new Plot(plot); }
    public int getPropertiesCount() { return numberOfProperties; }

    public void setName(String name) { this.name = name; }
    public void setTaxID(String taxID) { this.taxID = taxID; }
    public void setMgmtFee(double mgmtFee) { this.mgmtFee = mgmtFee; }
    public void setPlot(Plot p) { this.plot = new Plot(p); }

    /**
     * Overloaded addProperty methods.
     * Return codes:
     * -1 : array full
     * -2 : property object passed is null
     * -3 : property plot not encompassed by management company plot
     * -4 : property plot overlaps existing property
     * >=0 : index where property was added
     */

    // 1) addProperty(Property p)
    public int addProperty(Property p) {
        if (isPropertiesFull()) return -1;
        if (p == null) return -2;

        Plot pPlot = p.getPlot();
        if (!this.plot.encompasses(pPlot)) return -3;

        // check overlap with existing properties
        for (int i = 0; i < numberOfProperties; i++) {
            Property existing = properties[i];
            if (existing != null && existing.getPlot().overlaps(pPlot)) {
                return -4;
            }
        }

        // find first empty slot
        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i] == null) {
                properties[i] = new Property(p); // store a copy
                numberOfProperties++;
                return i;
            }
        }

        // Should not reach here because we checked full earlier
        return -1;
    }

    // 2) addProperty by details (no plot - uses default company plot child Plot)
    public int addProperty(String propertyName, String city, double rent, String owner) {
        Property p = new Property(propertyName, city, rent, owner);
        return addProperty(p);
    }

    // 3) addProperty by details with plot coordinates
    public int addProperty(String propertyName, String city, double rent, String owner,
                           int x, int y, int width, int depth) {
        Property p = new Property(propertyName, city, rent, owner, x, y, width, depth);
        return addProperty(p);
    }

    /**
     * Sums rental amounts of stored properties.
     */
    public double getTotalRent() {
        double total = 0.0;
        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i] != null) {
                total += properties[i].getRentAmount();
            }
        }
        return total;
    }

    /**
     * Returns the property with the highest rent. If none, returns null.
     * Assumes each property has a unique rental amount as per spec.
     */
    public Property getHighestRentProperty() {
        if (numberOfProperties == 0) return null;

        Property highest = null;
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i] != null) {
                double r = properties[i].getRentAmount();
                if (r > max) {
                    max = r;
                    highest = properties[i];
                }
            }
        }
        return highest;
    }

    /**
     * Removes (nullifies) the last property in array (highest index non-null).
     * Returns true if removed, false if none to remove.
     */
    public boolean removeLastProperty() {
        for (int i = MAX_PROPERTY - 1; i >= 0; i--) {
            if (properties[i] != null) {
                properties[i] = null;
                numberOfProperties--;
                if (numberOfProperties < 0) numberOfProperties = 0;
                return true;
            }
        }
        return false;
    }

    public boolean isPropertiesFull() {
        return numberOfProperties >= MAX_PROPERTY;
    }

    /**
     * Valid if mgmt fee between 0 and 100 inclusive.
     */
    public boolean isManagementFeeValid() {
        return mgmtFee >= 0.0 && mgmtFee <= 100.0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of the properties for ").append(name).append(", taxID: ").append(taxID).append("\n");
        sb.append("_____________________________________________\n");
        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i] != null) {
                sb.append(properties[i].toString()).append("\n");
            }
        }
        sb.append("______________________________________________\n\n");
        double total = getTotalRent();
        double fee = total * (mgmtFee / 100.0);
        sb.append(" total management Fee: ").append(fee);
        return sb.toString();
    }

    // For GUI/tests: return internal properties array (defensive copy)
    public Property[] getProperties() {
        Property[] copy = new Property[MAX_PROPERTY];
        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (this.properties[i] != null) copy[i] = new Property(this.properties[i]);
        }
        return copy;
    }
}
