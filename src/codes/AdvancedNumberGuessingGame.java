package codes;

import java.util.Scanner;

public class AdvancedNumberGuessingGame {

//********************************************* METHODS ******************************************************
	
// Random Number Generator
	public static int RNG(int min, int max)
	{
		int number = (int)(Math.random()*(max-min+1) +min);
		
		return number;
	}
	
// Error Trap w/o a range
	public static int errortrap()
	{
		Scanner input = new Scanner(System.in);
		int response = 0, check = 1;
		
		do
		{
			check = 1;
			
			try
			{
				response = input.nextInt();
			}
			catch (Exception e)
			{
				input.next();
				check = 0;
				
				System.out.println("Invalid input. Please try again");
			}
			
		} while (check == 0);
		
		return response;
	}
	
// Error Trap w/i a range
	public static int errortraprange(int min, int max)
	{
		Scanner input = new Scanner(System.in);
		int response = 0, check;
		
		do
		{
			check = 1;
			
			try
			{
				response = input.nextInt();
			}
			catch (Exception e)
			{
				input.next();
				
				check = 0;
			}
			
			if (response < min || response > max || check == 0)
			{
				System.out.println("Invalid input. Please try again");
			}
			
		} while (response < min || response > max);
		
		return response;
	}
	
// Hot, Warm, Cold response
	public static void hotcold(int guess, int answer)
	{
		int percent;
		
		percent = (guess * 100 / answer);
		
		if (percent > 80 && percent < 120)	// Hot: w/i 20%
		{
			System.out.println("You are hot");
		}
		else if (percent > 65 && percent < 135)	// Warm: w/i 35%
		{
			System.out.println("You are warm");
		}
		else	// Cold: else
		{
			System.out.println("You are cold");
		}
		
	}
	
// Checking for a Correct Response
	public static int answer(int answer, int min, int max)
	{
		Scanner input = new Scanner(System.in);
		int guess, tries = 3, result = 0;
		
		do
		{
			System.out.println("You have " + tries + " tries remaining");
			
			guess = errortraprange(min,max);
			
			if (guess == answer) // Guessed correctly
			{
				System.out.println("You have guessed correctly!");
				
				result = 1;
			}
			else // Guessed incorrectly
			{
				System.out.println("You have guessed incorrectly");
				
				tries--;
				
				hotcold(guess, answer);
				
				if (tries > 0)
				{
					System.out.println("Please try again");
				}
			}
			
			
		} while (result == 0 && tries > 0);
			
		return guess;
	}
	
	
//********************************************** MAIN ********************************************************
	
	public static void main(String[] args) {
		
		int response = -1, max=1, min=0, answer = 0, guess = 0;
		
		System.out.println("Welcome to the Advanced Random Number Guessing Game");
		
		do
		{	// Start: repeat the game
			do
			{ // Start: Choose difficulty
	
				System.out.println("Choose your difficulty:");
						System.out.println("	1. Easy		(1-10)"); 
						System.out.println("	2. Medium	(1-30)");
						System.out.println("	3. Hard		(1-50)");
						System.out.println("	4. Custom");
					response = errortraprange(1,4);
				
			} while (response < 1 || response > 4); // End: Choose difficulty
			
			if(response == 1) // Difficulty = easy
			{
				System.out.println("You have chosen Easy difficulty");
				
				min = 1;
				max = 10;
			}
			if(response == 2) // Difficulty = medium
			{
				System.out.println("You have chosen Medium difficulty");
				
				min = 1;
				max = 30;
			}
			if(response == 3) // Difficulty = hard
			{
				System.out.println("You have chosen Hard difficulty");
				
				min = 1;
				max = 50;
			}
			if(response == 4) // Difficulty = custom
			{	// Start: Custom diffifulty
				System.out.println("You have chosen Custom difficulty");
				do
				{	// Start: Choose max & min
					//Choose min
					System.out.println("Choose a minimum:");
						min = errortrap();
					
					// Choose max
					System.out.println("Choose a maximum:");
						max = errortrap();
						
					if (min > max)
					{
						System.out.println("Invalid range. Please try again");
					}
					
				} while(min > max);	// End: Choose max & min
				
			}	// End: Custom difficulty
			
			
			// Generate a number
			answer = RNG(min,max);
			
			// Guess the number
				System.out.println("Guess the number");
					guess = answer(answer, min, max);
					
			// Reveal the number
			System.out.println("The number is: " + answer);
			
			if (guess == answer)
			{
				System.out.println("You have won the game!");
			}
			else
			{
				System.out.println("You have lost the game");
			}
			
			System.out.println("Would you like to play again? (0=no, 1=yes)");
			response = errortraprange(0,1);
			
		} while (response == 1);	// End: repeat the game
		
		System.out.println("Thank you for playing");

	} // End: main

}