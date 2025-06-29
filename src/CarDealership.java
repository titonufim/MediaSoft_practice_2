import java.util.*;
import java.util.stream.Collectors;

public class CarDealership {
    // Задание 2.5
    private List<Car> cars = new ArrayList<>();

    public boolean addCar(Car car) {
        if (cars.stream().anyMatch(c -> c.getVin().equals(car.getVin()))) {
            return false; // дубликат VIN
        }
        cars.add(car);
        return true;
    }

    public List<Car> findByManufacturer(String manufacturer) {
        return cars.stream()
                .filter(c -> c.getManufacturer().equalsIgnoreCase(manufacturer))
                .collect(Collectors.toList());
    }

    public double averagePriceByType(CarType type) {
        return cars.stream()
                .filter(c -> c.getType() == type)
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0.0);
    }

    public List<Car> sortByYearDesc() {
        return cars.stream()
                .sorted(Comparator.comparingInt(Car::getYear).reversed())
                .collect(Collectors.toList());
    }

    public Map<CarType, Long> countByType() {
        return cars.stream()
                .collect(Collectors.groupingBy(Car::getType, Collectors.counting()));
    }

    public Optional<Car> getOldestCar() {
        return cars.stream()
                .min(Comparator.comparingInt(Car::getYear));
    }

    public Optional<Car> getNewestCar() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getYear));
    }

    public List<Car> getAllCars() {
        return new ArrayList<>(cars);
    }
}
