class Solution {
    public int countSubmatrices(int[][] grid, int k) {

        if(grid[0][0] > k){

            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;

        int sum = grid[0][0];
       
        int cnt = 1;

        int[][] prefix = new int[m][n];

        for(int i = 1; i < m; i++){

            sum += grid[i][0];

            if(sum > k){

                break;
            }
          
            cnt++;
        
        }

        

        sum = grid[0][0];

        for(int i = 1; i < n; i++){

            sum += grid[0][i];

            if(sum > k){

                break;
            }
          
            cnt++;
        
        }

        System.out.println(cnt);

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                if(j == 0){

                    prefix[i][j] = grid[i][j];
                    continue;
                }

                prefix[i][j] = prefix[i][j - 1] + grid[i][j];
            }
        }

       

        // for(int[] p : prefix){

        //     for(int ele : p){

        //         System.out.print(ele+" ");
        //     }

        //     System.out.println();
        // }

        for(int i = 1; i < m; i++){

            for(int j = 1; j < n; j++){

                sum = prefix[i][j] + prefix[i - 1][j];
                 prefix[i][j] = sum;

                if(sum > k){

                    break;
                }

               
                cnt++;
            }
        }

        return cnt;
    }
}