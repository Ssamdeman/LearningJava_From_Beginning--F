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
        terminal = new pa0.LineUsage[500];
        for (int i = 0; i < 500; i++) {
            terminal[i] = new pa0.LineUsage();
        }

    }
    // k + k+ k + n
    //

    // read input data, put facts into lines array
    void loadData(String fname) throws FileNotFoundException {//

        File fNameUser = new File(fname);///n
        String userNames; //temp string holder//k
        int k = 0; //holder tracks
        Scanner sc = new Scanner(fNameUser);
        ///get all the string username and saves in the each arreas that adds the names;
        // I dont' know how to use the Split.
        while (sc.hasNextLine()) { //  n+ n + n + n
            k = sc.nextInt();
            userNames = sc.nextLine();
            terminal[k - 1].addObservation(userNames);
           /* System.out.println(userNames);
            System.out.println(k);*/
        }
    } ///run time is n * n* k becuase the add == 2n *l

    // given loaded lines array, generate report on lines
    void generateReport() {

        System.out.print("Terminals \t");
        System.out.print(" Most Common User \t");
        System.out.println(" Count \t");

        for (int i = 0; i < terminal.length; i++) {
            System.out.print(i + 1);
            System.out.println(
                    "\t" + terminal[i].findMaxUsage().getUser() + "\t" + terminal[i].findMaxUsage()
                                                                                    .getCount());

        }

    }/// run time is n+

    public static void main(String[] args) throws FileNotFoundException {
        LineReport report = new LineReport();
        report.loadData(args[0]);
        report.generateReport();


    }
}
