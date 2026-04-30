class Pair{

    int key;
    int freq;

    public Pair(int key,int freq){

        this.key = key;
        this.freq = freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        int n = nums.length;

        Map<Integer,Integer> mpp = new HashMap<>();

        for(int ele : nums){

            mpp.put(ele,mpp.getOrDefault(ele,0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.freq - y.freq);

        for(Map.Entry<Integer,Integer> entry : mpp.entrySet()){

            int key = entry.getKey();
            int val = entry.getValue();

            pq.add(new Pair(key,val));

            if(pq.size() > k){

                pq.poll();
            }
        }

        List<Integer> list = new ArrayList<>();

        while(!pq.isEmpty()){

            list.add(pq.poll().key);
        }

        return list.stream()
                    .mapToInt(Integer :: intValue)
                    .toArray();
    }
}