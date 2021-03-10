package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HandValueTest {

  @Test
  public void withTwoCardsValueIsSumOfTheirRanks() throws Exception {
    Hand hand = new Hand(List.of(new Card(Suit.CLUBS, "10"),
                                 new Card(Suit.CLUBS, "7"),
                                 new Card(Suit.CLUBS, "2")));
    assertThat(hand.value())
        .isEqualTo(10 + 7 + 2);
  }
}
