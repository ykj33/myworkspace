package chap06.exercises.ex19;

public class Account {
	private int balance;
	private final static int MIN_VALUE = 0;
	private final static int MAX_VALUE = 1000000;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		if (balance >= 0 && balance <= 1000000) {
			this.balance = balance;
			if (this.balance <= 0) {
				this.balance = MIN_VALUE;
			} else if (this.balance >= 1000000) {
				this.balance = MAX_VALUE;
			}
		}
	}

}
