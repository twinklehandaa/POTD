// Lexicographically Smallest Valid Sequence

//   A string x is called almost equal to y if you can change at most one character in x to make it identical to y.

// A sequence of indices seq is called valid if:

// The indices are sorted in ascending order.
// Concatenating the characters at these indices in word1 in the same order results in a string that is almost equal to word2.
// Return an array of size word2.length representing the lexicographically smallest valid sequence of indices. If no such sequence of indices exists, return an empty array.

class Solution {
    public int[] validSequence(String word1, String word2) {
        char[] s = word1.toCharArray();
        char[] t = word2.toCharArray();

        int n = s.length;
        int m = t.length;

        int[] suff = new int[n+1];
        int j = m-1;
        int matched = 0;

        for(int i = n-1; i>=0; i--){
            if(j>=0 && s[i]==t[j]){
                matched++;
                j--;
            }
            suff[i]=matched;
        }

        int[] ans = new int[m];
        int i = 0;
        j=0;

        while(i<n && j<m){
            if(s[i]==t[j]){
                ans[j]=i;
                j++;
            } else{
                if(suff[i+1]>=m-j-1){
                    ans[j]=i;
                    j++;
                    i++;
                    break;
                }
            }
            i++;
        }
        if(j<m && i==n) return new int[0];
        while (i<n && j<m){
            if(s[i]==t[j]){
                ans[j]=i;
                j++;
            }
            i++;
        }
        if(j!=m) return new int[0];
        return ans;
    }
}
