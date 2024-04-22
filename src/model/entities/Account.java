package model.entities;

import model.exception.ValueError;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	private Double value = 0.0;

	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdraw() {
		return withdrawLimit;
	}

	public void setWithdraw(Double withdraw) {
		this.withdrawLimit = withdraw;
	}

	public void deposit(Double amount) throws ValueError {
		if (amount < 0) {
			throw new ValueError("The amount must be greater than 0");
		}
		this.balance = amount;
	}

	public void withdraw(Double value) throws ValueError {
		this.value = value;

		if (value > withdrawLimit) {
			throw new ValueError("The amount exceeds withdraw limit");
		}
		if (value > balance) {
			throw new ValueError("Not enough balance");
		}

		this.balance -= value;

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Number: " + number + "\n");
		sb.append("Holder: " + holder + "\n");
		sb.append("Previous value: " + String.format("%.2f", (balance + value)) + "\n");
		sb.append("Amount deposited: " + String.format("%.2f", value) + "\n");
		sb.append("New balance: " + String.format("%.2f", balance) + "\n");
		return sb.toString();
	}

}