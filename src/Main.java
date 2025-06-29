import java.util.*;

public class Main {
    public static void main(String[] args) {
        //CarsArray.run();
        //CarCollection.run();
        //CarSet.run();
        //CarStream.run();
        Scanner scanner = new Scanner(System.in);
        CarDealership dealership = new CarDealership();

        // тестовые данные
        dealership.addCar(new Car("VIN001", "Model S", "Tesla", 2020, 15000, 80000, CarType.ELECTRIC));
        dealership.addCar(new Car("VIN002", "X5", "BMW", 2018, 40000, 45000, CarType.SUV));
        dealership.addCar(new Car("VIN003", "Camry", "Toyota", 2016, 60000, 20000, CarType.SEDAN));
        dealership.addCar(new Car("VIN004", "Model 3", "Tesla", 2021, 10000, 50000, CarType.ELECTRIC));
        dealership.addCar(new Car("VIN005", "F-150", "Ford", 2019, 30000, 35000, CarType.TRUCK));
        dealership.addCar(new Car("VIN006", "Civic", "Honda", 2015, 75000, 15000, CarType.SEDAN));
        dealership.addCar(new Car("VIN007", "Corolla", "Toyota", 2017, 50000, 18000, CarType.SEDAN));
        dealership.addCar(new Car("VIN008", "Model X", "Tesla", 2019, 20000, 90000, CarType.ELECTRIC));

        System.out.println("Автосалон загружен тестовыми данными.");

        while (true) {
            System.out.println("\n=== Меню автосалона ===");
            System.out.println("1. Добавить машину");
            System.out.println("2. Найти машины по производителю");
            System.out.println("3. Средняя цена по типу");
            System.out.println("4. Отсортировать по году (от новых)");
            System.out.println("5. Статистика по типам");
            System.out.println("6. Самая старая и самая новая машина");
            System.out.println("7. Показать все машины");
            System.out.println("0. Выход");
            System.out.print("Выбор: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("VIN: ");
                    String vin = scanner.nextLine();
                    System.out.print("Модель: ");
                    String model = scanner.nextLine();
                    System.out.print("Производитель: ");
                    String manufacturer = scanner.nextLine();
                    System.out.print("Год: ");
                    int year = scanner.nextInt();
                    System.out.print("Пробег: ");
                    int mileage = scanner.nextInt();
                    System.out.print("Цена: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Тип (SEDAN, SUV, ELECTRIC, HATCHBACK, TRUCK, COUPE): ");
                    CarType type = CarType.valueOf(scanner.nextLine().toUpperCase());

                    boolean added = dealership.addCar(new Car(vin, model, manufacturer, year, mileage, price, type));
                    System.out.println(added ? "Машина добавлена." : "Машина с данным VIN уже существует.");
                }

                case 2 -> {
                    System.out.print("Введите производителя: ");
                    String maker = scanner.nextLine();
                    var list = dealership.findByManufacturer(maker);
                    list.forEach(System.out::println);
                }

                case 3 -> {
                    System.out.print("Тип машины: ");
                    CarType type = CarType.valueOf(scanner.nextLine().toUpperCase());
                    double avg = dealership.averagePriceByType(type);
                    System.out.println("Средняя цена: $" + avg);
                }

                case 4 -> {
                    var sorted = dealership.sortByYearDesc();
                    sorted.forEach(System.out::println);
                }

                case 5 -> {
                    var stat = dealership.countByType();
                    stat.forEach((type, count) -> System.out.println(type + ": " + count + " шт."));
                }

                case 6 -> {
                    dealership.getOldestCar().ifPresent(car -> System.out.println("Старая: " + car));
                    dealership.getNewestCar().ifPresent(car -> System.out.println("Новая: " + car));
                }

                case 7 -> {
                    dealership.getAllCars().forEach(System.out::println);
                }

                case 0 -> {
                    System.out.println("Выход...");
                    return;
                }

                default -> System.out.println("Неверный выбор");
            }
        }
    }
}