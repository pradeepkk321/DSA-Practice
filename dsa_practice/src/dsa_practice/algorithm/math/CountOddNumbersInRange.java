package dsa_practice.algorithm.math;

/**
 * Leetcode 1523. Count Odd Numbers in an Interval Range
 * https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
 * 
 * Given two non-negative integers low and high. 
 * Return the count of odd numbers between low and high (inclusive).
 * 
 * Example 1:
 * Input: low = 3, high = 7
 * Output: 3
 * Explanation: The odd numbers between 3 and 7 are [3,5,7]. There are 3 odd numbers.
 * 
 * Example 2:
 * Input: low = 2, high = 10
 * Output: 5
 * Explanation: The odd numbers between 2 and 10 are [3,5,7,9]. There are 5 odd numbers.
 * 
 * Constraints:
 * 0 <= low <= high <= 10^9
 * 	
 *
 * Approach: Mathematical Calculation
 * The count of odd numbers can be determined based on the parity of low and high.
 * If both low and high are even, the count of odd numbers is (high - low) / 2.
 * If either low or high is odd, the count of odd numbers is (high - low) / 2 + 1.
 * This approach runs in constant time O(1) and uses O(1) space.
 *
 */
public class CountOddNumbersInRange {

	public int countOdds(int low, int high) {
		// If both low and high are even, the count of odd numbers is (high - low) / 2
		if (low % 2 == 0 && high % 2 == 0) {
			return (high - low) / 2;
		}
		// If either low or high is odd, the count of odd numbers is (high - low) / 2 +
		// 1
		else {
			return (high - low) / 2 + 1;
		}
	}

	// My Solution
	// Compared to the optimized solution, this one calculates the total numbers in the range first
	// performs slightly worse in terms of time taken for large inputs
	// because of the additional arithmetic operation
	public int countOddsMySolution(int low, int high) {

		// Total numbers in the range
		int totalNums = high - low + 1;
		// If low is even, half of the numbers are odd
		if (low % 2 == 0)
			return totalNums / 2;
		// If low is odd, half of the numbers + 1 are odd
		else
			return (totalNums + 1) / 2;

	}
	
	public int countOddsBruteForce(int low, int high) {
	    int count = 0;
	    for (int i = low; i <= high; i++) {
	        if (i % 2 != 0) {
	            count++;
	        }
	    }
	    return count;
	}

	public static void main(String[] args) {

		CountOddNumbersInRange obj = new CountOddNumbersInRange();

		System.out.println("Using Optimized Solution:");
		System.out.println(obj.countOdds(3, 7)); // Output: 3
		System.out.println(obj.countOdds(2, 10)); // Output: 5
		System.out.println(obj.countOdds(4, 4)); // Output: 0
		System.out.println(obj.countOdds(1, 1)); // Output: 1
		System.out.println(obj.countOdds(0, 0)); // Output: 0
		System.out.println(obj.countOdds(0, 1)); // Output: 1
		System.out.println(obj.countOdds(1, 10000000)); // Output: 5000000

		System.out.println("Using My Solution:");
		System.out.println(obj.countOddsMySolution(3, 7)); // Output: 3
		System.out.println(obj.countOddsMySolution(2, 10)); // Output: 5
		System.out.println(obj.countOddsMySolution(4, 4)); // Output: 0
		System.out.println(obj.countOddsMySolution(1, 1)); // Output: 1
		System.out.println(obj.countOddsMySolution(0, 0)); // Output: 0
		System.out.println(obj.countOddsMySolution(0, 1)); // Output: 1
		System.out.println(obj.countOddsMySolution(1, 10000000)); // Output: 5000000
		
		System.out.println("Using Brute Force Solution:");
		//Comparing time taken by brute force for large input and my solution
		long startTime = System.nanoTime();
		System.out.println(obj.countOddsBruteForce(1, 10000000)); // Output: 5000000
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("Time taken by Brute Force: " + duration + " nanoseconds");
		
		startTime = System.nanoTime();
		System.out.println(obj.countOddsMySolution(1, 10000000)); // Output: 5000000
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("Time taken by My Solution: " + duration + " nanoseconds");
		
		startTime = System.nanoTime();
		System.out.println(obj.countOdds(1, 10000000)); // Output: 5000000
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("Time taken by Optimized Solution: " + duration + " nanoseconds");
	
	}

}
