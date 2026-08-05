// find missing elements

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> missing = new ArrayList<Integer>();
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length-1; i++){
            int nxt = nums[i] + 1;
            while(nxt < nums[i+1]){
                missing.add(nxt);
                nxt++;
            }
        }
        return missing;
    }
}


// q- Originally, nums contained every integer within a certain range. However, some integers might have gone missing from the array.
// The smallest and largest integers of the original range are still present in nums.
// Return a sorted list of all the missing integers in this range. If no integers are missing, return an empty list.

 
// solution: arrange in increasing order then add a while loop to check if consecutively next number exists, if not, add in solution list.
