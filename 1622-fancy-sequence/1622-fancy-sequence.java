class Fancy {

    List<Long> list = new ArrayList<>();

    long add,mul;

    int mod = (int) 1e9 + 7;

    public Fancy() {
        
        add = 0;
        mul = 1;
    }
    
    public void append(int val) {

        long x = (val - add + mod) % mod;
        x = (x * modInverse((int)mul)) % mod;
        list.add(x);
        
    }
    
    public void addAll(int inc) {
        
        add = (add + inc) % mod;
    }
    
    public void multAll(int m) {
        
        add = (add * m) % mod;
        mul = (mul * m) % mod;
    }
    
    public int getIndex(int idx) {

        if(idx >= list.size()){

            return -1;
        }

       long res = (list.get(idx) * mul) % mod;
        res = (res + add) % mod;
        return (int) res;
        
    }

    private long modInverse(long x){

        return modPow(x,mod - 2);
    }

    private long modPow(long a,long b){

        long res = 1;
        
        a %= mod;

        while(b > 0){

            if((b & 1) == 1){

                res = (res * a) % mod;
            }

            a = (a * a) % mod;
            b >>= 1;
        }

        return res;

    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */