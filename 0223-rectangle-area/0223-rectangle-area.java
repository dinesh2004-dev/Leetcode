class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        
        int height1 = ay2 - ay1,width1 = ax2 - ax1;
        int height2 = by2 - by1,width2 = bx2 - bx1;

        int areaOfRect1 = width1 * height1;
        int areaOfRect2 = width2 * height2;

        int totalArea = areaOfRect1 + areaOfRect2;

        int intersecX1 = Math.max(ax1,bx1);
        int intersecY1 = Math.max(ay1,by1);
        int intersecX2 = Math.min(ax2,bx2);
        int intersecY2 = Math.min(ay2,by2);

        int intersecWidth = intersecX2 - intersecX1;
        int intersecHeight = intersecY2 - intersecY1;

         int intersecArea = 0;

        if(intersecWidth > 0 && intersecHeight > 0){
            intersecArea = intersecWidth * intersecHeight;
        }

        return totalArea - intersecArea;
    }
}