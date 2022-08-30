
    public class Prime extends Thread {
        private int n;
        private int t;
        public Prime(int n, int t){
            this.n= n;this.t= t;
        }
        public void run(){
            boolean prime = true;
            int end = n + 1000;
            int i = 2;
            while (n <= end){
                for(;i<= n/2; i++){
//                System.out.println(n + "%" + i + "=" + (n % i));
                    if(n % i == 0){
                        prime = false;
                    }
                }
                //if(prime) System.out.println(n + " thread -> " + t);
                prime = true;
                i=2;
                n++;
            }
        }
    }

