import java.util.Random;

public class CarsArray {
    public static void run() {
        // Задание 2.1
        int[] years = new int[50];
        Random rand = new Random();

        for (int i = 0; i < years.length; i++) {
            years[i] = 2000 + rand.nextInt(26);
        }

        System.out.println("Машины после 2015:");
        for (int y : years) {
            if (y > 2015) System.out.print(y + " ");
        }

        int totalAge = 0;
        for (int y : years) {
            totalAge += (2025 - y);
        }
        double avgAge = (double) totalAge / years.length;
        System.out.println("\nСредний возраст автомобилей: " + avgAge);
    }
}
