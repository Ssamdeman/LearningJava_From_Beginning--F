package pa1;

///java -cp .:../lib/algs4.jar pa1.LinearProbingHashST2 tinyST.txt S A-- Working

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

//Key and Value is generic type.
public class LinearProbingHashST2<Key, Value> {

    // must be a power of 2
    private static final int INIT_CAPACITY = 4;

    private int n;           // number of key-value pairs in the symbol table
    private int m;           // size of linear probing table
    private Key[] keys;      // the keys
    private Value[] vals;    // the values
    //My code
    boolean[] flags; // this flag's keeps track the if the keys are exist or not.
    private int flagsCounter;
    // counting how many flags are true; Every time is true we increment the this variables.


    /**
     * Initializes an empty symbol table.
     */
    public LinearProbingHashST2() {
        this(INIT_CAPACITY);
    }

    /**
     * Initializes an empty symbol table with the specified initial capacity.
     *
     * @param capacity the initial capacity
     */
    public LinearProbingHashST2(int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[]) new Object[m];
        vals = (Value[]) new Object[m];
        //my code.
        flags = new boolean[m]; /// the default values are false.
        flagsCounter = 0;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     */
    public int size() {
        return n;
    }

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     * {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param key the key
     * @return {@code true} if this symbol table contains {@code key};
     * {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        // It will return false if key does not have the value.
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;

    }

    // hash function for keys - returns value between 0 and m-1
    private int hashTextbook(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
        //key is key data type which which is part of Object class. Object lass is superclass


    }
    //what is key datat type---D

    // hash function for keys - returns value between 0 and m-1 (assumes m is a power of 2)
    private int hash(Key key) {
        int h = key.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12) ^ (h >>> 7) ^ (h >>> 4);
        return h & (m - 1);
    }

    // resizes the hash table to the given capacity by re-hashing all of the keys
    private void resize(int capacity) {
        LinearProbingHashST2<Key, Value> temp = new LinearProbingHashST2<Key, Value>(capacity);
        //original code
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        //my code:

        //original:
        //not_null != null = True
        keys = temp.keys;
        vals = temp.vals;
        m = temp.m;
        flags = temp.flags;

    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param key the key
     * @param val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        //Original code:
        if (val == null) {
            delete(key);
            return;
        }

        // double table size if 50% full
        if (n >= m / 2) resize(2 * m);

        // if the key is not empty we are updating same key with new value.and save the hash where we have null.
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                //my code
                //flags[i] = true;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
        ///my code:
        flags[i] = true;

    }

    /**
     * Returns the value associated with the specified key.
     *
     * @param key the key
     * @return the value associated with {@code key};
     * {@code null} if no such value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");

        for (int i = hash(key); keys[i] != null; i = (i + 1) % m)
            //original code
            /*if (keys[i].equals(key))
                return vals[i];*/
            //my code
            if (keys[i].equals(key) && flags[i])
                return vals[i];
        return null;
    }


    /**
     * Removes the specified key and its associated value from this symbol table
     * (if the key is in this symbol table).
     * java -cp pa1/lib/args4.jar pa1/LinearProbingHashST2 tinyST.txt
     *
     * @param key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return;


        // find position i of key
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m; //I got it now.
            //If the key has collision, then we put it next. So findinf i is just matter of
        }
        //My code: find the position only if flags is set to true;


        // delete key and associated value
        /*keys[i] = null;
        vals[i] = null;*/
        flags[i] = false;
        flagsCounter++;

        // rehash all keys in same cluster
        //Resize the number of whole table.:
        i = (i + 1) % m; ///0 - m-1
        while (keys[i] != null) {
            // delete keys[i] an vals[i] and reinsert
            Key keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(keyToRehash, valToRehash); /// this one does the rehashing:
            i = (i + 1) % m;
        }
        n--;

        // halves size of array if it's 12.5% full or less
        if (n > 0 && n <= m / 8) resize(m / 2);

        assert check();
    }

    /**
     * Returns all keys in this symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     *
     * @return all keys in this symbol table
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++)
            if (keys[i] != null) {
                if (flags[i] == false) continue;
                queue.enqueue(keys[i]);
            }

        return queue;
    }

    // integrity check - don't check after each put() because
    // integrity not maintained during a delete()
    private boolean check() {

        // check that hash table is at most 50% full
        if (m < 2 * n) {
            System.err.println("Hash table size m = " + m + "; array size n = " + n);
            return false;
        }

        // check that each key in table can be found by get()
        for (int i = 0; i < m; i++) {
            if (keys[i] == null) continue;
            else if (get(keys[i]) != vals[i]) {
                System.err.println(
                        "get[" + keys[i] + "] = " + get(keys[i]) + "; vals[i] = " + vals[i]);
                return false;
            }
        }
        return true;
    }

    //Testing thing
    /*public void display() {
        for (int i = 0; i < m; i++) {
            System.out.print(" " + flags[i] + " " + keys[i]);
        }
    }*/
    public int numberOfOverallKeys() {
        return n + flagsCounter;
    }

    public int tableSize() {
        return m;
    }

    /**
     * Unit tests the {@code LinearProbingHashST} data type.
     *
     * @param args the command-line arguments
     */


    public static void main(String[] args) {
        LinearProbingHashST2<String, Integer> st = new LinearProbingHashST2<String, Integer>();
        In allIn = new In(args[0]);
        String[] dataArray = allIn.readAllStrings();
        //int totalWords = dataArray.length;
        for (int i = 0; i < dataArray.length; i++) {
            st.put(dataArray[i], i);
        }
        //original.
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
        System.out.print(st.size() + " ");
        System.out.print(st.numberOfOverallKeys() + " ");
        System.out.println(st.tableSize());

        //PRITING AFTER DELETING
        st.delete(args[1]);
        st.delete(args[2]);

        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
        System.out.print(st.size() + " ");
        System.out.print(st.numberOfOverallKeys() + " ");
        System.out.print(st.tableSize());

    }
}


