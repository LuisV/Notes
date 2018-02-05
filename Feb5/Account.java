public class Account {
  private String acctName;
  private int acctNumber;
  private int acctType;
  private double acctBalance;

  public void setAccount(String aName, int aNumber, int aType, double aBalance) {
    acctName = aName;
    acctNumber = aNumber;
    acctType = aType;
    acctBalance = aBalance;
  }

  public void setAccount(String aName, int aNumber, double aBalance) {
    acctName = aName;
    acctNumber = aNumber;
    acctType = 1;
    acctBalance = aBalance;
  }

  public String getName(){
    return (acctName);
  }

  public double getBalance() {
    return (acctBalance);
  }

  public void deposit(double fund) {
    if (fund < 0.0)  {
      System.out.println("Error: no negative amount to deposit.");
      System.exit(0);
    }
    acctBalance += fund;
  }

  public boolean withdrawal(double fund) {
    // CST338 exercise
    if(fund>acctBalance)
    {
      System.out.println("Error: Not possible with current funds. Exiting.")
      return false;
    }
    acctBalance -= fund;
    return true;
  }

  public String toString() {
    return String.format("%s's account balance is $%,.2f", acctName, acctBalance);
  }
}
