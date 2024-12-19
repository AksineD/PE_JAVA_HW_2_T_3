import java.util.Scanner;

public class CylinderBuilding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // קלט רדיוס וגובה הגליל
        System.out.print("הכנס את רדיוס הגליל: ");
        double r = sc.nextDouble();
        System.out.print("הכנס את גובה הגליל: ");
        double h = sc.nextDouble();

        // חישוב שטח/נפח הגליל לפי הדוגמה (π * r^2 * h)
        double area = Math.PI * r * r * h;

        // חישוב מספר הקומות התקינות (גובה מינימלי 3 מטר)
        int fullFloors = (int)(h / 3);

        // חישוב הגובה שנותר לאחר הקומות התקינות
        double remainingHeight = h - (fullFloors * 3);

        // חישוב מספר הקומות הנמוכות (גובה מינימלי 2 מטר)
        int smallFloors = (int)(remainingHeight / 2);

        // חישוב הרווח החודשי
        // 30000 ₪ לקומה תקינה, 10000 ₪ לקומה קטנה
        int monthlyIncome = (fullFloors * 30000) + (smallFloors * 10000);

        // הדפסת התוצאות
        System.out.printf("שטח הבניין החדש הוא %.2f מטר רבוע.%n", area);
        System.out.println("ניתן לבנות " + fullFloors + " קומות תקינות.");
        System.out.println("ניתן לבנות " + smallFloors + " קומות קטנות נמוכות.");
        System.out.println("הרווח החודשי מהבניין הינו " + monthlyIncome + " ₪.");

        sc.close();
    }
}
