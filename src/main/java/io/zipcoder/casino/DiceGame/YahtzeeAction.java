package io.zipcoder.casino.DiceGame;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public enum YahtzeeAction {

    ROLL(yahtzeeObject -> yahtzeeObject.roll()),
    SAVE(yahtzeeObject -> yahtzeeObject.saveDice()),
    RETURN(yahtzeeObject -> yahtzeeObject.returnDice()),
    SCORECARD(yahtzeeObject -> yahtzeeObject.showScorecard()),
    MARK(yahtzeeObject -> yahtzeeObject.checkForBack()),
    EXIT(yahtzeeObject -> yahtzeeObject.walkAway());


    private final Consumer<Yahtzee> consumer;

    YahtzeeAction(Consumer<Yahtzee> consumer) {
        this.consumer = consumer;
    }


    public void perform(Yahtzee yahtzeeObject) {
        consumer.accept(yahtzeeObject);
    }

}
