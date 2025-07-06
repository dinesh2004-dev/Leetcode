class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    HashMap<Integer,Integer> mpp = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for(int ele : nums2){
            mpp.put(ele,mpp.getOrDefault(ele,0)+1);
        }
    }
    
    public void add(int index, int val) {
        mpp.put(nums2[index],mpp.get(nums2[index]) - 1);
        nums2[index] += val;
        mpp.put(nums2[index],mpp.getOrDefault(nums2[index],0)+1);
    }
    
    public int count(int tot) {
        int count = 0;
        for(int ele : nums1){
            count += mpp.getOrDefault(tot - ele,0);
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */