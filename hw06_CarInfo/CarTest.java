/*
 * CarTest.java - contains the main method and creates car objects
 * to test is the car.java class works as intended
 * 
 * author: Corey Caldwell
 * date:   3/27/2016
 * 
 */

import java.util.Calendar;
public class CarTest {

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		
		// creating a car with the first constructor
		Car carOne = new Car("Chevrolet", "Malibu Limited", "Red", 22565, 26000, 2016);
		System.out.println(carOne.toString());
		if (carOne.getCarMake() == "Chevrolet") {
			System.out.println("Car make:  Pass");
		} else {
			System.out.println("Car make:  Fail");
		}
		if (carOne.getCarModel() == "Malibu Limited") {
			System.out.println("Car model: Pass");
		} else {
			System.out.println("Car model: Fail");
		}
		if (carOne.getCarColor() == "Red") {
			System.out.println("Car color: Pass");
		} else {
			System.out.println("Car color: Fail");
		}
		if (carOne.getInitCarPrice() == 22565) {
			System.out.println("Car price: Pass");
		} else {
			System.out.println("Car price: Fail");
		}
		if (carOne.getCarMiles() == 26000) {
			System.out.println("Car miles: Pass");
		} else {
			System.out.println("Car miles: Fail");
		}
		if (carOne.getCarYear() == 2016) {
			System.out.println("Car year:  Pass");
		} else {
			System.out.println("Car year:  Fail");
		}
		// creating a car with the second comstructor
		Car carTwo = new Car("Chevrolet", "Camaro", "Black", 25700);
		System.out.println(carTwo.toString());
		if (carTwo.getCarMake() == "Chevrolet") {
			System.out.println("Car make:  Pass");
		} else {
			System.out.println("Car make:  Fail");
		}
		if (carTwo.getCarModel() == "Camaro") {
			System.out.println("Car model: Pass");
		} else {
			System.out.println("Car model: Fail");
		}
		if (carTwo.getCarColor() == "Black") {
			System.out.println("Car color: Pass");
		} else {
			System.out.println("Car color: Fail");
		}
		if (carTwo.getInitCarPrice() == 25700) {
			System.out.println("Car price: Pass");
		} else {
			System.out.println("Car price: Fail");
		}
		if (carTwo.getCarMiles() == 0) {
			System.out.println("Car miles: Pass");
		} else {
			System.out.println("Car miles: Fail");
		}
		if (carTwo.getCarYear() == now.get(Calendar.YEAR)) {
			System.out.println("Car year:  Pass");
		} else {
			System.out.println("Car year:  Fail");
		}
		// creating a car that in antique
		Car carThree = new Car("Cadillac", "Coupe DeVille", "Mocha Steel Metallic", 26500, 35000, 1961);
		System.out.println(carThree.toString());
		if (carThree.isAntique() == true){
			System.out.println("Is antique: Pass");
		} else {
			System.out.println("Is antique: Fail");
		}
		// creating a car with the same year as the antique deadline
		Car carFour = new Car("Ford", "Mustand", "Blue", 26995, 65000, 1971);
		System.out.println(carFour.toString());
		if (carFour.isAntique() == false){
			System.out.println("Not antique: Pass");
		} else {
			System.out.println("Not antique: Fail");
		}
		// creating a car with the year 2017
		Car carFive = new Car("Chevrolet", "Volt", "Blue", 33220, 0, 2017);
		System.out.println(carFive.toString());

		// checking the getters
		System.out.println("\nCar Five make getter: " + carFive.getCarMake());
		System.out.println("Car Five model getter: " + carFive.getCarModel());
		System.out.println("Car Five color getter: " + carFive.getCarColor());
		System.out.println("Car Five initial price getter: " + carFive.getInitCarPrice());
		System.out.println("Car Five miles getter: " + carFive.getCarMiles());
		System.out.println("Car Five year getter: " + carFive.getCarYear());
		// checking the set color
		System.out.println("\nSetting car color to black.");
		carFive.setCarColor("Black");
		System.out.println("Car Five color getter: " + carFive.getCarColor());
		// checking the add miles
		System.out.println("\nAdding 10000 miles to car five.");
		carFive.addMiles(10000);
		System.out.println("Car Five miles getter: " + carFive.getCarMiles());
		System.out.println("Showing car five's new value: " + carFive.currentValue());
		// checking the add miles for the same car
		System.out.println("\nAdding another 25000 miles to car five.");
		carFive.addMiles(25000);
		System.out.println("Car Five miles getter: " + carFive.getCarMiles());
		System.out.println("Showing car five's new value: " + carFive.currentValue());
		// checking the add miles for a negative number
		System.out.println("\nAdding -10000 miles to car five.");
		carFive.addMiles(-10000);
		System.out.println("Car Five miles getter: " + carFive.getCarMiles());
		System.out.println("Showing car five's new value: " + carFive.currentValue());

	}
}
