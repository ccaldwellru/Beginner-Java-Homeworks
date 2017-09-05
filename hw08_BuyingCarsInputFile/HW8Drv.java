/***********************
 *
 *   HW8Drv - class that drives the purchase of a Car using PiggyBanks.
 *
 *   Author:   Shawn Brenneman
 *   Date:     2016-Apr-9
 *
 ***********************/
import java.io.FileNotFoundException;

public class HW8Drv {
    public static void main(String[] args) throws FileNotFoundException {

        String bankFilename = "mybanks.csv";
        String carFilename = "mycars.csv";

        CarBuyerHelper helper = new CarBuyerHelper(bankFilename, carFilename);

        System.out.println("I have a total of $" + helper.getTotalInPiggyBanks()
            + ", and can afford " + helper.getNumberOfAffordableCars() + " cars.\n");

        System.out.println("--------------- Cars I can afford ---------------");
        Car[] affordableCars = helper.getAffordableCars();
        for (int ii = 0; ii < affordableCars.length; ii++) {
            System.out.println(affordableCars[ii]);
        }

        System.out.println("\n------ The most expensive Car I can afford ------\n" + helper.getMostExpensiveAffordableCar());
    }
}
