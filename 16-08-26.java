// Stone game

// Alice and Bob take turns, with Alice starting first. On each turn, the player may remove any stone from stones. The player who removes a stone loses if the sum of the values of all removed stones is divisible by 3. Bob will win automatically if there are no remaining stones (even if it is Alice's turn).

// Assuming both players play optimally, return true if Alice wins and false if Bob wins.

class Solution {
    public boolean stoneGameIX(int[] stones) {
        // int sum = 0;
        // int n = stones.length;
        // // Arrays.sort(stones);
        // for (int i = 1; i<n-1; i++){
        //     sum+=stones[i];
        //     if(sum%3==0 && i%2!=0) return true;
        //     if(sum%3==0 && i%2==0) return false;
        // }
        // return false;

        int a = 0, b=0, c=0;
        for(int s:stones){
            if(s%3==0) a++;
            else if(s%3==1) b++;
            else c++;
        }
        if(a%2==0) return b>0 && c>0;
        return Math.abs(b-c)>2;
        
    }
}

            //              START
            //                |
            //                v
            //      Count cnt0, cnt1, cnt2
            //                |
            //                v
            //         Is cnt0 even?
            //          /          \
            //        YES           NO
            //         |             |
            //         v             v
            //  cnt1 > 0 &&     abs(cnt1-cnt2)
            //     cnt2 > 0          > 2
            //     /    \           /    \
            //   YES    NO        YES    NO
            //    |      |         |      |
            //    v      v         v      v
            //  Alice   Bob      Alice   Bob
            //   Wins   Wins      Wins   Wins
