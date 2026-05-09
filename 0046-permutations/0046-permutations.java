class Solution {
    private void solve(int[] nums,int ind,List<Integer> list,
    List<List<Integer>> res,boolean[] visited){

        if(ind == nums.length){

            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){

            if(!visited[i]){

                visited[i] = true;
                list.add(nums[i]);

                solve(nums,ind + 1,list,res,visited);

                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        int n = nums.length;

        boolean[] visited = new boolean[n];

        solve(nums,0,list,res,visited);

        return res;
    }
}