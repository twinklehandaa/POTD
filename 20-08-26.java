// distribute elements into two arrays
//distribute all the elements of nums between two arrays arr1 and arr2 using n operations. In the first operation, append nums[1] to arr1. In the second operation, append nums[2] to arr2. Afterwards, in the ith operation:

// If the last element of arr1 is greater than the last element of arr2, append nums[i] to arr1. Otherwise, append nums[i] to arr2.
// The array result is formed by concatenating the arrays arr1 and arr2

class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        // int[] arr1 = new int[n];
        // int[] arr2 = new int[n];
        List<Integer> arr1 = new ArrayList<>(); 
        List<Integer> arr2 = new ArrayList<>(); 
        // int n1 = arr1.size();
        // int n2 = arr2.size();

        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for(int i = 2; i < n; i++){
            if(arr1.get(arr1.size()-1) > arr2.get(arr2.size()-1)) arr1.add(nums[i]);
            else arr2.add(nums[i]);
        }

        int[] res = new int[n];
        for(int i = 0; i < arr1.size(); i++){
            res[i] = arr1.get(i);
        }
        for(int i = 0; i < arr2.size(); i++){
            res[i+arr1.size()] = arr2.get(i);
        }

        return res;
        
    }
}
