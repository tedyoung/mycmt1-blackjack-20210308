package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameBetPayoffTest {

  @Test
  public void playerStartsWithZeroBalance() throws Exception {
    Game game = new Game();

    assertThat(game.playerBalance())
        .isZero();
  }

  @Test
  public void playerDeposits25BalanceIs25() throws Exception {
    Game game = new Game();

    game.playerDeposits(25);

    assertThat(game.playerBalance())
        .isEqualTo(25);
  }

  @Test
  public void playerWith100BalanceBets75BalanceIs25() throws Exception {
    Game game = new Game();
    game.playerDeposits(100);

    game.playerBets(75);

    assertThat(game.playerBalance())
        .isEqualTo(100 - 75);
  }

  @Test
  public void playerWith100BalanceBets50AndWinsBalanceIs150() throws Exception {
    Game game = new Game();
    game.playerDeposits(100);
    game.playerBets(50);

    game.playerWins();

    assertThat(game.playerBalance())
        .isEqualTo(100 - 50 + (50 * 2));
  }

  @Test
  public void playerWith80Bets20AndLosesBalanceIs60() throws Exception {
    Game game = new Game();
    game.playerDeposits(80);
    game.playerBets(20);

    game.playerLoses();

    assertThat(game.playerBalance())
        .isEqualTo(80 - 20);
  }

  @Test
  public void playerWith75Bets40AndPushesBalanceIs75() throws Exception {
    Game game = new Game();
    game.playerDeposits(75);
    game.playerBets(40);

    game.playerPushes();

    assertThat(game.playerBalance())
        .isEqualTo(75 - 40 + 40);
  }

  @Test
  public void playerWith400Bets400WinBlackjackBalanceIs1_000() throws Exception {
    Game game = new Game();
    game.playerDeposits(400);
    game.playerBets(400);

    game.playerWinsBlackjack();

    assertThat(game.playerBalance())
        .isEqualTo(400 - 400 + ((int) (400 * 2.5)));
  }


}