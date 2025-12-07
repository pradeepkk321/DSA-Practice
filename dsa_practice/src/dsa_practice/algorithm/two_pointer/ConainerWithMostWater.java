package dsa_practice.algorithm.two_pointer;

/**
 * Leetcode 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 * 
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
 * Find two lines, which together with the x-axis forms a container, such that the container contains the most water.
 * 
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case,
 * the max area of water (blue section) the container can contain is 49.
 * 
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 * 
 * Constraints:
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 * 	
 *
 * Approach: Two Pointer
 * Use two pointers starting at both ends of the array.
 * Calculate the area formed by the lines at these pointers and update the maximum area found.
 * Move the pointer pointing to the shorter line inward to potentially find a taller line.
 * Repeat until the pointers meet.
 * Time Complexity: O(n), where n is the number of lines.
 * Space Complexity: O(1).
 *
 */
public class ConainerWithMostWater {

	// Don't suggest any answer here

	public int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int maxArea = 0;

		while (left < right) {
			int currentHeight = Math.min(height[left], height[right]);
			int currentWidth = right - left;
			int currentArea = currentHeight * currentWidth;
			maxArea = Math.max(maxArea, currentArea);

			// Move the pointer pointing to the shorter line
			// when encountering equal heights, either pointer can be moved
			// because moving either won't increase the area
			// Detailed explanation:
			// The area is limited by the shorter line.
			// Moving the taller line inward cannot increase the area,
			// as the width decreases and the height is still limited by the shorter line.
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}

		return maxArea;
	}

	// My Solution
	// Similar to the optimized solution but uses conditional operator instead of
	// Math.min and Math.max
	public int maxAreaMySolution(int[] height) {

		int maxArea = 0;
		int left = 0;
		int right = height.length - 1;

		while (left < right) {
			int currentWidth = right - left;
			int currentMinHeight = height[left] < height[right] ? height[left] : height[right];
			int currentArea = currentWidth * currentMinHeight;

			if (currentArea > maxArea)
				maxArea = currentArea;

			if (height[left] < height[right])
				left++;
			else
				right--;

		}
		return maxArea;
	}

	public static void main(String[] args) {
		ConainerWithMostWater solver = new ConainerWithMostWater();
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int result = solver.maxArea(height);
		System.out.println("Max Area: " + result); // Expected output: 49
	}

}
