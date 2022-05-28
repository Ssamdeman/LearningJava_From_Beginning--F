package pa3;

import edu.princeton.cs.algs4.BinaryIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

/**
 * Class to Implement MTF
 */


public class MoveToFront {

    ArrayList<Character> character = new ArrayList<Character>();

    public MoveToFront() {

        for (int i = 0; i < 256; i++) { //---> n
            character.add((char) i);
        }
        //System.out.println(character);

    }

    public void decode(String f) {

        BinaryIn data = new BinaryIn(f);
        int c;
        ArrayList<Character> character3 = (ArrayList<Character>) character.clone();
        while (!data.isEmpty()) {
            c = data.readChar(8);//char as int form
            // System.out.println("I am here: " + (char) c);
            StdOut.printf("%c", character3.get(c));
            //System.out.println();
            char temp = character3.get(c);
            character3.remove(c);
            character3.add(0, temp);

            //System.out.println("I am here2: " + character2.get(0));


        }


    }


    public void encode(String f) {

        BinaryIn data = new BinaryIn(f); //--1
        //ArrayList<Integer> output = new ArrayList<Integer>();
        char c; ///---1
        ArrayList<Character> character2 = (ArrayList<Character>) character.clone(); //--n
        while (!data.isEmpty()) {///--n
            c = data.readChar(8); // 1
            for (int i = 0; i < 256; i++) {// 1
                if (character2.get(i) == c) { // find the character -1
                    //move to front
                    character2.remove(i); ///n
                    character2.add(0, c);///1
                    System.out.print(character.get(i));//1

                }

            }

        }
        //System.out.println();

    }

    public static void main(String[] args) {

        MoveToFront movefront = new MoveToFront();
        //System.out.println("Hello World");
        movefront.encode("abra.txt");

        //movefront.decode("abra_dec.txt");


    }


}

