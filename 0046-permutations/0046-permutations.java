class Solution {
    public void solve(int ind,int[] nums,List<List<Integer>> res,List<Integer> list,boolean[] visited){
        if(ind == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(nums[i]);

                solve(ind + 1,nums,res,list,visited);

                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[n];

        solve(0,nums,res,list,visited);

        return res;
    }
}