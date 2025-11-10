public class SavingsAccount extends BankAccount {

	private double rate = 0.025; // 2.5%
	private int savingsNumber = 0;
	private String accountNumber;

	public SavingsAccount(String name, double amount) {
		super(name, amount);
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}

	public SavingsAccount(SavingsAccount original, double amount) {
		super(original, amount);
		savingsNumber = original.savingsNumber + 1;
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}

	public void postInterest() {
		double monthlyRate = rate / 12;
		double interest = getBalance() * monthlyRate;
		deposit(interest);
	}

	@Override
	public String getAccountNumber() {
		return accountNumber;
	}
}
