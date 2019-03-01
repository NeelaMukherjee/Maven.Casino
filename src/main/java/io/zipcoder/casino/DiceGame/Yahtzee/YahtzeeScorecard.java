package io.zipcoder.casino.DiceGame.Yahtzee;

import io.zipcoder.casino.DiceGame.DiceUtils.Dice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.TreeMap;

public class YahtzeeScorecard {


    public static TreeMap<String, Integer> setUpScoreCard() {
        TreeMap<String, Integer> scoreCard = new TreeMap<>();
        for(String s : getAllCategories()){
            scoreCard.put(s, null);
        }
        scoreCard.put("upper bonus", null);
        scoreCard.put("total score", null);

        return scoreCard;
    }


    public static String getAcesScoreString() {
        if (Yahtzee.getScoreCard().get("aces") == null) {
            return "   Aces            |\n";
        } else {
            return "   Aces            |    " + Yahtzee.getScoreCard().get("aces") + "\n";
        }
    }


    public static String getTwosScoreString() {
        if (Yahtzee.getScoreCard().get("twos") == null) {
            return "   Twos            |\n";
        } else {
            return "   Twos            |    " + Yahtzee.getScoreCard().get("twos") + "\n";
        }
    }


    public static String getThreesScoreString() {
        if (Yahtzee.getScoreCard().get("threes") == null) {
            return "   Threes          |\n";
        } else {
            return "   Threes          |    " + Yahtzee.getScoreCard().get("threes") + "\n";
        }
    }


    public static String getFoursScoreString() {
        if (Yahtzee.getScoreCard().get("fours") == null) {
            return "   Fours           |\n";
        } else {
            return "   Fours           |    " + Yahtzee.getScoreCard().get("fours") + "\n";
        }
    }


    public static String getFivesScoreString() {
        if (Yahtzee.getScoreCard().get("fives") == null) {
            return "   Fives           |\n";
        } else {
            return "   Fives           |    " + Yahtzee.getScoreCard().get("fives") + "\n";
        }
    }


    public static String getSixesScoreString() {
        if (Yahtzee.getScoreCard().get("sixes") == null) {
            return "   Sixes           |\n";
        } else {
            return "   Sixes           |    " + Yahtzee.getScoreCard().get("sixes") + "\n";
        }
    }


    public static String getThreeOfAKindScoreString() {
        if (Yahtzee.getScoreCard().get("three of a kind") == null) {
            return "   3 of a Kind     |\n";
        } else {
            return "   3 of a Kind     |    " + Yahtzee.getScoreCard().get("three of a kind" +
                    "") + "\n";
        }
    }

    public static String getFourOfAKindScoreString() {
        if (Yahtzee.getScoreCard().get("four of a kind") == null) {
            return "   4 of a Kind     |\n";
        } else {
            return "   4 of a Kind     |    " + Yahtzee.getScoreCard().get("four of a kind") + "\n";
        }
    }


    public static String getFullHouseScoreString() {
        if (Yahtzee.getScoreCard().get("full house") == null) {
            return "   Full House      |\n";
        } else {
            return "   Full House      |    " + Yahtzee.getScoreCard().get("full house") + "\n";
        }
    }


    public static String getSmallStraightScoreString() {
        if (Yahtzee.getScoreCard().get("small straight") == null) {
            return "   Small Straight  |\n";
        } else {
            return "   Small Straight  |    " + Yahtzee.getScoreCard().get("small straight") + "\n";
        }
    }


    public static String getLargeStraightScoreString() {
        if (Yahtzee.getScoreCard().get("large straight") == null) {
            return "   Large Straight  |\n";
        } else {
            return "   Large Straight  |    " + Yahtzee.getScoreCard().get("large straight") + "\n";
        }
    }


    public static String getYahtzeeScoreString() {
        if (Yahtzee.getScoreCard().get("yahtzee") == null) {
            return "   Yahtzee         |\n";
        } else {
            return "   Yahtzee         |    " + Yahtzee.getScoreCard().get("yahtzee") + "\n";
        }
    }


    public static String getChanceScoreString() {
        if (Yahtzee.getScoreCard().get("chance") == null) {
            return "   Chance          |\n";
        } else {
            return "   Chance          |    " + Yahtzee.getScoreCard().get("chance") + "\n";
        }
    }


    public static String getUpperBonusScoreString() {
        if (Yahtzee.getScoreCard().get("upper bonus") == null) {
            return "   Upper Bonus     |\n";
        } else {
            return "   Upper Bonus     |    " + Yahtzee.getScoreCard().get("upper bonus") + "\n";
        }
    }


