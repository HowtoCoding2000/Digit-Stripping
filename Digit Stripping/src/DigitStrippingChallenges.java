import java.util.Scanner;
public class DigitStrippingChallenges
	{
		static Scanner userInput = new Scanner(System.in);
		static int userNumber; 
		public static void main(String[] args)
			{
				// TODO Auto-generated method stub
				fillArrayWithUserNumber();
//				askForNewUserNumber();
			//	reportDigitsInUserNumber();
			}
		public static void fillArrayWithUserNumber()
			{
				System.out.println("Enter a 6 digit number.");
				userNumber = userInput.nextInt();
				int [] numbers = new int [6]; 
				for (int i = 0; i < numbers.length; i++)
					{
						numbers[i] = userNumber % 10;
						userNumber /= 10;
					}
				for (int i = 0; i < numbers.length; i++)
					{
						System.out.println(numbers[i]);
					}
			}
//		public static void askForNewUserNumber()
//			{
//				System.out.println("Enter a number.");
//				userNumber = userInput.nextInt();
//				do
//					{
//						
//					}
//			}
	}
