/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.ArrayList;

public class testingDynamic {
    ArrayList<Integer> inputArr;

    public testingDynamic(ArrayList<Integer> inpt) {
        inputArr = inpt;

        ArrayList<Integer> LIS = new ArrayList<Integer>(inputArr.size());

        LIS.set(0, 1); //setting the LIS[0] = 1;
        //Bottom up.
        for (int i = 1; i < inputArr.size(); i++) {
            LIS.set(i, 1);
            for (int j = 0; j < i; j++) {

                if (inputArr.get(i) > inputArr.get(j) && LIS.get(i) < LIS.get(j) + 1)
                    LIS.set(i, LIS.get(j) + 1);

            }

        }
        for (int i = 0; i < inputArr.size(); i++) {
            System.out.println(("OPT [" + i + "] " + "-" + LIS.get(i)));

        }

    }

    public static void main(String[] args) {


        ArrayList<Integer> input = new ArrayList<>();
        input.add(3);
        input.add(1);
        input.add(8);
        input.add(2);
        input.add(5);
        System.out.println("I am Here");
        System.out.println(input.get(4));


        //testingDynamic d = new testingDynamic(input);


    }


}
