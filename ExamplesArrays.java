// EXAM INSTRUCTIONS:
// All of your code for Task 1 goes in this file.

import tester.*;

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
		int lowestIndex = 0;
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
	 * Takes an array of Pair and returns array of int where each element of
	 * returned array is sum of a and b fields of corresponding pair.
	 *
	 * @param pairs
	 * @return sums
	 */
	int[] sumOfPairs(Pair[] pairs)
	{
		int[] sums = new int[pairs.length];

		for (int i = 0; i < pairs.length; i++)
		{
//System.out.println("pairs[" + i + "].a: " + pairs[i].a);
//System.out.println("pairs[" + i + "].b: " + pairs[i].b);
			sums[i] = pairs[i].a + pairs[i].b;
//System.out.println("sums[" + i + "]: " + sums[i]);
		}

		return sums;
	}

	/**
	 * Takes array of Region and a Point and returns a new array of Regions
	 * from input that contain given Point
	 *
	 * @param regions
	 * @param point
	 * @return regionsWithPoints
	 */
	Region[] regionsWithPoint(Region[] regions, Point point)
	{
		int regCount = 0;

		for (int regIndex = 0; regIndex < regions.length; regIndex++)
		{
			if (regions[regIndex].contains(point))
			{
				regCount += 1;
			}
		}

		Region[] regionsWithPoint = new Region[regCount];
		int regWithIndex = 0;

		for (int regIndex = 0; regIndex < regions.length; regIndex++)
		{
			if (regions[regIndex].contains(point))
			{
				regionsWithPoint[regWithIndex] = regions[regIndex];
				regWithIndex += 1;
			}
		}

		return regionsWithPoint;
	}


/*
	// TEST
	public static void main(String[] args)
	{
		ExamplesArrays test = new ExamplesArrays();
		// TASK 1
		ExamplesArrays averageTest = new ExamplesArrays();
		double[] exArray = {2.0, 1.0, 1.0, 1.0};
		double avg = averageTest.averageWithoutLowest(exArray);

		for (int i = 0; i < exArray.length; i++)
		{
			System.out.println("exArray[" + i + "]: " + exArray[i]);
		}
		System.out.println("avg: " + avg);
		System.out.println("lowest: " + averageTest.lowest);


		// TASK 2

		Pair pair1 = new Pair(1,2);
		Pair pair2 = new Pair(3,4);
//		Pair pair3 = new Pair(3,3);
		Pair[] exPairs = {pair1, pair2};
		int[] intsArray = test.sumOfPairs(exPairs);
for (int i = 0; i < intsArray.length; i++)
{
	System.out.println("intsArray[" + i + "]: " + intsArray[i]);
}


		// TASK 3
		Region[] regions = {new CircleRegion(new Point(0, 0), 5),
			new CircleRegion(new Point(0, 0), 10)};

		Region[] regTest = test.regionsWithPoint(regions, new Point(9, 0));
for (int i = 0; i < regTest.length; i++)
{
	System.out.println
}

		
	}
*/
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

class ProvidedExamples
{
	void testAverageWithoutLowest(Tester t)
	{
		double[] unique = {1.0, 2.0, 3.0};
		t.checkExpect(averageWithoutLowest(unique), 2.5);
	};

	void testRegionsWithPoint(Tester t)
	{
		Region[] regions = {new CircleRegion(new Point(0, 0), 5),
			new CircleRegion(new Point(0, 0), 10)};
		Region[] result = {new CircleRegion(new Point(0, 0), 10)};
		t.checkExpect(regionsWithPoint(regions, new Point(9, 0)), result);
	};

	void testSumOfPairs(Tester t)
	{
		Pair[] pairs = {new Pair(1, 2), new Pair(3, 4)};
		int[] result = {3, 7};
		t.checkExpect(sumOfPairs(pairs), result);
	};
}
