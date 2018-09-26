import java.util.Scanner;
import java.io.*;
public class CreditCardValidator
	{
		static boolean stillRunningCode = true;
		static boolean stillAsking = true;
		static boolean stillPlaying = true;	
		static int codeSelection;
		static String cardNumberString = "";
		static long cardNumber = 0;
		static Scanner userIntput = new Scanner(System.in);
		static Scanner userStringput = new Scanner(System.in);
		static boolean lessThan16NumbersEntered = true;
		static long [] cardNumberArray = new long [16];
		static long [] generatedCreditCards = new long[100];
		static int generatedCardIndex = 0;
		static long doubledDigit = 0;
		static long doubledDigit1 = 0;
		static long sumOfAllDigits = 0;
		public static void main(String[] args) throws IOException
			{
				while (stillRunningCode)
					{
						askWhichCodeToRun();
						runSelectedCode();
						askToChangeCodes();
					}
				
			}
		public static void askWhichCodeToRun()
			{
				System.out.println("Would you like to run (1) Credit Card Validator or (2) Credit Card Generator?");
				codeSelection = userIntput.nextInt();
			}
		public static void runSelectedCode() throws IOException
			{
				stillAsking = true;
				while (stillAsking)
					{
						if (codeSelection == 1)
							{
								creditCardValidator();
								stillAsking = false;
							}
						else if (codeSelection == 2)
							{
								creditCardNumberGenerator();
								stillAsking = false;
							}
						else
							{
								System.out.println("Please choose (1) Credit Card Validator or (2) Credit Card Generator.");
								codeSelection = userIntput.nextInt();
							}
					}
			}
		public static void askToChangeCodes()
			{
				stillAsking = true;
				while (stillAsking)
					{
						System.out.println("Would you like to run another code?");
						System.out.println("(1) Yes or (2) No");
						int runAnotherCode = userIntput.nextInt();
						if (runAnotherCode == 1)
							{
								stillAsking = false;
							}
						else if (runAnotherCode == 2)
							{
								System.out.println("Thank you for running CreditCardValidator.");
								stillRunningCode = false;
								stillAsking = false;
							}
						else
							{
								stillAsking = true;
							}
					}
				
			}
		public static void creditCardValidator() throws IOException
			{
				boolean stillValidating = true;
				askToTakeInputOrReadFile();
				while (stillValidating)
					{
						
					}
			}
		public static void creditCardNumberGenerator()
			{
				while (generatedCardIndex <100)
					{
						generateNumber();
						doubleAlternatingDigits();
						addAllDigits();
						ifValidAddToGeneratedCreditCards();
					}
				for (int i = 0; i < 100; i++)
					{
						System.out.println(generatedCreditCards[i]);
					}
			}
		public static void askToTakeInputOrReadFile() throws IOException
			{
				boolean stillAskingToTakeInputOrReadFile = true;
				System.out.println("Would you like to (1) input a number or (2) read from an existing file?");
				while (stillAskingToTakeInputOrReadFile)
					{
						int inputNumberOrReadFile = userIntput.nextInt();
						if (inputNumberOrReadFile == 1)
							{
								takeCreditCardNumber();
								doubleAlternatingDigits();
								addAllDigits();
								checkIfDivisableByTen();
							}
						else if (inputNumberOrReadFile == 2)
							{
								readFile();
							}
						else
							{
								System.out.println("Please choose (1) input a number or (2) read from an existing file.");
							}
					}
			}
		public static void takeCreditCardNumber()
			{
				while (cardNumberString.length() < 16)
					{
						System.out.println("Input a 16 digit number.");
						cardNumberString = userStringput.nextLine();
					}
				cardNumber = Long.parseLong(cardNumberString);
				for (int i = 0; i < 16; i++)
					{
						cardNumberArray[i] = cardNumber % 10;
						cardNumber /= 10;
					}
//				for (int i = 0; i < 16; i++)
//					{
//						System.out.print(cardNumberArray[i]);
//					}
//				System.out.println();
			}
		public static void readFile() throws IOException
			{
				Scanner creditCardNumbers = new Scanner (new File("creditCardNumbers"));
				int numberOfPotentiallyValidCardNumbers = 0;
				while (creditCardNumbers.hasNext())
					{
						cardNumber = Long.parseLong(creditCardNumbers.next());
						System.out.println(cardNumber);
						
						//transfer card number to array
						for (int i = 15; i > -1; i--)
							{
								cardNumberArray[i] = cardNumber % 10;
								cardNumber /= 10;
							}
//						for (int i = 0; i < 16; i++)
//							{
//								System.out.print(cardNumberArray[i]);
//							}
//						System.out.println();
						
						//double alternating digits
						for (int i = 0; i < 16; i += 2)
							{
								if (cardNumberArray[i] * 2 < 10)
									{
										cardNumberArray[i] *= 2;
									}
								else
									{
										doubledDigit = cardNumberArray[i] * 2;
										doubledDigit1 = doubledDigit % 10;
										doubledDigit = doubledDigit / 10;
										doubledDigit += doubledDigit1;
										cardNumberArray[i] = doubledDigit;
									}
							}
//						for (int i = 0; i < 16; i++)
//							{
//								System.out.print(cardNumberArray[i]);
//							}
//						System.out.println();
						
						//add all digits
						sumOfAllDigits = 0;
						for (int i = 0; i < 16; i++)
							{
								sumOfAllDigits += cardNumberArray[i];
//								System.out.println(sumOfAllDigits);
							}
//						System.out.println(sumOfAllDigits);
						
						//determine if valid
						if (sumOfAllDigits % 10 == 0)
							{
								numberOfPotentiallyValidCardNumbers++;
//								System.out.println("valid");
							}
						else
							{
//								System.out.println("invalid");
							}
					}
				System.out.println(numberOfPotentiallyValidCardNumbers + " of the numbers in the file are potentially valid credit card numbers.");
			}
		public static void generateNumber()
			{
				for (int i = 0; i < 16; i++)
					{
						long randomNumber =(long)(Math.random()*10 - 1);
						cardNumberArray[i] = randomNumber;
					}
//				for (int i = 0; i < 16; i++)
//					{
//						System.out.print(cardNumberArray[i]);
//					}
//				System.out.println();
			}
		public static void doubleAlternatingDigits()
			{
				for (int i = 1; i < 16; i += 2)
					{
						if (cardNumberArray[i] * 2 < 10)
							{
								cardNumberArray[i] *= 2;
							}
						else
							{
								doubledDigit = cardNumberArray[i] * 2;
								doubledDigit1 = doubledDigit % 10;
								doubledDigit /= 10;
								doubledDigit += doubledDigit1;
								cardNumberArray[i] = doubledDigit;
							}
					}
//				for (int i = 0; i < 16; i++)
//					{
//						System.out.print(cardNumberArray[i]);
//					}
//				System.out.println();
			}
		public static void addAllDigits()
			{
				for (int i = 0; i < 16; i++)
					{
						sumOfAllDigits = sumOfAllDigits + cardNumberArray[i];
					}
//				System.out.println(sumOfAllDigits);
			}
		public static void checkIfDivisableByTen()
			{
				System.out.println(sumOfAllDigits % 10 == 0 ? "That is a potentially valid credit card number." : "That is not a valid credit card number.");
//				if (sumOfAllDigits % 10 == 0)
//					{
//						System.out.println("That is a potentially valid credit card number.");
//					}
//				else
//					{
//						System.out.println("That is not a valid credit card number.");
//					}
			}
		public static void ifValidAddToGeneratedCreditCards()
			{
				if (sumOfAllDigits % 10 == 0)
					{
						for (int i = 0; i < 16; i++) 
							{
								generatedCreditCards[generatedCardIndex] += cardNumberArray[i];
							}
						generatedCardIndex++;
					}
			}
	}
