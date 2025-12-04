package dsa_practice.algorithm.two_pointer;

/**
 * Leetcode 2211. Count Collisions on a Road 
 * https://leetcode.com/problems/count-collisions-on-a-road/
 * 
 * Given a string directions representing the directions of cars on a road,
 * where each character in the string can be 'L', 'R', or 'S',
 * indicating a car moving left, right, or stationary respectively,
 * return the total number of collisions that will occur on the road.
 * 
 * A collision occurs when two cars moving in opposite directions meet,
 * or when a moving car meets a stationary car.
 * 
 * Example 1:
 * Input: directions = "RLRSLL"
 * Output: 5
 * Explanation:
 * The collisions that will occur are as follows:
 * - The first car (R) collides with the second car (L) and both become stationary.
 * - The third car (R) collides with the fourth car (S) and becomes stationary.
 * - The fifth car (L) collides with the sixth car (L) and both become stationary.
 * - The fifth car (L) collides with the now stationary third car (S) and becomes stationary.
 * - The fourth car (S) collides with the now stationary fifth car (S) and remains stationary.
 * Total collisions = 5.
 * 
 * Example 2:
 * Input: directions = "LLRR"
 * Output: 0
 * Explanation:
 * No collisions will occur, as all cars are moving away from each other.
 * Constraints:
 * 1 <= directions.length <= 10^5
 * directions[i] is either 'L', 'R', or 'S'.
 * 	
 *
 * Approach: Two Pointer
 * All cars moving left at the start and all cars moving right at the end will never collide.
 * We can ignore these cars and focus on the cars in between.
 * All cars that are not stationary ('S') in this segment will eventually collide only once and stop.
 * Stationary cars do not contribute to collisions.
 * Time Complexity: O(n), where n is the length of the directions string.
 * Space Complexity: O(1).
 *
 */
public class CollisionOnRoad {
	
	    public int countCollisions(String directions) {
	        int n = directions.length();
	        int l = 0;
	        int r = n - 1;

	        // Skip all leading 'L's
	        while (l < n && directions.charAt(l) == 'L') {
	            l++;
	        }
	        
	        // Skip all trailing 'R's
	        while (r >= l && directions.charAt(r) == 'R') {
	            r--;
	        }

	        // Count collisions in the remaining segment
	        int res = 0;
	        for (int i = l; i <= r; i++) {
	            if (directions.charAt(i) != 'S') {
	                res++;
	            }
	        }
	        return res;
	    }
	
    
    
    public static void main(String[] args) {
		
		testCollistionCount("RLRSLL", 5);
		testCollistionCount("LLRR", 0);
		testCollistionCount("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR", 20);
		testCollistionCount("RRSLLRSRLLRSRLRLRRLLRRSLLRLRRLLSRL", 29);
	}



	private static void testCollistionCount(String directions, int expected) {
		CollisionOnRoad cor = new CollisionOnRoad();
		int result = cor.countCollisions(directions);
		System.out.println("Number of collisions: " + result);
		System.out.println("Test " + (result == expected ? "Passed" : "Failed"));
	}

}
