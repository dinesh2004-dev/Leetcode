class MedianFinder {

    PriorityQueue<Integer> smaller;

    PriorityQueue<Integer> larger;

   
    public MedianFinder() {
        smaller = new PriorityQueue<>((x,y) -> y - x);

        larger = new PriorityQueue<>((x,y) -> x - y);
      
    }
    
    public void addNum(int num) {
        
        smaller.add(num);

        larger.add(smaller.poll());

        if(smaller.size() < larger.size()){

            smaller.add(larger.poll());
        }

    }
    
    public double findMedian() {
         int n1 = smaller.size();

       int n2 = larger.size();

        if(n1 > n2){

            return smaller.peek();
        }

        return (smaller.peek() + larger.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */