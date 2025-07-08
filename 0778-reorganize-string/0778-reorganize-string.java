class Solution {
    class Pair{
        char ch;
        int freq;
        public Pair(char ch,int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
    public String reorganizeString(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> y.freq - x.freq);
        int n = s.length();
        int[] hash = new int[26];

        for(char c : s.toCharArray()){
            hash[(int)(c - 'a')]++;
        }
        for(int ele : hash){
            if(ele > (n + 1) / 2){
                return "";
            }
        }
        for(int i = 0; i < 26; i++){
            if(hash[i] > 0){
                pq.add(new Pair((char)(i + 'a'),hash[i]));
            }
        }

        StringBuilder str = new StringBuilder();
        Pair prev = new Pair('#',0);
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            str.append(top.ch);
            top.freq -= 1;

            if(prev.freq > 0){
                pq.add(prev);
            }
            prev = top;
        }
        return str.toString();
        
    }
}