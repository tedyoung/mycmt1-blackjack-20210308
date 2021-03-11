package com.jitterted.ebp.blackjack;

public class Wallet {
  private int balance = 0;

  public Wallet() {
  }

  public boolean isEmpty() {
    return balance == 0;
  }

  public void addMoney(int amount) {
    ensureAmountIsGreaterThanZero(amount);
    balance += amount;
  }

  public int balance() {
    return balance;
  }

  public void bet(int betAmount) {
    ensureBetZeroOrMore(betAmount);
    ensureSufficientBalanceForBet(betAmount);
    balance -= betAmount;
  }

  private void ensureBetZeroOrMore(int betAmount) {
    if (betAmount < 0) {
      throw new IllegalArgumentException();
    }
  }

  private void ensureAmountIsGreaterThanZero(int amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException();
    }
  }

  private void ensureSufficientBalanceForBet(int betAmount) {
    if (balance < betAmount) {
      throw new IllegalStateException();
    }
  }
}
