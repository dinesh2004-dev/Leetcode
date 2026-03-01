class Solution {
    public int minPartitions(String n) {
        
        int maxi = n.charAt(0) - '0';

        for(int i = 1; i < n.length(); i++){

            maxi = Math.max(maxi,n.charAt(i) - '0');
        }

        return maxi;
    }
}