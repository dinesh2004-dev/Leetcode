class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();
        res.add(folder[0]);

        for(int i = 1; i < folder.length; i++){
            if(!folder[i].startsWith(res.get(res.size() - 1) + "/")){
                res.add(folder[i]);
            }
        }
        return res;
    }
}