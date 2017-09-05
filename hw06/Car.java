/*
 * Car.java - holds the constructors and the getter/setter/toString/currentValue/isAntique/addMiles methods so that
 * CarTest.java is able to get the information about a car.
 * 
 * author: Corey Caldwell
 * date:   3/27/2016
 * 
 */
import java.util.Calendar;

public class Car {
	private String carMake;
	private String carModel;
	private String carColor;
	private int carYear;
	private int initCarPrice;
	private int carMiles;
	Calendar now = Calendar.getInstance();

	public Car(String _carMake, String _carModel, String _carColor, int _initCarPrice, int _carMiles, int _carYear) {
		this.carMake = _carMake;
		this.carModel = _carModel;
		this.carColor = _carColor;
		this.initCarPrice = _initCarPrice;
		this.carMiles = _carMiles;
		this.carYear = _carYear;
	}

	public Car(String _carMake, String _carModel, String _carColor, int _initCarPrice) {
		this.carMake = _carMake;
		this.carModel = _carModel;
		this.carColor = _carColor;
		this.initCarPrice = _initCarPrice;
		this.carMiles = 0;
		this.carYear = now.get(Calendar.YEAR);
	}

	public String getCarMake() {
		return carMake;
	}

	public String getCarModel() {
		return carModel;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public int getCarYear() {
		return carYear;
	}

	public int getInitCarPrice() {
		return initCarPrice;
	}

	public int getCarMiles() {
		return carMiles;
	}

	public int addMiles(int miles) {
		if(miles >= 0){
			this.carMiles += miles;
		}
		return this.carMiles;
		
	}

	public Boolean isAntique() {
		Boolean bool = false;
		int carAge = now.get(Calendar.YEAR) - this.carYear;
		if (carAge > 45) {
			bool = true;
		}
		return bool;
	}

	public int currentValue() {
		int carPrice = this.initCarPrice - 1000;
		int yearsOld = now.get(Calendar.YEAR) - this.carYear;
		
		if (this.carYear == now.get(Calendar.YEAR)) {
			if ((this.carMiles) > 12000) {
				carPrice -= 1 * 1550;
			} else if ((this.carMiles) < 10000) {
				carPrice -= 1 * 1300;
			} else {
				carPrice -= 1 * 1400;
			}
			if (carPrice < 0) {
				carPrice = 0;
			}
		} else if (this.carYear < now.get(Calendar.YEAR)) {
			if ((this.carMiles / yearsOld) > 12000) {
				carPrice -= yearsOld * 1550;
			} else if ((this.carMiles / yearsOld) < 10000) {
				carPrice -= yearsOld * 1300;
			} else {
				carPrice -= yearsOld * 1400;
			}

			if (carPrice < 0) {
				carPrice = 0;
			}
		} else {
			if ((this.carMiles) > 12000) {
				carPrice -= 1 * 1550;
			} else if ((this.carMiles) < 10000) {
				carPrice -= 1 * 1300;
			} else {
				carPrice -= 1 * 1400;
			}
			if (carPrice < 0) {
				carPrice = 0;
			}
		}
		return carPrice;
	}

	public String toString() {
		return "\nCar Make: " + this.carMake + "\nCar Model: " + this.carModel + "\nCar Color: " + this.carColor
				+ "\nCar Year: " + this.carYear + "\nInitial Car Price: " + this.initCarPrice + "\nCar Miles: "
				+ this.carMiles + "\nAntique: " + isAntique() + "\nCurrent Value: " + currentValue();
	}

}
