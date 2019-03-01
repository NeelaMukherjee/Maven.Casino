package io.zipcoder.casino.DiceGame.Yahtzee;

import java.util.function.Function;

public enum YahtzeeAction {

    ROLL(yahtzeeObject -> yahtzeeObject.roll()),
    SAVE(yahtzeeObject -> yahtzeeObject.saveDice()),
    RETURN(yahtzeeObject -> yahtzeeObject.returnDice()),
    SCORECARD(yahtzeeObject -> yahtzeeObject.showScorecard()),
    MARK(yahtzeeObject -> yahtzeeObject.checkForBack()),
    BACK(yahtzeeObject -> yahtzeeObject.back()),
    EXIT(yahtzeeObject -> yahtzeeObject.exit());


    private final Function<Yahtzee, String> function;

    YahtzeeAction(Function<Yahtzee, String> function) {
        this.function = function;
    }


    public String perform(Yahtzee yahtzeeObject) {
        return function.apply(yahtzeeObject);

    }

}
