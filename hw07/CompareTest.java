/***********************
 *
 *   CompareTest - tests .equals and .compareTo methods for Car objects and PiggyBank objects 
 *
 *   Author:   Shawn Brenneman/Corey Caldwell
 *   Date:     2016-Mar 30
 *
 ***********************/
public class CompareTest {

public static void main(String[] args) {

    Car mustang = new Car("Ford", "Mustang", "white", 1964, 60000, 95432);
    Car wagon = new Car("Ford", "Country Squire", "blue/paneled", 30000);
    Car tesla = new Car("Tesla", "Model S", "silver", 2017, 75000, 0);
    Car oldCar = new Car("Toyota", "Corolla", "red", 1987, 9200, 230000);
    Car bug = new Car("Volkswagon", "Beetle", "yellow", 2005, 24200, 26000); 
    Car anotherBug = new Car("Volkswagon", "Beetle", "yellow", 2005, 24500, 120000); 
    Car mini = new Car("MINI", "Cooper", "blue", 2011, 20400, 48000); 
    Car truck = new Car("Ford", "F150", "green", 2010, 22300, 68000);

    System.out.println("\nTesting Car .equals\n");

    System.out.println("tesla.equals(anotherBug) --> " + tesla.equals(anotherBug) + "\t : " + (tesla.equals(anotherBug) ? "-FAIL" : "Pass")) ;
    System.out.println("mustang.equals(wagon) --> " + mustang.equals(wagon) + "\t\t : " + (mustang.equals(wagon) ? "-FAIL" : "Pass")) ;
    System.out.println("mustang.equals(oldCar) --> " + mustang.equals(oldCar) + "\t : " + (mustang.equals(oldCar) ? "-FAIL" : "Pass")) ;
    System.out.println("bug.equals(anotherBug) --> " + bug.equals(anotherBug) + "\t\t : " + (bug.equals(anotherBug) ? "Pass" : "-FAIL")) ;


    System.out.println("\nTesting Car .compareTo\n");

    System.out.println("tesla.compareTo(anotherBug) --> " + tesla.compareTo(anotherBug) + "\t : " + (tesla.compareTo(anotherBug) > 0 ? "Pass" : "-FAIL")) ;
    System.out.println("mustang.compareTo(oldCar) --> " + mustang.compareTo(oldCar) + "\t\t : " + (mustang.compareTo(oldCar) == 0 ? "Pass" : "-FAIL")) ;
    System.out.println("anotherBug.compareTo(bug) --> " + anotherBug.compareTo(bug) + "\t : " + (anotherBug.compareTo(bug) < 0 ? "Pass" : "-FAIL")) ;
    System.out.println("truck.compareTo(mini) --> " + truck.compareTo(mini) + "\t\t : " + (truck.compareTo(mini) == 0 ? "Pass" : "-FAIL")) ;

    System.out.println();

    // these next 4 lines of code are just to show you how to use the addCoins method, written below,
    // to add a bunch of coins to a piggy bank.  you can remove or change them after you understand them.

    PiggyBank dawn = new PiggyBank("Dawn");
	PiggyBank lawn = new PiggyBank("Lawn");
	PiggyBank brawn = new PiggyBank("Brawn");
	PiggyBank fawn = new PiggyBank("Fawn");
	PiggyBank spawn = new PiggyBank("Spawn");
	PiggyBank yawn = new PiggyBank("Yawn");
	

    addCoins(dawn, 231, 430, 322, 598);
	addCoins(lawn, 200, 400, 300, 500);
	addCoins(brawn, 300, 500, 600, 700);
	addCoins(fawn, 0, 300, 200, 100);
	addCoins(spawn, 231, 430, 322, 598);
	addCoins(yawn, 0, 300, 200, 100);
	
	System.out.println("\nTesting PiggyBank .equals\n");

    System.out.println("Dawn.equals(Lawn) --> " + dawn.equals(lawn) + "\t\t : " + (dawn.equals(lawn) ? "-FAIL" : "Pass")) ;
    System.out.println("Lawn.equals(Brawn) --> " + lawn.equals(brawn) + "\t\t : " + (lawn.equals(brawn) ? "-FAIL" : "Pass")) ;
    System.out.println("Lawn.equals(Fawn) --> " + lawn.equals(fawn) + "\t\t : " + (lawn.equals(fawn) ? "-FAIL" : "Pass")) ;
    System.out.println("Dawn.equals(Spawn) --> " + dawn.equals(spawn) + "\t\t : " + (dawn.equals(spawn) ? "Pass" : "-FAIL")) ;


    System.out.println("\nTesting PiggyBank .compareTo\n");

    System.out.println("Dawn.compareTo(Lawn) --> " + dawn.compareTo(lawn) + "\t : " + (dawn.compareTo(lawn) > 0 ? "Pass" : "-FAIL")) ;
    System.out.println("Dawn.compareTo(Spawn) --> " + dawn.compareTo(spawn) + "\t\t\t : " + (dawn.compareTo(spawn) == 0 ? "Pass" : "-FAIL")) ;
    System.out.println("Fawn.compareTo(Brawn) --> " + fawn.compareTo(brawn) + "\t\t : " + (fawn.compareTo(brawn) < 0 ? "Pass" : "-FAIL")) ;
    System.out.println("Fawn.compareTo(Yawn) --> " + fawn.compareTo(yawn) + "\t\t\t : " + (fawn.compareTo(yawn) == 0 ? "Pass" : "-FAIL")) ;

	System.out.println();
}

//--------------------------------------------
//
//  method to make it easy to add a bunch of coins to a PiggyBank.
//
//--------------------------------------------
public static void addCoins(PiggyBank bank, int qs, int ds, int ns, int ps)
{
    for (int i=0; i<qs; i++)
        bank.addQuarter();
    for (int i=0; i<ds; i++)
        bank.addDime();
    for (int i=0; i<ns; i++)
        bank.addNickel();
    for (int i=0; i<ps; i++)
        bank.addPenny();
}
}
