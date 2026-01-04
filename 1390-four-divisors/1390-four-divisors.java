class Solution {
    public int[] findDivisors(int n){

        int noOfFactors = 0;

        int sum = 0;

        for(int i = 1; i * i <= n; i++){

            if (n % i == 0) {

            if (i == n / i) {
                
                noOfFactors += 1;
                sum += i;
            } else {
                noOfFactors += 2;
                sum += i + (n / i);
            }
        }
        }

        System.out.println(n+":"+noOfFactors);

        return new int[]{noOfFactors,sum};
    }
    public int sumFourDivisors(int[] nums) {
        
        int n = nums.length;

        int sum = 0;

        for(int i = 0; i < n; i++){

            int[] temp = findDivisors(nums[i]);

            if(temp[0] == 4){

                sum += temp[1];
            }
        }

        return sum;
    }
}