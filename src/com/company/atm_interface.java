package com.company;

import java.util.Scanner;

	public class atm_interface
		{

					String name;
					String userName;
					String password;
					String accNo;
					double bal = 10000;
					int transaction = 0 ;
					String tranhistory= "";
		
					// user registration
					 public void register()
						 {
							 	Scanner sc = new Scanner(System.in);
							 	System.out.println("Enter your name : ");
							 	this.name = sc.nextLine();	
							 	System.out.println("Enter username : ");
								this.userName = sc.nextLine();
							 	System.out.println("Enter password : ");
							 	this.password = sc.nextLine();
							 	System.out.println("Enter account number :  ");
							 	this.accNo = sc.nextLine();	 	
							 	System.out.println("\nRegistration completed sucessfully.");
							 	System.out.println("Kindly login to your account \n");				 
						 }
					 
					 // user login
					 
					 public boolean login()
					 {
						 	boolean islogin = false;
						 	Scanner sc = new Scanner(System.in);
						 	while(!islogin)
						 		{
						 				System.out.println("\n Enter username : ");
						 				String username = sc.nextLine();
						 				if (username.equals(userName))
						 					{
						 							while(!islogin)
						 								{
						 										System.out.println("Enter your password : ");
						 										String pw = sc.nextLine();
						 										if (pw.equals(password))
							 										{
						 													System.out.println("Login Successfull!");
						 													islogin = true;
							 										}
						 										else
						 											System.out.println("Incorrect Password. Please try again.");
						 								}
						 					}
						 				else
			 								System.out.println("Username not found");
						 		}
						 	return islogin;
					 }
		
					 
					 // withdrawal of money
					 
					 public void withdraw()
					 {
						 	System.out.println("Enter the amount to be withdrawn : ");
						 	Scanner sc = new Scanner(System.in);
						 	double amount = sc.nextDouble();
						 	try
								 	{
								 			if (bal >= amount)
								 			{
								 					bal = bal - amount;				// OR      			balance  -= amount 
								 					System.out.println("Withdrawal Successfull!");
								 					String str = "\nRs. " + amount + "  withdrawn sucessfully.\n";
								 					tranhistory = tranhistory.concat(str);
								 			}
								 			else
								 				System.out.println("Insufficient Balance");	
								 	}
						 	catch(Exception e)
								 	{
								 			
								 	}
					 }
					 
					 // deposit of money
					 
					 public void deposit()
							 {
								 	System.out.println("Enter amount to deposit : ");
								 	Scanner sc = new Scanner(System.in);
								 	double amount = sc.nextDouble();
								 	try
										 	{
											 		if (amount <= 100000)
													 		{
														 			transaction ++;
														 			bal = bal + amount;
														 			System.out.println("\nDeposit Successfull!");
														 			String str = "\nRs. " + amount + " deposited successfully.\n";
														 			System.out.println("\n");
														 			tranhistory = tranhistory.concat(str);
													 		}
											 		else
											 			System.out.println("Limit is exceeded!");
										 	}
								 	catch(Exception e)
										 	{	
										 	}
							 }
					 
					 
					 // transferring of amount
					 
					 public void transfer()
							 {
								 	Scanner sc = new Scanner(System.in);
								 	System.out.println("Enter reciepent name : ");
								 	String rcp = sc.nextLine();
								 	System.out.println("Enter amount to be transferred : ");
								 	double amount = sc.nextDouble();
								 	
								 	try
										 	{
										 			if(bal >= amount)
												 			{
												 				if(amount <= 50000)
														 				{
														 					transaction++;
														 					bal = bal - amount;
														 					System.out.println("Successfully transferred to " + rcp);
														 					String str = "\nRs. " + amount + " transferred to " + rcp + ".";
														 					tranhistory = tranhistory.concat(str);
														 			    }
												 				else
												 					System.out.println("Sorry! The limit is Rs. 50000.");
												 			}
										 			else
										 				System.out.println("Insufficient Balance");
										 	}
								 	catch (Exception e)
									 	{
									    }
						  }
					 
					 // check balance
					 
					 public void checkBalance()
							 {
								 	System.out.println("Rs. " + bal);
							 }
					 
					 // transaction history
					 
					 public void transhist()
							 {
								 if(transaction == 0)
										 {
											 System.out.println("No transactions found.");
										 }
								else
										{
										     System.out.println(tranhistory);
										}
							 }
					 
		// interface of ATM
					 
					 
		static class Atm
			{
						public static int takeInput(int limit)
							{
									int input = 0;
									boolean flag = false;
									while(!flag)
											{
													try
														{
															Scanner sc = new Scanner(System.in);
															input = sc.nextInt();
															flag = true;
															if (flag && input > limit || input < 1)
																{
																		System.out.println("Select the numbers between 1 to " + limit);
																		flag = false;
																}
														}
													catch (Exception e)
														{
															System.out.println("Enter integer value only");
															flag = false;
														}
											}
									return input;
							}
						
						// main method
						public static void main(String[] args)
							{
									System.out.println("WELCOME TO SBI ATM");
									System.out.println("\n1. Register");
									System.out.println("2. Exit");
									System.out.println("Select your choice : ");
									int select = takeInput(2);
									if (select == 1)
											{
												atm_interface a = new atm_interface();
												a.register();
												while(true)
														{
															System.out.println("1. Login");
															System.out.println("2. Exit");
															System.out.println("Select your choice : ");
															int sl = takeInput(2);
															if (sl == 1)
																{
																	if (a.login())
																		{
																			System.out.println("WELCOME  BACK!  " + a.name +" \n");
																			System.out.println("\n");
																			boolean isComplete = false;
																			while(!isComplete)
																				{
																					System.out.println("\n1. Deposit\n2. Withdraw\n3. Transfer\n4. Transaction History\n5. Check Balance");
																					System.out.println("\nSelect your choice : ");
																					int s = takeInput(6);
																					switch(s)
																						{
																							case 1:
																								a.deposit();
																								break;
																							case 2:
																								a.withdraw();
																								break;
																							case 3:
																								a.transfer();
																								break;
																							case 4:
																								a.transhist();
																								break;
																							case 5:
																								a.checkBalance();
																								break;
																							case 6:
																								isComplete = true;
																								break;
																							default:
																								System.out.println("Wrong choice!");			
																						}
																				}
																		}
																}
															else
																System.exit(0);
														}
											}
								}	
					}
	}



