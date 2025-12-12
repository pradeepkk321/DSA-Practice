package dsa_practice.algorithm.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 3583. Count Special Triplets
 * https://leetcode.com/problems/count-special-triplets/
 */
public class CountSpecialTriplets {
	
    int mod = 1000000007;
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mapLeft = new HashMap<>();
        Map<Integer, Integer> mapRight = new HashMap<>();
        long cnt = 0;
        for(int i=2; i<n; i++){
            mapRight.put(nums[i], mapRight.getOrDefault(nums[i], 0)+1);
        }
        mapLeft.put(nums[0], 1);
        int i=1;
        while(i<nums.length-1){
            int req = 2 * nums[i];
            if(mapLeft.containsKey(req) && mapRight.containsKey(req)){
                int n1 = mapLeft.get(req);
                int n2 = mapRight.get(req);
                cnt = (cnt + ((long)n1 * (long)n2) % mod) % mod;
            } 
            mapLeft.put(nums[i], mapLeft.getOrDefault(nums[i], 0)+1);
            // if(i+1 < nums.length){
                mapRight.put(nums[i+1], mapRight.get(nums[i+1])-1);
                if(mapRight.get(nums[i+1]) == 0){
                    mapRight.remove(nums[i+1]);
                }
            // }
            i++;
        }
        return (int)cnt;
    }
    
    public static void main(String[] args) {
		CountSpecialTriplets obj = new CountSpecialTriplets();
		int[] nums1 = {6,3,6};
		int[] nums2 = {0,1,0,0};
		int[] nums3 = {8,4,2,8,4};
		System.out.println(obj.specialTriplets(nums1)); // Output: 1
		System.out.println(obj.specialTriplets(nums2)); // Output: 1
		System.out.println(obj.specialTriplets(nums3)); // Output: 2
	}

}
