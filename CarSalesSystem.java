package simpleCarSalesSystem_java;


	import java.util.ArrayList;
	import java.util.Scanner;

	class Car {
	    String make;
	    String model;
	    int year;

	    public Car(String make, String model, int year) {
	        this.make = make;
	        this.model = model;
	        this.year = year;
	    }

	    @Override
	    public String toString() {
	        return year + " " + make + " " + model;
	    }
	}

	class CarInventory {
	    ArrayList<Car> cars;

	    public CarInventory() {
	        cars = new ArrayList<>();
	    }

	    public void addCar(Car car) {
	        cars.add(car);
	        System.out.println("Car added to inventory.");
	    }

	    public void viewInventory() {
	        if (cars.isEmpty()) {
	            System.out.println("Inventory is empty.");
	        } else {
	            System.out.println("Car Inventory:");
	            for (Car car : cars) {
	                System.out.println(car);
	            }
	        }
	    }

	    public void searchCar(String keyword) {
	        boolean found = false;
	        for (Car car : cars) {
	            if (car.make.equalsIgnoreCase(keyword) || car.model.equalsIgnoreCase(keyword)) {
	                System.out.println("Found matching car: " + car);
	                found = true;
	            }
	        }
	        if (!found) {
	            System.out.println("No matching car found.");
	        }
	    }
	}

	public class CarSalesSystem {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        CarInventory inventory = new CarInventory();

	        while (true) {
	            System.out.println("\nCar Sales System");
	            System.out.println("1. Add Car");
	            System.out.println("2. View Inventory");
	            System.out.println("3. Search Car");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine();  

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter make: ");
	                    String make = scanner.nextLine();
	                    System.out.print("Enter model: ");
	                    String model = scanner.nextLine();
	                    System.out.print("Enter year: ");
	                    int year = scanner.nextInt();
	                    scanner.nextLine();  // Consume newline
	                    Car car = new Car(make, model, year);
	                    inventory.addCar(car);
	                    break;
	                case 2:
	                    inventory.viewInventory();
	                    break;
	                case 3:
	                    System.out.print("Enter search keyword: ");
	                    String keyword = scanner.nextLine();
	                    inventory.searchCar(keyword);
	                    break;
	                case 4:
	                    System.out.println("Exiting...");
	                    scanner.close();
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice. Please enter a valid option.");
	            }
	        }
	    }
	}

