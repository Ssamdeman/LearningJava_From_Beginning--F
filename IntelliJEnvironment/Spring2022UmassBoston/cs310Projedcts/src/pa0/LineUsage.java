package pa0;
// Import packages as needed

import java.util.HashMap;
import java.util.Map;

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
    HashMap<String, Integer> lines = new HashMap<String, Integer>();

    // Constructor
    public LineUsage() {
        lines = new HashMap<String, Integer>();
    }

    // add one sighting of a user on this line
    public void addObservation(String username) {
        if (!lines.containsKey(username)) {
            lines.put(username, 1);
        } else {
            lines.put(username, (lines.get(username) + 1));
        }

    } ///run time is N

    // find the user with the most sightings on this line

    public pa0.Usage findMaxUsage() {
        int tempValue = 0;
        String user = "<NONE>";
        for (Map.Entry<String, Integer> element : lines.entrySet()) {
            for (Map.Entry<String, Integer> nextelement : lines.entrySet()) {
                if (element.getValue() >= nextelement.getValue()) {
                    tempValue = element.getValue();
                    user = element.getKey();
                }
            }
        }
        return new pa0.Usage(user, tempValue);
    }/// runtime is N^2* k constant


}


//This code is not working. find better solutions:
  /*  public pa0.Usage findMaxUsage() {
        int finalValue = 0;
        String finalUser = "";
        Map.Entry <String, Integer> tempUser;


        for (Map.Entry<String, Integer> element : lines.entrySet()) {
            if(tempUser.isEmpty()){
                tempUser = element;
                }
             else{
                    if(element.getValue() >= tempUser.getValue(){
                        finalValue = element.getValue();
                        finalUser = element.getKey();
                      }
                }

            }
        }*/
