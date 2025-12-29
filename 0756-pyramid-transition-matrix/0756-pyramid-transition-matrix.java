class Solution {

    Map<String,String> mpp = new HashMap<>();

    private boolean dfs(String row){

        if(row.length() == 1){

            return true;
        }

        return buildNextRow(0,row,new StringBuilder());
    }

    private boolean buildNextRow(int ind,String row,StringBuilder nextRow){

        if(ind == row.length() - 1){

            return dfs(nextRow.toString());
        }

        String pair = row.substring(ind,ind + 2);

        if(!mpp.containsKey(pair)){

            return false;
        }

        for(char ch : mpp.get(pair).toCharArray()){

            nextRow.append(ch);

           if(buildNextRow(ind + 1,row,nextRow)){

                return true;
           }

            nextRow.deleteCharAt(nextRow.length() - 1);
        }

        return false;
    }
    
    public boolean pyramidTransition(String bottom, List<String> allowed) {

    
        for(String allow : allowed){

            String str1 = allow.substring(0,2);
            String str2 = allow.substring(2);

            mpp.put(str1,mpp.getOrDefault(str1,"")+str2);
        }

        
        
        return dfs(bottom);
    }
}