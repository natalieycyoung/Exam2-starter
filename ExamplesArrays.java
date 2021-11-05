// EXAM INSTRUCTIONS:
// All of your code for Task 1 goes in this file.


class ExamplesArrays
{
	ExamplesArrays() {}

//	double lowest;	//put in avg method to make local after testing complete

	/**
	 * Takes an array of doubles and returns the average of the set without the
	 * lowest number
	 *
	 * @param numSet
	 * @return average
	 */
	double averageWithoutLowest(double[] numSet)
	{
		double average = 0;

		if (numSet.length < 1)
		{
			return average;
		}

		double lowest = numSet[0];
		int lowestIndex = 0; // double check that this doesn't break anything
		double sum = 0;

		for (int i = 0; i < numSet.length; i++)
		{
//System.out.println("numSet[" + i + "]: " + numSet[i]);
//System.out.println("lowestIndex: " + lowestIndex);
			if (numSet[i] < lowest)	// ensures exclusion of only one lowest
			{
//System.out.println("within if(numSet[i] < lowest)");
				lowest = numSet[i];
//System.out.println("current index: " + i);
				lowestIndex = i;
//System.out.println("lowestIndex: " + lowestIndex);
			}
		}
		
		for (int i = 0; i < numSet.length; i++)
		{
			if (i != lowestIndex)	// adds array value to sum if not lowest
			{
				sum += numSet[i];
			}
		}

		average = sum / (numSet.length - 1);
		
		return average;
	}

	/**
	 * Takes an array of Pair and returns array of int where each element of returned
	 * array is sum of a and b fields of corresponding pair.
	 *
	 * @param pairs
	 * @return sums
	 */
	int[] sumOfPairs(Pair[] pairs)
	{
		int[] sums = new int[pairs.length];

		for (int i = 0; i < pairs.length; i++)
		{
System.out.println("pairs[" + i + "].a: " + pairs[i].a);
System.out.println("pairs[" + i + "].b: " + pairs[i].b);
			sums[i] = pairs[i].a + pairs[i].b;
System.out.println("sums[" + i + "]: " + sums[i]);
		}

		return sums;
	}

	// TEST
	public static void main(String[] args)
	{
/*		ExamplesArrays averageTest = new ExamplesArrays();
		double[] exArray = {2.0, 1.0, 1.0, 1.0};
		double avg = averageTest.averageWithoutLowest(exArray);

		for (int i = 0; i < exArray.length; i++)
		{
			System.out.println("exArray[" + i + "]: " + exArray[i]);
		}
		System.out.println("avg: " + avg);
		System.out.println("lowest: " + averageTest.lowest);
*/
		ExamplesArrays test = new ExamplesArrays();
		Pair pair1 = new Pair(1,2);
		Pair pair2 = new Pair(3,4);
//		Pair pair3 = new Pair(3,3);
		Pair[] exPairs = {pair1, pair2};
		int[] intsArray = test.sumOfPairs(exPairs);
for (int i = 0; i < intsArray.length; i++)
{
	System.out.println("intsArray[" + i + "]: " + intsArray[i]);
}
	}
}


class Pair
{
	int a;
	int b;

	Pair(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
}
