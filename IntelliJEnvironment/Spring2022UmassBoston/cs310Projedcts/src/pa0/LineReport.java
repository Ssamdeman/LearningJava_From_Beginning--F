package pa0;

// Import here as needed

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LineReport {
    // Variables here
    static pa0.LineUsage terminal[];

    // Constructor
    public LineReport() {

    }

    // read input data, put facts into lines array
    static void loadData(String fname) throws FileNotFoundException {

        File fNameUser = new File(fname);
        String userNames; //temp string holder
        int k = 0; //holder tracks
        Scanner sc = new Scanner(fNameUser);
        ///get all the string username and saves in the each arreas that adds the names;
        // I dont' know how to use the Split.
        while (sc.hasNextLine()) {
            k = sc.nextInt();
            userNames = sc.nextLine();
            terminal[k - 1].addObservation(userNames);

           /* System.out.println(userNames);
            System.out.println(k);*/
        }
    } ///run time is n * n* k becuase the add == 2n *l

    // given loaded lines array, generate report on lines
    static void generateReport() {
        pa0.Usage usageTemp;

        System.out.print("Terminals \t");
        System.out.print(" Most Common User \t");
        System.out.println(" Count \t");

        for (int i = 0; i < terminal.length; i++) {
            System.out.print(i + 1);
            System.out.println("\t" + terminal[i].findMaxUsage().getUser() + "\t" + terminal[i].findMaxUsage().getCount());

        }

    }/// run time is n+

    public static void main(String[] args) throws FileNotFoundException {

        terminal = new pa0.LineUsage[500];
        for (int i = 0; i < 500; i++) {
            terminal[i] = new pa0.LineUsage();
        }

        loadData("test.txt");
        generateReport();


    }
}
