/***********************
 *
 *   CarBuyerHelper - class that facilitates purchasing a Car using PiggyBanks.
 *
 *   Author:   Shawn Brenneman/Corey Caldwell
 *   Date:     2016-Apr-9
 *
 ***********************/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CarBuyerHelper {

    PiggyBank[] banks;
    Car[] cars;

    public CarBuyerHelper(String banksFilename, String carsFilename) throws FileNotFoundException {
        banks = getPiggyBanks(banksFilename);
        cars = getCars(carsFilename);
    }

    public static PiggyBank[] getPiggyBanks(String filename) throws FileNotFoundException {
        PiggyBank[] banks = new PiggyBank[30];
        int ii = 0;
        Scanner scanFile = new Scanner(new File(filename));
        while (scanFile.hasNext()) {
            Scanner scanLine = new Scanner(scanFile.nextLine());
            scanLine.useDelimiter(",");
            String name = scanLine.next();
            int quarters = scanLine.nextInt();
            int dimes = scanLine.nextInt();
            int nickels = scanLine.nextInt();
            int pennies = scanLine.nextInt();
            banks[ii] = new PiggyBank(name, quarters, dimes, nickels, pennies);
            // System.out.println("" + ii + ": " + banks[ii]); // FOR HELP WITH DEBUGGING
            ii++;
        }
        return banks;
    }

    // =-=-=-=-= YOU get to write these methods. =-=-=-=-=-=

    public static Car[] getCars(String filename) throws FileNotFoundException {
        Car[] cars = new Car[30];
        int i = 0;
        Scanner scanFile = new Scanner(new File(filename));
        while (scanFile.hasNext()) {
            Scanner scanLine = new Scanner(scanFile.nextLine());
            scanLine.useDelimiter(",");
			String make = scanLine.next();
			String model = scanLine.next();
			String color = scanLine.next();
			int year = scanLine.nextInt();
			int purchasePrice = scanLine.nextInt();
			int odometer = scanLine.nextInt();
            cars[i] = new Car(make, model, color, year, purchasePrice, odometer);
            i++;
        }
        return cars;
    }

    public double getTotalInPiggyBanks() {
		double money = 0.0;
		for(int i = 0; i < this.banks.length; i++){
			money = money + this.banks[i].contains();
		}
		return money;
    }

    public int getNumberOfAffordableCars() {
		int numCars = 0;
        for(int i = 0; i < this.cars.length; i++){
			if(this.cars[i].currentValue() < this.getTotalInPiggyBanks()){
				numCars++;
			}
		}
		return numCars;
    }

    public Car[] getAffordableCars() {
		int count = 0;
		Car[] affordCars = new Car[this.getNumberOfAffordableCars()];
        for(int i = 0; i < this.cars.length; i++){
			if(this.cars[i].currentValue() < this.getTotalInPiggyBanks()){
				affordCars[count] = cars[i];
				count++;
			}
		}
		return affordCars;
    }

    public Car getMostExpensiveAffordableCar() {
		Car[] affordCars = this.getAffordableCars();
		Car mostExpensiveCar = affordCars[0];
        for(int i = 0; i < affordCars.length; i++){
			if(affordCars[i].currentValue() > mostExpensiveCar.currentValue()){
				mostExpensiveCar = affordCars[i];
			}
		}
		return mostExpensiveCar;
    }
}
