package io.zipcoder.casino.Utilities;

public class Player {
    private String name;
    private double wallet;

    public Player(String name, double wallet){
        this.name = name;
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }

    public double getWallet(){
        return wallet;
    }
}
