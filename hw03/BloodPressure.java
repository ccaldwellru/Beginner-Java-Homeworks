/*
 * BloodPressure.java will take a user's blood pressure and 
 * 
 * @author Corey Caldwell
 * @version 2/14/16
 * 
 */

import java.util.Scanner;

public class BloodPressure {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int systolic;
		int diastolic;
		String bloodPressureCategory = "";
		
		System.out.print("Please enter Systolic: ");
		systolic = scan.nextInt();
		System.out.print("Please enter Diastolic: ");
		diastolic = scan.nextInt();
		scan.close();
		
		if((systolic < 0) || (diastolic < 0)){
			bloodPressureCategory = "ERROR: Negative number";
		}
		else if((systolic < 90) && (diastolic > 80 && diastolic <= 90)){
			bloodPressureCategory = "ERROR: Diastolic is high while Systolic is low.";
		}
		else if((systolic > 120 && systolic < 300) && (diastolic < 60)){
			bloodPressureCategory = "ERROR: Systolic is high while Diastolic is low.";
		}
		else if((systolic >= 300) || (diastolic >= 300)){
			bloodPressureCategory = "ERROR: Not allowed to be 300 or over 300.";
		}
		else if((systolic >= 160 && systolic < 300) || (diastolic >= 100 && diastolic < 300)){
			bloodPressureCategory = "Stage 2 Hypertension";
		}
		else if((systolic >= 140 && systolic < 160) || (diastolic >= 90 && diastolic < 100)){
			bloodPressureCategory = "Stage 1 Hypertension";
		}
		else if((systolic > 120 && systolic < 140) || (diastolic > 80 && diastolic < 90)){
			bloodPressureCategory = "Prehypertension";
		}
		else if((systolic >= 90 && systolic <= 120) || (diastolic >= 60 && diastolic <= 80)){
			bloodPressureCategory = "Normal Blood Pressure";
		}
		else if((systolic < 90) || (diastolic < 60)){
			bloodPressureCategory = "Low";
		}		
		
		System.out.println("Your Blood Pressure readding of " + systolic + "/" + diastolic +": " + bloodPressureCategory);
	}
}
