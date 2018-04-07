package com.bharath.bowlingapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import com.sap.bowlingapp.Player;

public class BowlingSystem
{
	
	private final int MAX_BOWL = 10;
	
    /*
    * GuideLines Text with welcome
    */
    public void guidelinesMessage(boolean withWelcome) {
    	String welcomeMessage = "Welcome to the Game";
    	String guideLines = "\n Hit Enter button to start the game \n Enter Q any time to exit from the Game\n Once Game started press Enter button to throw the Ball";
        if(withWelcome)
    	System.out.println(welcomeMessage + guideLines);
        else
        	System.out.println(guideLines);
    }
    
    
    /*
    * The system for bowling frames 1-9
    * 
    * Bonus points are calculated using bonusCounter. BonusCounter is incremented by 2 for every strike
    * and 1 for every spare. It is decremented by 1 for each bonus score added. If there are two bonus
    * scores added (e.g. the two previous balls were strikes) then the bonus score is decremented by 2. 
    */
    public void bowlFrame(Player player, int frame) throws IOException {
        int totalScore = 0;
        int bonusCounter = player.checkBonusCounter();
        System.out.print("Press enter to throw ball 1:");
        int score = getScore(totalScore);
        totalScore = totalScore + score;
        player.setFirstBall(frame, score);
        
        // Update player score
        if (bonusCounter == 1 | bonusCounter == 2) {
            player.setPlayerScore(score + score);
            bonusCounter -= 1;
        }
        else if (bonusCounter == 3) {
            player.setPlayerScore(score + score + score);
            bonusCounter -= 2;
        }
        else {
            player.setPlayerScore(score);
        }
        
        if (totalScore == MAX_BOWL){ // Checks for strike 
            player.setSecondball(frame, 0);
            System.out.println("You have bowled a strike!!");
        }
        else {
            System.out.print("Press enter to throw ball 2:"); // Gets score for ball 2 if there was no strike
            score = getScore(totalScore);
            player.setSecondball(frame, score);
            if (bonusCounter == 1) {
                player.setPlayerScore(score + score);
                bonusCounter -= 1;
            }
            else {
                player.setPlayerScore(score);
            }
            totalScore = totalScore + score;
            if (totalScore == MAX_BOWL) { // Checks for spare
                System.out.println("You have bowled a spare!!");
            }
        }
        
        if ((player.checkFirstBall(frame)) == MAX_BOWL) { // Updates bonus counter if the player got a strike
            bonusCounter += 2;
        }
        else if (totalScore == MAX_BOWL) { // Updates bonus counter if the player got a spare
            bonusCounter += 1;
        }
        player.setBonusCounter(bonusCounter);
        System.out.println("Total score is " + player.checkPlayerScore());
    } // end bowlFrame method
    
    /*
    * Special system for scoring the last frame.
    * Includes bonus ball if the player got a strike or spare.
    */
    public void bowlLastFrame(Player player, int frame) throws IOException {
        int totalScore = 0;
        int bonusCounter = player.checkBonusCounter();
        
        // Bowl first ball
        System.out.print("Press enter to throw ball 1:");
        int score = getScore(totalScore);
        totalScore = totalScore + score;
        player.setFirstBall(frame, score);
        
        // Update player score
        if (bonusCounter == 1 | bonusCounter == 2) {
            player.setPlayerScore(score + score);
            bonusCounter -= 1;
        }
        if (bonusCounter == 3) {
            player.setPlayerScore(score + score + score);
            bonusCounter -= 2;
        }
        else {
            player.setPlayerScore(score);
        }

        // Bowl second ball - system for when player bowled a strike on the first ball
        if (totalScore == MAX_BOWL){ 
            System.out.println("You have bowled a strike!!");
            bonusCounter += 2;
            System.out.print("Press enter to throw ball 2:");
            score = getScore();
            player.setSecondball(frame, score);
            if (bonusCounter == 1 | bonusCounter == 2) {
                player.setPlayerScore(score);
                bonusCounter -= 1;
            }
            if (bonusCounter == 3) {
                player.setPlayerScore(score + score);
                bonusCounter -= 2;
            }
        }
        // Bowl second ball - system for when player did not bowl a strike on the first ball
        else {
            System.out.print("Press enter to throw ball 2:");
            score = getScore(totalScore);
            player.setSecondball(frame, score);
            totalScore = totalScore + score;
            if (bonusCounter == 1 | bonusCounter == 2) {
                player.setPlayerScore(score + score);
                bonusCounter -= 1;
            }
            else {
                player.setPlayerScore(score);
            }
        }
        // Bowl bonus bowl if player bowled any strikes or a spare this frame  
        if (totalScore == MAX_BOWL) {
            System.out.println("Strike");
            System.out.println("You have earned a bonus ball! Enter your score for the bonus ball:");
            score = getScore();
            player.setBonusBall(score);
            if (score == MAX_BOWL) {
                System.out.println("Strike!!!");
            }
            player.setPlayerScore(score);
        }
        
        System.out.println("Total score is " + player.checkPlayerScore());

    }
    
    /*
    * Gets the bowling score from the player
    */
    public int getScore(int totalScore) throws IOException{
        int tempScore = 0;
            String temp = new BufferedReader(new InputStreamReader(System.in)).readLine();
            if(temp.equalsIgnoreCase("q"))
            {
            	System.out.println("\n******************** Thank you ********************");
            	System.exit(0);
            }
            tempScore = throwBall(totalScore);
            System.out.println(tempScore);
       return tempScore;
    }
    
    /*
    * Gets the bowling scores for the bonus round
    */
	public int getScore() throws IOException {
		int tempScore = 0;
		String temp = new BufferedReader(new InputStreamReader(System.in)).readLine();
		if (temp.equalsIgnoreCase("q")) {
			System.out.println("\n******************** Thank you ********************");
			System.exit(0);
		}
		tempScore = throwBall(0);
		System.out.println(tempScore);
		return tempScore;
	}
    
    
	/*
	    * Gets random number from 0 to 10 based on pinsdown
	    */
    private int throwBall(int PinsDown)
    {
        int standing = MAX_BOWL-PinsDown;
        Random rand = new Random();
        int  down = rand.nextInt(standing+1); 
        return down;
    }
    
    
    
}
