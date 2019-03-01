package io.zipcoder.casino.DiceGame.Yahtzee;

import io.zipcoder.casino.DiceGame.DiceUtils.Dice;

import java.util.*;

public class Scorecard {

    private Map<String, Integer> scorecard;

    public Scorecard(){
        scorecard = setUpScoreCard();
    }


    public TreeMap<String, Integer> setUpScoreCard() {
        TreeMap<String, Integer> scorecard = new TreeMap<>();
        for(String s : getAllCategories()){
            scorecard.put(s, null);
        }
        scorecard.put("upper bonus", null);
        scorecard.put("total score", null);

        return scorecard;
    }


    public Collection<String> getAllCategories() {
        Collection<String> allCategories = new ArrayList<>();
        ((ArrayList<String>) allCategories).addAll(getUpperSectionCategories());
        ((ArrayList<String>) allCategories).addAll(getLowerSectionCategories());

        return allCategories;
    }


    public String getAcesScoreString() {
        if (scorecard.get("aces") == null) {
            return "   Aces            |\n";
        } else {
            return "   Aces            |    " + scorecard.get("aces") + "\n";
        }
    }


    public String getTwosScoreString() {
        if (scorecard.get("twos") == null) {
            return "   Twos            |\n";
        } else {
            return "   Twos            |    " + scorecard.get("twos") + "\n";
        }
    }


    public String getThreesScoreString() {
        if (scorecard.get("threes") == null) {
            return "   Threes          |\n";
        } else {
            return "   Threes          |    " + scorecard.get("threes") + "\n";
        }
    }


    public String getFoursScoreString() {
        if (scorecard.get("fours") == null) {
            return "   Fours           |\n";
        } else {
            return "   Fours           |    " + scorecard.get("fours") + "\n";
        }
    }


    public String getFivesScoreString() {
        if (scorecard.get("fives") == null) {
            return "   Fives           |\n";
        } else {
            return "   Fives           |    " + scorecard.get("fives") + "\n";
        }
    }


    public String getSixesScoreString() {
        if (scorecard.get("sixes") == null) {
            return "   Sixes           |\n";
        } else {
            return "   Sixes           |    " + scorecard.get("sixes") + "\n";
        }
    }


    public String getThreeOfAKindScoreString() {
        if (scorecard.get("three of a kind") == null) {
            return "   3 of a Kind     |\n";
        } else {
            return "   3 of a Kind     |    " + scorecard.get("three of a kind" +
                    "") + "\n";
        }
    }

    public  String getFourOfAKindScoreString() {
        if (scorecard.get("four of a kind") == null) {
            return "   4 of a Kind     |\n";
        } else {
            return "   4 of a Kind     |    " + scorecard.get("four of a kind") + "\n";
        }
    }


    public String getFullHouseScoreString() {
        if (scorecard.get("full house") == null) {
            return "   Full House      |\n";
        } else {
            return "   Full House      |    " + scorecard.get("full house") + "\n";
        }
    }


    public String getSmallStraightScoreString() {
        if (scorecard.get("small straight") == null) {
            return "   Small Straight  |\n";
        } else {
            return "   Small Straight  |    " + scorecard.get("small straight") + "\n";
        }
    }


    public String getLargeStraightScoreString() {
        if (scorecard.get("large straight") == null) {
            return "   Large Straight  |\n";
        } else {
            return "   Large Straight  |    " + scorecard.get("large straight") + "\n";
        }
    }


    public String getYahtzeeScoreString() {
        if (scorecard.get("yahtzee") == null) {
            return "   Yahtzee         |\n";
        } else {
            return "   Yahtzee         |    " + scorecard.get("yahtzee") + "\n";
        }
    }


    public String getChanceScoreString() {
        if (scorecard.get("chance") == null) {
            return "   Chance          |\n";
        } else {
            return "   Chance          |    " + scorecard.get("chance") + "\n";
        }
    }


    public String getUpperBonusScoreString() {
        if (scorecard.get("upper bonus") == null) {
            return "   Upper Bonus     |\n";
        } else {
            return "   Upper Bonus     |    " + scorecard.get("upper bonus") + "\n";
        }
    }


    public String getTotalScoreString() {
        if (scorecard.get("total score") == null) {
            return "   Total Score     |\n";
        } else {
            return "   Total Score     |    " + scorecard.get("total score") + "\n";
        }
    }


    public  Collection<String> getUpperSectionCategories(){
        Collection<String> upperSectionCategories = new ArrayList<>();
        upperSectionCategories.add("aces");
        upperSectionCategories.add("twos");
        upperSectionCategories.add("threes");
        upperSectionCategories.add("fours");
        upperSectionCategories.add("fives");
        upperSectionCategories.add("sixes");

        return upperSectionCategories;
    }

    public Collection<String> getLowerSectionCategories(){
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



    public boolean upperSectionScoresComplete() {

        for(String s : getUpperSectionCategories()){
            if (scorecard.get(s) == null){
                return false;
            }
        }
        return true;
    }


    public  boolean scorecardComplete() {
        Set<String> scorecardCategories = scorecard.keySet();
        for (String s : scorecardCategories){
            if (scorecard.get(s) == null){
                return false;
            }
        }
        return true;
    }


    public boolean isValidCategory(String categoryInput) {
        String input = categoryInput.toLowerCase();

        for(String s :getAllCategories()){
            if(input.equals(s)){
                return true;
            }
        }

        return false;
    }



    public Integer upperSectionBonus() {
        if (getUpperSectionTotal() >= 63) {
            return 35;
        } else {
            return 0;
        }
    }

    public Integer getUpperSectionTotal() {
        Integer upperTotal = 0;

        for(String s : getUpperSectionCategories()){
            if(scorecard.get(s) != null){
                upperTotal += scorecard.get(s);
            }
        }

        return upperTotal;
    }

    public int getLowerSectionTotal() {
        int lowerTotal = 0;

        for (String s : getLowerSectionCategories()){
            if (scorecard.get(s) != null){
                lowerTotal += scorecard.get(s);
            }
        }
        return lowerTotal;
    }


    public int getTotalScore() {
        return getLowerSectionTotal() + getUpperSectionTotal() + upperSectionBonus();
    }



    public void markScoreCard(String category, List<Dice> dice) {
        int score = Yahtzee.getScoreForCategory(category, dice);
        scorecard.put(category.toLowerCase(), score);

        if (upperSectionScoresComplete()) {
            scorecard.put("upper bonus", upperSectionBonus());
        }
    }


    public String getScoreCardString() {
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

    public Map<String, Integer> getScorecard() {
        return scorecard;
    }
}
