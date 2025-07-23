class Solution {
    class Result{
        public int points;
        public String remainingString;
        public Result(int points,String remainingString){
            this.points = points;
            this.remainingString = remainingString;
        }
    }
    public Result solve(String text,String pattern,int score){
        StringBuilder stack = new StringBuilder();
        int points = 0;
        char p1 = pattern.charAt(0);
        char p2 = pattern.charAt(1);

        for(int i = 0; i < text.length(); i++){
            char ch = text.charAt(i);
            if(stack.length() > 0 && stack.charAt(stack.length() - 1) == p1 && ch == p2){
                points += score;
                stack.deleteCharAt(stack.length() - 1);
            }
            else{
                stack.append(ch);
            }
        }
        return new Result(points,stack.toString());
    }
    public int maximumGain(String s, int x, int y) {
        String highestPriority = (x > y) ? "ab" : "ba";
        String lowestPriority = (x > y) ? "ba" : "ab";
        int highestPriorityScore = Math.max(x,y);
        int lowestPriorityScore = Math.min(x,y);
        int totalScore = 0;

        Result afterFirstPass = solve(s,highestPriority,           highestPriorityScore);

        totalScore += afterFirstPass.points;
        Result afterSecondPass = solve(afterFirstPass.remainingString,lowestPriority,lowestPriorityScore);
        totalScore += afterSecondPass.points;

        return totalScore;

    }
}