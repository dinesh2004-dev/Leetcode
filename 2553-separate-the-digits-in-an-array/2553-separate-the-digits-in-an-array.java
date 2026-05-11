class Solution {

    private int[] findDigits(int num){

        List<Integer> res = new ArrayList<>();

        while(num > 0){

            int rem = num % 10;

            res.add(rem);

            num = num / 10;
        }

        return res.stream()
                  .mapToInt(Integer::intValue)
                  .toArray();
    }
    public int[] separateDigits(int[] nums) {
        
        List<Integer> res = new ArrayList<>();

        int n = nums.length;

        for(int i = 0; i < n; i++){

            int[] digits = findDigits(nums[i]);

            for(int j = digits.length - 1; j >= 0; j--){

                res.add(digits[j]);
            }
        }

        return res.stream()
                  .mapToInt(Integer::intValue)
                  .toArray();
    }
}