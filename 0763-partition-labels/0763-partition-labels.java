class Solution {
    public List<Integer> partitionLabels(String s) {
        
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];

        Arrays.fill(hash1,-1);
        Arrays.fill(hash2,-1);

        int n = s.length();

        for(int i = 0; i < n; i++){

            char ch = s.charAt(i);

            if(hash1[ch - 'a'] == -1){

                hash1[ch - 'a'] = i;
            }

            hash2[ch - 'a'] = i;
        }

        int ind = 0;

        List<Integer> res = new ArrayList<>();

        while(ind < n){

            char ch = s.charAt(ind);
            int start = hash1[ch - 'a'];
            int end = hash2[ch - 'a'];

            int j = start + 1;

            while(j <= end){

                char ch1 = s.charAt(j);

                if(hash2[ch1 -  'a'] > end){

                    end = hash2[ch1 - 'a'];
                }

                j++;
            }

            res.add(end - start + 1);

            ind = end + 1;

           
            
        }

        return res;
    }
}