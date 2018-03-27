import java.util.Calendar;

public class CreditCard {

    private String creditCardNumber;
    private String cardHolderName;
    private String bank;
    private int limit;
    private double balance;
    Calendar cal = Calendar.getInstance();

    public CreditCard(String creditCardNumber, String cardHolderName,
		      String bank, int limit, double balance) {
	this.creditCardNumber = creditCardNumber;
	this.cardHolderName = cardHolderName;
	this.bank = bank;
	this.limit = limit;
	this.balance = balance;
    }

    public String getCreditCardNumber() {return creditCardNumber;}
    public String getCardHolderName() {return cardHolderName;}
    public String getBank() {return bank;}
    public int getLimit() {return limit;}
    public double getBalance() {return balance;}
    
    public boolean chargeIt(double price) {
    		if (price <= limit) {
    			balance -= price;
    			System.out.println("Transaction accepted");
    			return true;
    		}
    		System.out.println("Transaction denied");
    		return false;
    }
    
    public double payment(double amount) {
    		if (cal.get(Calendar.DATE) > 15) {
                System.out.println("Late penalty(3%): " + (balance * 0.03));
    			balance -= balance * 0.03;
    		}
    		balance += amount;
    		return balance;
    }
    
    @Override
    public String toString() {
	return "CreditCard [creditCardNumber=" + creditCardNumber
	    + ", cardHolderName=" + cardHolderName + ", bank=" + bank
	    + ", limit=" + limit + ", balance=" + balance + "]";
    }
	
}
