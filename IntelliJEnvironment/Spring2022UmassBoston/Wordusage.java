/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 *
 * https://stackoverflow.com/questions/5181578/what-is-the-point-of-final-class-in-java
 * https://programming.guide/java/when-to-create-a-final-class.html
 *https://www.geeksforgeeks.org/difference-between-abstract-class-and-interface-in-java/
 *  Read these for answering final questions.
 *
 **************************************************************************** */

public class Wordusage {

    private final String word;
    private int count;

    public Wordusage(String newWord, int newCount) {
        word = newWord;
        count = newCount;
    }

    public Wordusage(String newWord) {
        word = newWord;
        count = 1;
    }

    //getters
    public void getWord() {
        System.out.println(word);
    }

    public void getCount() {
        System.out.println(count);
    }

    //setter
    public int setCount(int newCount) {
        count = newCount;
        return count;
    }

    public void inceremnt() {
        this.count += 1;

    }

}
