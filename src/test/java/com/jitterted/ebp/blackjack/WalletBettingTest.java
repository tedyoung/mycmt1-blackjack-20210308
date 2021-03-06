package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WalletBettingTest {

  @Test
  public void walletWith25Bet13BalanceIs12() throws Exception {
    // GIVEN A WALLET with 25
    Wallet wallet = new Wallet();
    wallet.addMoney(25);

    // WHEN bet 13
    wallet.bet(13);

    // THEN balance is 12
    assertThat(wallet.balance())
        .isEqualTo(25 - 13);
  }

  @Test
  public void walletWith44Bet11And12BalanceIs21() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(44);

    wallet.bet(11);
    wallet.bet(12);

    assertThat(wallet.balance())
        .isEqualTo(44 - 11 - 12);
  }

  @Test
  public void walletWith87BetFullAmountIsEmpty() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(87);

    wallet.bet(87);

    assertThat(wallet.isEmpty())
        .isTrue();
  }
  
  @Test
  public void betMoreThanBalanceThrowsException() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(43);

    assertThatThrownBy(() -> {
      wallet.bet(44);
    }).isInstanceOf(IllegalStateException.class);
  }

  @Test
  public void betNegativeAmountThrowsException() throws Exception {
    Wallet wallet = new Wallet();

    assertThatThrownBy(() -> {
      wallet.bet(-1);
    }).isInstanceOf(IllegalArgumentException.class);
  }
}
