import java.util.*;

public class CarSet {
    public static void run() {
        Set<Car> cars = new HashSet<>();

        Car c1 = new Car("VIN123", "Model S", "Tesla", 2022, 20000, 60000, CarType.SEDAN ); // дубликаты
        Car c2 = new Car("VIN123", "Model S", "Tesla", 2022, 20000, 60000, CarType.SEDAN); // дубликаты
        Car c3 = new Car("VIN456", "X5", "BMW", 2020, 55000, 45000, CarType.SEDAN);

        cars.add(c1);
        cars.add(c2); // не добавится
        cars.add(c3);

        System.out.println("Уникальные машины:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
