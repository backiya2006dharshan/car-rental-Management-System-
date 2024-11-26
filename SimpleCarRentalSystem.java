import java.util.ArrayList;
import java.util.Scanner;


class Car {
    int id;            
    String name;       
    boolean available; 

    Car(int id, String name) {
        this.id = id;
        this.name = name;
        this.available = true; 
    }

    void rentCar() {
        if (available) {
            available = false;
            System.out.println("You have rented the car: " + name);
        } else {
            System.out.println("Sorry, this car is not available.");
        }
    }

    void returnCar() {
        if (!available) {
            available = true;
            System.out.println("You have returned the car: " + name);
        } else {
            System.out.println("This car is already available.");
        }
    }
}

public class SimpleCarRentalSystem {
    static ArrayList<Car> cars = new ArrayList<>(); 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    
        cars.add(new Car(1, "Toyota Corolla"));
        cars.add(new Car(2, "Honda Civic"));
        cars.add(new Car(3, "Ford Mustang"));

        while (true) {
            
            System.out.println("\nCar Rental System");
            System.out.println("1. Show Available Cars");
            System.out.println("2. Rent a Car");
            System.out.println("3. Return a Car");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt(); 
            switch (choice) {
                case 1: 
                    System.out.println("\nAvailable Cars:");
                    for (Car car : cars) {
                        if (car.available) {
                            System.out.println("ID: " + car.id + ", Name: " + car.name);
                        }
                    }
                    break;

                case 2: 
                    System.out.print("\nEnter the Car ID to rent: ");
                    int rentId = scanner.nextInt();
                    boolean carFound = false;
                    for (Car car : cars) {
                        if (car.id == rentId) {
                            car.rentCar();
                            carFound = true;
                            break;
                        }
                    }
                    if (!carFound) {
                        System.out.println("Invalid Car ID!");
                    }
                    break;

                case 3: 
                    System.out.print("\nEnter the Car ID to return: ");
                    int returnId = scanner.nextInt();
                    carFound = false;
                    for (Car car : cars) {
                        if (car.id == returnId) {
                            car.returnCar();
                            carFound = true;
                            break;
                        }
                    }
                    if (!carFound) {
                        System.out.println("Invalid Car ID!");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the Car Rental System. Goodbye!");
                    scanner.close();
                    return;

                default: //
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
