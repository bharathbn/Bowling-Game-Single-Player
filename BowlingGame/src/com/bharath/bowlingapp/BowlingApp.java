package com.bharath.bowlingapp;

import java.io.*;

import com.sap.bowlingapp.BowlingSystem;
import com.sap.bowlingapp.Player;
import com.sap.bowlingapp.ScoreBoard;

public class BowlingApp
{
    public static void main(String[] args) throws IOException
    {
        final BowlingSystem bowlingSystem = new BowlingSystem();
        final ScoreBoard scoreboard = new ScoreBoard();
        Player player = new Player();
        boolean bContinue = true;
        bowlingSystem.guidelinesMessage(true);
        
        while(bContinue)
        {
        	String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        	if(input.equalsIgnoreCase(""))
        	{
//              The game begins!
                for (int i=0; i<9; i++) {
                    System.out.println("\n********************You are in Frame " + (i + 1) + "********************");
                        bowlingSystem.bowlFrame(player, i);
                }
//                 The final frame is executed separately because of special scoring requirements.
                System.out.println("\n********************The Final Frame begins now!********************");
                    bowlingSystem.bowlLastFrame(player, 9);
               
                scoreboard.printScores(player);
                bowlingSystem.guidelinesMessage(false);
        	}
        	else
        	{
        		bContinue = false;
        	}
        		
        }
        
        System.out.println("\n******************** Thank you ********************"); 
        
    }

}
