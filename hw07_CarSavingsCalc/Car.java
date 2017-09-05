/***********************
 *
 *   Car - models a car that depreciates
 *
 *   Author:   Shawn Brenneman/Corey Caldwell
 *   Date:     2016-
 *
 ***********************/
 import java.util.Calendar;
 public class Car
 {
    private String make;
    private String model;
    private String color;
    private int year;
    private int purchasePrice;
    private int odometer;

    public Car (String _make, String _model, String _color, int _year, int _price, int _odo)
    {
        this.make = _make;
        this.model = _model;
        this.color = _color;
        this.year = _year;
        this.purchasePrice = _price;
        this.odometer = _odo;
    }
    public Car (String _make, String _model, String _color, int _price)
    {
        this.make = _make;
        this.model = _model;
        this.color = _color;
        this.purchasePrice = _price;
        this.odometer = 0;
        Calendar now = Calendar.getInstance();
        this.year = now.get(Calendar.YEAR);
    }
    public String getMake()
    {
        return make;
    }
    public String getModel()
    {
        return model;
    }
    public String getColor()
    {
        return color;
    }
    public int getYear()
    {
        return year;
    }
    public int getMiles()
    {
        return odometer;
    }
    public int getPurchasePrice()
    {
        return purchasePrice;
    }
    public void addMiles(int miles)
    {
        if (miles > 0)
            odometer += miles;
    }
    public void setColor(String newColor)
    {
        color = newColor;
    }
    public boolean isAntique()
    {
        boolean result = false;
        Calendar now = Calendar.getInstance();
        if ((now.get(Calendar.YEAR) - year) > 45)
            result = true;
        return result;
    }
    public int currentValue()
    {
        Calendar now = Calendar.getInstance();
        int age = now.get(Calendar.YEAR) - year;
        if (age <= 0)
            age=1;
            
        int currentVal = purchasePrice - 1000;

        int hiMileage = age * 12000;
        int normalMileage = age * 10000;

        if (odometer > hiMileage)
            currentVal -= age * 1550;
        else if (odometer < normalMileage)
            currentVal -= age * 1300;
        else
            currentVal -= age * 1400;

        if (currentVal < 0)
            currentVal = 0;

        return currentVal;
    }
	
	public int compareTo(Car otherCar){
		int a = this.currentValue();
		int b = otherCar.currentValue();
		return a-b;
	}
	
	public boolean equals(Car otherCar){
		boolean result = false;
		if(this.make.equals(otherCar.make)){
			if(this.model.equals(otherCar.model))
				if(this.year == otherCar.year){
					if(this.color.equals(otherCar.color)){
						result = true;
					}
				}
		}
		return result;
	}
	
    public String toString()
    {
        String result = color + " " + year + " " + make + " " + model;
        result += " with " + odometer + " miles";
        return result;
    }



 }
