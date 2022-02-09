import java.util.HashMap;

public class ST {


    public static void main(String[] args) {
        int minlen = Integer.parseInt(args[0]); // key-length cutoff
        HashMap<String, Integer> st = new HashMap<String, Integer>();
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.length() < minlen) continue;//if this line is true then next line would work?
            if (!st.containsKey(word)) st.put(word, 1);
            else {
                st.put(word, st.get(word) + 1);
            }
        }
        //printing the max value;
        String max = "";
        st.put(max, 0);
        for (String word : st.keySet()) ; ///Assuming the st.keyset can be can indivial key.
        {
            if (st.get(word) > st.get(max)) ;
            max = word;


        }
    }
}
