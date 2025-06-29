import java.util.*;

public class CarCollection {
    public static void run() {
        // Задание 2.2
        List<String> models = Arrays.asList(
                "Toyota Camry", "BMW X5", "Tesla Model S",
                "BMW X5", "Toyota Camry", "Tesla Model 3", "Audi A6"
        );

        Set<String> unique = new HashSet<>(models);
        List<String> sorted = new ArrayList<>(unique);
        sorted.sort(Comparator.reverseOrder());

        System.out.println("Отсортированные модели:");
        for (String model : sorted) System.out.println(model);

        Set<String> processed = new HashSet<>();
        for (String model : sorted) {
            if (model.toLowerCase().contains("tesla")) {
                processed.add("ELECTRO_CAR");
            } else {
                processed.add(model);
            }
        }

        System.out.println("\nМодели после замены Tesla:");
        processed.forEach(System.out::println);
    }
}
