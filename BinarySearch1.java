import java.util.Arrays;


//12-30-2021 13:10:20 this code is not working. I have no ideas why it is not working. 
public class BinarySearch1{

    public static int rank(int key, int[] a){
        int lo = 0;
        int hi = a.length - 1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(key < a[mid]) hi = mid -1;
            else if( key > a[mid]) lo = mid+1;
            else return mid;
        }

        return -1;
    }

    //creating new method. Method is like a fuction that that can be called and used. 
    public static double squareRoot (double c)
    {
        if( c < 0 ) return Double.NaN;

        double err = 1e-15;
        double t = c;
        
        while(Math.abs(t - c/t) > err * t) t = (c/t + t / 2.0);

        return t;
    }
    public static boolean isPrime(int N)
    {
        if (N < 2) return false;
        
        for( int i = 2; i*i <= N; i++){
            if (N % i == 0) return false;
        }
        return true;
    }

    /// building library of static method called Models

    public static void main(String [] args){
        int [] whitelist = In.readInts(args[0]);
        In.readInts(args[0]); 
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()){
            int key =  StdIn.readInts();
            if(rank(rank, whitelist) == -1) StdOut.printLn(key);
        }
    }

}
