class Solution {

    private static int mod = (int) 1e9 + 7;
    public int maxSum(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length,n2 = nums2.length;

        long sum1 = 0,sum2 = 0;

        long maxSum = 0;

        int i = 0,j = 0;

        while(i < n1 && j < n2){

            if(nums2[j] > nums1[i]){

                sum1 += nums1[i];
                i++;
            }
            else if(nums1[i] > nums2[j]){

                sum2 += nums2[j];
                j++;
            }
            else{

                maxSum = Math.max(sum1,sum2);
                sum1 = maxSum + nums1[i];
                sum2 = maxSum + nums2[j];
                i++;
                j++;
            }
        }

        while(i < n1){

            sum1 += nums1[i];
            i++;
        }

        while(j < n2){

            sum2 += nums2[j];
            j++;
        }

        maxSum = Math.max(sum1,sum2);

        return (int) (maxSum % mod);
    }
}