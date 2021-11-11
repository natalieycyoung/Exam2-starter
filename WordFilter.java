// EXAM INSTRUCTIONS:
// All of your code for Task 3 goes in this file.
//

import java.util.Scanner;

class WordFilter
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		String strInput = input.nextLine();

		String[] words = strInput.split(" ");

		for (int i = 1; i < words.length; i++)
		{
			if (words[i].contains(words[0]))
			{
				System.out.print(" " + words[i] + " ");
			}
		}
	}
}
