public class HealthRecord {

    private int height;

    private static final int MIN_PERMITTED_HEIGHT = 50;
    private static final int MAX_PERMITTED_HEIGHT = 175;
    private static final int DEFAULT_HEIGHT = 100;

    private static int tallestHeight = DEFAULT_HEIGHT;
    private static int shortestHeight = DEFAULT_HEIGHT;

    private static int counter = 0;
    private static double averageHeight = 0.0;

    public HealthRecord(int height) {
        setHeight(height);
        counter++;
    }

    public void setHeight(int height) {
        int oldHeight = this.height;

        if (height >= MIN_PERMITTED_HEIGHT && height <= MAX_PERMITTED_HEIGHT) {
            this.height = height;
        } else {
            this.height = DEFAULT_HEIGHT;
        }

        if (this.height > tallestHeight) {
            tallestHeight = this.height;
        }
        if (this.height < shortestHeight) {
            shortestHeight = this.height;
        }

        if (counter == 0) {
            averageHeight = this.height;
        } else {
            averageHeight = ((averageHeight * (counter - 1)) + this.height) / counter;
        }
    }

    public int getHeight() {
        return this.height;
    }

    public static int getTallestHeight() {
        return tallestHeight;
    }

    public static int getShortestHeight() {
        return shortestHeight;
    }

    public static double getAverageHeight() {
        return averageHeight;
    }

    public void displayDetails() {
        System.out.println("Height (cm): " + getHeight());
    }

    public static void displayClassDetails() {
        System.out.println("The tallest height (cm): " + getTallestHeight());
        System.out.println("The shortest height (cm): " + getShortestHeight());
        System.out.println("Average height (cm): " + getAverageHeight());
    }
}
