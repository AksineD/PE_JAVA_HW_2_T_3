import java.util.Scanner;

public class CylinderBuildingCalculator {

    // Class constants
    private static final double MIN_VALUE = 0.0;
    private static final double FULL_FLOOR_MIN_HEIGHT = 3.0;
    private static final double SMALL_FLOOR_MIN_HEIGHT = 2.0;
    private static final int FULL_FLOOR_RENT = 30000;
    private static final int SMALL_FLOOR_RENT = 10000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double radius = getValidatedInput(scanner, "Enter the cylinder's radius: ", MIN_VALUE,
                "Radius must be greater than 0.");
        double height = getValidatedInput(scanner, "Enter the cylinder's height: ", MIN_VALUE,
                "Height must be greater than 0.");

        scanner.close();
        processAndDisplayResults(radius, height);
    }

    /**
     * Validates user input ensuring it is greater than a given minimum value.
     *
     * @param scanner      The scanner object used for reading input.
     * @param prompt       The message to display to the user.
     * @param minValue     The minimum acceptable value for the input.
     * @param errorMessage The error message displayed when invalid input is given.
     * @return The validated numeric input.
     */
    private static double getValidatedInput(Scanner scanner, String prompt, double minValue, String errorMessage) {
        double inputValue;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                inputValue = scanner.nextDouble();
                if (inputValue > minValue) {
                    return inputValue; // Valid input
                } else {
                    System.out.println(errorMessage);
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next();
            }
        }
    }

    /**
     * Processes the input (radius and height), calculates building data
     * such as area, number of floors, and monthly profit, then displays the results.
     *
     * @param radius The radius of the cylinder.
     * @param height The total height of the cylinder.
     */
    private static void processAndDisplayResults(double radius, double height) {
        double area = calculateCylinderArea(radius, height);
        int fullFloors = calculateFullFloors(height);
        int smallFloors = calculateSmallFloors(height, fullFloors);

        int monthlyIncome = (fullFloors * FULL_FLOOR_RENT) + (smallFloors * SMALL_FLOOR_RENT);
        displayResults(area, fullFloors, smallFloors, monthlyIncome);
    }

    /**
     * Calculates the area (technically the volume, as per the original task) of the cylinder.
     *
     * @param radius The radius of the cylinder.
     * @param height The height of the cylinder.
     * @return The area/volume of the cylinder.
     */
    private static double calculateCylinderArea(double radius, double height) {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    /**
     * Calculates how many standard floors (with a minimum height of FULL_FLOOR_MIN_HEIGHT)
     * can fit in the given height.
     *
     * @param height The total height of the cylinder.
     * @return The number of full (standard) floors.
     */
    private static int calculateFullFloors(double height) {
        return (int) (height / FULL_FLOOR_MIN_HEIGHT);
    }

    /**
     * Calculates how many smaller floors (with a minimum height of SMALL_FLOOR_MIN_HEIGHT)
     * can fit in the remaining height after building all standard floors.
     *
     * @param height     The total height of the cylinder.
     * @param fullFloors The number of full (standard) floors already counted.
     * @return The number of small floors.
     */
    private static int calculateSmallFloors(double height, int fullFloors) {
        double usedHeight = fullFloors * FULL_FLOOR_MIN_HEIGHT;
        double remainingHeight = height - usedHeight;
        return (int) (remainingHeight / SMALL_FLOOR_MIN_HEIGHT);
    }

    /**
     * Displays the results of the calculations.
     *
     * @param area          The total area/volume of the cylinder.
     * @param fullFloors    The number of standard floors.
     * @param smallFloors   The number of small floors.
     * @param monthlyIncome The total monthly income from the building.
     */
    private static void displayResults(double area, int fullFloors, int smallFloors, int monthlyIncome) {
        System.out.printf("The new building’s total area is %.2f square meters.%n", area);
        System.out.println("You can build " + fullFloors + " standard floors.");
        System.out.println("You can build " + smallFloors + " smaller floors.");
        System.out.println("The monthly profit from the building is " + monthlyIncome + " ₪.");
    }
}
