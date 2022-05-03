package pa3;

import java.util.ArrayList;

public class DynamicSubsequence {
    private ArrayList<Integer> inputArr;
    private ArrayList<Integer> sizes; // Size of longest sequence ending at each index
    private ArrayList<Integer> previous; // Track back sequence to previous index
    private ArrayList<Integer> output; // Track back sequence to previous index

    public DynamicSubsequence(ArrayList<Integer> inpt) {
        inputArr = inpt;
        if (inputArr == null || inputArr.size() == 0) {
            throw new IllegalArgumentException("Inpt cannot be 0");
        }
        sizes = new ArrayList<>(inputArr.size());
        for (int i = 0; i < inputArr.size())
            //sizes.set(0, 1); ///// the longest increasing subsequence ending at `[0]` has length 1

            for (int i = 1; i < inputArr.size())
    }

    public ArrayList maxSubsequence() {
        return output;
    }


    public static void main(String[] args) {
        int len = args.length;
        ArrayList<Integer> Inp = new ArrayList<>();
        for (int i = 0; i < len; i++)
            Inp.add(Integer.parseInt(args[i]));
        DynamicSubsequence d = new DynamicSubsequence(Inp);
        if (len == 0) return;
        ArrayList<Integer> Outp = d.maxSubsequence();
        System.out.println(Outp);
    }
}
