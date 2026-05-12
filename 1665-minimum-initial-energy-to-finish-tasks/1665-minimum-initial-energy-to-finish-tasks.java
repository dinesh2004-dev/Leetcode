class Solution {
    private boolean canFinish(int[][] tasks,int energy){

        for(int i = 0; i < tasks.length; i++){

            if(energy <= 0 || energy < tasks[i][1]){

                return false;
            }

            energy = energy - tasks[i][0];
        }

        return true;
    }
    public int minimumEffort(int[][] tasks) {
        
        int n = tasks.length;

        Arrays.sort(tasks,(x,y) -> {

            int diff1 = x[1] - x[0];
            int diff2 = y[1] - y[0];

            return diff2 - diff1;
        });

       int start = tasks[0][1];
       int bal = tasks[0][1] - tasks[0][0];

       int loan = 0;

       for(int i = 1; i < n; i++){

            int cost = tasks[i][0];
            int thresh = tasks[i][1];

            if(bal < thresh){

                loan += thresh - bal;

                bal = thresh;
            }

            bal -= cost;
       }

       return start + loan;
    }
}