/**
 * CarCost.java - asks the user for Euro information about car costs
 * and computes it to the equal American cost.
 *
 * @author Corey Caldwell
 * @version 2/7/2016
 */
import java.util.Scanner;

public class CarCost {

	public static void main(String[] args) {
		//Creating the scanner object
		Scanner scan = new Scanner(System.in);
		//Creating the constant variables to compute American values
		final double LITER_TO_GALLON = 0.264172;
		final double PRICE_PER_OUNCE = 33.8;
		final double PRICE_PER_GALLON = 128;
		final double KILOMETERS_TO_MILES = 0.621371;
		//Creating variables to hold the users input
		double conversionRate;
		double pricePerLiter;
		double litersPurchased;
		double kilometersDriven;
		//Creating variables to hold the computed input
		double pricePerGallon;
		double milesDriven;
		double gallonsOfGas;
		double milesPerGallon;
		//Print statements to get information from the user and put
		//that information in the corresponding variables
		System.out.print("What is the current exchange rate of Euro to Dollar?: ");
		conversionRate = scan.nextDouble();
		System.out.print("Enter the price of gas per liter (in Euros): ");
		pricePerLiter = scan.nextDouble();
		System.out.print("How many liters did you buy for this tank of gas?: ");
		litersPurchased = scan.nextDouble();
		System.out.print("How many kilometers did you drive on this tank of gas?: ");
		kilometersDriven = scan.nextDouble();
		//Closing the scanner to use less resources
		scan.close();
		//Computing all of the American values
		pricePerGallon = pricePerLiter / PRICE_PER_OUNCE * PRICE_PER_GALLON * conversionRate;
		milesDriven = kilometersDriven * KILOMETERS_TO_MILES;
		gallonsOfGas = litersPurchased * LITER_TO_GALLON;
		milesPerGallon = milesDriven / gallonsOfGas;
		//Printing out all of the American values
		System.out.println("\nCost report for driving your European car:\nPrice of gas is $" + String.format("%.2f", pricePerGallon) + " per gallon." +
							"\n\nYou drove " + String.format("%.1f", milesDriven) + " miles\non "+ String.format("%.1f", gallonsOfGas) + " gallons of gas." +
							"\n\nYou got " + String.format("%.1f", milesPerGallon) + " miles per gallon.");
	}

}
