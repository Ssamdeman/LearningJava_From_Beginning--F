package pa3;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

public class DynamicSubsequence {
    private ArrayList<Integer> inputArr;
    private ArrayList<Integer> LIS; // Size of longest sequence ending at each index
    private ArrayList<Integer> previous; // Track back sequence to previous index
    private ArrayList<Integer> output;

    public DynamicSubsequence(ArrayList<Integer> inpt) {
        inputArr = inpt;//1
        //System.out.println("I am here" + inputArr.size());
        if (inputArr.size() == 0 || inputArr == null) return;//1

        //storing longest increasing subsequence
        List<List<Integer>> LIS = new ArrayList<>(); //1
        //initialsinz the lis to be just empty.
        for (int i = 0; i < inputArr.size(); i++) { //--> n
            LIS.add(new ArrayList<>()); // to keep track the data and make arralist inside of arraylis
            //System.out.println("Now I am here" + i);
        }
        LIS.get(0).add(inpt.get(0)); //setting the first elemnt of our input in to be

        //we are find the input[0-j, i-1}
        for (int i = 1; i < inputArr.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (inputArr.get(j) < inputArr.get(i) && LIS.get(j).size() > LIS.get(i).size()) {
                    LIS.set(i, new ArrayList<>(LIS.get(j))); //1
                }
            }
            //adding the input in the arra list
            LIS.get(i).add(inputArr.get(i)); ///1

        }
        //testing
       /* for (int i = 0; i < inputArr.size(); i++) {
            System.out.println("Priting interation on LIS[" + i + "] — " + LIS.get(i));
        }*/

        //System.out.println(LIS.get(inputArr.size() - 1));
        output = (ArrayList) LIS.get(inputArr.size() - 1); //1

    }


    public ArrayList maxSubsequence() {
        return output;
    }

    public static void main(String[] args) {

        ArrayList<Integer> data = new ArrayList<>();
       /* data.add(3);
        data.add(1);
        data.add(8);
        data.add(2);
        data.add(5);*/
        // 3, 1,8,2,5
        In file = new In(args[0]);
        while (!file.isEmpty()) {
            data.add(file.readInt());
        }

        DynamicSubsequence d = new DynamicSubsequence(data);
        System.out.println(d.maxSubsequence());
    }

}


//testing purposes:
       /* System.out.println();
        System.out.println("I am here");
        System.out.println(Inp);
        System.out.println(Inp.get(0));
        */

        /*ArrayList<Integer> Outp = d.maxSubsequence();
        System.out.println(Outp);*/


// 3, 1,8,2,5
//--------------------------------------------------------------------------------

       /* //testing purposes. Create temp values.
        int testedCount = 0;

        //Top to down
        inputArr = inpt;
        if (inputArr == null || inputArr.size() == 0) {
            throw new IllegalArgumentException("Inpt cannot be 0");
        }

        sizes = new ArrayList<>(inputArr.size());
        sizes.set(0, 1); /// base case.

        for (int i = 1; i < inputArr.size(); i++) {
            sizes.set(i, 1);
        }
        System.out.println("I am here working");
        ///// the longest increasing subsequence ending at `[0]` has length 1
        //for (int i = 1; i < inputArr.size())
        //Not sure if this working,
        for (int i = inputArr.size(); i >= 0; i--) {
            for (int j = i + 1; j < inputArr.size(); i++) {
                if (inputArr.get(i) < inputArr.get(j)) {
                    sizes.set(i, Integer.max(sizes.get(i), 1 + sizes.get(j)));
                }

            }
            System.out.println(" inside of I loop " + inputArr.get(i));
        }


    }*/
////-----------------------------------------------------------------------------------------------------
/* inputArr = inpt;
         if (inputArr == null || inputArr.size() == 0) {
         return;
         }
         List<List<Integer>> OPT = new ArrayList<>();
        for (int i = 1; i < inputArr.size(); i++) {
        OPT.add(new ArrayList<>());
        }

        OPT.get(0).add(inputArr.get(0));

        for (int i = 1; i < inputArr.size(); i++) {

        for (int j = 0; j < i; j++) {
        if (inputArr.get(j) < inputArr.get(i) && OPT.get(j).size() > OPT.get(i).size()) {
        OPT.set(i, new ArrayList<>(OPT.get(j)));
        }
        }

        OPT.get(i).add(inputArr.get(i));
        }
        //priting the OPT.

        for (int i = 0; i < inputArr.size(); i++) {
        System.out.println("OPT [" + i + "] " + "-" + OPT.get(i));
        }

        }*/
//-----------------------------------------------------------------------------
/*
        inputArr = inpt;
        // base case
        if (inpt == null || inpt.size() == 0) {
            return;
        }
        int n = inputArr.size(); //arrays

        int min = Integer.MAX_VALUE; // min.


        //initialse  the size to keep in track.
        for (int i = 0; i < n; i++) {
            LIS.add(i, 0); //
        }
        LIS.set(0, 1); //size base case.
        previous.set(0, null);

        ArrayList<Integer> temp = (ArrayList) inputArr.clone();
        for (int i = 1; i < n; i++) {
            //finding the smaller number from array.
            if (min > temp.get(i)) {
                min = temp.get(i);
            }
        }

        for (int i = 0; i < inputArr.get(i); i++)
            if (inputArr.get(i) < min) {
                if (LIS.get(i) + 1 > LIS.get(inputArr.get(min))) {
                    LIS.add(m)
                }
            }*/


/// has has to be leng
///---------------------------------------------------------------------------
/*
    inputArr = inpt;
    ArrayList LIS = new ArrayList();
    //adding the array list to be 1.
    ///i j
    // 0 1 2 3 4 --indext
    // 3,1,8,2,5
    //Lis  1,1,1,1,1
    for (int i = 0; i < n; i++) {
        LIS.add(1);
    }
    //lis[i] < lis[j] + 1)
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (inputArr.get(i) > inputArr.get(j) && LIS.get(i) < LIS.get(j + 1) + 1)
                LIS.get(i) = LIS.get(j + 1) + 1;
        }
    }
    */

