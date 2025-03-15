class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        Set<Integer> set1 = new HashSet<>();

        Set<Integer> set2 = new HashSet<>();

        for(int n : nums1){

            set1.add(n);
        }

        for(int n : nums2){

            set2.add(n);
        }

        List<Integer> list1 = set1.stream()
                          .filter(num -> !set2.contains(num))
                          .collect(Collectors.toList());
        List<Integer> list2 = set2.stream()
                          .filter(num -> !set1.contains(num))
                          .collect(Collectors.toList());
        return Arrays.asList(list1,list2);

        
    }
}