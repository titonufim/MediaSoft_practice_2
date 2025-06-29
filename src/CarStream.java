import java.util.*;
import java.util.stream.Collectors;

public class CarStream {
    public static void run() {
        // Задание 2.4
        List<Car> cars = Arrays.asList(
                new Car("VIN1", "Model S", "Tesla", 2022, 20000, 70000, CarType.SEDAN),
                new Car("VIN2", "X5", "BMW", 2021, 60000, 50000, CarType.SEDAN),
                new Car("VIN3", "Camry", "Toyota", 2018, 40000, 25000, CarType.SEDAN),
                new Car("VIN4", "Model 3", "Tesla", 2023, 10000, 55000, CarType.SEDAN),
                new Car("VIN5", "A6", "Audi", 2020, 70000, 30000, CarType.SEDAN)
        );

        // Пробег < 50 000
        List<Car> lowMileage = cars.stream()
                .filter(c -> c.getMileage() < 50000)
                .collect(Collectors.toList());

        System.out.println("Машины с малым пробегом:");
        lowMileage.forEach(System.out::println);

        // Сортировка по цене убывание
        List<Car> topExpensive = cars.stream()
                .sorted(Comparator.comparingDouble(Car::getPrice).reversed())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("\nТоп-3 дорогие:");
        topExpensive.forEach(System.out::println);

        // Средний пробег
        double avgMileage = cars.stream()
                .mapToInt(Car::getMileage)
                .average().orElse(0);
        System.out.println("\nСредний пробег: " + avgMileage);

        // по производителю
        Map<String, List<Car>> byMaker = cars.stream()
                .collect(Collectors.groupingBy(Car::getManufacturer));

        System.out.println("\nГруппировка:");
        byMaker.forEach((maker, list) -> {
            System.out.println(maker + ":");
            list.forEach(System.out::println);
        });
    }
}
