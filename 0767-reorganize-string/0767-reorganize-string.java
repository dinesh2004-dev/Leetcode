class Pair{

    char ch;
    int fq;

    public Pair(char ch,int fq){

        this.ch = ch;
        this.fq = fq;
    }
}
class Solution {
    public String reorganizeString(String s) {
        
        int n = s.length();

        int[] freq = new int[26];

        for(char ch : s.toCharArray()){

            freq[ch - 'a']++;
        }

        for(int ele : freq){
            if(ele > (n + 1) / 2){
                return "";
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> y.fq - x.fq);

        for(int i = 0; i < 26; i++){

            if(freq[i] > 0){

                pq.add(new Pair((char) (i + 'a'),freq[i]));
            }
        }

        StringBuilder str = new StringBuilder();
        Pair prev = new Pair('#',0);

            while(!pq.isEmpty()){

                Pair top = pq.poll();
                str.append(top.ch);
                top.fq--;
                if(prev.fq > 0){

                    pq.add(prev);
                }

                prev = top;
            }

            
        

        return str.toString();
    }
}