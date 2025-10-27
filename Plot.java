
public class Plot {
    private int x;
    private int y;
    private int width;  // horizontal extent
    private int depth;  // vertical extent

    // Default constructor (0,0,1,1) - small positive area by default
    public Plot() {
        this(0, 0, 1, 1);
    }

    // Parameter constructor
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    // Copy constructor
    public Plot(Plot other) {
        if (other == null) {
            this.x = 0;
            this.y = 0;
            this.width = 1;
            this.depth = 1;
        } else {
            this.x = other.x;
            this.y = other.y;
            this.width = other.width;
            this.depth = other.depth;
        }
    }

    // Getters and setters
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public int getDepth() { return depth; }
    public void setDepth(int depth) { this.depth = depth; }

    /**
     * Determines if this plot overlaps another plot.
     * Overlap is true only if the intersection area is positive.
     * If plots only share an edge, they do NOT overlap (per spec).
     */
    public boolean overlaps(Plot other) {
        if (other == null) return false;

        int leftA = this.x;
        int rightA = this.x + this.width;
        int topA = this.y;
        int bottomA = this.y + this.depth;

        int leftB = other.x;
        int rightB = other.x + other.width;
        int topB = other.y;
        int bottomB = other.y + other.depth;

        // If one rectangle is to the left of the other or above the other -> no overlap
        if (rightA <= leftB || rightB <= leftA) return false; // edges touching => no overlap
        if (bottomA <= topB || bottomB <= topA) return false; // edges touching => no overlap

        return true; // otherwise they overlap with positive area
    }

    /**
     * Determines if this plot fully encompasses another plot.
     * Inclusive: edges lying on edges are acceptable.
     */
    public boolean encompasses(Plot other) {
        if (other == null) return false;

        int leftA = this.x;
        int rightA = this.x + this.width;
        int topA = this.y;
        int bottomA = this.y + this.depth;

        int leftB = other.x;
        int rightB = other.x + other.width;
        int topB = other.y;
        int bottomB = other.y + other.depth;

        // this contains other if all edges of other are within or on edges of this
        return (leftB >= leftA) && (rightB <= rightA) && (topB >= topA) && (bottomB <= bottomA);
    }

    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}
