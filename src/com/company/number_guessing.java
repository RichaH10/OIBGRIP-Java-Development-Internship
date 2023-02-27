package com.company;

	import java.util.Random;
	import java.util.Scanner;
	public class number_guessing 
			{
			
				    public int number;
				    public int inputNum;
				    public int noOfGuesses = 0;
			
				    public int getNoOfGuesses() 
						    {
						        return noOfGuesses;
						    }
			
				    public void setNoOfGuesses(int noOfGuesses) 
						    {
						        this.noOfGuesses = noOfGuesses;
						    }
			
				    number_guessing()
						    {
						        Random r = new Random();
						        this.number = r.nextInt(100);
						    }
				    void takeUserInput()
						    {
						        System.out.println("Guess the number");
						        Scanner sc = new Scanner(System.in);
						        inputNum = sc.nextInt();
						    }
				    boolean isCorrectNumber()
						    {
						        noOfGuesses++;
						        if (inputNum==number)
								        {
								            System.out.format("Congratulations!  You guessed it right,\nit was %d and you guessed it in %d attempts", number, noOfGuesses);
								            return true;
								        }
						        else if(inputNum<number)
								        {
								            System.out.println("Too low...");
								        }
						        else if(inputNum>number)
								        {
								            System.out.println("Too high...");
								        }
			         return false;
						    }
			
				
				    public static void main(String[] args) 
						    {
						       
						    	number_guessing g = new number_guessing();
						        boolean a= false;
						        while(!a)
								        {
									        g.takeUserInput();
									        a = g.isCorrectNumber();
								        }
					  }
			}
			
