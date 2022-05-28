public class May16_2022 {

    public static int dynnamicSum(int array) {

        // I cannot solve it/ Come back later. My issue is with the array.
        int[] storingDP = new int[100];
        storingDP[0] = 0;


        for (int i = 1; i <= array; i++) {
            storingDP[i] = storingDP[i - 1] + i;

        }
        return storingDP[array];

    }

    public static void main(String[] args) {
        System.out.println(dynnamicSum(3));
    }

}
