package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class HandTest {

  private static final Suit DUMMY_SUIT = Suit.SPADES;

  @Test
  public void handWithValueOf22IsBusted() throws Exception {
    List<Card> cards = List.of(new Card(DUMMY_SUIT, "10"),
                               new Card(DUMMY_SUIT, "Q"),
                               new Card(DUMMY_SUIT, "2"));
    Hand hand = new Hand(cards);

    assertThat(hand.isBusted())
        .isTrue();
  }

}