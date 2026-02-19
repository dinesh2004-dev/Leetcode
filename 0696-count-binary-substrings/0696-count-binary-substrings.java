class Solution {
    public int countBinarySubstrings(String s) {
        
        int cnt = 0;

        char[] charStr = s.toCharArray();

        int n = charStr.length;

        int onePtr = 0,zeroPtr = 0;

        for(int i = 0; i < n; i++){

           if(charStr[i] == '0'){

            // System.out.println(i);

                int zeroStart = i;

                while(i < n && charStr[i] == '0'){

                    i++;
                }

                int oneStart = i;

                while( i < n && charStr[i] == '1'){

                    i++;
                }

                int lastIdx = i;

                int zeroLen = oneStart - zeroStart;
                int oneLen = lastIdx - oneStart;

                cnt += Math.min(zeroLen,oneLen);

                i = oneStart - 1;
           }
           else{

                System.out.println(i);

                int oneStart = i;

                while(i < n && charStr[i] == '1'){

                    i++;
                }

                int zeroStart = i;

                while(i < n && charStr[i] == '0'){

                    i++;
                }

                int lastIdx = i;

                int oneLen = zeroStart - oneStart;
                int zeroLen = lastIdx - zeroStart;

                i = zeroStart - 1;

                cnt += Math.min(oneLen,zeroLen);
           }
        }

        return cnt;
    }
}