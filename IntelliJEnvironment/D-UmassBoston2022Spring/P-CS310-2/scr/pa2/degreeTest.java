/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class degreeTest {
    public static void main(String[] args) {
        String filename = "movies.txt";
        String delimiter = "/";
        String source = "Bacon, Kevin";

        DegreesOfSeparationBFS testobject = new DegreesOfSeparationBFS(filename, delimiter, source);
        System.out.println(testobject.baconNumber("Kidman, Nicole"));
        //testobject.printPath();

    }
}
