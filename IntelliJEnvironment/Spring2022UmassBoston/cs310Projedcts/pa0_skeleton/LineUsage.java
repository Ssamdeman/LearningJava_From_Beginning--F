package pa0;
// Import packages as needed

import java.util.HashMap;

// LineUsageData.java: Handle one line's data, using a Map

//---------------------------------------------------------------//
// The problem is that I dont know how will I get the data in the LineUsage.
// I know LineUsage crates HashTable and save it. questions would be the user data
// is coming? And how the Friequesn counter got it here.


// I think my problem is that I am approaching this probelm as if this is the main function
// I think there are other ways apporeach it.

//To list: how to fill the hashtable: -->
/*HashMap<String, Integer> st = new HashMap<String, Integer>();
        while (!StdIn.isEmpty()) {
        String word = StdIn.readString();
        if (word.length() < minlen) continue;
        if (!st.containsKey(word)) st.put(word, 1);
        else {
        st.put(word, st.get(word) + 1);
        }
    }*/
public class LineUsage {
    // Variables here
    
    HashMap<String, Integer> user_count = new HashMap<String, Integer>();

    // Constructor
    public LineUsage() {
        this.user_count = new HashMap<String, Integer>();
    }

    // add one sighting of a user on this line
    public void addObservation(String username) {
        this.user_count[username] += 1;

    }

    // find the user with the most sightings on this line
    public pa0.Usage findMaxUsage() {

    }

    public static void main(String[] args) {

    }

}
