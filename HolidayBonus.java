
public class HolidayBonus {

    // constants 
    private static final double HIGH_BONUS = 5000.0;
    private static final double MEDIUM_BONUS = 2000.0;
    private static final double LOW_BONUS = 1000.0;

    public HolidayBonus() {}

    /**
     * Calculates the holiday bonus for each store.
     * @param data the two dimensional ragged array of store sales
     * @return a double array representing bonus payout per store
     */
    public static double[] calculateHolidayBonus(double[][] data) {
        double[] storeBonuses = new double[data.length];

        // Determine the number of columns in the ragged array
        int maxColumns = 0;
        for (double[] row : data) {
            if (row.length > maxColumns)
                maxColumns = row.length;
        }

        for (int col = 0; col < maxColumns; col++) {
            // Find highest & lowest in this column (only positive values count)
            double highest = Double.NEGATIVE_INFINITY;
            double lowest = Double.POSITIVE_INFINITY;

            for (double[] row : data) {
                if (col < row.length && row[col] > 0) {
                    if (row[col] > highest)
                        highest = row[col];
                    if (row[col] < lowest)
                        lowest = row[col];
                }
            }

            // Award bonuses to eligible stores
            for (int r = 0; r < data.length; r++) {
                if (col < data[r].length && data[r][col] > 0) {
                    if (data[r][col] == highest)
                        storeBonuses[r] += HIGH_BONUS;
                    else if (data[r][col] == lowest)
                        storeBonuses[r] += LOW_BONUS;
                    else
                        storeBonuses[r] += MEDIUM_BONUS;
                }
            }
        }

        return storeBonuses;
    }

    /**
     * Calculates the total holiday bonuses.
     * @param data the two dimensional ragged array of store sales
     * @return the total sum of all holiday bonuses
     */
    public static double calculateTotalHolidayBonus(double[][] data) {
        double[] bonuses = calculateHolidayBonus(data);
        double total = 0;
        for (double bonus : bonuses) {
            total += bonus;
        }
        return total;
    }
}
