/***********************
 *
 *   PiggyBank - class that models a piggy bank 
 *
 *   Author:   Shawn Brenneman/Corey Caldwell
 *   Date:     2016-Mar-24
 *
 ***********************/
 public class PiggyBank
 {
    private String name;
    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;

    public PiggyBank(String _name) {
        name = _name;
        quarters = 0;
        dimes = 0;
        nickels = 0;
        pennies = 0;
    }
    public int getQuarterCnt()
    {
        return quarters;
    }
    public int getDimeCnt()
    {
        return dimes;
    }
    public int getNickelCnt()
    {
        return nickels;
    }
    public int getPennyCnt()
    {
        return pennies;
    }
    public String getName()
    {
        return name;
    }
    public void addQuarter()
    {
        quarters++;
    }
    public void addDime()
    {
        dimes++;
    }
    public void addNickel()
    {
        nickels++;
    }
    public void addPenny()
    {
        pennies++;
    }
    public double contains()
    {
        return quarters*0.25 + dimes*.10 + nickels*.05 + pennies*.01;
    }
    public double empty()
    {
        double amount = this.contains();
        quarters=0;
        dimes=0;
        nickels=0;
        pennies=0;
        return amount;
    }
	
	public double compareTo(PiggyBank otherPiggy){
		double a = this.contains();
		double b = otherPiggy.contains();
		return a-b;
	}
	
	public boolean equals(PiggyBank otherPiggy){
		boolean result = false;
		if(this.quarters == otherPiggy.quarters){
			if(this.dimes == otherPiggy.dimes){
				if(this.nickels == otherPiggy.nickels){
					if(this.pennies == otherPiggy.pennies){
						result = true;
					}
				}
			}
		}
		return result;
	}
	
    public String toString() 
    {
        String result = name + "'s piggy bank" + "\n";
        result += "quarters: " + quarters + "\n";
        result += "dimes: " + dimes + "\n";
        result += "nickels: " + nickels + "\n";
        result += "pennies: " + pennies + "\n";

        return result;
    }
 }
