/***********************
 *
 *   PiggyBank - class that models a piggy bank 
 *
 *   Author:   Shawn Brenneman
 *   Date:     2016-Apr-9
 *
 ***********************/
 public class PiggyBank {
    private String name;
    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;

    public PiggyBank(String _name) {
        this(_name, 0, 0, 0, 0);
    }

    public PiggyBank(String _name, int initQuarters, int initDimes, int initNickels, int initPennies) {
        name = _name;
        quarters = initQuarters;
        dimes = initDimes;
        nickels = initNickels;
        pennies = initPennies;
    }

    public int getQuarterCnt() {
        return quarters;
    }
    public int getDimeCnt() {
        return dimes;
    }
    public int getNickelCnt() {
        return nickels;
    }
    public int getPennyCnt() {
        return pennies;
    }

    public String getName() {
        return name;
    }

    public void addQuarter() {
        quarters++;
    }
    public void addQuarters(int count) {
        quarters += count;
    }

    public void addDime() {
        dimes++;
    }
    public void addDimes(int count) {
        dimes += count;
    }

    public void addNickel() {
        nickels++;
    }
    public void addNickels(int count) {
        nickels += count;
    }

    public void addPenny() {
        pennies++;
    }
    public void addPennies(int count) {
        pennies += count;
    }

    public double contains() {
        int total = quarters * 25 + dimes * 10 + nickels * 5 + pennies * 1;
        return (double)total/100.0;
    }

    public double empty() {
        double amount = this.contains();
        quarters=0;
        dimes=0;
        nickels=0;
        pennies=0;
        return amount;
    }

    public boolean equals(PiggyBank other) {
        return ( (int) (this.contains()*100 + .5) == (int) (other.contains()*100 + .5) );
    }
    public int compareTo(PiggyBank other) {
        return ( (int) (this.contains()*100 + .5) - (int) (other.contains()*100 + .5) );
    }
    public String toString() {
        String result = "Piggy Bank: " + name + " Quarters: " + quarters + " Dimes: " + dimes
            + " Nickels: " + nickels + " Pennies: " + pennies + " Total: $" + contains();
        return result;
    }
 }
