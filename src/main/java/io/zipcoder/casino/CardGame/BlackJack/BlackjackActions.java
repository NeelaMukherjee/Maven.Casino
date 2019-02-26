package io.zipcoder.casino.CardGame.BlackJack;

import io.zipcoder.casino.CardGame.Cards.Deck;

import java.util.function.BiConsumer;

public enum BlackjackActions {

    HIT(BlackjackPlayer::hit),
    STAND((blackjackPlayer, deck) -> blackjackPlayer.stand()),
    DOUBLEDOWN((blackjackPlayer, deck) -> blackjackPlayer.doubleDown()),
    SPLIT((blackjackPlayer, deck) -> blackjackPlayer.split());
    //WALKAWAY();

    private final BiConsumer<BlackjackPlayer, Deck> consumer;

    BlackjackActions (BiConsumer<BlackjackPlayer, Deck> consumer) {
        this.consumer = consumer;
    }

    public void perform(BlackjackPlayer playerObject, Deck deckObject) {
        consumer.accept(playerObject, deckObject);
    }


}

