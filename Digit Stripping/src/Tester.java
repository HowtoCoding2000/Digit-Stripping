
public class Tester
	{
		public static void main(String[] args)
			{
				long number = 8;
				long doubledDigit = number * 2;
				long doubledDigit1 = doubledDigit % 10;
				doubledDigit = doubledDigit / 10;
				doubledDigit += doubledDigit1;
				System.out.println(doubledDigit);
			}
	}
