class Pair{
    
    int x,y;
    public Pair(int x,int y){
        
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair p = (Pair) o;
        return x == p.x && y == p.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;   // standard hash combining
    }
}
class Solution {
    private int fun(String s,char x,char y,char z){

        int n = s.length();
        int i = 0;

        int maxLen = 0;

        while(i < n){

            if(s.charAt(i) == z){

                i++;
                continue;
            }

            int cnt = 0;

            Map<Integer,Integer> mpp = new HashMap<>();
            mpp.put(cnt,i);

            int j = i;

            while(j < n && s.charAt(j) != z){

                cnt += (s.charAt(j) == x) ? 1 : -1;

                if(mpp.containsKey(cnt)){

                    maxLen = Math.max(maxLen,j - mpp.get(cnt) + 1);
                }
                else{

                    mpp.put(cnt,j + 1);
                }

                j++;
            }

            i = j;
        }

        return maxLen;
    }
    public int longestBalanced(String s) {

        int maxLen = 0;

        int i = 0;
        int n = s.length();

        while( i < n){

            int j = i;
            int cnt = 0;

            while(j < n && s.charAt(j) == s.charAt(i)){

                cnt++;
                j++;
            }

            maxLen = Math.max(maxLen,cnt);
            i = j;
        }

        maxLen = Math.max(maxLen,fun(s,'a','b','c'));
        maxLen = Math.max(maxLen,fun(s,'b','c','a'));
        maxLen = Math.max(maxLen,fun(s,'a','c','b'));

        // System.out.println(maxLen);

        Map<Pair,Integer> mpp = new HashMap<>();

        mpp.put(new Pair(0,0),-1);

        int countA = 0,countB = 0,countC = 0;

        for(int j = 0; j < n; j++){

            if(s.charAt(j) == 'a'){

                countA++;
            }
            else if(s.charAt(j) == 'b'){

                countB++;
            }
            else{

                countC++;
            }

            Pair key = new Pair(countA - countB,countB - countC);

            if(mpp.containsKey(key)){

                maxLen = Math.max(maxLen,j - mpp.get(key));
                System.out.println("1");
            }
            else{

                mpp.put(key,j);
            }
        }

        return maxLen;
        
        
    }
}