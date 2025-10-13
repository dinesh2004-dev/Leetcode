class Solution {
    public List<String> removeAnagrams(String[] words) {
        
        List<Map<Character,Integer>> freq = new ArrayList<>();

        for(int i = 0; i < words.length; i++){

            Map<Character,Integer> mpp = new HashMap<>();

            for(int j = 0; j < words[i].length(); j++){

                mpp.put(words[i].charAt(j),mpp.getOrDefault(words[i].charAt(j),0)+1);
            }

            freq.add(mpp);
        }

        List<String> res = new ArrayList<>();

        res.add(words[0]);

        for(int i = 1; i < words.length; i++){

            if(!freq.get(i).equals(freq.get(i - 1))){

                res.add(words[i]);
            }
        }

        return res;
    }
}