class Solution {
    public boolean hasAlternatingBits(int n) {
        
        int rightShift = n >> 1;
        int xor = n ^ rightShift;

        return (xor & (xor + 1)) == 0;
    }
}