    public static String getTotalScoreString() {
        if (Yahtzee.getScoreCard().get("total score") == null) {
            return "   Total Score     |\n";
        } else {
            return "   Total Score     |    " + Yahtzee.getScoreCard().get("total score") + "\n";
        }
    }


    public static Collection<String> getUpperSectionCategories(){
        Collection<String> upperSectionCategories = new ArrayList<>();
        upperSectionCategories.add("aces");
        upperSectionCategories.add("twos");
        upperSectionCategories.add("threes");
        upperSectionCategories.add("fours");
        upperSectionCategories.add("fives");
        upperSectionCategories.add("sixes");

        return upperSectionCategories;
    }

    public static Collection<String> getLowerSectionCategories(){
        Collection<String> lowerSectionCategories = new ArrayList<>();
        lowerSectionCategories.add("three of a kind");
        lowerSectionCategories.add("four of a kind");
        lowerSectionCategories.add("full house");
        lowerSectionCategories.add("small straight");
        lowerSectionCategories.add("large straight");
        lowerSectionCategories.add("yahtzee");
        lowerSectionCategories.add("chance");
        return lowerSectionCategories;
    }

    public static Collection<String> getAllCategories() {
        Collection<String> allCategories = new ArrayList<>();
        ((ArrayList<String>) allCategories).addAll(getUpperSectionCategories());
        ((ArrayList<String>) allCategories).addAll(getLowerSectionCategories());

        return allCategories;
    }

    public static boolean upperSectionScoresComplete() {

        for(String s : getUpperSectionCategories()){
            if (Yahtzee.getScoreCard().get(s) == null){
                return false;
            }
        }
        return true;
    }


    public static boolean scorecardComplete() {
        Set<String> scorecardCategories = Yahtzee.getScoreCard().keySet();
        for (String s : scorecardCategories){
            if (Yahtzee.getScoreCard().get(s) == null){
                return false;
            }
        }
        return true;
    }


    public static boolean isValidCategory(String categoryInput) {
        String input = categoryInput.toLowerCase();

        for(String s :getAllCategories()){
            if(input.equals(s)){
                return true;
            }
        }

        return false;
    }



    public static Integer upperSectionBonus() {
        if (getUpperSectionTotal() >= 63) {
            return 35;
        } else {
            return 0;
        }
    }

    public static Integer getUpperSectionTotal() {
        Integer upperTotal = 0;

        for(String s : getUpperSectionCategories()){
            if(Yahtzee.getScoreCard().get(s) != null){
                upperTotal += Yahtzee.getScoreCard().get(s);
            }
        }

        return upperTotal;
    }

    public static int getLowerSectionTotal() {
        int lowerTotal = 0;

        for (String s : getLowerSectionCategories()){
            if (Yahtzee.getScoreCard().get(s) != null){
                lowerTotal += Yahtzee.getScoreCard().get(s);
            }
        }
        return lowerTotal;
    }


    public static int getTotalScore() {
        return getLowerSectionTotal() + getUpperSectionTotal() + upperSectionBonus();
    }



    public static void markScoreCard(String category, ArrayList<Dice> dice) {
        int score = Yahtzee.getScoreForCategory(category, dice);
        Yahtzee.getScoreCard().put(category.toLowerCase(), score);

        if (upperSectionScoresComplete()) {
            Yahtzee.getScoreCard().put("upper bonus", upperSectionBonus());
        }
    }


    public static String getScoreCardString() {
        String scoreCardString = "";
        String spacerString = "|---------------------------------|\n";
        String categoryString = "  Category         |  Score        \n";
        scoreCardString = scoreCardString + spacerString +
                categoryString + spacerString +
                getAcesScoreString() + spacerString +
                getTwosScoreString() + spacerString +
                getThreesScoreString() + spacerString +
                getFoursScoreString() + spacerString +
                getFivesScoreString() + spacerString +
                getSixesScoreString() + spacerString +
                getUpperBonusScoreString() + spacerString +
                getThreeOfAKindScoreString() + spacerString +
                getFourOfAKindScoreString() + spacerString +
                getFullHouseScoreString() + spacerString +
                getSmallStraightScoreString() + spacerString +
                getLargeStraightScoreString() + spacerString +
                getYahtzeeScoreString() + spacerString +
                getChanceScoreString() + spacerString +
                getTotalScoreString() + spacerString;

        return scoreCardString;
    }

}
