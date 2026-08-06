// smallest divisible digit prod

// Return the smallest number greater than or equal to n such that the product of its digits is divisible by t.

class Solution {
    public int prod(int n){
        int p = 1;
        while(n!=0){
            p*=n%10;
            n/=10;
        }
        return p;
    }
    public int smallestNumber(int n, int t) {
        while(prod(n)%t!=0) n++;
        return n;
    }
}

// Start from the given number n and check whether the product of its digits is divisible by t.

// If it is not divisible, increment the number and repeat the process.

// The first number satisfying the condition is the required answer.
