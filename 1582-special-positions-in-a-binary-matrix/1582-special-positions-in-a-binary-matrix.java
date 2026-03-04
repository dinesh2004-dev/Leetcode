class Solution {
    public int numSpecial(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;

        int[] arr1 = new int[m];
        int[] arr2 = new int[n];

        for(int i = 0; i < m; i++){

            int cnt = 0;

            for(int j = 0; j < n; j++){

                if(mat[i][j] == 1){

                    cnt++;
                }
            }

            arr1[i] = cnt;
        }

        

        for(int i = 0; i < n; i++){

            int cnt = 0;

            for(int j = 0; j < m; j++){

                if(mat[j][i] == 1){

                    cnt++;
                }

                
            }
            arr2[i] = cnt;
        }

        for(int ele : arr1){

            System.out.print(ele+" ");
        }

        System.out.println();

        for(int ele : arr2){

            System.out.print(ele+" ");
        }

        int ans = 0;

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                if(mat[i][j] == 1 && 
                    arr1[i] == 1 && arr2[j] == 1){

                        ans++;
                    }
            }
        }

       
        return ans;
    }
}