
class Solution {
    public int minOperations(String s, int k) {
        
        int n = s.length();

        int zeros = 0;

        for(char ch : s.toCharArray()){

            if(ch == '0'){

                zeros++;
            }
        }

        if(zeros == 0){

            return 0;
        }

        TreeSet<Integer>[] unv = new TreeSet[2];
        unv[0] = new TreeSet<>();
        unv[1] = new TreeSet<>();

        for(int i = 0; i <= n; i++){

            if(i != zeros){

                unv[i % 2].add(i);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{zeros,0});

        while(!q.isEmpty()){

            int[] curr = q.poll();
            int z = curr[0];
            int steps = curr[1];

            int ones = n - z;

            int xMin = Math.max(0,k - ones);
            int xMax = Math.min(z,k);

            if(xMin > xMax){

                continue;
            }

            int L = z + k - 2 * xMax;
            int U = z + k - 2 * xMin;

            if(L > U){

                int t = L;
                L = U;
                U = t;
            }

            int parity = (z + k) % 2;

            Integer next = unv[parity].ceiling(L);

            while(next != null && next <= U){

                int nz = next;

                if(nz == 0){

                    return steps+1;
                }

                q.add(new int[]{nz,steps+1});
                unv[parity].remove(nz);
                next = unv[parity].ceiling(L);
            }
        }

        return -1;
    }
}