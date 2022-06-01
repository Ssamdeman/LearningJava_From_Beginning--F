package RandomExploring;

public class testMyArrayList {

    public static void main(String[] args) {
        myArrayList number = new myArrayList(3);
        number.insert(1);
        number.insert(2);
        number.insert(3);
        number.insert(4);
        number.removeAt(100);
        number.print();

    }

}
