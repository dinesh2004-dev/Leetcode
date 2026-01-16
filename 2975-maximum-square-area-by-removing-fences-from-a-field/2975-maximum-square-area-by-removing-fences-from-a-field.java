class Solution {
    private static int modulo = (int) 1e9 + 7;
    private Set<Integer> findGap(int m,int[] fences){

        List<Integer> bars = new ArrayList<>();

        Set<Integer> gaps = new HashSet<>();

        bars.add(1);

        for(int i = 0; i < fences.length; i++){
            
            bars.add(fences[i]);
        }

        bars.add(m);

        Collections.sort(bars);

        for(int i = 0; i < bars.size(); i++){

            for(int j = i + 1; j < bars.size(); j++){

                gaps.add(bars.get(j) - bars.get(i));
            }
        }

        return gaps;
    }
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        
        Set<Integer> hGaps = findGap(m,hFences);
        Set<Integer> vGaps = findGap(n,vFences);

        long maxGap = -1;

        for(int gap : hGaps){

            if(vGaps.contains(gap)){

                maxGap = Math.max(maxGap,gap);
            }
        }
        long area = maxGap * maxGap;
        System.out.println(area+":"+maxGap);
        return (maxGap == -1) ? -1 : (int) (area % modulo);
    }
}