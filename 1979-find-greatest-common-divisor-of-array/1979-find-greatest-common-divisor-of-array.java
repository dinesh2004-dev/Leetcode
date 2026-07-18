class Solution {

    private int gcd(int a,int b){

        // System.out.println(a+" "+b);

        while(b != 0){

            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
    public int findGCD(int[] nums) {
        
        int smallest = nums[0];
        int largest = nums[0];

        for(int i = 1; i < nums.length; i++){

            smallest = Math.min(smallest,nums[i]);
            largest = Math.max(largest,nums[i]);
        }

        int res = gcd(smallest,largest);

        return res;
    }
}