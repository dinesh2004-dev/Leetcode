class Pair{

    int value;
    int index;

    public Pair(int value,int index){

        this.value = value;
        this.index = index;
    }
}
class StockSpanner {

    Stack<Pair> st;

    int idx = -1;

    public StockSpanner() {

        st = new Stack<>();
        idx = -1;
        
    }
    
    public int next(int price) {

        idx = idx + 1;

        while(!st.isEmpty() && price >= st.peek().value){

            st.pop();
        }

        int ans = idx - ((st.isEmpty()) ? -1 : st.peek().index);

        st.push(new Pair(price,idx));

        return ans;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */