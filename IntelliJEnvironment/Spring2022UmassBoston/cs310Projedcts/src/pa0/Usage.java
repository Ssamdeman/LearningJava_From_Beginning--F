package pa0;

// One user's record on one line: how many times
// this user has been seen on this line
//---------------------------------------------------------------//
//I dont I understand of I did this thing right or not.
//becasue it is asking this: Ask help from TA.
///"a, create a Usage object, add one to its count, and
//then print out its username and count using the getters."--D
//---------------------------------------------------------------//
public class Usage {
    int count;
    String userName;

    public Usage(String x, int count) {
        userName = x;
        this.count = count;
    }

    public String getUser() {
        return userName;
    }

    public int getCount() {
        return this.count;
    }

    /*public static void main(String[] args) {
        Usage objc = new Usage("Hello", 10);
        System.out.print(objc.getUser() + " ");
        System.out.println(objc.getCount());
    }*/
}
