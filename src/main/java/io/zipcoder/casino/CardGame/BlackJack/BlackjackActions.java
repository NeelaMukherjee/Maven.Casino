package io.zipcoder.casino.CardGame.BlackJack;

import io.zipcoder.casino.CardGame.Cards.Deck;

import java.util.function.BiConsumer;

public enum BlackjackActions {

    HIT(BlackjackPlayer::hit, 1),
    STAND((blackjackPlayer, deck) -> blackjackPlayer.stand(),2),
    DOUBLE_DOWN((blackjackPlayer, deck) -> blackjackPlayer.doubleDown(),3),
    SPLIT((blackjackPlayer, deck) -> blackjackPlayer.split(),4);

    private final BiConsumer<BlackjackPlayer, Deck> consumer;
    private int menuOption;

    BlackjackActions (BiConsumer<BlackjackPlayer, Deck> consumer, int menuOption) {
        this.consumer = consumer;
        this.menuOption = menuOption;
    }

    public void perform(BlackjackPlayer playerObject, Deck deckObject) {
        consumer.accept(playerObject, deckObject);
    }

    public int getMenuOption(){
        return this.menuOption;
    }
}

