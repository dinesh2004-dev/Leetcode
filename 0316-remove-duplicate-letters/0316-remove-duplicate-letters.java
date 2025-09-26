class Solution {
    public String removeDuplicateLetters(String s) {
        
        int n = s.length();
        int[] lastIndex = new int[26];

        for(int i = 0; i < n; i++){

            lastIndex[s.charAt(i) - 'a'] = i;
        }

        boolean[] seen = new boolean[26];

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){

            int curr = s.charAt(i) - 'a';

            if(seen[curr]){
                continue;
            }

            while(!st.isEmpty() && st.peek() > curr && i < lastIndex[st.peek()]){
                seen[st.pop()] = false;
            }

            st.push(curr);

            seen[curr] = true;
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){

            sb.append((char) (st.pop() + 'a'));
        }

        return sb.reverse().toString();
    }
}