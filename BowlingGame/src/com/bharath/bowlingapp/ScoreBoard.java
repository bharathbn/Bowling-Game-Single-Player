package com.bharath.bowlingapp;

import com.sap.bowlingapp.Player;

public class ScoreBoard
{
    public void printScores(Player player) {
        System.out.println("\n ******** Final scores! ********\n");
            System.out.println("Total score is: " + player.checkPlayerScore());
            System.out.println("___________________________________________");
            System.out.print("|");
            for (int i = 0; i < 9; i ++){
                if (player.checkFirstBall(i) == 10) {
                    System.out.print("X|");
                }
                else System.out.print(player.checkFirstBall(i) + "|");
                if (player.checkSecondBall(i) == 0) {
                    System.out.print("0|");
                }
                else if ((player.checkFirstBall(i) + player.checkSecondBall(i)) == 10) {
                    System.out.print("/|");
                }
                else {
                    System.out.print(player.checkSecondBall(i) + "|");
                }
            } // print first 9 frames
            
            	  if (player.checkFirstBall(9) == 10) {
                      System.out.print("X|");
                  }
                  else System.out.print(player.checkFirstBall(9) + "|");
                  if (player.checkSecondBall(9) == 10) {
                      System.out.print("X|");
                  }
                  else if ((player.checkFirstBall(9) + player.checkSecondBall(9)) == 10) {
                      System.out.print("/|");
                  }
                  else {
                      System.out.print(player.checkSecondBall(9) + "|");
                  }
                  
                  if ((player.checkFirstBall(9) == 10) | (player.checkFirstBall(9) + player.checkSecondBall(9) == 10)) {
                      if (player.checkFirstBall(9) == 10) {
                          System.out.println("X|");
                      }
                      else {
                          System.out.println(player.checkBonusBall() + "|");
                      }
                  }
                  else {
                      System.out.println(" |");
                  }
	
          
            System.out.println("|___|___|___|___|___|___|___|___|___|_____|");
            System.out.println("\n");
    }
}
