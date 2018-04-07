package com.sap.bowlingapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> firstBall = new ArrayList<Integer>();
    private List<Integer> secondBall = new ArrayList<Integer>();
    private int bonusBall;
    private int playerScore;
    private int bonusCounter;
    
    
    // Sets the first ball of a frame
    public void setFirstBall(int frame, int score) throws IOException{
        firstBall.add(score);
    }
    
    // Gets the first ball of a frame
    public int checkFirstBall(int frame) {
        return firstBall.get(frame);
    }
    
    // Sets the second ball of a frame
    public void setSecondball(int frame, int score) throws IOException{
        secondBall.add(score);
    }
    
    // Gets the second ball of a frame
    public int checkSecondBall(int frame) {
        return secondBall.get(frame);
    }
    
    // Sets the bonus balls for the last frame
    public void setBonusBall(int score) {
        bonusBall = score;
    }
    
    // Gets the bonus ball of the last frame
    public int checkBonusBall() {
        return bonusBall;
    }
    
    // Updates the player's total score
    public void setPlayerScore(int score) {
        playerScore = playerScore + score;
    }
    
    // Gets a player's total score
    public int checkPlayerScore() {
        return playerScore;
    }

    // Sets a player's bonus counter
    public void setBonusCounter(int counter) {
        bonusCounter = counter;
    }
    
    // Gets a player's bonus counter
    public int checkBonusCounter() {
        return bonusCounter;
    }
}