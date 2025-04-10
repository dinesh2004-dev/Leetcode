class Solution {
    public int numMatchingSubseq(String s, String[] words) {

        Map<String,Integer> mpp = new HashMap<>();

        for(String str : words){

            mpp.put(str,mpp.getOrDefault(str,0) + 1);
        }

        int ans = 0;

        char ch[] = s.toCharArray();

        for(String str : mpp.keySet()){

            char temp[] = str.toCharArray();

            int i = 0,j = 0;

            while(i < ch.length && j < temp.length){

                if(ch[i] == temp[j]){

                    j++;
                }
                
                    i++;
                
            }
            if(j == temp.length){

                ans += mpp.get(str);
            }
        }
        return ans;

        
    }
}