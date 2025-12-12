package dsa_practice.algorithm.math;

/**
 * Leetcode 1925. Count Square Sum Triples
 * https://leetcode.com/problems/count-square-sum-triples/
 * 
 * A square sum triple (a,b,c) is a triple where a, b, and c are integers such that a^2 + b^2 = c^2.
 * Given an integer n, return the number of square sum triples such that 1 <= a, b, c <= n.
 * 
 * Example 1:
 * Input: n = 5
 * Output: 2
 * Explanation: The square sum triples are (3,4,5) and (4,3,5).
 * 
 * Example 2:
 * Input: n = 10
 * Output: 4
 * Explanation: The square sum triples are (6,8,10), (8,6,10), (3,4,5), and (4,3,5).
 * 
 * Constraints:
 * 1 <= n <= 250
 * 	
 *
 * Approach: Brute Force with Nested Loops
 * We use two nested loops to iterate through all possible pairs (a, b) and calculate c using the Pythagorean theorem.
 * If c is an integer and within the range [1, n], we count the pair as a valid square sum triple.
 * This approach runs in O(n^2) time and uses O(1) space.
 * 
 * Approach: Optimized Approach using HashSet
 * We precompute the squares of all integers from 1 to n and store them in a HashSet for O(1) lookups.
 * Then, we use two nested loops to iterate through all possible pairs (a, b) and check if a^2 + b^2 exists in the HashSet.
 * If it does, we count the pair as a valid square sum triple.
 * This approach runs in O(n^2) time and uses O(n) space.
 *
 */
public class CountSquareSumTriples {
	
	public int countTriplets(int n) {
			
		int count = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = i+1; j <=n; j++) {
				double sqrt = Math.sqrt(i*i + j*j);
				
				if(sqrt <= n && sqrt == Math.floor(sqrt)) {
					count += 2;
				}
			}
		}
		return count;
	}
	
	// Optimized Approach: Using HashSet to store squares
	public int countTripletsOptimized(int n) {
		
		int count = 0;
		java.util.Set<Integer> squares = new java.util.HashSet<>();
		
		for(int i = 1; i <= n; i++) {
			squares.add(i * i);
		}
		
		for(int a = 1; a <= n; a++) {
			for(int b = a; b <= n; b++) {
				int cSquare = a * a + b * b;
				if(squares.contains(cSquare)) {
					count += (a == b) ? 1 : 2;
				}
			}
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		
		CountSquareSumTriples obj =  new CountSquareSumTriples();
		
		System.out.println(obj.countTriplets(10));
	}

}
