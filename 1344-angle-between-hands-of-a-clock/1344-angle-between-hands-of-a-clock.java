class Solution {
    public double angleClock(int hour, int minutes) {
        
        double h = (hour % 12 + (double) minutes / 60) * 30;
        double m = minutes * 6;

        double angle = Math.abs(h - m);

        if(angle > 180){

            angle = 360 - angle;
        }

        return angle;
    }
}