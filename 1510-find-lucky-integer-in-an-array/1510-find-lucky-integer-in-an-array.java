class Solution {
    public int findLucky(int[] arr) {
        Map<Integer,Integer> mpp = new HashMap<>();
      for(int i = 0; i < arr.length; i++){
          mpp.put(arr[i],mpp.getOrDefault(arr[i],0)+1);
      }
      int ele = -1;
      for(Map.Entry<Integer,Integer> entry : mpp.entrySet()){
          if(entry.getValue() == entry.getKey()){
                ele = entry.getKey();
          }
    }
    return ele;
    }
}