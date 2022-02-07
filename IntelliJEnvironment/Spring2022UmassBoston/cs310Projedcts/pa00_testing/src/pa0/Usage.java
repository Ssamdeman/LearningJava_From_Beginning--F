//package com.gradescope.pa0;
package pa0;

// One user's record on one line: how many times
// this user has been seen on this line
public class Usage {
    int count;
    String userName;

    public Usage(String x, int count) {
        userName = x;
        this.count = count;
    }

    public void setCount(int x) {
        this.count = x;
    }

    public String getUser() {
        return "NOTHING";
    }

    public int getCount() {
        return -1;
    }
}


