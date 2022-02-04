package pa0;

// One user's record on one line: how many times
// this user has been seen on this line
public class Usage {
    private int count;
    private String userName;

    public Usage(String x, int count) {
        userName = x;
        this.count = count;
    }

    public void setCount(int x) {
        this.count = x;
    }

    public String getUser() {

        return userName;
    }

    public int getCount() {
        return this.count;
    }

    /*public static void main(String[] args) {
        Usage objc = new Usage("Hello", 10);
        System.out.println(objc.getCount());

    }*/
}
