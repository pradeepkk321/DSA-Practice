package dsa_practice.algorithm.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * leetcode 3531. Count Covered Buildings
 * https://leetcode.com/problems/count-covered-buildings/
 * You are given an integer n representing the size of an n x n grid.
 * Each cell in the grid contains a building. You are also given a 2D integer array buildings where buildings[i] = [rowi, coli] indicates that there is a building located at (rowi, coli).
 * A building located at (rowi, coli) is considered covered if there is at least one building in the same row to the left or right of it, and at least one building in the same column above or below it.
 * Return the number of covered buildings.
 * 
 * Example 1:
 * Input: n = 3, buildings = [[2,1],[2,3],[3,3],[2,2],[1,3]]
 * Output: 0
 * Explanation: The grid representation of the buildings is shown above.
 * There are no covered buildings in this example.
 * 
 * Example 2:
 * Input: n = 3, buildings = [[1,2],[2,2],[3,2],[2,1],[2,3]]
 * Output: 1
 * Explanation: The grid representation of the buildings is shown above.
 * The only covered building is located at (2,2).
 * 
 * Example 3:
 * Input: n = 3, buildings = [[1,1],[1,2],[2,1],[2,2]]
 * Output: 0
 * Explanation: The grid representation of the buildings is shown above.
 * There are no covered buildings in this example.
 * 
 * Constraints:
 * 1 <= n <= 10^5
 * 1 <= buildings.length <= 10^5
 * buildings[i].length == 2
 * 1 <= rowi, coli <= n
 * All the pairs (rowi, coli) are unique.
 * 
 * * Approach: Using HashMap with TreeSet to store sorted rows and columns
 * * Explanation:
 * We use two HashMaps to store the buildings in each row and each column using TreeSet to keep them sorted.
 * For each building, we check if there are buildings on both sides in its row and column by checking the first and last elements in the TreeSet.
 * If both conditions are satisfied, we count the building as covered.
 * 
 */
public class CountCoveredBuildings {
	
	public int countCoveredBuildings(int n, int[][] buildings) {

        Map<Integer, TreeSet<Integer>> sortedRows = new HashMap<>();
        Map<Integer, TreeSet<Integer>> sortedColumns = new HashMap<>(); 

        for(int i = 0; i < buildings.length; i++) {
            int[] building = buildings[i];
            int rowNum = building[0];
            int colNum = building[1];

            sortedRows.putIfAbsent(rowNum, new TreeSet<Integer>());
            Set<Integer> row = sortedRows.get(rowNum);
            row.add(colNum);

            sortedColumns.putIfAbsent(colNum, new TreeSet<Integer>());
            Set<Integer> col = sortedColumns.get(colNum);
            col.add(rowNum);
        }

        int count = 0;
        for(int i = 0; i < buildings.length; i++) {
            int[] building = buildings[i];
            int rowNum = building[0];
            int colNum = building[1];

            TreeSet<Integer> row = sortedRows.get(rowNum);
            if(row.size() > 2 && row.first() != colNum && row.last() != colNum ) {
                TreeSet<Integer> col = sortedColumns.get(colNum);
                if(col.size() > 2 && col.first() != rowNum && col.last() != rowNum ) {
                    count++;
                }
            }  
        }
        return count;
    }
	
	/** Optimized Approach: Using HashMap to count occurrences
	 * 
	 * Explanation:
	 * We use two HashMaps to count the number of buildings in each row and each column.
	 * For each building, we check if there are more than one building in its row and column.
	 * If both conditions are satisfied, we count the building as covered.
	 * 
	 * @param n
	 * @param buildings
	 * @return
	 */
	public int countCoveredBuildingsOptimized(int n, int[][] buildings) {
		
		Map<Integer, Integer> rowCount = new HashMap<>();
		Map<Integer, Integer> colCount = new HashMap<>();
		
		for(int i = 0; i < buildings.length; i++) {
			int rowNum = buildings[i][0];
			int colNum = buildings[i][1];
			
			rowCount.put(rowNum, rowCount.getOrDefault(rowNum, 0) + 1);
			colCount.put(colNum, colCount.getOrDefault(colNum, 0) + 1);
		}
		
		int count = 0;
		for(int i = 0; i < buildings.length; i++) {
			int rowNum = buildings[i][0];
			int colNum = buildings[i][1];
			
			if(rowCount.get(rowNum) > 1 && colCount.get(colNum) > 1) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		CountCoveredBuildings obj =  new CountCoveredBuildings();
		
		int[][] buildings1 = {{2,1},{2,3},{3,3},{2,2},{1,3}};
		System.out.println(obj.countCoveredBuildings(3, buildings1) == 0 ? "Test case 1 passed" : "Test case 1 Failed");
		
		int[][] buildings2 = {{1,2},{2,2},{3,2},{2,1},{2,3}};
		System.out.println(obj.countCoveredBuildings(3, buildings2) == 1 ? "Test case 2 passed" : "Test case 2 Failed");
		
		int[][] buildings3 = {{1,1},{1,2},{2,1},{2,2}};
		System.out.println(obj.countCoveredBuildings(3, buildings3) == 0 ? "Test case 3 passed" : "Test case 3 Failed");
		
		int[][] buildings4 = {{1,3},{3,2},{3,3},{3,5},{5,3}};
		System.out.println(obj.countCoveredBuildings(5, buildings4) == 1 ? "Test case 4 passed" : "Test case 4 Failed");
	}

}
