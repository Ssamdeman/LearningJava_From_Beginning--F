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
