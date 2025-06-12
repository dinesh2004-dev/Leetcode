class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        
        
        int low = 0, high = n - 1, pos = -1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (arr[mid] < x) {
                pos = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
       
        int left = pos;
        int right = pos + 1;
        
        List<Integer> res = new ArrayList<>();
        
       
        while (res.size() < k) {
            if (left < 0) {
                
                res.add(arr[right]);
                right++;
            } else if (right >= n) {
                
                res.add(arr[left]);
                left--;
            } else {
                
                int leftDiff = Math.abs(arr[left] - x);
                int rightDiff = Math.abs(arr[right] - x);
                
                if (leftDiff < rightDiff || (leftDiff == rightDiff && arr[left] < arr[right])) {
                    res.add(arr[left]);
                    left--;
                } else {
                    res.add(arr[right]);
                    right++;
                }
            }
        }
        
        Collections.sort(res);
        return res;
    }
}