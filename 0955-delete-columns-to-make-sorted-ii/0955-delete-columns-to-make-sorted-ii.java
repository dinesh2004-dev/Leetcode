class Solution {
    public int minDeletionSize(String[] strs) {
        
        int n = strs.length;

        boolean[] sorted = new boolean[n - 1];

        int dels = 0;

        for(int i = 0; i < strs[0].length(); i++){

            boolean toDelete = false;

            for(int j = 0; j < n - 1; j++){

                if(!sorted[j] && strs[j].charAt(i) > strs[j + 1].charAt(i)){

                    toDelete = true;
                    break;
                }
            }

            if(toDelete){

                dels++;
                continue;
            }

            for(int j = 0; j < n - 1; j++){

                if(!sorted[j] && strs[j].charAt(i) < strs[j + 1].charAt(i)){

                    sorted[j] = true;
                }
            }
        }

        return dels;
    }
}