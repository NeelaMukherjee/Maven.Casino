package io.zipcoder.casino.DiceGame.Yahtzee;

import io.zipcoder.casino.DiceGame.DiceUtils.Dice;

import java.util.ArrayList;
import java.util.function.BiFunction;

public enum YahtzeeCategory {

    ACES(1, (allDice, value) -> Yahtzee.scoreUpperSection(allDice, value)),
    TWOS(2, (allDice, value) -> Yahtzee.scoreUpperSection(allDice, value)),
    THREES(3,(allDice, value) -> Yahtzee.scoreUpperSection(allDice, value)),
    FOURS(4, (allDice, value) -> Yahtzee.scoreUpperSection(allDice, value)),
    FIVES(5, (allDice, value) -> Yahtzee.scoreUpperSection(allDice, value)),
    SIXES(6,(allDice, value) -> Yahtzee.scoreUpperSection(allDice, value)),
    THREEOFAKIND(0, (allDice, value) -> Yahtzee.scoreThreeOfAKind(allDice)),
    FOUROFAKIND(0, (allDice, value) -> Yahtzee.scoreFourOfAKind(allDice)),
    FULLHOUSE(0, (allDice, value) -> Yahtzee.scoreFullHouse(allDice)),
    SMALLSTRAIGHT(0, (allDice, value) -> Yahtzee.scoreSmallStraight(allDice)),
    LARGESTRAIGHT(0, (allDice, value) -> Yahtzee.scoreLargeStraight(allDice)),
    YAHTZEE(0, (allDice, value) -> Yahtzee.scoreYahtzee(allDice)),
    CHANCE(0, (allDice, value) -> Yahtzee.scoreChance(allDice));



    private final BiFunction<ArrayList<Dice>, Integer, Integer> bifunction;
    private final int value;


    YahtzeeCategory(Integer value, BiFunction<ArrayList<Dice>, Integer, Integer> bifunction) {
        this.value = value;
        this.bifunction = bifunction;
    }


    public Integer perform(ArrayList<Dice> allDice, Integer value) {
      return bifunction.apply(allDice, value);
    }

    public int getValue(){
        return this.value;
    }

}
